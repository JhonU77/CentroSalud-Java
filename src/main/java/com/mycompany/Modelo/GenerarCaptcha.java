/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Modelo;

import java.util.Random;
/**
 *
 * @author farro
 */
public class GenerarCaptcha {

    public static String generarCodigo() {
        String mayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String minusculas = "abcdefghijklmnopqrstuvwxyz";
        String numeros = "0123456789";
        StringBuilder captcha = new StringBuilder();
        Random random = new Random();

        // Generamos intercalado: Mayuscula - Número - Minuscula - Número - Mayuscula - Número - Minuscula
        captcha.append(mayusculas.charAt(random.nextInt(mayusculas.length())));
        captcha.append(numeros.charAt(random.nextInt(numeros.length())));
        captcha.append(minusculas.charAt(random.nextInt(minusculas.length())));
        captcha.append(numeros.charAt(random.nextInt(numeros.length())));
        captcha.append(mayusculas.charAt(random.nextInt(mayusculas.length())));
        captcha.append(numeros.charAt(random.nextInt(numeros.length())));
        captcha.append(minusculas.charAt(random.nextInt(minusculas.length())));

        return captcha.toString();
    }
    
}