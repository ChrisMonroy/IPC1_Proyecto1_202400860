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
import Model.Clientes;
import java.util.List;
import javax.swing.*;

public class RetirosController {
     private List<Clientes> clientes;

    // Constructor que recibe la lista de clientes
    public RetirosController(List<Clientes> clientes) {
        this.clientes = clientes;
    }

    public void realizarRetiro(String idCuenta, double monto) {
        Cuentas cuenta = buscarCuentaPorId(idCuenta);
        if (cuenta != null) {
            if (monto > 0 && cuenta.getSaldo() >= monto) {
                cuenta.retirar(monto);
                Bitacora.registrar("AdministradorIPC1D", "Retiro", "Éxito", 
                    "Retiro de Q" + monto + " realizado. Saldo actual: Q" + cuenta.getSaldo());
            } else {
                Bitacora.registrar("AdministradorIPC1D", "Retiro", "Error", 
                    "Monto inválido o saldo insuficiente.");
                JOptionPane.showMessageDialog(null, "Monto inválido o saldo insuficiente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            Bitacora.registrar("AdministradorIPC1D", "Retiro", "Error", 
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
