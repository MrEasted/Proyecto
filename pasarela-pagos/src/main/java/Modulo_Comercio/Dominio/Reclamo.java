package Modulo_Comercio.Dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "Comercio_Reclamos")
@Table(name = "comercio_reclamos")
public class Reclamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comercio_id", referencedColumnName = "id")
    private Comercio comercio;

    private String reclamo;
    private LocalDate fecha;

    public Reclamo() {
    }

    public Reclamo(Comercio comercio, String reclamo) {
        this.comercio = comercio;
        this.reclamo = reclamo;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public String getReclamo() {
        return reclamo;
    }

    public void setReclamo(String reclamo) {
        this.reclamo = reclamo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

}
