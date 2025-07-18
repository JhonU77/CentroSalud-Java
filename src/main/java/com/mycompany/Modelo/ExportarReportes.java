/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Modelo;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author farro
 */
public class ExportarReportes {
    
    private static final Logger logger = LogManager.getLogger(ExportarReportes.class);
    
    public static void exportarEstablecimiento(Object[] fila) {
        logger.info("Iniciando exportación de reporte individual...");

        try (Connection con = Conexion.getConexion()) {
            logger.info("Conexión a la base de datos establecida.");

            String nombreEstablecimiento = fila[6].toString();
            int idEstablecimiento = ConsultasSql.obtenerIdEstablecimiento(nombreEstablecimiento);
            int idAtencion = (int) fila[5];

            logger.info("Obteniendo datos del reporte con nombre: {}", fila[0]);

            String sql = "SELECT e.Red, e.Microred, e.Nombre_Establecimiento, r.Nombre_ReporteClinico, " +
                         "r.Cantidad_Examen, a.Desc_Atencion, r.FechaInicio_ReporteClinico, r.FechaFin_ReporteClinico, " +
                         "r.Edad_Desde, r.Edad_Hasta " +
                         "FROM ReporteClinico r " +
                         "INNER JOIN Establecimiento e ON r.ID_Establecimiento = e.ID_Establecimiento " +
                         "INNER JOIN Atencion a ON r.ID_Atencion = a.ID_Atencion " +
                         "WHERE r.Nombre_ReporteClinico = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, fila[0].toString());
            ResultSet rs = ps.executeQuery();

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Reporte Clínico");

            logger.info("Generando hoja de Excel...");
        
            // Estilo para encabezados
            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            // Encabezados
            String[] columnas = {
                "Red", "Microred", "Establecimiento", "Nombre Reporte", "Cantidad Atencion",
                "Atencion", "Fecha Inicio", "Fecha Fin", "Edad Desde", "Edad Hasta"
            };

            Row header = sheet.createRow(0);
            for (int i = 0; i < columnas.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(columnas[i]);
                cell.setCellStyle(headerStyle);
            }

            int filaExcel = 1;
            while (rs.next()) {
                Row row = sheet.createRow(filaExcel++);
                for (int i = 1; i <= 10; i++) {
                    row.createCell(i - 1).setCellValue(rs.getString(i) != null ? rs.getString(i) : "");
                }
            }

            for (int i = 0; i < 10; i++) {
                sheet.autoSizeColumn(i);
            }

            String nombreArchivo = "Reporte_" + fila[0].toString().replaceAll("\\s+", "_") + ".xlsx";
            String rutaEscritorio = Paths.get(System.getProperty("user.home"), "Desktop", nombreArchivo).toString();

            try (FileOutputStream out = new FileOutputStream(new File(rutaEscritorio))) {
                workbook.write(out);
                workbook.close();
                JOptionPane.showMessageDialog(null, "Reporte exportado exitosamente en el escritorio.");
                logger.info("Archivo exportado exitosamente: {}", rutaEscritorio);
            }

        } catch (Exception e) {
            logger.error("Error al exportar reporte", e);
            JOptionPane.showMessageDialog(null, "Error al exportar reporte: " + e.getMessage());
        }
    }
    
    public static void exportarTodosReportesEstablecimiento() {
        String sql = 
            "SELECT e.Red, e.Microred, e.Nombre_Establecimiento, " +
            "r.Nombre_ReporteClinico, r.Cantidad_Examen, a.Desc_Atencion, " +
            "r.FechaInicio_ReporteClinico, r.FechaFin_ReporteClinico, " +
            "r.Edad_Desde, r.Edad_Hasta " +
            "FROM ReporteClinico r " +
            "INNER JOIN Establecimiento e ON r.ID_Establecimiento = e.ID_Establecimiento " +
            "INNER JOIN Atencion a ON r.ID_Atencion = a.ID_Atencion " +
            "WHERE r.DNI_Personal IS NULL";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Todos Reportes Est.");

            // Estilo encabezado
            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);

            // Encabezados
            String[] columnas = {
                "Red", "Microred", "Establecimiento", "Nombre Reporte",
                "Cantidad Atencion", "Atencion", "Fecha Inicio", "Fecha Fin",
                "Edad Desde", "Edad Hasta"
            };
            Row header = sheet.createRow(0);
            for (int i = 0; i < columnas.length; i++) {
                Cell cell = header.createCell(i);
                cell.setCellValue(columnas[i]);
                cell.setCellStyle(headerStyle);
            }

            // Rellenar datos
            int filaExcel = 1;
            while (rs.next()) {
                Row row = sheet.createRow(filaExcel++);
                row.createCell(0).setCellValue(rs.getString("Red"));
                row.createCell(1).setCellValue(rs.getString("Microred"));
                row.createCell(2).setCellValue(rs.getString("Nombre_Establecimiento"));
                row.createCell(3).setCellValue(rs.getString("Nombre_ReporteClinico"));
                row.createCell(4).setCellValue(rs.getInt("Cantidad_Examen"));
                row.createCell(5).setCellValue(rs.getString("Desc_Atencion"));
                row.createCell(6).setCellValue(rs.getDate("FechaInicio_ReporteClinico").toString());
                row.createCell(7).setCellValue(rs.getDate("FechaFin_ReporteClinico").toString());
                row.createCell(8).setCellValue(rs.getInt("Edad_Desde"));
                row.createCell(9).setCellValue(rs.getInt("Edad_Hasta"));
            }

            // Autoajustar
            for (int i = 0; i < columnas.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Guardar en escritorio
            String nombreArchivo = "Todos_Reportes_Establecimiento.xlsx";
            String rutaEscritorio = Paths.get(
                System.getProperty("user.home"), "Desktop", nombreArchivo
            ).toString();
            try (FileOutputStream out = new FileOutputStream(rutaEscritorio)) {
                workbook.write(out);
                workbook.close();
                JOptionPane.showMessageDialog(null,
                    "Se exportaron " + (filaExcel-1) + " reportes al escritorio:\n" + rutaEscritorio
                );
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                "Error al exportar todos los reportes: " + e.getMessage()
            );
            e.printStackTrace();
        }
    }

    
    public static void exportarReportePersonal(String dniPersonal, String nombreReporte) {
        logger.info("Iniciando exportación del reporte personal para el DNI: {}", dniPersonal);

        // Validar nombre de archivo
        String nombreLimpio = nombreReporte.replaceAll("[\\\\/:*?\"<>|]", "_");

        String sql = "SELECT r.Nombre_ReporteClinico, r.FechaInicio_ReporteClinico, r.FechaFin_ReporteClinico, " +
                     "p.Nombres_Personal, p.ApellidoPaterno_Personal, p.ApellidoMaterno_Personal, " +
                     "m.Cantidad_MetaExamen, m.FechaInicio_MetaExamen, m.FechaFin_MetaExamen, " +
                     "(SELECT COUNT(*) FROM Cita c " +
                     "WHERE c.DNI_Personal = m.DNI_Personal " +
                     "AND c.ID_Atencion = m.ID_Atencion " +
                     "AND c.Estado_Cita = 'Atendido' " +
                     "AND c.FechaAtencion_Cita BETWEEN m.FechaInicio_MetaExamen AND m.FechaFin_MetaExamen) AS TotalExamenes, " +
                     "a.Desc_Atencion " +
                     "FROM ReporteClinico r " +
                     "INNER JOIN Personal p ON r.DNI_Personal = p.DNI_Personal " +
                     "INNER JOIN MetaExamen m ON m.DNI_Personal = p.DNI_Personal AND " +
                     "      m.FechaInicio_MetaExamen >= r.FechaInicio_ReporteClinico AND " +
                     "      m.FechaFin_MetaExamen <= r.FechaFin_ReporteClinico " +
                     "INNER JOIN Atencion a ON m.ID_Atencion = a.ID_Atencion " +
                     "WHERE r.DNI_Personal = ?";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dniPersonal);
            ResultSet rs = ps.executeQuery();

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Reporte Personal");

            String[] headers = {
                "Nombre Reporte", "Nombre Obstetra", "Apellido Paterno", "Apellido Materno",
                "Fecha Inicio Reporte", "Fecha Fin Reporte", "Meta Asignada",
                "Fecha Inicio Meta", "Fecha Fin Meta", "Estado",
                "Total Examenes", "Avance"
            };

            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            CreationHelper createHelper = workbook.getCreationHelper();
            CellStyle dateCellStyle = workbook.createCellStyle();
            dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/MM/yyyy"));

            int rowIndex = 1;
            while (rs.next()) {
                Row row = sheet.createRow(rowIndex++);

                String nombreReporteBD = rs.getString("Nombre_ReporteClinico");
                String nombre = rs.getString("Nombres_Personal");
                String apellidoP = rs.getString("ApellidoPaterno_Personal");
                String apellidoM = rs.getString("ApellidoMaterno_Personal");

                Date fechaInicioReporte = rs.getDate("FechaInicio_ReporteClinico");
                Date fechaFinReporte = rs.getDate("FechaFin_ReporteClinico");

                int meta = rs.getInt("Cantidad_MetaExamen");
                Date fechaInicioMeta = rs.getDate("FechaInicio_MetaExamen");
                Date fechaFinMeta = rs.getDate("FechaFin_MetaExamen");

                int totalExamenes = rs.getInt("TotalExamenes");

                int avancePorc = meta > 0 ? (int) ((totalExamenes * 100.0) / meta) : 0;

                LocalDate hoy = LocalDate.now();
                String estado;
                if (totalExamenes >= meta) {
                    estado = "Completado";
                } else if (hoy.isAfter(fechaFinMeta.toLocalDate())) {
                    estado = "Incompleto";
                } else {
                    estado = "En progreso";
                }

                int col = 0;
                row.createCell(col++).setCellValue(nombreReporteBD);
                row.createCell(col++).setCellValue(nombre);
                row.createCell(col++).setCellValue(apellidoP);
                row.createCell(col++).setCellValue(apellidoM);

                Cell cellFechaIniRep = row.createCell(col++);
                cellFechaIniRep.setCellValue(fechaInicioReporte);
                cellFechaIniRep.setCellStyle(dateCellStyle);

                Cell cellFechaFinRep = row.createCell(col++);
                cellFechaFinRep.setCellValue(fechaFinReporte);
                cellFechaFinRep.setCellStyle(dateCellStyle);

                row.createCell(col++).setCellValue(meta);

                Cell cellFechaIniMeta = row.createCell(col++);
                cellFechaIniMeta.setCellValue(fechaInicioMeta);
                cellFechaIniMeta.setCellStyle(dateCellStyle);

                Cell cellFechaFinMeta = row.createCell(col++);
                cellFechaFinMeta.setCellValue(fechaFinMeta);
                cellFechaFinMeta.setCellStyle(dateCellStyle);

                row.createCell(col++).setCellValue(estado);
                row.createCell(col++).setCellValue(totalExamenes);
                row.createCell(col++).setCellValue(avancePorc + "%");
            }

            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            // Guardar automáticamente en el escritorio
            String rutaEscritorio = System.getProperty("user.home") + File.separator + "Desktop";
            File archivo = new File(rutaEscritorio + File.separator + nombreLimpio + ".xlsx");

            try (FileOutputStream fos = new FileOutputStream(archivo)) {
                workbook.write(fos);
                logger.info("Archivo Excel exportado exitosamente en: {}", archivo.getAbsolutePath());
                JOptionPane.showMessageDialog(null, "Exportación exitosa en el escritorio como: " + nombreLimpio + ".xlsx");
            } catch (IOException ioEx) {
                logger.error("Error al guardar el archivo Excel.", ioEx);
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo: " + ioEx.getMessage());
            }

            workbook.close();
            logger.info("Libro de Excel cerrado correctamente.");

        } catch (Exception e) {
            logger.error("Ocurrió un error durante la exportación del reporte personal.", e);
            JOptionPane.showMessageDialog(null, "Error al exportar: " + e.getMessage());
        }
    }


}
