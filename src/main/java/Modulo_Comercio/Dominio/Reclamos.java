package Modulo_Comercio.Dominio;

import java.time.LocalDate;

public class Reclamos {
    private String reclamo;
    private Comercio Comercio;
    private LocalDate fecha;


    public Reclamos() {
    }


    public Reclamos(Comercio comercio, String reclamo) {
        Comercio = comercio;
        this.reclamo = reclamo;
    }

    public Comercio getComercio() {
        return Comercio;
    }

    public void setComercio(Comercio comercio) {
        Comercio = comercio;
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
