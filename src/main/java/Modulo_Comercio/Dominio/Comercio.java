package Modulo_Comercio.Dominio;

import java.util.List;


public class Comercio {
    private int rut;
    private CuentaBancoComercio cuenta;
    private List<Pos> pos;

    public Comercio(int rut, List<Compra> compras, CuentaBancoComercio cuenta, List<Pos> pos) {
        this.rut = rut;
        this.cuenta = cuenta;
        this.pos = pos;
    }

    public  Comercio() {}


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

}


