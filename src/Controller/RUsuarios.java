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
import Model.Clientes;
import Model.Bitacora;
import javax.swing.*;

public class RUsuarios {
    private Banco banco;
    private Bitacora bitacora;
    public RUsuarios(Banco banco, Bitacora bitacora) {
        this.banco = banco;
        this.bitacora = bitacora;
    }

    public void registrarUsuario(String cui, String nombre, String apellido) {
        Clientes cliente = new Clientes(cui, nombre, apellido);
        if (banco.agregarCliente(cliente)) {
            String registro = "Registro: CUI: " + cui + ", Nombre: " + nombre + ", Apellido: " + apellido;
            bitacora.agregarRegistro(registro);
            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden registrar más usuarios.");
        }
    }
}
