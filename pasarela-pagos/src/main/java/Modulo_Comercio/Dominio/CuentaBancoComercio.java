package Modulo_Comercio.Dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity (name = "Comercio_Cuenta_Banco_Comercio")
@Table(name = "comercio_cuenta_banco_comercio")
public class CuentaBancoComercio {
    @Id
    private int nroCuenta;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cuenta_id")
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
