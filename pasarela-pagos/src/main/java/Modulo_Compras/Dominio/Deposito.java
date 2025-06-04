package Modulo_Compras.Dominio;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Compra_Deposito")
@Table(name = "compra_deposito")
public class Deposito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "compra_cuenta_id")
    private CuentaBancoComercio cuenta;

    private LocalDate fecha;
    private float importe;

    public Deposito() {}

    public Deposito(LocalDate fecha, float importe) {
        this.fecha = fecha;
        this.importe = importe;
    }

    public CuentaBancoComercio getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancoComercio cuenta) {
        this.cuenta = cuenta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
}
