package Conta;

public class Conta {
    private double saldo;
    private double limite;
    
    public Conta(double limite) {
        saldo = 0;
        this.limite = limite;
    }
    
    public void depositar(double qte) {
        saldo += qte;
    }
    
    public boolean sacar(double qte) {
        if(saldo - qte < limite) return false;
        else return true;
    }
}
