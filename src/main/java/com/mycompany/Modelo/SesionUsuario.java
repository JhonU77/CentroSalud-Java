/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Modelo;

/**
 *
 * @author farro
 */
public class SesionUsuario {
    private static String dniUsuario;
    private static String correoUsuario;
    private static String cargoUsuario;

    public static void setUsuario(String dni, String correo, String cargo) {
        dniUsuario = dni;
        correoUsuario = correo;
        cargoUsuario = cargo;
    }
    public static void setRestauracion(String dni, String correo) {
        dniUsuario = dni;
        correoUsuario = correo;
    }

    public static String getDniUsuario() {
        return dniUsuario;
    }

    public static String getCorreoUsuario() {
        return correoUsuario;
    }
    
    public static String getCargoUsuario() {
        return cargoUsuario;
    }

    public static void clear() {
        dniUsuario = null;
        correoUsuario = null;
        cargoUsuario = null;
    }
}