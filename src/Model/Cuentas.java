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
import java.time.LocalDateTime;
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
        this.saldo = 0.00;  
        this.transacciones = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
            transacciones.add(new Transaccion(id,"Depósito", 0, monto, LocalDateTime.now(), saldo)); // Guardar la transacción
        } else {
            throw new IllegalArgumentException("El monto del depósito debe ser mayor a 0.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && saldo >= monto) {
            saldo -= monto;
            transacciones.add(new Transaccion(id, "Retiro", monto, 0, LocalDateTime.now(), saldo)); // Guardar la transacción
        } else {
            throw new IllegalArgumentException("Monto inválido o saldo insuficiente.");
        }
    }
    
    public void agregarTransaccion(Transaccion transaccion) {
        if (transacciones.size() < 25) {
            double nuevoSaldo = this.saldo; 
            if (transaccion.getMontoAcreditado() > 0) {
                nuevoSaldo += transaccion.getMontoAcreditado(); 
            } else {
                nuevoSaldo -= transaccion.getMontoDebitado(); 
            }
           // transaccion.setSaldoDisponible(nuevoSaldo); 
            transacciones.add(transaccion);
        } else {
            throw new IllegalStateException("No se pueden realizar más de 25 transacciones por cuenta.");
        }
    }
}
