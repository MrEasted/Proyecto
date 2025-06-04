package Modulo_Compras.Dominio;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity(name = "Compra_Compra")
@Table(name = "compra_compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "compra_tarjeta_id")
    private Tarjeta tarjeta;

    private int pos;


    private double importe;
    private LocalDate fecha;
    private String descripcion;

    public Compra(double importe, LocalDate fecha, String descripcion, Tarjeta tarjeta, int pos) {
        this.importe = importe;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tarjeta = tarjeta;
        this.pos = pos;
    }

    public Compra() {}


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}

