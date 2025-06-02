package Modulo_Monitoreo.Dominio;

public class Tarjeta {

    private int numero;
    private String marca;
    private Date localDate;


    public Tarjeta(int numero, Date localDate, String marca) {
        this.numero = numero;
        this.localDate = localDate;
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

    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }
}


