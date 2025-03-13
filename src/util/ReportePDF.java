/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author Christopher
 */
import Model.Bitacora;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import Model.Transaccion;
import Model.Reporte;
import java.io.FileOutputStream;
import java.util.List;

public class ReportePDF {
   public static void generarReporte(Reporte reporte) {
        String nombreArchivo = reporte.generarNombreArchivo();
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            document.open();

            // Título del reporte
            document.add(new Paragraph("Reporte de " + reporte.getTipoReporte()));
            document.add(new Paragraph("Fecha de generación: " + reporte.getFechaGeneracion()));
            document.add(new Paragraph(" ")); // Espacio en blanco

            // Crear una tabla para mostrar las transacciones
            PdfPTable table = new PdfPTable(5); // 5 columnas
            table.addCell("ID Transacción");
            table.addCell("Fecha y Hora");
            table.addCell("Detalle");
            table.addCell("Monto Debitado");
            table.addCell("Monto Acreditado");

            // Llenar la tabla con las transacciones
            for (Transaccion transaccion : reporte.getTransacciones()) {
                table.addCell(transaccion.getId());
                table.addCell(transaccion.getFechaHora().toString());
                table.addCell(transaccion.getDetalle());
                table.addCell(String.valueOf(transaccion.getMontoDebitado()));
                table.addCell(String.valueOf(transaccion.getMontoAcreditado()));
            }

            document.add(table);
            document.close();

            // Registrar en la bitácora
            Bitacora.registrar("AdministradorIPC1D", "Generación de reporte", "Éxito",
                "Reporte de " + reporte.getTipoReporte() + " generado correctamente.");
        } catch (DocumentException | java.io.IOException e) {
            e.printStackTrace();
            Bitacora.registrar("AdministradorIPC1D", "Generación de reporte", "Error",
                "Error al generar el reporte de " + reporte.getTipoReporte());
        }
    }
}