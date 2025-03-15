/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Christopher
 */
import Model.Cuentas;
import Model.Bitacora;
import javax.swing.*;
import Model.Clientes;
import java.util.List;

public class DepositosController {
    private List<Clientes> clientes;

    // Constructor que recibe la lista de clientes
    public DepositosController(List<Clientes> clientes) {
        this.clientes = clientes;
    }

    public void realizarDeposito(String idCuenta, double monto) {
        Cuentas cuenta = buscarCuentaPorId(idCuenta);
        if (cuenta != null) {
            if (monto > 0) {
                cuenta.depositar(monto);
                Bitacora.registrar("AdministradorIPC1D", "Depósito", "Éxito", 
                    "Depósito de Q" + monto + " realizado. Saldo actual: Q" + cuenta.getSaldo());
                JOptionPane.showMessageDialog(null, "Depósito realizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                Bitacora.registrar("AdministradorIPC1D", "Depósito", "Error", 
                    "El monto del depósito debe ser mayor a 0.");
                JOptionPane.showMessageDialog(null, "El monto del depósito debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            Bitacora.registrar("AdministradorIPC1D", "Depósito", "Error", 
                "Cuenta no encontrada.");
            JOptionPane.showMessageDialog(null, "Cuenta no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Cuentas buscarCuentaPorId(String idCuenta) {
        for (Clientes cliente : clientes) {
            for (Cuentas cuenta : cliente.getCuentas()) {
                if (cuenta.getId().equals(idCuenta)) {
                    return cuenta;
                }
            }
        }
        return null;
    }
}
