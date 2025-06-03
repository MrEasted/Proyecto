package Modulo_Compras.Dominio;

import java.time.LocalDate;

public class Tarjeta {

    private int numero;
    private String marca;
    private LocalDate fechaVencimiento; //vencimiento


    public Tarjeta(int numero, LocalDate fechaVencimiento, String marca) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.marca = marca;
    }

    public Tarjeta() {

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


