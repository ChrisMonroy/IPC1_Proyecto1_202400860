/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Bitacora;
import Model.Clientes;
import Model.Cuentas;
import Model.Transaccion;
import View.Bienvenida;
import View.LoginView;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
    /*
    * @author Christopher
    */
    public class LoginController {
    private LoginView view;  // Vista de inicio de sesión
    private List<Clientes> clientes;  // Lista de clientes
    private Bitacora bitacoraModel;  // Modelo de bitácora

     public LoginController() {
         
    }
     
    // Constructor
    public LoginController(LoginView view, List<Clientes> clientes, Bitacora bitacoraModel) {
        this.view = view;
        this.clientes = clientes;
        this.bitacoraModel = bitacoraModel;

    }

    public LoginView getView() {
        return view;
    }

    public void setView(LoginView view) {
        this.view = view;
    }

    public List<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(List<Clientes> clientes) {
        this.clientes = clientes;
    }

    public Bitacora getBitacoraModel() {
        return bitacoraModel;
    }

    public void setBitacoraModel(Bitacora bitacoraModel) {
        this.bitacoraModel = bitacoraModel;
    }

 

    // Método para manejar el inicio de sesión
    public boolean iniciarSesion(String usuario, String password) {
       //String usuario = view.getUsuario();
       //String password = view.getPassword();
       //System.out.println("HOLA");
        // Validar credenciales
        if (usuario.equals("AdministradorIPC1D") && password.equals("ipc1D1s2025")) {
            //System.out.println("ADIOS");
            JOptionPane.showMessageDialog(view, "Bienvenido", "Bienvenido", JOptionPane.INFORMATION_MESSAGE);
            bitacoraModel.registrar("Sistema", "Inicio de sesión", "Éxito", "Sesión iniciada correctamente.");

            //Abrir la pantalla principal
           Bienvenida bienvenidaView = new Bienvenida();
           BController bController = new BController(bienvenidaView, clientes, new ArrayList<>(),
           new Transaccion("" ,"Inicio de sesión", 0.0, 0.0, LocalDateTime.now(), 0.0),bitacoraModel);
            //bienvenidaView.setVisible(true);
            return true;

            // Cerrar la ventana de inicio de sesión
            //view.dispose();
        } else {
            bitacoraModel.registrar("Sistema", "Inicio de sesión", "Error", "Usuario o contraseña incorrectos.");
            JOptionPane.showMessageDialog(view, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
        } 
    }
}