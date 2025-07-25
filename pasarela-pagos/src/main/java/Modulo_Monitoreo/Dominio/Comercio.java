package Modulo_Monitoreo.Dominio;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity (name = "Monitoreo_Comercio")
@Table(name = "monitoreo_comercio")
public class Comercio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "monitoreo_cuenta_id")
    private CuentaBancoComercio cuenta;



    private int rut;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "monitoreo_Compras_Comercio_Id")
    private List<Compra> micompra;



    public Comercio() {}

    public Comercio(List<Compra> micompra, String password, List<Reclamos> reclamos, int rut, CuentaBancoComercio cuenta) {
        this.micompra = micompra;
        this.password = password;
      //  this.reclamos = reclamos;
        this.rut = rut;
        this.cuenta = cuenta;
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

    public List<Compra> getMicompra() {
        return micompra;
    }

    public void setMicompra(List<Compra> micompra) {
        this.micompra = micompra;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
}


