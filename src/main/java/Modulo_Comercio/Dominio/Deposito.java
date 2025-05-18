package Modulo_Comercio.Dominio;

import java.time.LocalDate;

public class Deposito {
    private LocalDate fecha;
    private float importe;
    private Compra compra;

    public Deposito(LocalDate fecha, float importe, Compra compra) {
        this.fecha = fecha;
        this.importe = importe;
    }

    public Deposito() {}

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public float getImporte() {
        return importe;
    }
    public void setImporte(float importe) {
        this.importe = importe;
    }
    public Compra getCompra() { return compra; }
    public void setCompra(Compra compra) { this.compra = compra; }
}
