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
import java.util.List;
import javax.swing.JOptionPane;
import Model.Clientes;
import Model.Cuentas;

public class CrearCuentaController {
     private List<Clientes> clientes;
    private static final int MAX_CUENTAS_POR_CLIENTE = 3; 
    
    public CrearCuentaController(List<Clientes> clientes) {
        this.clientes = clientes;
    }

   public void crearCuenta(String cuiCliente, String idCuenta) {
        Clientes cliente = buscarClientePorCui(cuiCliente);
        if (cliente == null) {
            Bitacora.registrar("AdministradorIPC1D", "Creación de cuenta", "Error", 
                "Cliente no encontrado.");
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cliente.getCuentas().size() >= MAX_CUENTAS_POR_CLIENTE) {
            Bitacora.registrar("AdministradorIPC1D", "Creación de cuenta", "Error", 
                "No se pueden agregar más cuentas. Límite alcanzado.");
            JOptionPane.showMessageDialog(null, "No se pueden agregar más cuentas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar el patrón del identificador de la cuenta (Tabla 2)
        if (!idCuenta.startsWith("D2D025")) {
            Bitacora.registrar("AdministradorIPC1D", "Creación de cuenta", "Error", 
                "El identificador de la cuenta no sigue el patrón requerido.");
            JOptionPane.showMessageDialog(null, "El identificador de la cuenta no sigue el patrón requerido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cuentas cuenta = new Cuentas(idCuenta, cliente);
        cuenta.setSaldo(0); // Asegurarse de que el saldo inicial sea 0
        cliente.agregarCuenta(cuenta);
        Bitacora.registrar("AdministradorIPC1D", "Creación de cuenta", "Éxito", 
            "Cuenta creada con número '" + idCuenta + "', saldo inicial: Q0.");
        JOptionPane.showMessageDialog(null, "Cuenta creada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);      
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