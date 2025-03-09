/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Christopher
 */
import Model.Banco;
import Model.Cuentas;
import Model.Bitacora;
import javax.swing.*;
public class RetirosController {
    private Banco banco;
    private Bitacora bitacora;

    public RetirosController(Banco banco, Bitacora bitacora) {
        this.banco = banco;
        this.bitacora = bitacora;
    }

    public void realizarRetiro(String idCuenta, double monto) {
        Cuentas cuenta = banco.buscarCuenta(idCuenta);
        if (cuenta != null && monto > 0 && cuenta.retirar(monto)) {
            String registro = "Retiro: Cuenta ID: " + idCuenta + ", Monto: " + monto + ", Nuevo Saldo: " + cuenta.getSaldo();
            bitacora.agregarRegistro(registro);
            JOptionPane.showMessageDialog(null, "Retiro realizado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error en el retiro.");
        }
    }
}
