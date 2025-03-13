/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Bitacora;
import Model.Clientes;
import Model.Cuentas;
import Model.Transaccion;
import View.Bienvenida;
import View.BuscarCuentas;
import View.CrearCuenta;
import View.Depositos;
import View.Historial;
import View.Reportes;
import View.Retiros;
import View.Usuario;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Christopher
 */
public class BController {
    private Bienvenida view;  // Vista de la pantalla principal
    private List<Clientes> clientes;  // Lista de clientes
    private List<Cuentas> cuentas;  // Lista de cuentas
    private Transaccion transaccionModel;  // Modelo de transacciones
    private Bitacora bitacoraModel;  // Modelo de bitácora

    // Constructor
    public BController(Bienvenida view, List<Clientes> clientes, List<Cuentas> cuentas, Transaccion transaccionModel, Bitacora bitacoraModel) {
        this.view = view;
        this.clientes = clientes;
        this.cuentas = cuentas;
        this.transaccionModel = transaccionModel;
        this.bitacoraModel = bitacoraModel;

    }

    // Método para mostrar la vista de Registro de Usuario
    public void mostrarRegistroUsuario() {
        RUsuarios registroController = new RUsuarios(clientes);
        Usuario usuarioView = new Usuario(registroController);
        usuarioView.setVisible(true);
        bitacoraModel.registrar("AdministradorIPC1D", "Registro de Usuario", "Éxito", "Vista de registro de usuario abierta.");
    }

    // Método para mostrar la vista de Crear Cuenta
    public void mostrarCrearCuenta() {
        CrearCuentaController crearCuentaController = new CrearCuentaController(clientes);
        CrearCuenta crearCuentaView = new CrearCuenta(crearCuentaController);
        crearCuentaView.setVisible(true);
        bitacoraModel.registrar("AdministradorIPC1D", "Crear Cuenta", "Éxito", "Vista de creación de cuenta abierta.");
    }

    // Método para mostrar la vista de Retiros
    public void mostrarRetiros() {
        RetirosController retirosController = new RetirosController(clientes); // Pasar la lista de clientes
        Retiros retirosView = new Retiros(retirosController, clientes); // Crear la vista de retiros
        retirosView.setVisible(true); // Mostrar la vista
    }

    public void mostrarDepositos() {
        DepositosController depositosController = new DepositosController(clientes);
        Depositos depositosView = new Depositos(depositosController, clientes);
        depositosView.setVisible(true);
    }

    // Método para mostrar la vista de Buscar Cuentas
    private void mostrarBuscarCuentas() {
        BuscarController buscarController = new BuscarController(clientes);
        BuscarCuentas buscarCuentasView = new BuscarCuentas(buscarController);
        buscarCuentasView.setVisible(true);
        bitacoraModel.registrar("AdministradorIPC1D", "Buscar Cuentas", "Éxito", "Vista de búsqueda de cuentas abierta.");
    }

    // Método para mostrar la vista de Historial de Transacciones
    public void mostrarHistorialTransacciones() {
        HistorialController historialController = new HistorialController(clientes);
        Historial historialView = new Historial(historialController);
        historialView.setVisible(true);
        bitacoraModel.registrar("AdministradorIPC1D", "Historial de Transacciones", "Éxito", "Vista de historial de transacciones abierta.");
    }

    // Método para mostrar la vista de Generar Reportes
    private void mostrarGenerarReportes() {
        ReportesControler reportesController = new ReportesControler(clientes);
        Reportes reportesView = new Reportes(reportesController);
        reportesView.setVisible(true);
        bitacoraModel.registrar("AdministradorIPC1D", "Generar Reportes", "Éxito", "Vista de generación de reportes abierta.");
    }

    // Método para mostrar los datos del estudiante
    private void mostrarDatosEstudiante() {
       

        bitacoraModel.registrar("AdministradorIPC1D", "Datos del Estudiante", "Éxito", "Datos del estudiante mostrados.");
    }
}
