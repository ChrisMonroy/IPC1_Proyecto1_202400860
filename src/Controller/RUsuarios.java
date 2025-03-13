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
import javax.swing.JOptionPane;
import java.util.List;

public class RUsuarios {
       private List<Clientes> clientes;
    private static final int MAX_CLIENTES = 6; // Para la sección D

    public RUsuarios(List<Clientes> clientes) {
        this.clientes = clientes;
    }

    public void registrarUsuario(String cui, String nombre, String apellido) {
        if (clientes.size() >= MAX_CLIENTES) {
            Bitacora.registrar("AdministradorIPC1D", "Registro de usuario", "Error", 
                "No se pueden agregar más clientes. Límite alcanzado.");
            JOptionPane.showMessageDialog(null, "No se pueden agregar más clientes.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Clientes cliente : clientes) {
            if (cliente.getCui().equals(cui)) {
                Bitacora.registrar("AdministradorIPC1D", "Registro de usuario", "Error", 
                    "No se pueden crear clientes con CUI duplicados.");
                JOptionPane.showMessageDialog(null, "El CUI ingresado ya existe en el sistema.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Clientes cliente = new Clientes(cui, nombre, apellido);
        clientes.add(cliente);
        Bitacora.registrar("AdministradorIPC1D", "Registro de usuario", "Éxito", 
            "Usuario " + nombre + " " + apellido + " registrado.");
    }
}
