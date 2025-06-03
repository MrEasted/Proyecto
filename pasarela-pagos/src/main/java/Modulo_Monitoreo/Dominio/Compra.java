package Modulo_Monitoreo.Dominio;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "monitoreo_compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "monitoreo_tarjeta_id")
    private Tarjeta tarjeta;

    private float importe;
    private LocalDate fecha;
    private String descripcion;
    private int cantidades;

    public Compra() {}


    public Compra(int idCompra, int importe, LocalDate fecha, int cantidades) {
        this.id = idCompra;
        this.importe = importe;
        this.fecha = fecha;
        this.cantidades = cantidades;
    }


    public int getCantidades() {
        return cantidades;
    }

    public void setCantidades(int cantidades) {
        this.cantidades = cantidades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
