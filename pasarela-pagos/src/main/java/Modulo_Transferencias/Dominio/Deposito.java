package Modulo_Transferencias.Dominio;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Transferencia_Deposito")
@Table(name = "transferencia_deposito")
public class Deposito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String referencia;
    private LocalDate fecha;
    private float importe;

    public Deposito(LocalDate fecha, float importe) {
        this.fecha = fecha;
        this.importe = importe;
    }

    public Deposito() {
    }


    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
