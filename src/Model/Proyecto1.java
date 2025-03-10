/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

/**
 *
 * @author Christopher
 */
import Model.Banco;
import Controller.LoginController;
import View.LoginView;

public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Banco banco = new Banco();
        LoginController loginController = new LoginController(banco);
        new LoginView(loginController);
    }
}
