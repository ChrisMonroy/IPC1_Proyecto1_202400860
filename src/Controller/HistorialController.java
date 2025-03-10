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
import javax.swing.*;

public class HistorialController {
    private Banco banco;

    public HistorialController(Banco banco) {
        this.banco = banco;
    }

    public void mostrarHistorial(String idCuenta) {
        // Implementar lógica para mostrar historial de transacciones
        // Este método puede abrir una nueva vista que muestre las transacciones
        JOptionPane.showMessageDialog(null, "Historial de transacciones para la cuenta: " + idCuenta);
    }
}