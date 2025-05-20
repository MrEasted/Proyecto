package Modulo_Transferencias.Dominio;

import lombok.Getter;
import java.util.List;

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

    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setCompras(List<Compra> compras) { this.compras = compras; }

    public void setCuenta(CuentaBancoComercio cuenta) {
        this.cuenta = cuenta;
    }

    public void setPos(List<Pos> pos) { this.pos = pos; }

}


