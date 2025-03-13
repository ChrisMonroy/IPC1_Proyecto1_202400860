/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Christopher
 */
import Model.Bitacora;
import Model.Clientes;
import Model.Cuentas;
import Model.Reporte;
import Model.Transaccion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import util.ReportePDF;

public class HistorialController {
  private List<Clientes> clientes;

    public HistorialController(List<Clientes> clientes) {
        this.clientes = clientes;
    }

    // Método para obtener las transacciones de una cuenta
    public List<Transaccion> obtenerTransacciones(String idCuenta) {
        List<Transaccion> transacciones = new ArrayList<>();
        for (Clientes cliente : clientes) {
            for (Cuentas cuenta : cliente.getCuentas()) {
                if (cuenta.getId().equals(idCuenta)) {
                    transacciones.addAll(cuenta.getTransacciones());
                    return transacciones; // Retorna las transacciones de la cuenta encontrada
                }
            }
        }
        // Si no se encuentra la cuenta, muestra un mensaje de error
        Bitacora.registrar("AdministradorIPC1D", "Búsqueda de transacciones", "Error", 
            "No se encontraron transacciones para la cuenta con ID: " + idCuenta);
        JOptionPane.showMessageDialog(null, "No se encontraron transacciones para la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
        return transacciones; // Retorna una lista vacía si no se encontraron transacciones
    }

    // Método para generar el reporte en PDF
    public void generarReporteTransacciones(String idCuenta) {
        List<Transaccion> transacciones = obtenerTransacciones(idCuenta);
        if (!transacciones.isEmpty()) {
            // Generar el reporte en PDF
            Reporte reporte = new Reporte("Historial de Transacciones", transacciones);
            ReportePDF.generarReporte(reporte);
        }
    }
}