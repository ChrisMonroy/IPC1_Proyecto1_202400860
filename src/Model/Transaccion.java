/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Christopher
 */
import java.util.Date;

public class Transaccion {
    private String id;
    private Date fecha;
    private String detalle;
    private double montoDebitado;
    private double montoAcreditado;

    public Transaccion(String id, Date fecha, String detalle, double montoDebitado, double montoAcreditado) {
        this.id = id;
        this.fecha = fecha;
        this.detalle = detalle;
        this.montoDebitado = montoDebitado;
        this.montoAcreditado = montoAcreditado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getMontoDebitado() {
        return montoDebitado;
    }

    public void setMontoDebitado(double montoDebitado) {
        this.montoDebitado = montoDebitado;
    }

    public double getMontoAcreditado() {
        return montoAcreditado;
    }

    public void setMontoAcreditado(double montoAcreditado) {
        this.montoAcreditado = montoAcreditado;
    }
    
}
