package Modulo_Compras.Dominio;

import Modulo_Comercio.Dominio.CuentaBancoCliente;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "compra_tarjeta")
public class Tarjeta {
    @Id
    private int numero;

    @ManyToOne
    @JoinColumn(name = "compra_cuenta_cliente_id")
    private CuentaBancoCliente cuentaCliente;

    private String marca;
    private LocalDate fechaVencimiento;

    public Tarjeta(int numero, LocalDate fechaVencimiento, String marca) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.marca = marca;
    }

    public Tarjeta() {

    }

    public CuentaBancoCliente getCuentaCliente() {
        return cuentaCliente;
    }

    public void setCuentaCliente(CuentaBancoCliente cuentaCliente) {
        this.cuentaCliente = cuentaCliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}


