package Modulo_Transferencias.Dominio;

import java.util.List;
import java.util.stream.Collectors;

public class Comercio {
    private int rut;
    private List<Compra> compras;
    private CuentaBancoComercio cuenta;
    private List<Pos> pos;

    public Comercio(int rut, List<Compra> compras, CuentaBancoComercio cuenta, List<Pos> pos) {
        this.rut = rut;
        this.compras = compras;
        this.cuenta = cuenta;
        this.pos = pos;
    }

    public  Comercio() {}

    public Comercio(int rut, CuentaBancoComercio cuenta, List<Pos> posList) {}








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

}


