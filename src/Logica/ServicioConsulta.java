/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Utilidades.JsonUtil;
import comunicacion.ClienteHTTP;
import comunicacion.ClienteTCP;
import dto.ErrorDTO;
import dto.PersonaDTO;




/**
 *
 * @author jerso
 */

public class ServicioConsulta {

    private final ClienteTCP clienteTCP;
    private final ClienteHTTP clienteHTTP;

    public ServicioConsulta() {
        clienteTCP = new ClienteTCP();
        clienteHTTP = new ClienteHTTP();
    }

    public PersonaDTO consultar(String cedula, String protocolo)
            throws Exception {

        cedula = validarCedula(cedula);

        if (protocolo == null) {
            throw new IllegalArgumentException(
                    "Debe seleccionar un protocolo."
            );
        }

        String respuesta;

        try {

            if (protocolo.equalsIgnoreCase("TCP")) {

                respuesta = clienteTCP.consultar(cedula);

            } else if (protocolo.equalsIgnoreCase("HTTP")) {

                respuesta = clienteHTTP.consultar(cedula);

            } else {

                throw new IllegalArgumentException(
                        "Protocolo no valido."
                );
            }

        } catch (java.io.IOException e) {

            throw new Exception(
                    "No se pudo conectar con el servidor."
            );
        }

        if (JsonUtil.esError(respuesta)) {

            ErrorDTO error =
                    JsonUtil.convertirError(respuesta);

            if (error != null
                    && error.getMensaje() != null) {

                throw new Exception(
                        error.getMensaje()
                );
            }

            throw new Exception(
                    "El servidor reporto un error."
            );
        }

        PersonaDTO persona =
                JsonUtil.convertirPersona(respuesta);

        if (persona == null
                || persona.getCedula() == null) {

            throw new Exception(
                    "La respuesta recibida no es valida."
            );
        }

        return persona;
    }

    private String validarCedula(String cedula) {

        if (cedula == null
                || cedula.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Debe ingresar una cedula."
            );
        }

        cedula = cedula.trim();

        if (!cedula.matches("\\d+")) {

            throw new IllegalArgumentException(
                    "La cedula debe contener solamente numeros."
            );
        }

        return cedula;
    }
}