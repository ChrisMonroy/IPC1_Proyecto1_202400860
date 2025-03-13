/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Christopher
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import util.ReportePDF;
import Model.Clientes;

public class Reporte {
    private String tipoReporte;
    private LocalDateTime fechaGeneracion;
    private List<Transaccion> transacciones;

    public Reporte(String tipoReporte, List<Transaccion> transacciones) {
        this.tipoReporte = tipoReporte;
        this.fechaGeneracion = LocalDateTime.now();
        this.transacciones = transacciones;
    }

    public String getTipoReporte() {
        return tipoReporte;
    }

    public LocalDateTime getFechaGeneracion() {
        return fechaGeneracion;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public String generarNombreArchivo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
        return "reporte" + tipoReporte + "_" + fechaGeneracion.format(formatter) + ".pdf";
    }
}
