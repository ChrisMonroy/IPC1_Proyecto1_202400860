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
this.cuentas= new Cuentas[10];
this.numCuentas=0;
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



}
