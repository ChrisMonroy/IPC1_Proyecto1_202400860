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
    private double saldoDisponible;

    public Transaccion(String id, String detalle, double montoDebitado, double montoAcreditado, LocalDateTime fechaHora, double saldoDisponible) {
        this.id = id;
        this.detalle = detalle;
        this.montoDebitado = montoDebitado;
        this.montoAcreditado = montoAcreditado;
        this.fechaHora = fechaHora;
        this.saldoDisponible = saldoDisponible;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
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
