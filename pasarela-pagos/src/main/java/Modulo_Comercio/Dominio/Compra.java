package Modulo_Comercio.Dominio;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity (name = "Comercio_Compra")
@Table(name = "comercio_compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "tarjeta_id")
    private Tarjeta tarjeta;

    @ManyToOne
    @JoinColumn(name = "pos_id")
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
