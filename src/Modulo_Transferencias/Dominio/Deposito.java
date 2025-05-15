package Modulo_Transferencias.Dominio;

public class Deposito {
    private Date fecha;
    private float importe;

    public Deposito(Date fecha, float importe) {
        this.fecha = fecha;
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
}
