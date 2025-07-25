/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.Gui;

import com.mycompany.Modelo.Conexion;
import com.mycompany.Modelo.SesionUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author farro
 */
public class RecuperarContrasena extends javax.swing.JDialog {

    /**
     * Creates new form RecuperarContrasena
     */
    public RecuperarContrasena(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
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
        jLabel6 = new javax.swing.JLabel();
        jtxtCorreo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bttConfirmar = new javax.swing.JButton();
        bttCerra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("¿Olvido su contraseña?");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 200, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Ingrese su dni y su correo . tenga en cuenta que");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 250, 20));
        jPanel1.add(jtxtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 250, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("DNI:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 40, -1));
        jPanel1.add(jtxtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 250, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setText("Correo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 60, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("esté todo bien escrito.");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        bttConfirmar.setBackground(new java.awt.Color(0, 0, 102));
        bttConfirmar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        bttConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        bttConfirmar.setText("Confirmar");
        bttConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttConfirmarActionPerformed(evt);
            }
        });
        jPanel1.add(bttConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 100, -1));

        bttCerra.setBackground(new java.awt.Color(153, 0, 0));
        bttCerra.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        bttCerra.setForeground(new java.awt.Color(255, 255, 255));
        bttCerra.setText("Cerrar");
        bttCerra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCerraActionPerformed(evt);
            }
        });
        jPanel1.add(bttCerra, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttConfirmarActionPerformed
        String dni = jtxtDni.getText().trim();
        String correo = jtxtCorreo.getText().trim();

        if (dni.isEmpty() || correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar DNI y correo");
            return;
        }

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = Conexion.getConexion();
            String sql = "SELECT * FROM Usuario u JOIN Personal p ON u.DNI_Personal = p.DNI_Personal WHERE u.DNI_Personal = ? AND u.Correo = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            ps.setString(2, correo);
            rs = ps.executeQuery();

            if (rs.next()) {

                SesionUsuario.setRestauracion(dni, correo);
                CambioContrasena conf = new CambioContrasena(this, true);
                conf.setLocationRelativeTo(null);
                conf.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "DNI y/o correo no están registrados");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
        }
    }//GEN-LAST:event_bttConfirmarActionPerformed

    private void bttCerraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCerraActionPerformed
        dispose();
    }//GEN-LAST:event_bttCerraActionPerformed

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
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecuperarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RecuperarContrasena dialog = new RecuperarContrasena(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttCerra;
    private javax.swing.JButton bttConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtxtCorreo;
    private javax.swing.JTextField jtxtDni;
    // End of variables declaration//GEN-END:variables
}
