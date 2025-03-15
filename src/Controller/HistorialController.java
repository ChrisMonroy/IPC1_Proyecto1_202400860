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
import javax.swing.table.DefaultTableModel;
import util.ReportePDF;

public class HistorialController {
   private List<Clientes> clientes;
    
    public HistorialController(List<Clientes> clientes) {
        this.clientes = clientes;
    }

    public List<Transaccion> obtenerTransacciones(String idCuenta) {
        List<Transaccion> transacciones = new ArrayList<>();

        for (Clientes cliente : clientes) {
            for (Cuentas cuenta : cliente.getCuentas()) {
                if (cuenta.getId().equals(idCuenta)) {
                    if (cuenta.getTransacciones().size() >= 25) {
                        JOptionPane.showMessageDialog(null, "No se pueden realizar más de 25 transacciones por cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
                        return transacciones;
                    }
                    transacciones.addAll(cuenta.getTransacciones());
                    return transacciones; // Retornar las transacciones encontradas
                }
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontraron transacciones para la cuenta.", "Error", JOptionPane.ERROR_MESSAGE);
        return transacciones; // Retornar lista vacía si no se encontraron transacciones
    }

    // Método para obtener el saldo inicial de la cuenta
    public double obtenerSaldoInicial(String idCuenta) {
        return 0.0; // Siempre retornar 0 como saldo inicial
    }
}