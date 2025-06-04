package Modulo_Comercio.Dominio;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Comercio_Deposito")
@Table(name = "comercio_deposito")
public class Deposito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private CuentaBancoComercio cuenta;

    private LocalDate fecha;
    private float importe;

    public Deposito(LocalDate fecha, float importe) {
        this.fecha = fecha;
        this.importe = importe;
    }

    public Deposito() {
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
