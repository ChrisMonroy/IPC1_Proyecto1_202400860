/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Christopher
 */
import View.Vista;
import Model.Clientes;
import Model.Cuentas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Clientes;
import Model.Cuentas;
import View.Vista;
public class Controlador {
public Vista vista;
public Clientes clientes;
public Cuentas cuentas;

//Construtor

public Controlador(Vista vista, Clientes clientes, Cuentas cuentas){

this.clientes=clientes;
this.cuentas=cuentas;
this.vista=vista;
}
public void VistaPrincipal(){

}

}