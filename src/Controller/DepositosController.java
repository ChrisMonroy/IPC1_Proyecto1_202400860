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
public class DepositosController {
    private Banco banco;
    private Bitacora bitacora;

    public DepositosController(Banco banco, Bitacora bitacora) {
        this.banco = banco;
        this.bitacora = bitacora;
    }

    public void realizarDeposito(String idCuenta, double monto) {
        Cuentas cuenta = banco.buscarCuenta(idCuenta);
        if (cuenta != null && monto > 0) {
            cuenta.depositar(monto);
            String registro = "Depósito: Cuenta ID: " + idCuenta + ", Monto: " + monto + ", Nuevo Saldo: " + cuenta.getSaldo();
            bitacora.agregarRegistro(registro);
            JOptionPane.showMessageDialog(null, "Depósito realizado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error en el depósito.");
        }
    }
}
