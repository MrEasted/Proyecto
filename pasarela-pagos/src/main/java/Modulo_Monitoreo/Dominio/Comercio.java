package main.java.Modulo_Monitoreo.Dominio;

public class Comercio {
    private int rut;
    private Compra micompra;
    private CuentaBancoComercio cuentabanco;


    public Comercio(int rut, Compra micompra, CuentaBancoComercio cuentabanco) {
        this.rut = rut;
        this.micompra = micompra;
        this.cuentabanco = cuentabanco;
    }

    public int getRut() {
        return rut;
    }

    public Compra getMicompra() {
        return micompra;
    }

    public CuentaBancoComercio getCuentabanco() {
        return cuentabanco;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setMicompra(Compra micompra) {
        this.micompra = micompra;
    }

    public void setCuentabanco(CuentaBancoComercio cuentabanco) {
        this.cuentabanco = cuentabanco;
    }
}


