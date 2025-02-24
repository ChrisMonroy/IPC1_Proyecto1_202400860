/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Christopher
 */
import Controller.Controlador;
import proyecto1.Clientes;
import View.Vista;
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    Vista vista = new Vista();
    Clientes cliente = new Clientes("20","Jose","Cesar");
    Controlador controlador = new Controlador(cliente,vista);
    Clientes cliente1 = new Clientes ("","","");
}
