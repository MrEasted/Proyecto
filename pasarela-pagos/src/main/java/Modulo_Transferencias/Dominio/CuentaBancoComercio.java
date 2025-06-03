package Modulo_Transferencias.Dominio;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "transferencia_cuenta_banco_comercio")
public class CuentaBancoComercio {
    @Id
    private int nroCuenta;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "transferencia_cuenta_id")
    private List<Deposito> depositos;

    public CuentaBancoComercio(int nroCuenta, List<Deposito> depositos) {
        this.nroCuenta = nroCuenta;
        this.depositos = depositos;
    }

    public CuentaBancoComercio() {
    }



    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public List<Deposito> getDepositos() {
        return depositos;
    }

    public void setDepositos(List<Deposito> depositos) {
        this.depositos = depositos;
    }
}
