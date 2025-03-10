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
import Model.Bitacora;
import Model.Cuentas;
import Model.Clientes;
import javax.swing.*;
import java.util.UUID;

public class CrearCuentaController {
    private Banco banco;
    private Bitacora bitacora;

    public CrearCuentaController(Banco banco, Bitacora bitacora) {
        this.banco = banco;
        this.bitacora = bitacora;
    }

   public void crearCuenta(String cuiCliente, double saldoInicial) {
         if (saldoInicial < 0) {
            JOptionPane.showMessageDialog(null, "El saldo inicial no puede ser negativo.");
            return;
        }

        Cuentas cuenta = new Cuentas(cuiCliente, saldoInicial); // Crear cuenta con saldo inicial 0
        cuenta.depositar(saldoInicial); // Depositar el saldo inicial
        Clientes cliente = banco.buscarCliente(cuiCliente);
        if (cliente != null) {
            if (cliente.numCuentas < cliente.cuentas.length) {
                cliente.AgregarCuenta(cuenta);
                String registro = "Creación de Cuenta: ID: " + cuenta.getId() + ", CUI Cliente: " + cuiCliente + ", Saldo Inicial: " + saldoInicial;
                bitacora.agregarRegistro(registro);
                JOptionPane.showMessageDialog(null, "Cuenta creada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pueden agregar más cuentas a este cliente.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }
}
