/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author farro
 */
public class ConsultasSql {
    
    // Obtener ID de Profesión según el nombre
    public static int obtenerIdProfesion(String descProfesion) {
        String sql = "SELECT ID_Profesion FROM Profesion WHERE Desc_Profesion = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, descProfesion);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("ID_Profesion");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener ID_Profesion: " + e.getMessage());
        }
        return -1; // En caso de error o si no se encuentra
    }

    // Obtener ID de Condición según el nombre
    public static int obtenerIdCondicion(String descCondicion) {
        String sql = "SELECT ID_Condicion FROM Condicion WHERE Desc_Condicion = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, descCondicion);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("ID_Condicion");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener ID_Condicion: " + e.getMessage());
        }
        return -1; // En caso de error o si no se encuentra
    }
    
}
