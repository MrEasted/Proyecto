package Modulo_Transferencias.Dominio;

public class Compra {
    private int idCompra;
    private int importe;
    private Date fecha;
    private String cantidades;

    public Compra(int idCompra, int importe, Date fecha, String cantidades) {
        this.idCompra = idCompra;
        this.importe = importe;
        this.fecha = fecha;
        this.cantidades = cantidades;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCantidades() {
        return cantidades;
    }

    public void setCantidades(String cantidades) {
        this.cantidades = cantidades;
    }
}
