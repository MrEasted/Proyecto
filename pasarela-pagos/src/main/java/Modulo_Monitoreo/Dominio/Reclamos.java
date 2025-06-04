package Modulo_Monitoreo.Dominio;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity(name = "Monitoreo_Reclamos")
@Table(name = "monitoreo_reclamos")
public class Reclamos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "monitoreo_comercio_id", referencedColumnName = "id")
    private Comercio comercio;

    private String reclamo;

    private LocalDate fecha;

    public Reclamos() {
    }

    public Reclamos(String reclamo, LocalDate fecha, Comercio comercio) {
        this.reclamo = reclamo;
        this.fecha = fecha;
        this.comercio = comercio;
    }


    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public long getId() {
        return id;
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
