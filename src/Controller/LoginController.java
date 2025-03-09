/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.LoginView;
import Model.Banco;
import View.Bienvenida;
import javax.swing.JOptionPane;
/**
 *
 * @author Christopher
 */
public class LoginController {
    private Banco banco;

    public LoginController(Banco banco) {
        this.banco = banco;
    }

    public void login(String usuario, String password) {
        if (usuario.equals("AdministradorIPC1D") && password.equals("ipc1D1s2025")) {
            Bienvenida bienvenida = new Bienvenida(new BController(banco));
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
        }
    }
}