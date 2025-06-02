package main.java.Modulo_Compras.Dominio;



import main.java.Modulo_Compras.Dominio.Compra;

import java.util.List;

public class Comercio {
    private int rut;
    private List<Compra> compras;
    private CuentaBancoComercio cuentabanco;
    private List<Pos> pos;


    public Comercio(int rut, List<Pos> pos, CuentaBancoComercio cuentabanco, List<Compra> compras) {
        this.rut = rut;
        this.pos = pos;
        this.cuentabanco = cuentabanco;
        this.compras = compras;
    }

    public Comercio() {

    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public List<Pos> getPos() {
        return pos;
    }

    public void setPos(List<Pos> pos) {
        this.pos = pos;
    }

    public CuentaBancoComercio getCuentabanco() {
        return cuentabanco;
    }

    public void setCuentabanco(CuentaBancoComercio cuentabanco) {
        this.cuentabanco = cuentabanco;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }
}


