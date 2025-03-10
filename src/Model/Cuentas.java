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
public class Cuentas {
    private String ID;
    private String CUI;
    private double saldo;
    
    public Cuentas(String cuiCliente, double saldoInicial) {
        this.ID = UUID.randomUUID().toString(); 
        this.CUI = cuiCliente;
        this.saldo = saldoInicial; 
    }

    public String getId() { return ID; }
    public String getCuiCliente() { return CUI; }
    public double getSaldo() { return saldo; }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        } else {
            System.out.println("El monto a depositar debe ser mayor que cero.");
        }
    }

    public boolean retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false; // Saldo insuficiente
    }
}
