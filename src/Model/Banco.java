/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.HashMap;
/**
 *
 * @author Christopher
 */
public class Banco {
 private HashMap<String, Clientes> clientes; // Usamos HashMap para almacenar clientes

    public Banco() {
        clientes = new HashMap<>();
    }

    public boolean agregarCliente(Clientes cliente) {
        if (clientes.size() < 6) { // Sección D
            clientes.put(cliente.cui, cliente); // Usamos el CUI como clave
            return true;
        }
        return false;
    }

    public Clientes buscarCliente(String cui) {
        return clientes.get(cui); // Buscamos el cliente por su CUI
    }

    public Cuentas buscarCuenta(String id) {
        for (Clientes cliente : clientes.values()) {
            for (int i = 0; i < cliente.numCuentas; i++) {
                if (cliente.cuentas[i].getId().equals(id)) {
                    return cliente.cuentas[i]; // Retornamos la cuenta encontrada
                }
            }
        }
        return null;
    }
}