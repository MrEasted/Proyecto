package main.java.Modulo_Compras.Dominio;


import java.time.LocalDate;

public class Compra {

    private static int contadorId = 1;


    private int idPos;
    private String descripcion;
    private LocalDate fecha;
    private double importe;
    private int id;
    private Tarjeta tarjeta;

    public Compra(int idPos, String descripcion, LocalDate fecha, double importe,Tarjeta tarjeta) {
        this.id = contadorId++;
        this.idPos = idPos;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.importe = importe;
        this.tarjeta = null;
    }


    public Compra() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPos() {
        return idPos;
    }

    public void setIdPos(int idPos) {
        this.idPos = idPos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }
    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

}
