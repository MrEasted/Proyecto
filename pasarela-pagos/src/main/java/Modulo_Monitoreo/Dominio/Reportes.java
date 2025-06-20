package Modulo_Monitoreo.Dominio;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Monitoreo_Reportes")
@Table(name = "monitoreo_reportes")
public class Reportes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int rutComercio;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    public Reportes(LocalDate fechaFin, LocalDate fechaInicio, int rutComercio) {
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.rutComercio = rutComercio;
    }

    public Reportes() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getRutComercio() {
        return rutComercio;
    }

    public void setRutComercio(int rutComercio) {
        this.rutComercio = rutComercio;
    }
}
