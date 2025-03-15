/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bitacora;
import Model.Clientes;
import View.BuscarCuentas;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher
 */
public class BuscarController {
    private List<Clientes> clientes;
    private BuscarCuentas view;

    public BuscarController(List<Clientes> clientes, BuscarCuentas view) {
        this.clientes = clientes;
        this.view = view;

        // Mostrar todos los clientes al iniciar la vista
        view.actualizarTablaClientes(clientes);
    }

    public void buscarCuentasAsociadas(String cuiCliente) {
        Clientes cliente = buscarClientePorCui(cuiCliente);
        if (cliente != null) {
            if (!cliente.getCuentas().isEmpty()) {
                // Actualizar la tabla de cuentas en la vista
                view.actualizarTablaCuentas(cliente.getCuentas());
                Bitacora.registrar("AdministradorIPC1D", "Búsqueda de cuentas", "Éxito",
                    "Se encontraron " + cliente.getCuentas().size() + " cuentas asociadas al titular '" + cliente.getNombre() + " " + cliente.getApellido() + "'.");
            } else {
                Bitacora.registrar("AdministradorIPC1D", "Búsqueda de cuentas", "Error",
                    "No se encontraron cuentas asociadas al titular '" + cliente.getNombre() + " " + cliente.getApellido() + "'.");
                JOptionPane.showMessageDialog(null, "No se encontraron cuentas asociadas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            Bitacora.registrar("AdministradorIPC1D", "Búsqueda de cuentas", "Error",
                "Cliente no encontrado.");
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