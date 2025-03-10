/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Model.Banco;
import Model.Bitacora;
import View.Usuario;
import View.CrearCuenta;
import View.Depositos;
import View.Retiros;
import View.Historial;

/**
 *
 * @author Christopher
 */
public class BController {
    private Banco banco;
    private Bitacora bitacora;

public BController(Banco banco) {
        this.banco = banco;
        this.bitacora = new Bitacora();
}

 public void mostrarRegistroUsuario() {
        new Usuario(new RUsuarios(banco, bitacora));
    }

    public void mostrarCrearCuenta() {
        new CrearCuenta(new CrearCuentaController(banco, bitacora));
    }

    public void mostrarDepositos() {
        new Depositos(new DepositosController(banco, bitacora));
    }

    public void mostrarRetiros() {
        new Retiros (new RetirosController(banco, bitacora));
    }

    public void mostrarHistorialTransacciones() {
        new Historial (new HistorialController(banco));
    }

    public void generarBitacoraPDF() {
        String nombreArchivo = "bitacora_" + System.currentTimeMillis() + ".pdf";
        bitacora.generarPDF(nombreArchivo);
    }
}
