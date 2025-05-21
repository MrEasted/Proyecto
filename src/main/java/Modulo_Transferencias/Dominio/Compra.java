package Modulo_Transferencias.Dominio;

import java.time.LocalDate;

public class Compra {
    private int id;
    private float importe;
    private LocalDate fecha;
    private String descripcion;
    private Tarjeta tarjeta;
    private Pos pos;

    public Compra(int id, int importe, LocalDate fecha, String descripcion, Tarjeta tarjeta, Pos pos) {
        this.id = id;
        this.importe = importe;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tarjeta = tarjeta;
        this.pos = pos;
    }

    public Compra() {}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public float getImporte() {return importe;}
    public void setImporte(float importe) {this.importe = importe;}
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public Tarjeta getTarjeta() {return tarjeta;}
    public void setTarjeta(Tarjeta tarjeta) {this.tarjeta = tarjeta;}
    public Pos getPos() {return pos;}
    public void setPos(Pos pos) {this.pos = pos;}
}
