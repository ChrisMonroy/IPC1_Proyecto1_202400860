/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Christopher
 */
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class Transaccion {
   private String id;
    private String detalle;
    private double montoDebitado;
    private double montoAcreditado;
    private LocalDateTime fechaHora;

    public Transaccion(String detalle, double montoAcreditado, double montoDebitado) {
        this.id = UUID.randomUUID().toString();
        this.detalle = detalle;
        this.montoAcreditado = montoAcreditado;
        this.montoDebitado = montoDebitado;
        this.fechaHora = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}
