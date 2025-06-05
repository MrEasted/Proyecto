package Modulo_Monitoreo.Dominio;

import Modulo_Compras.Dominio.CuentaBancoComercio;
import jakarta.ejb.Local;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Monitoreo_Deposito")
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

    private int rutComercio;

    public Deposito() {}


    public Deposito(LocalDate fecha, float importe) {
        this.fecha = fecha;
        this.importe = importe;
    }

    public Deposito(LocalDate fecha,float importe,int rutComercio){
        this.fecha = fecha;
        this.importe = importe;
        this.rutComercio = rutComercio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public int getRutComercio() {
        return rutComercio;
    }

    public void setRutComercio(int rutComercio) {
        this.rutComercio = rutComercio;
    }
}
