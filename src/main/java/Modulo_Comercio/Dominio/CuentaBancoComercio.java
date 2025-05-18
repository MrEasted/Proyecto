package Modulo_Comercio.Dominio;

import java.util.List;

public class CuentaBancoComercio {
    private int nroCuenta;
    private List<Deposito> depositos;

    public CuentaBancoComercio(int nroCuenta, List<Deposito> depositos) {
        this.nroCuenta = nroCuenta;
        this.depositos = depositos;
    }

    public CuentaBancoComercio() {}

    public int getNroCuenta() { return nroCuenta; }
    public void setNroCuenta(int nroCuenta) { this.nroCuenta = nroCuenta; }
    public List<Deposito> getDepositos() { return depositos; }
    public void setDepositos(List<Deposito> depositos) { this.depositos = depositos; }
}
