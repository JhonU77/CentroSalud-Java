/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.Gui;

import com.mycompany.Modelo.Conexion;
import com.mycompany.Modelo.ExportarReportes;
import com.mycompany.Modelo.ConsultasSql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import com.mycompany.Modelo.ConsultasSql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author farro
 */
public class Reportes extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    public Reportes() {
        initComponents();
        ConsultasSql.cargarAtenciones(cmbAtencionEstablecimiento); 
        ConsultasSql.cargarAtenciones(cmbAtencionPersonal); 
        cmbRedEstablecimiento.setEditable(true);
        cmbMicroredEstablecimiento.setEditable(true);
        cmbEstablecimientoEstablecimiento.setEditable(true);
        cmbRedPersonal.setEditable(true);
        cmbMicroredPersonal.setEditable(true);
        cmbEstablecimientoPersonal.setEditable(true);
        JTextField editor = (JTextField) cmbRedEstablecimiento.getEditor().getEditorComponent();
        editor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String texto = editor.getText();
                ConsultasSql.filtrarRedes(cmbRedEstablecimiento, texto);
            }
        }); 
        JTextField editor1 = (JTextField) cmbRedPersonal.getEditor().getEditorComponent();
        editor1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String texto = editor1.getText();
                ConsultasSql.filtrarRedes(cmbRedPersonal, texto);
            }
        }); 
        // para establecimiento:
        for (int i = 18; i <= 100; i++) {
            cmbEdadDesdeEstablecimiento.addItem(i);
            cmbEdadHastaEstablecimiento.addItem(i);
        }

        cmbEdadDesdeEstablecimiento.setEnabled(false);
        cmbEdadHastaEstablecimiento.setEnabled(false);

        ButtonGroup grupoEdad = new ButtonGroup();
        grupoEdad.add(checkSi);
        grupoEdad.add(checkNo);

        checkSi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkSi.isSelected()) {
                    cmbEdadDesdeEstablecimiento.setEnabled(true);
                    cmbEdadHastaEstablecimiento.setEnabled(true);
                }
            }
        });

        checkNo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkNo.isSelected()) {
                    cmbEdadDesdeEstablecimiento.setEnabled(false);
                    cmbEdadHastaEstablecimiento.setEnabled(false);
                }
            }
        });
        
        // Para Personal:
        for (int i = 18; i <= 100; i++) {
            cmbEdadDesdePersonal.addItem(i);
            cmbEdadHastaPersonal.addItem(i);
        }

        cmbEdadDesdePersonal.setEnabled(false);
        cmbEdadHastaPersonal.setEnabled(false);

        ButtonGroup grupoEdadPersonal = new ButtonGroup();
        grupoEdadPersonal.add(checkSi1);
        grupoEdadPersonal.add(checkNo1);

        checkSi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkSi1.isSelected()) {
                    cmbEdadDesdePersonal.setEnabled(true);
                    cmbEdadHastaPersonal.setEnabled(true);
                }
            }
        });

        checkNo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkNo1.isSelected()) {
                    cmbEdadDesdePersonal.setEnabled(false);
                    cmbEdadHastaPersonal.setEnabled(false);
                }
            }
        });
        
        String[] columnas = {
            "Nombre Reporte", "Fecha Registro", "Fecha Inicio", "Fecha Fin",
            "Cantidad Exámenes", "ID Atención", "Establecimiento"
        };

        DefaultTableModel modelo = new DefaultTableModel(null, columnas);
        tableMostrarReporteEstablecimiento.setModel(modelo);
        
        String[] columnasPersonal = {
            "Personal", "Nombre Reporte", "Fecha Registro", "Fecha Inicio", 
            "Fecha Fin", "Cantidad Exámenes", "Atención"
        };
        DefaultTableModel model = new DefaultTableModel(null, columnasPersonal);
        tableMostrarReportePersonal.setModel(model);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMostrarReportePersonal = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtNombreReportePersonal = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cmbAtencionPersonal = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        dateFechaInicioPersonal = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        dateFechaFinPersonal = new com.toedter.calendar.JDateChooser();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        checkSi1 = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();
        checkNo1 = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        cmbEdadDesdePersonal = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        cmbEdadHastaPersonal = new javax.swing.JComboBox<>();
        bttGuardarExportarReportePersonal = new javax.swing.JButton();
        bttMostrarReportePersonal = new javax.swing.JButton();
        bttGuardarReportePersonal = new javax.swing.JButton();
        bttLimpiarReportePersonal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cmbRedPersonal = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        cmbEstablecimientoPersonal = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        cmbMicroredPersonal = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePersonal = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        txtNombrePersonal = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtApellidoPaternoPersonal = new javax.swing.JTextField();
        bttBuscarPersonal = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        cmbRedEstablecimiento = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        cmbMicroredEstablecimiento = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbEstablecimientoEstablecimiento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        bttMostrarReporteEstablecimiento = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbAtencionEstablecimiento = new javax.swing.JComboBox<>();
        dateFechaFinEstablecimiento = new com.toedter.calendar.JDateChooser();
        dateFechaInicioEstablecimiento = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cmbEdadHastaEstablecimiento = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        checkNo = new javax.swing.JCheckBox();
        checkSi = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMostrarReporteEstablecimiento = new javax.swing.JTable();
        cmbEdadDesdeEstablecimiento = new javax.swing.JComboBox<>();
        bttGuardarReporteEstablecimiento = new javax.swing.JButton();
        bttGuardarExportarReporteEstablecimiento = new javax.swing.JButton();
        bttLimpiarCamposEstablecimiento = new javax.swing.JButton();
        bttExportarTodosReportesEstablecimiento = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtNombreReporteEstablecimiento = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableMostrarReportePersonal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableMostrarReportePersonal);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 640, 120));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 51));
        jLabel4.setText("Reporte de Personal");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 170, 30));
        jPanel1.add(txtNombreReportePersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 320, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Atencion:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 70, 20));

        jPanel1.add(cmbAtencionPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 150, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Fecha Inicio:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 80, 20));
        jPanel1.add(dateFechaInicioPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 115, -1));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Fecha Fin:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 70, 20));
        jPanel1.add(dateFechaFinPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 115, -1));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Desea filtrar por rango de edad?");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 210, 20));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText(" Si:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 30, 20));
        jPanel1.add(checkSi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 20, 20));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("No:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 280, 30, 20));
        jPanel1.add(checkNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 20, 20));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Edad desde:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 80, 20));

        jPanel1.add(cmbEdadDesdePersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 60, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Edad hasta:");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 80, 20));

        jPanel1.add(cmbEdadHastaPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 60, -1));

        bttGuardarExportarReportePersonal.setText("Guardar y exportar");
        bttGuardarExportarReportePersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttGuardarExportarReportePersonalActionPerformed(evt);
            }
        });
        jPanel1.add(bttGuardarExportarReportePersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, 130, -1));

        bttMostrarReportePersonal.setText("Mostrar reporte");
        bttMostrarReportePersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttMostrarReportePersonalActionPerformed(evt);
            }
        });
        jPanel1.add(bttMostrarReportePersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 130, -1));

        bttGuardarReportePersonal.setText("Guardar reporte");
        bttGuardarReportePersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttGuardarReportePersonalActionPerformed(evt);
            }
        });
        jPanel1.add(bttGuardarReportePersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 130, -1));

        bttLimpiarReportePersonal.setText("Limpiar reporte");
        bttLimpiarReportePersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttLimpiarReportePersonalActionPerformed(evt);
            }
        });
        jPanel1.add(bttLimpiarReportePersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 130, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 51));
        jLabel5.setText("Datos del Personal");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 51));
        jLabel6.setText("Datos del Reporte");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 150, 30));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Nombre de reporte:");
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 130, 20));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Red:");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 40, 20));

        cmbRedPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRedPersonalActionPerformed(evt);
            }
        });
        jPanel1.add(cmbRedPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 180, -1));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Establecimiento:");
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 110, 20));

        cmbEstablecimientoPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstablecimientoPersonalActionPerformed(evt);
            }
        });
        jPanel1.add(cmbEstablecimientoPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 350, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Microred:");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 70, 20));

        cmbMicroredPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMicroredPersonalActionPerformed(evt);
            }
        });
        jPanel1.add(cmbMicroredPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 150, -1));

        tablePersonal.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePersonalMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablePersonal);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 620, 60));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Nombre:");
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 60, 20));
        jPanel1.add(txtNombrePersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 110, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Apellido P:");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 70, 20));
        jPanel1.add(txtApellidoPaternoPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 110, -1));

        bttBuscarPersonal.setText("Buscar personal");
        bttBuscarPersonal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttBuscarPersonalActionPerformed(evt);
            }
        });
        jPanel1.add(bttBuscarPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 130, -1));

        jTabbedPane1.addTab("Reporte Personal", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Red:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 40, 20));

        cmbRedEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRedEstablecimientoActionPerformed(evt);
            }
        });
        jPanel2.add(cmbRedEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 180, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Microred:");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 70, 20));

        cmbMicroredEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMicroredEstablecimientoActionPerformed(evt);
            }
        });
        jPanel2.add(cmbMicroredEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 150, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Establecimiento:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 110, 20));

        cmbEstablecimientoEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstablecimientoEstablecimientoActionPerformed(evt);
            }
        });
        jPanel2.add(cmbEstablecimientoEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 350, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Reporte de Establecimiento");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 230, 30));

        bttMostrarReporteEstablecimiento.setText("Mostrar reporte");
        bttMostrarReporteEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttMostrarReporteEstablecimientoActionPerformed(evt);
            }
        });
        jPanel2.add(bttMostrarReporteEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 130, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Fecha Inicio:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 80, 20));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Fecha Fin:");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 70, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Edad hasta:");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 80, 20));

        jPanel2.add(cmbAtencionEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 150, -1));
        jPanel2.add(dateFechaFinEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 115, -1));
        jPanel2.add(dateFechaInicioEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 115, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 51));
        jLabel2.setText("Datos del Establecimiento");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 51));
        jLabel3.setText("Datos del Reporte");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 150, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Nombre de reporte:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 130, 20));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Desea filtrar por rango de edad?");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 210, 20));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("No:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 30, 20));

        jPanel2.add(cmbEdadHastaEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 240, 60, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Edad desde:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 80, 20));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText(" Si:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 30, 20));
        jPanel2.add(checkNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 20, 20));
        jPanel2.add(checkSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 20, 20));

        tableMostrarReporteEstablecimiento.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableMostrarReporteEstablecimiento);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 640, 210));

        jPanel2.add(cmbEdadDesdeEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 60, -1));

        bttGuardarReporteEstablecimiento.setText("Guardar reporte");
        bttGuardarReporteEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttGuardarReporteEstablecimientoActionPerformed(evt);
            }
        });
        jPanel2.add(bttGuardarReporteEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 130, -1));

        bttGuardarExportarReporteEstablecimiento.setText("Guardar y exportar");
        bttGuardarExportarReporteEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttGuardarExportarReporteEstablecimientoActionPerformed(evt);
            }
        });
        jPanel2.add(bttGuardarExportarReporteEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 130, -1));

        bttLimpiarCamposEstablecimiento.setText("Limpiar reporte");
        bttLimpiarCamposEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttLimpiarCamposEstablecimientoActionPerformed(evt);
            }
        });
        jPanel2.add(bttLimpiarCamposEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 130, -1));

        bttExportarTodosReportesEstablecimiento.setBackground(new java.awt.Color(0, 0, 102));
        bttExportarTodosReportesEstablecimiento.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        bttExportarTodosReportesEstablecimiento.setForeground(new java.awt.Color(0, 0, 102));
        bttExportarTodosReportesEstablecimiento.setText("Exportar todos los reportes");
        bttExportarTodosReportesEstablecimiento.setBorderPainted(false);
        bttExportarTodosReportesEstablecimiento.setContentAreaFilled(false);
        bttExportarTodosReportesEstablecimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttExportarTodosReportesEstablecimientoActionPerformed(evt);
            }
        });
        jPanel2.add(bttExportarTodosReportesEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 200, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 3, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Atencion:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 70, 20));
        jPanel2.add(txtNombreReporteEstablecimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 320, -1));

        jTabbedPane1.addTab("Reporte Establecimiento", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbRedEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRedEstablecimientoActionPerformed
        if (cmbRedEstablecimiento.getSelectedItem() != null) {
            String redSeleccionada = cmbRedEstablecimiento.getSelectedItem().toString();
            ConsultasSql.cargarMicroredesPorRed(cmbMicroredEstablecimiento, redSeleccionada);
        }
    }//GEN-LAST:event_cmbRedEstablecimientoActionPerformed

    private void cmbMicroredEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMicroredEstablecimientoActionPerformed
        if (cmbMicroredEstablecimiento.getSelectedItem() != null) {
            String microredSeleccionada = cmbMicroredEstablecimiento.getSelectedItem().toString();
            ConsultasSql.cargarEstablecimientosPorMicrored(cmbEstablecimientoEstablecimiento, microredSeleccionada);
        }
    }//GEN-LAST:event_cmbMicroredEstablecimientoActionPerformed

    private void cmbEstablecimientoEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstablecimientoEstablecimientoActionPerformed

    }//GEN-LAST:event_cmbEstablecimientoEstablecimientoActionPerformed

    private void bttMostrarReporteEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttMostrarReporteEstablecimientoActionPerformed
        System.out.println(">>> Ejecutando boton mostrar reporte");
        generarReporteYMostrar();
    }//GEN-LAST:event_bttMostrarReporteEstablecimientoActionPerformed

    private void bttGuardarReporteEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGuardarReporteEstablecimientoActionPerformed
        System.out.println(">>> Ejecutando boton guardar reporte");
        List<Object[]> reporte = generarReporteYMostrar();
        if (reporte.isEmpty()) return;

        boolean guardado = guardarReporteEnBD(reporte.get(0));
        if (guardado) {
            JOptionPane.showMessageDialog(null, "Reporte guardado correctamente.");
        }
    }//GEN-LAST:event_bttGuardarReporteEstablecimientoActionPerformed

    private void bttLimpiarCamposEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttLimpiarCamposEstablecimientoActionPerformed
        // Limpiar campos de texto
        txtNombreReporteEstablecimiento.setText("");

        // Limpiar fechas
        dateFechaInicioEstablecimiento.setDate(null);
        dateFechaFinEstablecimiento.setDate(null);

        // Reiniciar combos
        cmbRedEstablecimiento.setSelectedIndex(-1);
        cmbMicroredEstablecimiento.setSelectedIndex(-1);
        cmbEstablecimientoEstablecimiento.setSelectedIndex(-1);
        cmbAtencionEstablecimiento.setSelectedIndex(-1);
        cmbEdadDesdeEstablecimiento.setSelectedIndex(-1);
        cmbEdadHastaEstablecimiento.setSelectedIndex(-1);

        // Limpiar selección de checkboxes
        checkSi.setSelected(false);
        checkNo.setSelected(true);

        // Deshabilitar combos de edad
        cmbEdadDesdeEstablecimiento.setEnabled(false);
        cmbEdadHastaEstablecimiento.setEnabled(false);

        // Limpiar tabla
        DefaultTableModel modelo = (DefaultTableModel) tableMostrarReporteEstablecimiento.getModel();
        modelo.setRowCount(0);
    }//GEN-LAST:event_bttLimpiarCamposEstablecimientoActionPerformed

    private void bttGuardarExportarReporteEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGuardarExportarReporteEstablecimientoActionPerformed
        List<Object[]> reporte = generarReporteYMostrar();
        if (reporte.isEmpty()) return;

        // Guardar en la BD
        if (!guardarReporteEnBD(reporte.get(0))) return;

        // Exportar a Excel
        ExportarReportes.exportarEstablecimiento(reporte.get(0));
    }//GEN-LAST:event_bttGuardarExportarReporteEstablecimientoActionPerformed

    private void bttExportarTodosReportesEstablecimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttExportarTodosReportesEstablecimientoActionPerformed
        ExportarReportes.exportarTodosReportesEstablecimiento();
    }//GEN-LAST:event_bttExportarTodosReportesEstablecimientoActionPerformed

    private void cmbRedPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRedPersonalActionPerformed
        if (cmbRedPersonal.getSelectedItem() != null) {
            String redSeleccionada = cmbRedPersonal.getSelectedItem().toString();
            ConsultasSql.cargarMicroredesPorRed(cmbMicroredPersonal, redSeleccionada);
        }
    }//GEN-LAST:event_cmbRedPersonalActionPerformed

    private void cmbEstablecimientoPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstablecimientoPersonalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstablecimientoPersonalActionPerformed

    private void cmbMicroredPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMicroredPersonalActionPerformed
        if (cmbMicroredPersonal.getSelectedItem() != null) {
            String microredSeleccionada = cmbMicroredPersonal.getSelectedItem().toString();
            ConsultasSql.cargarEstablecimientosPorMicrored(cmbEstablecimientoPersonal, microredSeleccionada);
        }
    }//GEN-LAST:event_cmbMicroredPersonalActionPerformed

    private void bttBuscarPersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttBuscarPersonalActionPerformed
        if (cmbRedPersonal.getSelectedItem() == null || cmbMicroredPersonal.getSelectedItem() == null || cmbEstablecimientoPersonal.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una Red, Microred y Establecimiento.");
            return;
        }

        String establecimientoSeleccionado = cmbEstablecimientoPersonal.getSelectedItem().toString();
        ConsultasSql.buscarPersonalPorEstablecimiento(tablePersonal, establecimientoSeleccionado);
    }//GEN-LAST:event_bttBuscarPersonalActionPerformed

    private void tablePersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePersonalMouseClicked
        int filaSeleccionada = tablePersonal.getSelectedRow();
        if (filaSeleccionada != -1) {
            String nombres = tablePersonal.getValueAt(filaSeleccionada, 0).toString();
            String apellidoPaterno = tablePersonal.getValueAt(filaSeleccionada, 1).toString();
            txtNombrePersonal.setText(nombres);
            txtApellidoPaternoPersonal.setText(apellidoPaterno);
        }
    }//GEN-LAST:event_tablePersonalMouseClicked

    private void bttMostrarReportePersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttMostrarReportePersonalActionPerformed
        generarReportePersonalYMostrar();
    }//GEN-LAST:event_bttMostrarReportePersonalActionPerformed

    private void bttGuardarReportePersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGuardarReportePersonalActionPerformed
        List<Object[]> reporte = generarReportePersonalYMostrar();
        if (reporte.isEmpty()) return;

        boolean guardado = guardarReportePersonalEnBD(reporte.get(0));
        if (guardado) {
            JOptionPane.showMessageDialog(null, "Reporte del personal guardado correctamente.");
        }
    }//GEN-LAST:event_bttGuardarReportePersonalActionPerformed

    private void bttLimpiarReportePersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttLimpiarReportePersonalActionPerformed
        // Limpiar campos de texto
        txtNombrePersonal.setText("");
        txtApellidoPaternoPersonal.setText("");
        txtNombreReportePersonal.setText("");

        // Limpiar fechas
        dateFechaInicioPersonal.setDate(null);
        dateFechaFinPersonal.setDate(null);

        // Reiniciar combos
        cmbAtencionPersonal.setSelectedIndex(-1);
        cmbEdadDesdePersonal.setSelectedIndex(-1);
        cmbEdadHastaPersonal.setSelectedIndex(-1);
        cmbRedPersonal.setSelectedIndex(-1);
        cmbMicroredPersonal.setSelectedIndex(-1);
        cmbEstablecimientoPersonal.setSelectedIndex(-1);

        // Limpiar selección de checkboxes
        checkSi1.setSelected(false);
        checkNo1.setSelected(true);

        // Deshabilitar combos de edad
        cmbEdadDesdePersonal.setEnabled(false);
        cmbEdadHastaPersonal.setEnabled(false);

        // Limpiar tabla
        DefaultTableModel modelo = (DefaultTableModel) tableMostrarReportePersonal.getModel();
        modelo.setRowCount(0);
        DefaultTableModel model = (DefaultTableModel) tablePersonal.getModel();
        model.setRowCount(0);
    }//GEN-LAST:event_bttLimpiarReportePersonalActionPerformed

    private void bttGuardarExportarReportePersonalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttGuardarExportarReportePersonalActionPerformed
        List<Object[]> reporte = generarReportePersonalYMostrar();

        if (reporte.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron datos para mostrar, guardar ni exportar.");
            return;
        }

        boolean guardado = guardarReportePersonalEnBD(reporte.get(0));
        if (!guardado) {
            JOptionPane.showMessageDialog(null, "No se guardó el reporte. Verifica si ya existe o si hubo un error.");
            return;
        }

        String dniPersonal = reporte.get(0)[7].toString();
        String nombreReporte = txtNombreReportePersonal.getText().trim();

        if (nombreReporte.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre del reporte no puede estar vacío.");
            return;
        }

        ExportarReportes.exportarReportePersonal(dniPersonal, nombreReporte);
    }//GEN-LAST:event_bttGuardarExportarReportePersonalActionPerformed

    
    public List<Object[]> generarReportePersonalYMostrar() {
        List<Object[]> datosReporte = new ArrayList<>();
        DefaultTableModel modelo = (DefaultTableModel) tableMostrarReportePersonal.getModel();
        modelo.setRowCount(0);

        // Validaciones
        if (txtNombrePersonal.getText().trim().isEmpty() || txtApellidoPaternoPersonal.getText().trim().isEmpty() ||
            cmbAtencionPersonal.getSelectedItem() == null || 
            dateFechaInicioPersonal.getDate() == null || dateFechaFinPersonal.getDate() == null) {

            JOptionPane.showMessageDialog(null, "Completa todos los campos obligatorios.");
            return datosReporte;
        }

        String nombres = txtNombrePersonal.getText().trim();
        String apellidoPaterno = txtApellidoPaternoPersonal.getText().trim();
        String nombreReporte = txtNombreReportePersonal.getText().trim();
        String nombreAtencion = cmbAtencionPersonal.getSelectedItem().toString();

        java.sql.Date fechaInicio = new java.sql.Date(dateFechaInicioPersonal.getDate().getTime());
        java.sql.Date fechaFin = new java.sql.Date(dateFechaFinPersonal.getDate().getTime());

        boolean filtrarEdad = checkSi1.isSelected();
        int edadDesde = 0, edadHasta = 0;

        if (filtrarEdad) {
            if (cmbEdadDesdePersonal.getSelectedItem() == null || cmbEdadHastaPersonal.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Selecciona ambas edades.");
                return datosReporte;
            }
            edadDesde = Integer.parseInt(cmbEdadDesdePersonal.getSelectedItem().toString());
            edadHasta = Integer.parseInt(cmbEdadHastaPersonal.getSelectedItem().toString());
        }

        String dniPersonal = ConsultasSql.obtenerDniPersonalPorNombre(nombres, apellidoPaterno);
        if (dniPersonal == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el DNI del personal.");
            return datosReporte;
        }

        int idAtencion = ConsultasSql.obtenerIdAtencion(nombreAtencion);
        String descAtencion = ConsultasSql.obtenerDescripcionAtencionPorId(idAtencion);

        String sql = "SELECT ?, GETDATE(), ?, ?, COUNT(h.ID_Historial) " +
                     "FROM Historial h " +
                     "INNER JOIN Cita c ON h.ID_Cita = c.ID_Cita " +
                     "INNER JOIN Paciente p ON c.DNI_Paciente = p.DNI_Paciente " +
                     "WHERE c.Estado_Cita = 'Atendido' " +
                     "AND c.DNI_Personal = ? " +
                     "AND c.ID_Atencion = ? " +
                     "AND c.FechaAtencion_Cita BETWEEN ? AND ?";

        if (filtrarEdad) {
            sql += " AND DATEDIFF(YEAR, p.FechaNacimiento_Paciente, GETDATE()) BETWEEN ? AND ?";
        }

        sql += " GROUP BY c.ID_Atencion";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            int i = 1;
            ps.setString(i++, nombreReporte);
            ps.setDate(i++, fechaInicio);
            ps.setDate(i++, fechaFin);
            ps.setString(i++, dniPersonal);
            ps.setInt(i++, idAtencion);
            ps.setDate(i++, fechaInicio);
            ps.setDate(i++, fechaFin);
            if (filtrarEdad) {
                ps.setInt(i++, edadDesde);
                ps.setInt(i++, edadHasta);
            }

            ResultSet rs = ps.executeQuery();
            boolean hayDatos = false;

            while (rs.next()) {
                hayDatos = true;
                Object[] fila = {
                    nombres + " " + apellidoPaterno,
                    nombreReporte,
                    rs.getDate(2),
                    rs.getDate(3),
                    rs.getDate(4),
                    rs.getInt(5),
                    descAtencion,
                    dniPersonal,
                    idAtencion,
                    edadDesde,
                    edadHasta
                };
                modelo.addRow(fila);
                datosReporte.add(fila);
            }

            if (!hayDatos) {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados para el personal seleccionado.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar reporte: " + e.getMessage());
            e.printStackTrace();
        }

        return datosReporte;
    }

    public boolean guardarReportePersonalEnBD(Object[] fila) {
        String nombreReporte = fila[1].toString();
        java.sql.Date fechaRegistro = java.sql.Date.valueOf(fila[2].toString());
        java.sql.Date fechaInicio = java.sql.Date.valueOf(fila[3].toString());
        java.sql.Date fechaFin = java.sql.Date.valueOf(fila[4].toString());
        int cantidadExamen = (int) fila[5];
        String descAtencion = fila[6].toString();
        String dniPersonal = fila[7].toString();
        int idAtencion = (int) fila[8];
        int edadDesde = (int) fila[9];
        int edadHasta = (int) fila[10];

        try (Connection conn = Conexion.getConexion()) {
            // Validar si ya existe
            String validarSql = "SELECT COUNT(*) FROM ReporteClinico " +
                                "WHERE Nombre_ReporteClinico = ? AND FechaInicio_ReporteClinico = ? " +
                                "AND FechaFin_ReporteClinico = ? AND Edad_Desde = ? AND Edad_Hasta = ? " +
                                "AND DNI_Personal = ?";
            try (PreparedStatement validarStmt = conn.prepareStatement(validarSql)) {
                validarStmt.setString(1, nombreReporte);
                validarStmt.setDate(2, fechaInicio);
                validarStmt.setDate(3, fechaFin);
                validarStmt.setInt(4, edadDesde);
                validarStmt.setInt(5, edadHasta);
                validarStmt.setString(6, dniPersonal);

                ResultSet rs = validarStmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "Ya existe un reporte igual registrado para este personal.");
                    return false;
                }
            }

            // Insertar nuevo reporte
            String insertSql = "INSERT INTO ReporteClinico " +
                    "(Nombre_ReporteClinico, FechaRegistro_ReporteClinico, HoraRegistro_ReporteClinico, " +
                    "FechaInicio_ReporteClinico, FechaFin_ReporteClinico, Edad_Desde, Edad_Hasta, " +
                    "Cantidad_Examen, DNI_Personal, ID_Atencion, ID_Establecimiento) " +
                    "VALUES (?, ?, CONVERT(TIME, GETDATE()), ?, ?, ?, ?, ?, ?, ?, NULL)";

            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                ps.setString(1, nombreReporte);
                ps.setDate(2, fechaRegistro);
                ps.setDate(3, fechaInicio);
                ps.setDate(4, fechaFin);
                ps.setInt(5, edadDesde);
                ps.setInt(6, edadHasta);
                ps.setInt(7, cantidadExamen);
                ps.setString(8, dniPersonal);
                ps.setInt(9, idAtencion);
                int filas = ps.executeUpdate();
                return filas > 0;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar reporte del personal: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    
    
    public List<Object[]> generarReporteYMostrar() {
        List<Object[]> datosReporte = new ArrayList<>();
        DefaultTableModel modelo = (DefaultTableModel) tableMostrarReporteEstablecimiento.getModel();
        modelo.setRowCount(0); // limpiar tabla

        // Validaciones
        if (dateFechaInicioEstablecimiento.getDate() == null || dateFechaFinEstablecimiento.getDate() == null || 
            cmbEstablecimientoEstablecimiento.getSelectedItem() == null || cmbAtencionEstablecimiento.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Completa los campos requeridos.");
            return datosReporte;
        }

        String nombreReporte = txtNombreReporteEstablecimiento.getText().trim();
        java.sql.Date fechaInicio = new java.sql.Date(dateFechaInicioEstablecimiento.getDate().getTime());
        java.sql.Date fechaFin = new java.sql.Date(dateFechaFinEstablecimiento.getDate().getTime());
        String nombreEstablecimiento = cmbEstablecimientoEstablecimiento.getSelectedItem().toString();
        String nombreAtencion = cmbAtencionEstablecimiento.getSelectedItem().toString();
        int idEstablecimiento = ConsultasSql.obtenerIdEstablecimiento(nombreEstablecimiento);
        int idAtencion = ConsultasSql.obtenerIdAtencion(nombreAtencion);
        boolean filtrarEdad = checkSi.isSelected();
        int edadDesde = 0, edadHasta = 0;

        if (filtrarEdad) {
            edadDesde = Integer.parseInt(cmbEdadDesdeEstablecimiento.getSelectedItem().toString());
            edadHasta = Integer.parseInt(cmbEdadHastaEstablecimiento.getSelectedItem().toString());
        }

        String sql = "SELECT ?, GETDATE(), ?, ?, COUNT(h.ID_Historial), c.ID_Atencion, e.Nombre_Establecimiento " +
                     "FROM Historial h " +
                     "INNER JOIN Cita c ON h.ID_Cita = c.ID_Cita " +
                     "INNER JOIN Establecimiento e ON c.ID_Establecimiento = e.ID_Establecimiento " +
                     "INNER JOIN Paciente p ON c.DNI_Paciente = p.DNI_Paciente " +
                     "WHERE c.Estado_Cita = 'Atendido' " +
                     "AND c.ID_Establecimiento = ? " +
                     "AND c.ID_Atencion = ? " +
                     "AND c.FechaAtencion_Cita BETWEEN ? AND ?";

        if (filtrarEdad) {
            sql += " AND DATEDIFF(YEAR, p.FechaNacimiento_Paciente, GETDATE()) BETWEEN ? AND ?";
        }

        sql += " GROUP BY c.ID_Atencion, e.Nombre_Establecimiento";

        try (Connection conn = Conexion.getConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            int i = 1;
            ps.setString(i++, nombreReporte);
            ps.setDate(i++, fechaInicio);
            ps.setDate(i++, fechaFin);
            ps.setInt(i++, idEstablecimiento);
            ps.setInt(i++, idAtencion);
            ps.setDate(i++, fechaInicio);
            ps.setDate(i++, fechaFin);
            if (filtrarEdad) {
                ps.setInt(i++, edadDesde);
                ps.setInt(i++, edadHasta);
            }

            ResultSet rs = ps.executeQuery();
            boolean hayDatos = false;

            while (rs.next()) {
                hayDatos = true;
                Object[] fila = {
                    rs.getString(1),
                    rs.getDate(2),
                    rs.getDate(3),
                    rs.getDate(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getString(7),
                    edadDesde,
                    edadHasta
                };
                modelo.addRow(fila);
                datosReporte.add(fila);
            }

            if (!hayDatos) {
                JOptionPane.showMessageDialog(null, "No se encontraron resultados para el establecimiento seleccionado.", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar reporte: " + e.getMessage());
            e.printStackTrace();
        }

        return datosReporte;
    }
    
    public boolean guardarReporteEnBD(Object[] fila) {
        String nombreReporte = fila[0].toString();
        java.sql.Date fechaRegistro = java.sql.Date.valueOf(fila[1].toString());
        java.sql.Date fechaInicio = java.sql.Date.valueOf(fila[2].toString());
        java.sql.Date fechaFin = java.sql.Date.valueOf(fila[3].toString());
        int cantidadExamen = (int) fila[4];
        int idAtencion = (int) fila[5];
        String nombreEstablecimiento = fila[6].toString();
        int idEstablecimiento = ConsultasSql.obtenerIdEstablecimiento(nombreEstablecimiento);
        int edadDesde = (int) fila[7];
        int edadHasta = (int) fila[8];

        try (Connection conn = Conexion.getConexion()) {
            String validarSql = "SELECT COUNT(*) FROM ReporteClinico " +
                                "WHERE Nombre_ReporteClinico = ? AND FechaInicio_ReporteClinico = ? " +
                                "AND FechaFin_ReporteClinico = ? AND Edad_Desde = ? AND Edad_Hasta = ?";
            try (PreparedStatement validarStmt = conn.prepareStatement(validarSql)) {
                validarStmt.setString(1, nombreReporte);
                validarStmt.setDate(2, fechaInicio);
                validarStmt.setDate(3, fechaFin);
                validarStmt.setInt(4, edadDesde);
                validarStmt.setInt(5, edadHasta);
                ResultSet rs = validarStmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "Ya existe un reporte igual con mismo nombre, fechas y edades.");
                    return false;
                }
            }

            String insertSql = "INSERT INTO ReporteClinico " +
                    "(Nombre_ReporteClinico, FechaRegistro_ReporteClinico, HoraRegistro_ReporteClinico, " +
                    "FechaInicio_ReporteClinico, FechaFin_ReporteClinico, Edad_Desde, Edad_Hasta, " +
                    "Cantidad_Examen, DNI_Personal, ID_Atencion, ID_Establecimiento) " +
                    "VALUES (?, ?, CONVERT(TIME, GETDATE()), ?, ?, ?, ?, ?, NULL, ?, ?)";

            try (PreparedStatement ps = conn.prepareStatement(insertSql)) {
                ps.setString(1, nombreReporte);
                ps.setDate(2, fechaRegistro);
                ps.setDate(3, fechaInicio);
                ps.setDate(4, fechaFin);
                ps.setInt(5, edadDesde);
                ps.setInt(6, edadHasta);
                ps.setInt(7, cantidadExamen);
                ps.setInt(8, idAtencion);
                ps.setInt(9, idEstablecimiento);
                int filas = ps.executeUpdate();
                return filas > 0;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar reporte: " + e.getMessage());
            e.printStackTrace();
            return false;
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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttBuscarPersonal;
    private javax.swing.JButton bttExportarTodosReportesEstablecimiento;
    private javax.swing.JButton bttGuardarExportarReporteEstablecimiento;
    private javax.swing.JButton bttGuardarExportarReportePersonal;
    private javax.swing.JButton bttGuardarReporteEstablecimiento;
    private javax.swing.JButton bttGuardarReportePersonal;
    private javax.swing.JButton bttLimpiarCamposEstablecimiento;
    private javax.swing.JButton bttLimpiarReportePersonal;
    private javax.swing.JButton bttMostrarReporteEstablecimiento;
    private javax.swing.JButton bttMostrarReportePersonal;
    private javax.swing.JCheckBox checkNo;
    private javax.swing.JCheckBox checkNo1;
    private javax.swing.JCheckBox checkSi;
    private javax.swing.JCheckBox checkSi1;
    private javax.swing.JComboBox<String> cmbAtencionEstablecimiento;
    private javax.swing.JComboBox<String> cmbAtencionPersonal;
    private javax.swing.JComboBox<Integer> cmbEdadDesdeEstablecimiento;
    private javax.swing.JComboBox<Integer> cmbEdadDesdePersonal;
    private javax.swing.JComboBox<Integer> cmbEdadHastaEstablecimiento;
    private javax.swing.JComboBox<Integer> cmbEdadHastaPersonal;
    private javax.swing.JComboBox<String> cmbEstablecimientoEstablecimiento;
    private javax.swing.JComboBox<String> cmbEstablecimientoPersonal;
    private javax.swing.JComboBox<String> cmbMicroredEstablecimiento;
    private javax.swing.JComboBox<String> cmbMicroredPersonal;
    private javax.swing.JComboBox<String> cmbRedEstablecimiento;
    private javax.swing.JComboBox<String> cmbRedPersonal;
    private com.toedter.calendar.JDateChooser dateFechaFinEstablecimiento;
    private com.toedter.calendar.JDateChooser dateFechaFinPersonal;
    private com.toedter.calendar.JDateChooser dateFechaInicioEstablecimiento;
    private com.toedter.calendar.JDateChooser dateFechaInicioPersonal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableMostrarReporteEstablecimiento;
    private javax.swing.JTable tableMostrarReportePersonal;
    private javax.swing.JTable tablePersonal;
    private javax.swing.JTextField txtApellidoPaternoPersonal;
    private javax.swing.JTextField txtNombrePersonal;
    private javax.swing.JTextField txtNombreReporteEstablecimiento;
    private javax.swing.JTextField txtNombreReportePersonal;
    // End of variables declaration//GEN-END:variables
}
