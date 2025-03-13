/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package View;

/**
 *
 * @author Christopher
 */
import java.util.ArrayList;
import java.util.List;
import Controller.LoginController;
import Model.Bitacora;
import Model.Clientes;


public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      List<Clientes> clientes = new ArrayList<>();
      
     LoginController loginController = new LoginController();
  
     
     
     loginController.setClientes(clientes);
     
     
        // Mostrar la vista de login
        LoginView loginView = new LoginView(loginController);
        loginView.setVisible(true);
        Bitacora Bitacora = new Bitacora();
        
        loginController.setBitacoraModel(Bitacora);

        // Ejemplo de uso de la bitácora (no es necesario crear una instancia)
        Bitacora.registrar("Sistema", "Inicio de la aplicación", "Éxito", "La aplicación se ha iniciado correctamente.");
    }
}
