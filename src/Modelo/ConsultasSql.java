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
    
    //Validacion para no registrar un paciente con el mismo Dni
    public static boolean dniExiste(String dni) {
        boolean existe = false;

        try (Connection con = Conexion.getConexion()) {
            String sql = "SELECT COUNT(*) FROM Paciente WHERE DNI_Paciente = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                existe = true;
            }
        } catch (Exception e) {
            System.out.println("Error al verificar DNI: " + e.getMessage());
        }

        return existe;
    }
    
    public Paciente buscarPacientePorDni(String dni) {
        Paciente paciente = null;

        String sql = "SELECT * FROM Paciente WHERE DNI_Paciente = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                paciente = new Paciente();
                paciente.setDni(rs.getString("DNI_Paciente"));
                paciente.setNombres(rs.getString("Nombres_Paciente"));
                paciente.setApellidoPaterno(rs.getString("ApellidoPaterno_Paciente"));
                paciente.setApellidoMaterno(rs.getString("ApellidoMaterno_Paciente"));

                // ✅ Esto es importante ahora que fechaNacimiento es tipo Date
                java.sql.Date sqlDate = rs.getDate("FechaNacimiento_Paciente");
                if (sqlDate != null) {
                    paciente.setFechaNacimiento(new java.util.Date(sqlDate.getTime()));
                }

                paciente.setGenero(rs.getString("Genero_Paciente"));
            }

        } catch (SQLException e) {
            System.out.println("Error al buscar paciente: " + e.getMessage());
        }

    return paciente;
    }
    
}
