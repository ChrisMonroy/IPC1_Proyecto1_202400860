/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Christopher
 */
import Model.Cuentas;
import java.util.ArrayList;
import java.util.List;

public class Clientes {
 private String cui;
    private String nombre;
    private String apellido;
    private List<Cuentas> cuentas;

    public Clientes(String cui, String nombre, String apellido) {
        this.cui = cui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuentas = new ArrayList<>();
    }
    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Cuentas> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuentas> cuentas) {
        this.cuentas = cuentas;
    }
 

 public void agregarCuenta(Cuentas cuenta) {
        if (cuentas.size() < 3) { // Máximo 3 cuentas por cliente 
            cuentas.add(cuenta);
        } else {
            throw new IllegalStateException("No se pueden agregar más cuentas. Límite alcanzado.");
        }
    }
 
}
