package Modulo_Monitoreo.Dominio;

import Modulo_Compras.Dominio.CuentaBancoComercio;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "monitoreo_deposito")
public class Deposito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "monitoreo_cuenta_id")
    private CuentaBancoComercio cuenta;

    private LocalDate fecha;
    private float importe;


    public Deposito() {}


    public Deposito(LocalDate fecha, float importe) {
        this.fecha = fecha;
        this.importe = importe;
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
