package Modulo_Comercio.Dominio;

public class CuentaBancoCliente {

    private int numero;
    private double saldo;


    public CuentaBancoCliente(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public CuentaBancoCliente() {
    }



    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
