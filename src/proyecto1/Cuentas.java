/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

/**
 *
 * @author Christopher
 */
public class Cuentas {
    private String ID;
    private String CUI;
    private double saldo;
    
    public Cuentas (String ID, String CUI, double saldo){
        this.ID=ID;
        this.CUI=CUI;
        this.saldo=0.00;
    }
   public String getId() { return ID; }
    public String getCuiCliente() { return CUI; }
    public double getSaldo() { return saldo; }

    public void depositar(double monto) {
        saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            return true;
        }
        return false;
    }
}
