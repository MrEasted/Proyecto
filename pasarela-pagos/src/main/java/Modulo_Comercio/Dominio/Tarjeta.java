package Modulo_Comercio.Dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.time.LocalDate;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "Comercio_Tarjeta")
@Table(name = "comercio_tarjeta")
public class Tarjeta {
    @Id
    private int numero;

    @ManyToOne
    @JoinColumn(name = "cuenta_cliente_id")
    private CuentaBancoCliente cuentaCliente;

    private String marca;
    private LocalDate localDate;

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


