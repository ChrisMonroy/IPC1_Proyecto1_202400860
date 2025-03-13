/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bitacora;
import Model.Clientes;
import Model.Cuentas;
import util.ReportePDF;
import Model.Reporte;
import Model.Transaccion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher
 */
public class ReportesControler {
      private List<Clientes> clientes;

    public ReportesControler(List<Clientes> clientes) {
        this.clientes = clientes;
    }

    public void generarReporteDepositos(String cuiCliente) {
        Clientes cliente = buscarClientePorCui(cuiCliente);
        if (cliente != null) {
            List<Transaccion> depositos = new ArrayList<>();
            for (Cuentas cuenta : cliente.getCuentas()) {
                for (Transaccion transaccion : cuenta.getTransacciones()) {
                    if (transaccion.getMontoAcreditado() > 0) {
                        depositos.add(transaccion);
                    }
                }
            }
            Reporte reporte = new Reporte("Depósitos", depositos);
            ReportePDF.generarReporte(reporte);  // Generar el PDF usando ReportePDF
        } else {
            Bitacora.registrar("AdministradorIPC1D", "Generación de reporte", "Error", 
                    "Cliente no encontrado para generar reporte de depósitos.");
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void generarReporteRetiros(String cuiCliente) {
        Clientes cliente = buscarClientePorCui(cuiCliente);
        if (cliente != null) {
            List<Transaccion> retiros = new ArrayList<>();
            for (Cuentas cuenta : cliente.getCuentas()) {
                for (Transaccion transaccion : cuenta.getTransacciones()) {
                    if (transaccion.getMontoDebitado() > 0) {
                        retiros.add(transaccion);
                    }
                }
            }
            Reporte reporte = new Reporte("Retiros", retiros);
            ReportePDF.generarReporte(reporte);  // Generar el PDF usando ReportePDF
        } else {
            Bitacora.registrar("AdministradorIPC1D", "Generación de reporte", "Error", 
                    "Cliente no encontrado para generar reporte de retiros.");
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Clientes buscarClientePorCui(String cui) {
        for (Clientes cliente : clientes) {
            if (cliente.getCui().equals(cui)) {
                return cliente;
            }
        }
        return null;
    }
}
