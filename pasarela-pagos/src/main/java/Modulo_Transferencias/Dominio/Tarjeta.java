package Modulo_Transferencias.Dominio;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Transferencia_Tarjeta")
@Table(name = "transferencia_tarjeta")
public class Tarjeta {

    @Id
    private int numero;


    private String marca;
    private LocalDate localDate;
    @ManyToOne
    @JoinColumn(name = "transferencia_cuenta_cliente_id")
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


