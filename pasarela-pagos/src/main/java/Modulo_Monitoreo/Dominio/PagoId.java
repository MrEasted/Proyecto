package Modulo_Monitoreo.Dominio;


import jakarta.persistence.Embeddable;

@Embeddable
public class PagoId {


    private int rut;
    private int idCompra;

    public PagoId() {}

    public PagoId(int rut, int idCompra) {
        this.rut = rut;
        this.idCompra = idCompra;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }
}
