package Modulo_Transferencias.Dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "Transferencia_Comercio")
@Table(name = "transferencia_comercio")
public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private int rut;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "transferencia_Compras_Comercio_Id")
    private List<Compra> compras;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "transferencia_cuenta_id")
    private CuentaBancoComercio cuenta;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "comercio_id_pos")
    private List<Pos> pos;

    public Comercio(int rut, List<Compra> compras, CuentaBancoComercio cuenta, List<Pos> pos) {
        this.rut = rut;
        this.compras = compras;
        this.cuenta = cuenta;
        this.pos = pos;
    }

    public  Comercio() {}

    public Comercio(int rut, CuentaBancoComercio cuenta, List<Pos> posList) {}


    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public CuentaBancoComercio getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaBancoComercio cuenta) {
        this.cuenta = cuenta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Pos> getPos() {
        return pos;
    }

    public void setPos(List<Pos> pos) {
        this.pos = pos;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
}


