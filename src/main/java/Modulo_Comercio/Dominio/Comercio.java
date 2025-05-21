package Modulo_Comercio.Dominio;

import java.util.ArrayList;
import java.util.List;

public class Comercio {
    private int rut;
    private List<Compra> compras;
    private CuentaBancoComercio cuenta;
    private List<Pos> pos;
    private List<Reclamos> reclamos;

    public Comercio(int rut, List<Compra> compras, CuentaBancoComercio cuenta, List<Pos> pos) {
        this.rut = rut;
        this.compras = compras;
        this.cuenta = cuenta;
        this.pos = pos;
        this.reclamos = new ArrayList<>();
    }

    public  Comercio() {}

    public int getRut() {
        return rut;
    }
    public void setRut(int rut) {
        this.rut = rut;
    }
    public List<Compra> getCompras() {
        return compras;
    }
    public void setCompras(List<Compra> compras) { this.compras = compras; }
    public CuentaBancoComercio getCuenta() {
        return cuenta;
    }
    public void setCuenta(CuentaBancoComercio cuenta) {
        this.cuenta = cuenta;
    }
    public List<Pos> getPos() { return pos; }
    public void setPos(List<Pos> pos) { this.pos = pos; }
    public List<Reclamos> getReclamos() {return reclamos;}
    public void setReclamos(List<Reclamos> reclamos) {this.reclamos = reclamos;}

}


