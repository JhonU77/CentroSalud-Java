/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Modelo;

/**
 *
 * @author farro
 */
public class ValidarContrasena {
    // Verifica si tiene al menos 8 caracteres
    public static boolean tieneLongitudMinima(String contrasena) {
        return contrasena.length() >= 8;
    }

    // Verifica si tiene al menos una mayúscula
    public static boolean tieneMayuscula(String contrasena) {
        return contrasena.chars().anyMatch(Character::isUpperCase);
    }

    // Verifica si contiene al menos uno de los símbolos permitidos
    public static boolean tieneSimbolo(String contrasena) {
        String simbolos = "*=#_%@.-/";
        for (char c : contrasena.toCharArray()) {
            if (simbolos.indexOf(c) >= 0) {
                return true;
            }
        }
        return false;
    }

    // Valida todos los requisitos y devuelve true o false
    public static boolean validarContrasena(String contrasena) {
        return tieneLongitudMinima(contrasena) &&
               tieneMayuscula(contrasena) &&
               tieneSimbolo(contrasena);
    }
}