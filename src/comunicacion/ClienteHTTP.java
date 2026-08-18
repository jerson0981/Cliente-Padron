/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comunicacion;

import Utilidades.Configuracion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;



/**
 *
 * @author jerso
 */
public class ClienteHTTP {
    


    public String consultar(String cedula) throws IOException {

        String direccion =
                "http://"
                + Configuracion.HOST
                + ":"
                + Configuracion.PUERTO_HTTP
                + "/padron/"
                + cedula;

        URL url = new URL(direccion);

        HttpURLConnection conexion =
                (HttpURLConnection) url.openConnection();

        conexion.setRequestMethod("GET");
        conexion.setConnectTimeout(Configuracion.TIMEOUT);
        conexion.setReadTimeout(Configuracion.TIMEOUT);

        int codigo = conexion.getResponseCode();

        InputStream entrada;

        if (codigo >= 200 && codigo < 300) {
            entrada = conexion.getInputStream();
        } else {
            entrada = conexion.getErrorStream();
        }

        if (entrada == null) {
            conexion.disconnect();

            throw new IOException(
                    "El servidor no envio una respuesta."
            );
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     entrada,
                                     StandardCharsets.UTF_8
                             )
                     )) {

            StringBuilder respuesta = new StringBuilder();

            String linea;

            while ((linea = reader.readLine()) != null) {
                respuesta.append(linea);
            }

            return respuesta.toString();

        } finally {
            conexion.disconnect();
        }
    }
}
