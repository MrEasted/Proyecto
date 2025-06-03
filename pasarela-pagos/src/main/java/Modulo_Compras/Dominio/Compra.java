package Modulo_Compras.Dominio;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "compra_compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "compra_tarjeta_id")
    private Tarjeta tarjeta;

    @ManyToOne
    @JoinColumn(name = "compra_pos_id")
    private Pos pos;


    private float importe;
    private LocalDate fecha;
    private String descripcion;

    public Compra(float importe, LocalDate fecha, String descripcion, Tarjeta tarjeta, Pos pos) {
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

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Pos getPos() {
        return pos;
    }

    public void setPos(Pos pos) {
        this.pos = pos;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}

