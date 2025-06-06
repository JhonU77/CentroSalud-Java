/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author farro
 */
public class SesionUsuario {
    private static String dniUsuario;
    private static String correoUsuario;

    public static void setUsuario(String dni, String correo) {
        dniUsuario = dni;
        correoUsuario = correo;
    }

    public static String getDniUsuario() {
        return dniUsuario;
    }

    public static String getCorreoUsuario() {
        return correoUsuario;
    }

    public static void clear() {
        dniUsuario = null;
        correoUsuario = null;
    }
}
