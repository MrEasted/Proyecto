package Modulo_Monitoreo.Dominio;

import Modulo_Comercio.Dominio.Comercio;

import java.time.LocalDate;

public class Reclamos {
    private String reclamo;
    private Modulo_Comercio.Dominio.Comercio Comercio;
    private LocalDate fecha;

    public Reclamos() {
    }


    public Reclamos(Modulo_Comercio.Dominio.Comercio comercio, String reclamo) {
        Comercio = comercio;
        this.reclamo = reclamo;
    }

    public Modulo_Comercio.Dominio.Comercio getComercio() {
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
