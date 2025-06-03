package Modulo_Monitoreo.Dominio;


import Modulo_Comercio.Dominio.CuentaBancoCliente;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "monitoreo_tarjeta")
public class Tarjeta {

    @Id
    private int numero;

    @ManyToOne
    @JoinColumn(name = "monitoreo_cuenta_cliente_id")
    private CuentaBancoCliente cuentaCliente;

    private String marca;
    private LocalDate fechaVencimiento;


    public Tarjeta() {}


    public Tarjeta(int numero, LocalDate localDate, String marca) {
        this.numero = numero;
        this.fechaVencimiento = localDate;
        this.marca = marca;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public CuentaBancoCliente getCuentaCliente() {
        return cuentaCliente;
    }

    public void setCuentaCliente(CuentaBancoCliente cuentaCliente) {
        this.cuentaCliente = cuentaCliente;
    }
}


