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

public class CrearCuentaController {
     private Banco banco;
    private Bitacora bitacora;

    public CrearCuentaController(Banco banco, Bitacora bitacora) {
        this.banco = banco;
        this.bitacora = bitacora;
    }

    public void crearCuenta(String id, String cuiCliente, double saldo) {
        Cuentas cuenta = new Cuentas(id, cuiCliente, saldo);
        Clientes cliente = banco.buscarCliente(cuiCliente);
        if (cliente != null) {
            cliente.AgregarCuenta(cuenta);
            String registro = "Creación de Cuenta: ID: " + id + ", CUI Cliente: " + cuiCliente;
            bitacora.agregarRegistro(registro);
            JOptionPane.showMessageDialog(null, "Cuenta creada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }
}
