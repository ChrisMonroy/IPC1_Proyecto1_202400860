/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Christopher
 */
import java.util.UUID;
import Model.Transaccion;
import java.util.ArrayList;
import java.util.List;

public class Cuentas {
    private String id;
    private Clientes cliente;
    private double saldo;
    private List<Transaccion> transacciones;

    public Cuentas(String id, Clientes cliente) {
        this.id = id;
        this.cliente = cliente;
        this.saldo = 0.0;  
        this.transacciones = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        } else {
            throw new IllegalArgumentException("El monto del depósito debe ser mayor a 0.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
        } else {
            throw new IllegalArgumentException("Monto inválido o saldo insuficiente.");
        }
    }
    
}
