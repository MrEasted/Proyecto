package Modulo_Monitoreo.Dominio;


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity(name = "Monitoreo_Reclamos")
@Table(name = "monitoreo_reclamos")
public class Reclamos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   private int rutcomercio;

    private String reclamo;

    private LocalDate fecha;


    private String Clificacion;

    public Reclamos() {
    }

    public Reclamos(LocalDate fecha, long id, String reclamo, int rutcomercio) {
        this.fecha = fecha;
        this.id = id;
        this.reclamo = reclamo;
        this.rutcomercio = rutcomercio;
    }

    public String getClificacion() {
        return Clificacion;
    }

    public void setClificacion(String clificacion) {
        Clificacion = clificacion;
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

    public int getRutcomercio() {
        return rutcomercio;
    }

    public void setRutcomercio(int rutcomercio) {
        this.rutcomercio = rutcomercio;
    }
}
