package main.java.Modulo_Comercio.Interface.DTO;

import main.java.Modulo_Comercio.Dominio.Compra;
import main.java.Modulo_Comercio.Dominio.CuentaBancoComercio;
import main.java.Modulo_Comercio.Dominio.Pos;

import java.util.List;

public class AltaComercioRequest {
    private int rut;
    private List<Compra> compras;
    private CuentaBancoComercio cuenta;
    private List<Pos> pos;
    private String password;

    public int getRut() { return rut; }
    public void setRut(int rut) { this.rut = rut; }
    public List<Compra> getCompras() { return compras; }
    public void setCompras(List<Compra> compras) { this.compras = compras; }
    public CuentaBancoComercio getCuenta() { return cuenta; }
    public void setCuenta(CuentaBancoComercio cuenta) { this.cuenta = cuenta; }
    public List<Pos> getPos() { return pos; }
    public void setPos(List<Pos> pos) { this.pos = pos; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
