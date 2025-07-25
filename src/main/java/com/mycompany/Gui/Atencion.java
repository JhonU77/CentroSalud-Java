/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.Gui;

import com.mycompany.Modelo.Conexion;
import com.mycompany.Modelo.ConsultasSql;
import com.mycompany.Modelo.SesionUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author farro
 */
public class Atencion extends javax.swing.JFrame {

    private int idCitaSeleccionada = -1;

    /**
     * Creates new form Atencion
     */
    public Atencion() {
        initComponents();
        MostrarCitas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMostrarCitas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAtencion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPaciente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        atxtDiagnostico = new javax.swing.JTextArea();
        bttRegistrarAtencion = new javax.swing.JButton();
        bttExportarPdf = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaResumenHistorial = new javax.swing.JTextArea();
        bttMirarAvanceMeta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableMostrarCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableMostrarCitas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMostrarCitasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMostrarCitas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 640, 140));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Atencion Medica");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 160, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Diagnostico:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 90, 20));

        txtAtencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAtencionActionPerformed(evt);
            }
        });
        jPanel1.add(txtAtencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 160, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Paciente:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 60, 20));
        jPanel1.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 80, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Edad:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 50, 20));
        jPanel1.add(txtPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 160, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Atencion:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 70, 20));

        atxtDiagnostico.setColumns(20);
        atxtDiagnostico.setLineWrap(true);
        atxtDiagnostico.setRows(5);
        jScrollPane2.setViewportView(atxtDiagnostico);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 280, 110));

        bttRegistrarAtencion.setText("Resgistrar atención");
        bttRegistrarAtencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRegistrarAtencionActionPerformed(evt);
            }
        });
        jPanel1.add(bttRegistrarAtencion, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 140, 30));

        bttExportarPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pdf (1).png"))); // NOI18N
        bttExportarPdf.setBorderPainted(false);
        bttExportarPdf.setContentAreaFilled(false);
        bttExportarPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttExportarPdfActionPerformed(evt);
            }
        });
        jPanel1.add(bttExportarPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 40, 30));

        areaResumenHistorial.setEditable(false);
        areaResumenHistorial.setColumns(20);
        areaResumenHistorial.setLineWrap(true);
        areaResumenHistorial.setRows(5);
        areaResumenHistorial.setWrapStyleWord(true);
        jScrollPane4.setViewportView(areaResumenHistorial);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 350, 280));

        bttMirarAvanceMeta.setText("Ver Progreso");
        bttMirarAvanceMeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttMirarAvanceMetaActionPerformed(evt);
            }
        });
        jPanel1.add(bttMirarAvanceMeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMostrarCitasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMostrarCitasMouseClicked
        int filaSeleccionada = tableMostrarCitas.getSelectedRow();

        if (filaSeleccionada != -1) {
            int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    "Estás a punto de atender esta cita. ¿Deseas continuar?",
                    "Confirmar Atención",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                idCitaSeleccionada = Integer.parseInt(tableMostrarCitas.getValueAt(filaSeleccionada, 0).toString());
                String dniPaciente = tableMostrarCitas.getValueAt(filaSeleccionada, 1).toString(); // índice 1

                String nombrePaciente = tableMostrarCitas.getValueAt(filaSeleccionada, 5).toString(); // ahora es índice 5
                String descAtencion = tableMostrarCitas.getValueAt(filaSeleccionada, 6).toString();

                txtPaciente.setText(nombrePaciente);
                txtAtencion.setText(descAtencion);

                // nueva versión de edad
                mostrarEdadPacientePorDni(dniPaciente);

            }
        }
    }//GEN-LAST:event_tableMostrarCitasMouseClicked

    private void txtAtencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAtencionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAtencionActionPerformed

    private void bttRegistrarAtencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRegistrarAtencionActionPerformed
        if (idCitaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Primero seleccione una cita de la tabla.");
            return;
        }

        String diagnostico = atxtDiagnostico.getText().trim();
        if (diagnostico.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un diagnóstico.");
            return;
        }

        String correo = SesionUsuario.getCorreoUsuario();
        String dniPersonal = ConsultasSql.obtenerDniPersonalPorCorreo(correo);

        if (dniPersonal == null) {
            JOptionPane.showMessageDialog(this, "No se pudo obtener el DNI del personal logeado.");
            return;
        }

        String sqlInsert = "INSERT INTO Historial (FechaRegistro_Historial, Diagnostico, ID_Cita) VALUES (?, ?, ?)";
        String sqlUpdate = "UPDATE Cita SET Estado_Cita = 'Atendido', DNI_Personal = ? WHERE ID_Cita = ?";

        try (Connection con = Conexion.getConexion(); PreparedStatement psInsert = con.prepareStatement(sqlInsert); PreparedStatement psUpdate = con.prepareStatement(sqlUpdate)) {

            Timestamp fechaActual = Timestamp.valueOf(LocalDateTime.now());

            // INSERTAR EN HISTORIAL
            psInsert.setTimestamp(1, fechaActual);
            psInsert.setString(2, diagnostico);
            psInsert.setInt(3, idCitaSeleccionada);
            psInsert.executeUpdate();

            // ACTUALIZAR ESTADO Y DNI_Personal DE LA CITA
            psUpdate.setString(1, dniPersonal);
            psUpdate.setInt(2, idCitaSeleccionada);
            psUpdate.executeUpdate();

            JOptionPane.showMessageDialog(this, "Atención registrada correctamente.");
            cargarDatosExtrasParaResumen(idCitaSeleccionada);

            // Limpiar campos
            atxtDiagnostico.setText("");
            txtPaciente.setText("");
            txtEdad.setText("");
            txtAtencion.setText("");
            idCitaSeleccionada = -1;
            MostrarCitas();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar atención: " + e.getMessage());
        }
    }//GEN-LAST:event_bttRegistrarAtencionActionPerformed

    private void bttExportarPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttExportarPdfActionPerformed
        if (areaResumenHistorial.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay contenido para exportar.");
            return;
        }

        Document documento = new Document();

        try {
            // Obtener ruta al escritorio
            String rutaEscritorio = System.getProperty("user.home") + "/Desktop/resumen_historial.pdf";

            PdfWriter.getInstance(documento, new FileOutputStream(rutaEscritorio));
            documento.open();

            // Agregar contenido del JTextArea
            String texto = areaResumenHistorial.getText();
            documento.add(new Paragraph(texto));

            documento.close();

            JOptionPane.showMessageDialog(this, "Resumen exportado correctamente a tu escritorio.");

        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(this, "Error al exportar PDF: " + e.getMessage());
        }
    }//GEN-LAST:event_bttExportarPdfActionPerformed

    private void bttMirarAvanceMetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttMirarAvanceMetaActionPerformed
        VerificarMetas metasDialog = new VerificarMetas(null, true);
        metasDialog.setLocationRelativeTo(this);
        metasDialog.setVisible(true);
    }//GEN-LAST:event_bttMirarAvanceMetaActionPerformed

    private void cargarDatosExtrasParaResumen(int idCita) {
        String sql = "SELECT "
                + "P.ApellidoMaterno_Paciente, "
                + "P.Genero_Paciente, "
                + "PR.Nombres_Personal + ' ' + PR.ApellidoPaterno_Personal AS Obstetra "
                + "FROM Cita C "
                + "INNER JOIN Paciente P ON C.DNI_Paciente = P.DNI_Paciente "
                + "INNER JOIN Personal PR ON C.DNI_Personal = PR.DNI_Personal "
                + "WHERE C.ID_Cita = ?";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idCita);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String apellidoMaterno = rs.getString("ApellidoMaterno_Paciente");
                String genero = rs.getString("Genero_Paciente");
                String obstetra = rs.getString("Obstetra");

                // Obtener también lo demás
                String nombrePaciente = txtPaciente.getText().split(" ")[0];
                String apellidoPaterno = txtPaciente.getText().split(" ")[1];
                String edad = txtEdad.getText();
                String atencion = txtAtencion.getText();
                String diagnostico = atxtDiagnostico.getText();

                // Armar el texto
                String resumen = """
                             Historial
                Datos del paciente:
                  Nombre: %s
                  Apellido Paterno: %s
                  Apellido Materno: %s
                  Edad: %s
                  Género: %s

                Datos de Cita:
                  Obstetra: %s
                  Atención: %s
                  Diagnóstico: %s
                """.formatted(
                        nombrePaciente,
                        apellidoPaterno,
                        apellidoMaterno,
                        edad,
                        genero,
                        obstetra,
                        atencion,
                        diagnostico
                );

                areaResumenHistorial.setText(resumen);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar datos del resumen: " + e.getMessage());
        }
    }

    private void mostrarEdadPacientePorDni(String dni) {
        String sql = "SELECT FechaNacimiento_Paciente FROM Paciente WHERE DNI_Paciente = ?";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                java.sql.Date fechaNacimiento = rs.getDate("FechaNacimiento_Paciente");

                LocalDate nacimiento = fechaNacimiento.toLocalDate();
                LocalDate hoy = LocalDate.now();
                int edad = Period.between(nacimiento, hoy).getYears();

                txtEdad.setText(String.valueOf(edad));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al calcular edad: " + e.getMessage());
        }
    }

    private void MostrarCitas() {
        actualizarCitasVencidas();

        String[] columnas = {"ID_Cita", "DNI_Paciente", "Fecha Atención", "Hora Atención", "Establecimiento", "Paciente", "Atención", "Estado"};
        DefaultTableModel model = new DefaultTableModel(null, columnas);
        tableMostrarCitas.setModel(model);

        for (int i = 0; i < 2; i++) {
            tableMostrarCitas.getColumnModel().getColumn(i).setMinWidth(0);
            tableMostrarCitas.getColumnModel().getColumn(i).setMaxWidth(0);
            tableMostrarCitas.getColumnModel().getColumn(i).setWidth(0);
        }

        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

        String sql = "SELECT "
                + "C.ID_Cita, "
                + "P.DNI_Paciente, "
                + "C.FechaAtencion_Cita, "
                + "C.HoraAtencion_Cita, "
                + "E.Nombre_Establecimiento, "
                + "P.Nombres_Paciente + ' ' + P.ApellidoPaterno_Paciente AS NombrePaciente, "
                + "A.Desc_Atencion, "
                + "C.Estado_Cita "
                + "FROM Cita C "
                + "INNER JOIN Establecimiento E ON C.ID_Establecimiento = E.ID_Establecimiento "
                + "INNER JOIN Paciente P ON C.DNI_Paciente = P.DNI_Paciente "
                + "INNER JOIN Atencion A ON C.ID_Atencion = A.ID_Atencion "
                + "WHERE (C.Estado_Cita IS NULL OR C.Estado_Cita = 'Pendiente') "
                + "AND C.FechaAtencion_Cita = CAST(GETDATE() AS DATE)";

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Object[] fila = new Object[8];
                fila[0] = rs.getInt("ID_Cita");
                fila[1] = rs.getString("DNI_Paciente");
                fila[2] = rs.getDate("FechaAtencion_Cita");

                Time hora = rs.getTime("HoraAtencion_Cita");
                fila[3] = (hora != null) ? formatoHora.format(hora) : "";

                fila[4] = rs.getString("Nombre_Establecimiento");
                fila[5] = rs.getString("NombrePaciente");
                fila[6] = rs.getString("Desc_Atencion");
                fila[7] = rs.getString("Estado_Cita");

                model.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al mostrar citas: " + e.getMessage());
        }
    }

    private void actualizarCitasVencidas() {
        String sqlUpdate = """
            UPDATE Cita
            SET Estado_Cita = 'Vencido'
            WHERE (Estado_Cita IS NULL OR Estado_Cita = 'Pendiente')
              AND FechaAtencion_Cita < CAST(GETDATE() AS DATE)
        """;

        try (Connection con = Conexion.getConexion(); PreparedStatement ps = con.prepareStatement(sqlUpdate)) {
            ps.executeUpdate();  // Marca las citas vencidas solo por fecha
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar citas vencidas: " + e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Atencion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Atencion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaResumenHistorial;
    private javax.swing.JTextArea atxtDiagnostico;
    private javax.swing.JButton bttExportarPdf;
    private javax.swing.JButton bttMirarAvanceMeta;
    private javax.swing.JButton bttRegistrarAtencion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tableMostrarCitas;
    private javax.swing.JTextField txtAtencion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtPaciente;
    // End of variables declaration//GEN-END:variables
}
