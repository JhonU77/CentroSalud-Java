/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author farro
 */
public class prebaConexion {
    
    public static void main(String[] args) {
    Connection conn = Conexion.getConexion();
    if (conn != null) {
        System.out.println("Conexión a la base de datos exitosa.");
        try {
            conn.close();
            System.out.println("Conexión cerrada.");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    } else {
        System.out.println("No se pudo establecer la conexión.");
    }
}

    
}
