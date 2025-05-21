package Modulo_Comercio.Dominio;

import java.time.LocalDate;

public class Tarjeta {

    private int numero;
    private String marca;
    private LocalDate localDate;


    public Tarjeta(int numero, LocalDate localDate, String marca) {
        this.numero = numero;
        this.localDate = localDate;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}


