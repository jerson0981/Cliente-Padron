/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import com.google.gson.Gson;
import dto.ErrorDTO;
import dto.PersonaDTO;


/**
 *
 * @author jerso
 */
public class JsonUtil {

  
    private static final Gson gson = new Gson();

    private JsonUtil() {
    }

    public static boolean esError(String json) {

        if (json == null || json.isBlank()) {
            return true;
        }

        try {
            ErrorDTO error = gson.fromJson(json, ErrorDTO.class);
            return error != null && error.isError();
        } catch (Exception e) {
            return false;
        }
    }

    public static PersonaDTO convertirPersona(String json) {
        return gson.fromJson(json, PersonaDTO.class);
    }

    public static ErrorDTO convertirError(String json) {
        return gson.fromJson(json, ErrorDTO.class);
    }
}