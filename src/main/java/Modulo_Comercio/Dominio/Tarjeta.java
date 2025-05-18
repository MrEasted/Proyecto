package Modulo_Comercio.Dominio;

import java.time.LocalDate;

public class Tarjeta {
    private int numero;
    private String marca;
    private LocalDate vencimiento;

    public Tarjeta(int numero, String marca, LocalDate vencimiento) {
        this.numero = numero;
        this.marca = marca;
        this.vencimiento = vencimiento;
    }

    public Tarjeta() {}

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public LocalDate getVencimiento() { return vencimiento; }
    public void setVencimiento(LocalDate vencimiento) { this.vencimiento = vencimiento; }
}


