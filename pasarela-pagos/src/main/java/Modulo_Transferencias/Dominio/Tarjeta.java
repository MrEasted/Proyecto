package Modulo_Transferencias.Dominio;

import java.time.LocalDate;

public class Tarjeta {

    private int numero;
    private String marca;
    private LocalDate localDate;
    private CuentaBancoCliente cuentaCliente;

    public Tarjeta(int numero, String marca, LocalDate localDate, CuentaBancoCliente cuentaBancoCliente) {
        this.numero = numero;
        this.marca = marca;
        this.localDate = localDate;
        this.cuentaCliente = cuentaBancoCliente;
    }

    public Tarjeta() {
    }




    public CuentaBancoCliente getCuentaCliente() {
        return cuentaCliente;
    }

    public void setCuentaCliente(CuentaBancoCliente cuentaCliente) {
        this.cuentaCliente = cuentaCliente;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}


