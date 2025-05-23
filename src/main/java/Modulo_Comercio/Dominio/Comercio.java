package Modulo_Comercio.Dominio;

import java.util.ArrayList;
import java.util.List;


public class Comercio {
    private int rut;
    private CuentaBancoComercio cuenta;
    private List<Pos> pos;

    private String password;
    private List<Reclamos> reclamos;


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

    public List<Reclamos> getReclamos() {return reclamos;}
    public void setReclamos(List<Reclamos> reclamos) {this.reclamos = reclamos;}


}


