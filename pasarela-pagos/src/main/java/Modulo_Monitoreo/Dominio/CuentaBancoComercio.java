package Modulo_Monitoreo.Dominio;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "monitoreo_cuenta_banco_comercio")
public class CuentaBancoComercio {
    @Id
    private int nroCuenta;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "monitoreo_cuenta_id")
    private List<Deposito> depositos;

    public CuentaBancoComercio() {
    }

    public CuentaBancoComercio(List<Deposito> depositos, int nroCuenta) {
        this.depositos = depositos;
        this.nroCuenta = nroCuenta;
    }

    public List<Deposito> getDepositos() {
        return depositos;
    }

    public void setDepositos(List<Deposito> depositos) {
        this.depositos = depositos;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }
}
