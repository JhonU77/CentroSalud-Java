/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jhonatan Farro
 */
public class Conexion {
    
    public static Connection getConexion() {
        String conexionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "database=Sistema_ReporteClinico;"
                    + "user=sa;"
                    + "password=admin1010;"
                    + "loginTimeout=30;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;";
        try {
            Connection con = DriverManager.getConnection(conexionUrl);
            System.out.println("Conexión establecida con éxito.");
            return con;
        } catch (SQLException ex) {
            System.out.println("Error en la conexión: " + ex.toString());
            return null;
        }
    } 
    
}