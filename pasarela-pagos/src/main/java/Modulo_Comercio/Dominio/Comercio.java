package Modulo_Comercio.Dominio;

import Modulo_Comercio.Seguridad.HASH;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

// EL NOMBRE DE LA ENTIDAD NO PUEDE SER IGUAL A LAS OTRAS ENTIDADES

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity (name = "Comercio_Comercio")
@Table(name = "comercio_comercio")
public class Comercio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cuenta_id")
    private CuentaBancoComercio cuenta;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "comercio_id_pos")
    private List<Pos> pos;

    @OneToMany(mappedBy = "comercio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reclamo> reclamos;

    private int rut;
    private String password;
    private String usuario;

    public Comercio(int rut, List<Compra> compras, CuentaBancoComercio cuenta, List<Pos> pos, String password, String usuario) {
        this.rut = rut;
        this.cuenta = cuenta;
        this.pos = pos;
        //CONVERTIMOS EN HASH LA CONTRASEÑA
        this.password = HASH.convertToHas(password);
        this.reclamos = new ArrayList<>();
        this.usuario = usuario;
    }

    public  Comercio() {}

    public Comercio(int rut, List<Compra> compras, CuentaBancoComercio cuenta, List<Pos> pos) {
        this.rut = rut;
        this.cuenta = cuenta;
        this.pos = pos;
    }


    public int getRut() {
        return rut;
    }
    public void setRut(int rut) {
        this.rut = rut;
    }

    public CuentaBancoComercio getCuenta() {
        return cuenta;
    }
    public void setCuenta(CuentaBancoComercio cuenta) {
        this.cuenta = cuenta;
    }

    public List<Pos> getPos() { return pos; }
    public void setPos(List<Pos> pos) { this.pos = pos; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Reclamo> getReclamos() {return reclamos;}
    public void setReclamos(List<Reclamo> reclamos) {this.reclamos = reclamos;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}


