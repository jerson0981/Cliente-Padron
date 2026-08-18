/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;
import Utilidades.Configuracion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author jerso
 */
public class ClienteTCP {
    public String consultar(String cedula) throws IOException {

        try (Socket socket = new Socket()) {

            socket.connect(
                    new InetSocketAddress(
                            Configuracion.HOST,
                            Configuracion.PUERTO_TCP
                    ),
                    Configuracion.TIMEOUT
            );

            socket.setSoTimeout(Configuracion.TIMEOUT);

            BufferedWriter writer =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    socket.getOutputStream()
                            )
                    );

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()
                            )
                    );

            writer.write("GET|" + cedula);
            writer.newLine();
            writer.flush();

            String respuesta = reader.readLine();

            if (respuesta == null || respuesta.isBlank()) {
                throw new IOException(
                        "El servidor no envio una respuesta."
                );
            }

            return respuesta;
        }
    }
}