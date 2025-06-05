package Modulo_Compras.Dominio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "Compra_Comercio")
@Table(name = "compra_comercio")
public class Comercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "compra_comercio_compra")
    private List<Compra> compras;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "compra_cuenta_id")
    private CuentaBancoComercio cuenta;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "compra_comercio_id_pos")
    private List<Pos> pos;


    @OneToMany(mappedBy = "comercio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reclamo> reclamos;

    private int rut;
    private String password;

    public Comercio(int rut, List<Compra> compras, CuentaBancoComercio cuenta, List<Pos> pos, String password) {
        this.rut = rut;
        this.cuenta = cuenta;
        this.pos = pos;
        this.password = password;
        this.reclamos = new ArrayList<>();
    }

    public  Comercio() {}

    public Comercio(int rut, List<Compra> compras, CuentaBancoComercio cuenta, List<Pos> pos) {
        this.rut = rut;
        this.cuenta = cuenta;
        this.pos = pos;
    }

        public CuentaBancoComercio getCuenta() {
            return cuenta;
        }

        public void setCuenta(CuentaBancoComercio cuenta) {
            this.cuenta = cuenta;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public List<Pos> getPos() {
            return pos;
        }

        public void setPos(List<Pos> pos) {
            this.pos = pos;
        }

        public List<Reclamo> getReclamos() {
            return reclamos;
        }

        public void setReclamos(List<Reclamo> reclamos) {
            this.reclamos = reclamos;
        }

        public int getRut() {
            return rut;
        }

        public void setRut(int rut) {
            this.rut = rut;
        }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}


