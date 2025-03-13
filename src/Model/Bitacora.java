package Model;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Christopher
 */
public class Bitacora {
    private String marcaTemporal;
    private String usuario;
    private String accion;
    private String resultado;
    private String detalles;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Bitacora(String usuario, String accion, String resultado, String detalles) {
        this.marcaTemporal = LocalDateTime.now().toString();
        this.usuario = usuario;
        this.accion = accion;
        this.resultado = resultado;
        this.detalles = detalles;
    }

    public Bitacora() {
        
    }

    public void setMarcaTemporal(String marcaTemporal) {
        this.marcaTemporal = marcaTemporal;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    // Getters
    public String getMarcaTemporal() { return marcaTemporal; }
    public String getUsuario() { return usuario; }
    public String getAccion() { return accion; }
    public String getResultado() { return resultado; }
    public String getDetalles() { return detalles; }

    public static void registrar(String usuario, String accion, String resultado, String detalles) {
        // Obtener la marca temporal actual (fecha y hora)
        String marcaTemporal = LocalDateTime.now().format(formatter);

        // Crear el registro en formato de cadena
        String registro = String.format("[%s] Usuario: %s - Acción: %s - Resultado: %s - Detalles: %s",
                marcaTemporal, usuario, accion, resultado, detalles);

        // Imprimir el registro en la consola (puede ser reemplazado por un archivo de log)
        System.out.println(registro);
    }
}