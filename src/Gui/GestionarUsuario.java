/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Gui;

import Modelo.Conexion;
import Modelo.Encriptador;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author farro
 */
public class GestionarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form CrearUsuario
     */
    public GestionarUsuario() {
        setUndecorated(true);
        initComponents();
        listarUsuarios(jtableUsuarios);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtCorreo = new javax.swing.JTextField();
        jpassContrasena = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jbttRegistrar = new javax.swing.JButton();
        jbttEliminar = new javax.swing.JButton();
        jCombCargo = new javax.swing.JComboBox<>();
        jbttValidar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jtxtNombres = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtxtApellidoM = new javax.swing.JTextField();
        jtxtApellidoP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableUsuarios = new javax.swing.JTable();
        jbttModificar = new javax.swing.JButton();
        jtxtProfesion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jbttActualizar = new javax.swing.JButton();
        bttCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setDoubleBuffered(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Gestionar Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 180, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DNI:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));
        jPanel1.add(jtxtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 150, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Correo:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, 20));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Contraseña:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Cargo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 20));
        jPanel1.add(jtxtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 280, -1));
        jPanel1.add(jpassContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 160, -1));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Para crear un usuario asegurese de que el documento de  identidad del empleado se encuentre registrado.");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 570, -1));

        jbttRegistrar.setBackground(new java.awt.Color(0, 0, 102));
        jbttRegistrar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jbttRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jbttRegistrar.setText("Registrar");
        jbttRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(jbttRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 110, -1));

        jbttEliminar.setBackground(new java.awt.Color(102, 0, 0));
        jbttEliminar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jbttEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jbttEliminar.setText("Eliminar");
        jbttEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jbttEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 110, -1));

        jCombCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Jefe de Area", "Usuario Limitado" }));
        jPanel1.add(jCombCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 210, -1));

        jbttValidar.setBackground(new java.awt.Color(0, 102, 0));
        jbttValidar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jbttValidar.setForeground(new java.awt.Color(255, 255, 255));
        jbttValidar.setText("Validar");
        jbttValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttValidarActionPerformed(evt);
            }
        });
        jPanel1.add(jbttValidar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Nombres:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));
        jPanel1.add(jtxtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 190, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Apellido Paterno:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Apellido Materno:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 20));
        jPanel1.add(jtxtApellidoM, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 180, -1));
        jPanel1.add(jtxtApellidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 180, -1));

        jtableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        jtableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 610, 150));

        jbttModificar.setBackground(new java.awt.Color(0, 102, 102));
        jbttModificar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jbttModificar.setForeground(new java.awt.Color(255, 255, 255));
        jbttModificar.setText("Modificar");
        jbttModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jbttModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 110, -1));
        jPanel1.add(jtxtProfesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 170, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Profesión:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jbttActualizar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jbttActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jbttActualizar.setText("Actualizar");
        jbttActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(jbttActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, 110, -1));

        bttCerrar.setText("Cerrar");
        bttCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(bttCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbttRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttRegistrarActionPerformed
        String dni = jtxtDni.getText().trim();
        String correo = jtxtCorreo.getText().trim();
        String contraseña = new String(jpassContrasena.getPassword()).trim();
        String cargo = jCombCargo.getSelectedItem().toString();

        if (dni.isEmpty() || correo.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos.");
            return;
        }

        if (!correo.contains("@")) {
            JOptionPane.showMessageDialog(null, "Correo inválido. Debe contener '@'.");
            return;
        }

        String contraseñaCifrada = Encriptador.encriptarSHA256(contraseña);
        if (contraseñaCifrada == null) {
            JOptionPane.showMessageDialog(null, "Error al cifrar la contraseña.");
            return;
        }

        try (Connection con = Conexion.getConexion()) {
            String sql = "INSERT INTO Usuario (Correo, Contraseña, Cargo, DNI_Personal) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, contraseñaCifrada);
            ps.setString(3, cargo);
            ps.setString(4, dni);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Usuario agregado correctamente.");
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el usuario.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage());
        }
    }//GEN-LAST:event_jbttRegistrarActionPerformed

    private void jbttValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttValidarActionPerformed
        String dni = jtxtDni.getText().trim();

        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un DNI.");
            return;
        }

        String sql = "SELECT p.Nombres_Personal, p.ApellidoPaterno_Personal, p.ApellidoMaterno_Personal, pr.Desc_Profesion " +
                     "FROM Personal p " +
                     "JOIN Profesion pr ON p.ID_Profesion = pr.ID_Profesion " +
                     "WHERE p.DNI_Personal = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setString(1, dni);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                jtxtNombres.setText(rs.getString("Nombres_Personal"));
                jtxtApellidoP.setText(rs.getString("ApellidoPaterno_Personal"));
                jtxtApellidoM.setText(rs.getString("ApellidoMaterno_Personal"));
                jtxtProfesion.setText(rs.getString("Desc_Profesion"));
            } else {
                JOptionPane.showMessageDialog(null, "El DNI no se encuentra registrado.");
                jtxtDni.setText("");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al validar el DNI: " + e.getMessage());
        }
        listarUsuarios(jtableUsuarios);
    }//GEN-LAST:event_jbttValidarActionPerformed

    private void jtableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableUsuariosMouseClicked
        int fila = jtableUsuarios.getSelectedRow();

        if (fila >= 0) {
            jtxtDni.setText(jtableUsuarios.getValueAt(fila, 3).toString());
            jtxtNombres.setText(jtableUsuarios.getValueAt(fila, 4).toString());
            jtxtApellidoP.setText(jtableUsuarios.getValueAt(fila, 5).toString());
            jtxtApellidoM.setText(jtableUsuarios.getValueAt(fila, 6).toString());
            jtxtProfesion.setText(jtableUsuarios.getValueAt(fila, 7).toString());
            jtxtCorreo.setText(jtableUsuarios.getValueAt(fila, 1).toString());
            jCombCargo.setSelectedItem(jtableUsuarios.getValueAt(fila, 2).toString());
            jpassContrasena.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila válida.");
        }

    }//GEN-LAST:event_jtableUsuariosMouseClicked

    private void jbttModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttModificarActionPerformed
        String dni = jtxtDni.getText().trim();
        String nuevaContrasena = new String(jpassContrasena.getPassword());
        String nuevoCargo = (String) jCombCargo.getSelectedItem();

        if (dni.isEmpty() || nuevaContrasena.isEmpty() || nuevoCargo == null) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos.");
            return;
        }

        String contrasenaCifrada = Modelo.Encriptador.encriptarSHA256(nuevaContrasena);

        String sql = "UPDATE Usuario SET Contraseña = ?, Cargo = ? WHERE DNI_Personal = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, contrasenaCifrada);
            ps.setString(2, nuevoCargo);
            ps.setString(3, dni);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Usuario modificado correctamente.");
                limpiarCampos();
                listarUsuarios(jtableUsuarios);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el usuario con ese DNI.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar usuario: " + e.getMessage());
        }
    }//GEN-LAST:event_jbttModificarActionPerformed

    private void jbttEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttEliminarActionPerformed
        String dni = jtxtDni.getText().trim();

        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar o seleccionar un DNI.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM Usuario WHERE DNI_Personal = ?";

            try (Connection con = Conexion.getConexion();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, dni);
                int filas = ps.executeUpdate();

                if (filas > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
                    limpiarCampos();
                    listarUsuarios(jtableUsuarios); 
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró un usuario con ese DNI.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jbttEliminarActionPerformed

    private void jbttActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttActualizarActionPerformed
        listarUsuarios(jtableUsuarios);
    }//GEN-LAST:event_jbttActualizarActionPerformed

    private void bttCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_bttCerrarActionPerformed
  
    public void listarUsuarios(JTable jtableUsuarios) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Correo");
        modelo.addColumn("Cargo");
        modelo.addColumn("DNI");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellido P.");
        modelo.addColumn("Apellido M.");
        modelo.addColumn("Profesión");

        String sql = "SELECT u.ID_Usuario, u.Correo, u.Cargo, p.DNI_Personal, " +
                     "p.Nombres_Personal, p.ApellidoPaterno_Personal, p.ApellidoMaterno_Personal, pr.Desc_Profesion " +
                     "FROM Usuario u " +
                     "INNER JOIN Personal p ON u.DNI_Personal = p.DNI_Personal " +
                     "INNER JOIN Profesion pr ON p.ID_Profesion = pr.ID_Profesion";

        try (Connection con = Conexion.getConexion(); 
             Statement st = con.createStatement(); 
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Object[] fila = {
                    rs.getInt("ID_Usuario"),
                    rs.getString("Correo"),
                    rs.getString("Cargo"),
                    rs.getString("DNI_Personal"),
                    rs.getString("Nombres_Personal"),
                    rs.getString("ApellidoPaterno_Personal"),
                    rs.getString("ApellidoMaterno_Personal"),
                    rs.getString("Desc_Profesion")
                };
                modelo.addRow(fila);
            }

            jtableUsuarios.setModel(modelo);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
        }
    }
    
    private void limpiarCampos() {
        jtxtDni.setText("");
        jtxtNombres.setText("");
        jtxtApellidoP.setText("");
        jtxtApellidoM.setText("");
        jtxtProfesion.setText("");
        jtxtCorreo.setText("");
        jpassContrasena.setText("");
        jCombCargo.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(GestionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttCerrar;
    private javax.swing.JComboBox<String> jCombCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbttActualizar;
    private javax.swing.JButton jbttEliminar;
    private javax.swing.JButton jbttModificar;
    private javax.swing.JButton jbttRegistrar;
    private javax.swing.JButton jbttValidar;
    private javax.swing.JPasswordField jpassContrasena;
    private javax.swing.JTable jtableUsuarios;
    private javax.swing.JTextField jtxtApellidoM;
    private javax.swing.JTextField jtxtApellidoP;
    private javax.swing.JTextField jtxtCorreo;
    private javax.swing.JTextField jtxtDni;
    private javax.swing.JTextField jtxtNombres;
    private javax.swing.JTextField jtxtProfesion;
    // End of variables declaration//GEN-END:variables
}
