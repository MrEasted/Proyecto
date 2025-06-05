package Modulo_Comercio.Dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity (name = "Comercio_Cuenta_Banco_Cliente")
@Table(name = "comercio_cuenta_banco_cliente")
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
