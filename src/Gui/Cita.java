/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import Modelo.Conexion;
import Modelo.ConsultaReniec;
import Modelo.ConsultasSql;
import Modelo.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author farro
 */
public class Cita extends javax.swing.JFrame {

    /**
     * Creates new form Cita
     */
    public Cita() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtApellidoMaternoPaciente = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        txtNombrePaciente = new javax.swing.JTextField();
        txtApellidoPaternoPaciente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dateFechaNacimientoPaciente = new com.toedter.calendar.JDateChooser();
        checkMasculino = new javax.swing.JCheckBox();
        checkFemenino = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bttRegistrarPaciente = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        bttLimpiarCampos = new javax.swing.JButton();
        bttBuscarPaciente1 = new javax.swing.JButton();
        bttBuscarPaciente = new javax.swing.JButton();
        txtDniPaciente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Citas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 50, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Apellido M:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 80, 20));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Datos de la Cita");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Establecimiento:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 110, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombre:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 60, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Genero:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 60, 20));
        jPanel1.add(txtApellidoMaternoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 110, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 90, -1));
        jPanel1.add(txtNombrePaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 100, -1));
        jPanel1.add(txtApellidoPaternoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 110, -1));

        jButton1.setText("Registrar Cita");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 120, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 640, 170));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Apellido P:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 80, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Fecha Nacimiento:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 120, 20));
        jPanel1.add(dateFechaNacimientoPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        checkMasculino.setForeground(new java.awt.Color(0, 0, 0));
        checkMasculino.setText("M");
        jPanel1.add(checkMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, -1, -1));

        checkFemenino.setForeground(new java.awt.Color(0, 0, 0));
        checkFemenino.setText("F");
        jPanel1.add(checkFemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("_____________________________________________________________________________________________________________________________________________");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Dni:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 30, 20));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Datos del Paciente");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        bttRegistrarPaciente.setText("Registrar Paciente");
        bttRegistrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRegistrarPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(bttRegistrarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 130, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Descripción de atención:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 160, 20));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 150, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Hora Atención:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 110, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Obstetra:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 70, 20));
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Fecha Atención:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 110, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 150, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 150, -1));

        bttLimpiarCampos.setText("Limpiar Campos");
        bttLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttLimpiarCamposActionPerformed(evt);
            }
        });
        jPanel1.add(bttLimpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, 130, -1));

        bttBuscarPaciente1.setText("Buscar Paciente");
        bttBuscarPaciente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBuscarPaciente1ActionPerformed(evt);
            }
        });
        jPanel1.add(bttBuscarPaciente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 130, -1));

        bttBuscarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Confirm.png"))); // NOI18N
        bttBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBuscarPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(bttBuscarPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 30, -1));
        jPanel1.add(txtDniPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 90, -1));

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttRegistrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRegistrarPacienteActionPerformed
        String dni = txtDniPaciente.getText().trim();
        String nombres = txtNombrePaciente.getText().trim();
        String apellidoPaterno = txtApellidoPaternoPaciente.getText().trim();
        String apellidoMaterno = txtApellidoMaternoPaciente.getText().trim();

        if (dateFechaNacimientoPaciente.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Selecciona la fecha de nacimiento.");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaNacimiento = sdf.format(dateFechaNacimientoPaciente.getDate());

        String genero = "";
        if (checkMasculino.isSelected()) {
            genero = "M";
        } else if (checkFemenino.isSelected()) {
            genero = "F";
        }

        if (dni.isEmpty() || nombres.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() || genero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos.");
            return;
        }

        //Verificar si el DNI ya existe usando la clase ConsultasSql
        if (ConsultasSql.dniExiste(dni)) {
            JOptionPane.showMessageDialog(this, "El DNI ya está registrado.");
            return;
        }

        try (Connection con = Conexion.getConexion()) {
            String sql = "INSERT INTO Paciente (DNI_Paciente, Nombres_Paciente, ApellidoPaterno_Paciente, ApellidoMaterno_Paciente, FechaNacimiento_Paciente, Genero_Paciente) "
                       + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, nombres);
            ps.setString(3, apellidoPaterno);
            ps.setString(4, apellidoMaterno);
            ps.setString(5, fechaNacimiento);
            ps.setString(6, genero);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Paciente registrado correctamente.");
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo registrar el paciente.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar: " + ex.getMessage());
        }
    }//GEN-LAST:event_bttRegistrarPacienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bttLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttLimpiarCamposActionPerformed
        txtDniPaciente.setText("");
        txtNombrePaciente.setText("");
        txtApellidoPaternoPaciente.setText("");
        txtApellidoMaternoPaciente.setText("");
        dateFechaNacimientoPaciente.setDate(null);
        checkMasculino.setSelected(false);
        checkFemenino.setSelected(false);
        txtDniPaciente.requestFocus();
    }//GEN-LAST:event_bttLimpiarCamposActionPerformed

    private void bttBuscarPaciente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBuscarPaciente1ActionPerformed
        String dni = txtDniPaciente.getText().trim();

        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese un DNI.");
            return;
        }

        ConsultasSql consultas = new ConsultasSql();
        Paciente paciente = consultas.buscarPacientePorDni(dni);

        if (paciente != null) {
            txtNombrePaciente.setText(paciente.getNombres());
            txtApellidoPaternoPaciente.setText(paciente.getApellidoPaterno());
            txtApellidoMaternoPaciente.setText(paciente.getApellidoMaterno());
            dateFechaNacimientoPaciente.setDate(paciente.getFechaNacimiento());

            // Marcar checkbox según género
            if (paciente.getGenero().equalsIgnoreCase("M")) {
                checkMasculino.setSelected(true);
                checkFemenino.setSelected(false);
            } else if (paciente.getGenero().equalsIgnoreCase("F")) {
                checkFemenino.setSelected(true);
                checkMasculino.setSelected(false);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Paciente no registrado.");
        }
    }//GEN-LAST:event_bttBuscarPaciente1ActionPerformed

    private void bttBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBuscarPacienteActionPerformed
        String dni = txtDniPaciente.getText().trim();

        if (dni.length() != 8) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un DNI válido de 8 dígitos.");
            return;
        }

        ConsultaReniec consultas = new ConsultaReniec();
        String[] datos = consultas.obtenerDatosDni(dni);

        if (datos[0] != null) {
            txtNombrePaciente.setText(datos[0]);
            txtApellidoPaternoPaciente.setText(datos[1]);
            txtApellidoMaternoPaciente.setText(datos[2]);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el DNI o hubo un error.");
        }
    }//GEN-LAST:event_bttBuscarPacienteActionPerformed

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
            java.util.logging.Logger.getLogger(Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttBuscarPaciente;
    private javax.swing.JButton bttBuscarPaciente1;
    private javax.swing.JButton bttLimpiarCampos;
    private javax.swing.JButton bttRegistrarPaciente;
    private javax.swing.JCheckBox checkFemenino;
    private javax.swing.JCheckBox checkMasculino;
    private com.toedter.calendar.JDateChooser dateFechaNacimientoPaciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField txtApellidoMaternoPaciente;
    private javax.swing.JTextField txtApellidoPaternoPaciente;
    private javax.swing.JTextField txtDniPaciente;
    private javax.swing.JTextField txtNombrePaciente;
    // End of variables declaration//GEN-END:variables
}
