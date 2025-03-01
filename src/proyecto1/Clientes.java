/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Christopher
 */
import proyecto1.Cuentas;
public class Clientes {
 public String cui;

public String nombre;

public String apellido;

public Cuentas[] cuentas; // Arreglo de cuentas

public int numCuentas; // Contador de cuentas



public Clientes(String cui, String nombre, String apellido){
this.cui=cui;
this.nombre=nombre;
this.apellido=apellido;
this.cuentas= new Cuentas[3];
this.numCuentas=0;
}

public void AgregarCuenta(Cuentas cuenta){
    if(numCuentas <= cuentas.length){
        cuentas[numCuentas]=cuenta;
        numCuentas = numCuentas + 1;
    } else {
        System.out.println("Ya no se pueden agregar mas cuentas");
    }
    
}




}
