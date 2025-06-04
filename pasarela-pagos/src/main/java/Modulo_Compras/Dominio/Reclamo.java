package Modulo_Compras.Dominio;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Compra_Reclamos")
@Table(name = "compra_reclamos")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compra_comercio_id", referencedColumnName = "id")
    private Comercio comercio;

    private String reclamo;
    private LocalDate fecha;

    public Reclamo() {
    }

    public Reclamo(Comercio comercio, String reclamo) {
        this.comercio = comercio;
        this.reclamo = reclamo;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public long getId() {
        return id;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReclamo() {
        return reclamo;
    }

    public void setReclamo(String reclamo) {
        this.reclamo = reclamo;
    }
}
