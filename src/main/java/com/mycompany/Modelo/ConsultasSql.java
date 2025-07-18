/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Modelo;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author farro
 */
public class ConsultasSql {
    
    public static String obtenerDniPersonalPorNombre(String nombres, String apellidoPaterno) {
        String dni = null;
        String sql = "SELECT DNI_Personal FROM Personal WHERE Nombres_Personal = ? AND ApellidoPaterno_Personal = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombres);
            ps.setString(2, apellidoPaterno);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                dni = rs.getString("DNI_Personal");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener DNI del personal: " + e.getMessage());
        }

        return dni;
    }
    
    public static String obtenerDniPersonalPorCorreo(String correo) {
        String dni = null;
        String sql = "SELECT DNI_Personal FROM Usuario WHERE Correo = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dni = rs.getString("DNI_Personal");
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener DNI_Personal: " + e.getMessage());
        }

        return dni;
    }

    
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
        return -1;
    }

    // Obtener ID de Condición según el nombre
    public static int obtenerIdColegio(String descColegio) {
        String sql = "SELECT ID_Colegio FROM Colegio WHERE Desc_Colegio = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, descColegio);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("ID_Colegio");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener ID_Colegio: " + e.getMessage());
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
    
    
    public static int obtenerIdAtencion(String nombre) {
        int id = -1;
        try (Connection con = Conexion.getConexion()) {
            String sql = "SELECT ID_Atencion FROM Atencion WHERE Desc_Atencion = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public static String obtenerDescripcionAtencionPorId(int idAtencion) {
        String descripcion = null;
        String sql = "SELECT Desc_Atencion FROM Atencion WHERE ID_Atencion = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idAtencion);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                descripcion = rs.getString("Desc_Atencion");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener descripción de atención: " + e.getMessage());
        }

        return descripcion;
    }

    // Obtener el Id del usuario por correo
    public static int obtenerIdUsuarioPorCorreo(String correo) {
        int idUsuario = -1;
        try (Connection con = Conexion.getConexion()) {
            String sql = "SELECT ID_Usuario FROM Usuario WHERE Correo = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idUsuario = rs.getInt("ID_Usuario");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener ID_Usuario: " + e.getMessage());
        }
        return idUsuario;
    }
    
    public static void cargarColegio(JComboBox<String> cmbColegio) {
        String sql = "SELECT Desc_Colegio FROM Colegio";

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            cmbColegio.removeAllItems();
            while (rs.next()) {
                cmbColegio.addItem(rs.getString("Desc_Colegio"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar colegio: " + e.getMessage());
        }
    }
    
    public static void cargarAtenciones(JComboBox<String> cmbAtencion){
        String sql = "SELECT Desc_Atencion FROM Atencion";
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            cmbAtencion.removeAllItems();
            while (rs.next()) {
                cmbAtencion.addItem(rs.getString("Desc_Atencion"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar Atenciones: " + e.getMessage());
        }
    }
    
//Consutal de la tabla Establecimiento
    public static void cargarEstablecimiento(JComboBox<String> cmbEstablecimiento){
        String sql = "SELECT Nombre_Establecimiento FROM Establecimiento";
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            cmbEstablecimiento.removeAllItems();
            while (rs.next()) {
                cmbEstablecimiento.addItem(rs.getString("Nombre_Establecimiento"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar Atenciones: " + e.getMessage());
        }
    }
    
    public static int obtenerIdEstablecimiento(String nombre) {
        int id = -1;
        try (Connection con = Conexion.getConexion()) {
            String sql = "SELECT ID_Establecimiento FROM Establecimiento WHERE Nombre_Establecimiento = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt("ID_Establecimiento");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    
    public static void filtrarRedes(JComboBox<String> cmbRed, String texto) {
        cmbRed.removeAllItems();
        String sql = "SELECT DISTINCT Red FROM Establecimiento WHERE Red LIKE ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, "%" + texto + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cmbRed.addItem(rs.getString("Red"));
            }

            // Restaurar el texto que estaba escribiendo el usuario
            cmbRed.getEditor().setItem(texto);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al filtrar redes: " + e.getMessage());
        }
    }

    public static void cargarMicroredesPorRed(JComboBox<String> cmbMicrored, String redSeleccionada) {
        String sql = "SELECT DISTINCT Microred FROM Establecimiento WHERE Red = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, redSeleccionada);
            ResultSet rs = ps.executeQuery();

            cmbMicrored.removeAllItems();

            while (rs.next()) {
                cmbMicrored.addItem(rs.getString("Microred"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar microredes: " + e.getMessage());
        }
    }
    
    public static void cargarEstablecimientosPorMicrored(JComboBox<String> cmbEstablecimiento, String microredSeleccionada) {
        String sql = "SELECT Nombre_Establecimiento FROM Establecimiento WHERE Microred = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, microredSeleccionada);
            ResultSet rs = ps.executeQuery();

            cmbEstablecimiento.removeAllItems();

            while (rs.next()) {
                cmbEstablecimiento.addItem(rs.getString("Nombre_Establecimiento"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar establecimientos: " + e.getMessage());
        }
    }
    
    public static boolean existeCitaEnFechaHora(String fecha, String hora, int idEstablecimiento) {
        String sql = "SELECT COUNT(*) FROM Cita WHERE FechaAtencion_Cita = ? AND HoraAtencion_Cita = ? AND ID_Establecimiento = ?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, fecha);
            ps.setString(2, hora);
            ps.setInt(3, idEstablecimiento);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    
    public static List<LocalTime> obtenerHorasOcupadas(Date fecha, int idEstablecimiento) {
        List<LocalTime> horasOcupadas = new ArrayList<>();
        String sql = "SELECT HoraAtencion_Cita FROM Cita WHERE FechaAtencion_Cita = ? AND ID_Establecimiento = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDate(1, new java.sql.Date(fecha.getTime()));
            ps.setInt(2, idEstablecimiento);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Time hora = rs.getTime("HoraAtencion_Cita");
                if (hora != null) {
                    horasOcupadas.add(hora.toLocalTime());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return horasOcupadas;
    }


    public static void buscarPersonalPorEstablecimiento(JTable tabla, String nombreEstablecimiento) {
        String sql = "SELECT p.Nombres_Personal, p.ApellidoPaterno_Personal, pr.Desc_Profesion, c.Desc_Colegio " +
                     "FROM Personal p " +
                     "INNER JOIN Profesion pr ON p.ID_Profesion = pr.ID_Profesion " +
                     "INNER JOIN Colegio c ON p.ID_Colegio = c.ID_Colegio " +
                     "INNER JOIN Establecimiento e ON p.ID_Establecimiento = e.ID_Establecimiento " +
                     "WHERE e.Nombre_Establecimiento = ?";

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombres");
        model.addColumn("Apellido Paterno");
        model.addColumn("Profesión");
        model.addColumn("Colegio");

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombreEstablecimiento);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[4];
                fila[0] = rs.getString("Nombres_Personal");
                fila[1] = rs.getString("ApellidoPaterno_Personal");
                fila[2] = rs.getString("Desc_Profesion");
                fila[3] = rs.getString("Desc_Colegio");
                model.addRow(fila);
            }

            tabla.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar personal: " + e.getMessage());
        }
    }

    public static void cargarProfesiones(JComboBox<String> cmbProfesion) {
        String sql = "SELECT Desc_Profesion FROM Profesion";

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            cmbProfesion.removeAllItems();
            while (rs.next()) {
                cmbProfesion.addItem(rs.getString("Desc_Profesion"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar profesiones: " + e.getMessage());
        }
    }
    
}
