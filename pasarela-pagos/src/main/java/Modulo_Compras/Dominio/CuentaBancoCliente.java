package Modulo_Compras.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "compra_cuenta_banco_cliente")
public class CuentaBancoCliente {
    @Id
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
