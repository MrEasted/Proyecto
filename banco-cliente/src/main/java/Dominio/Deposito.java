package Dominio;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Deposito {
    private String rut;
    private double monto;
    private String referencia;

    public Deposito() {}

    public Deposito(String rut, double monto, String referencia) {
        this.rut = rut;
        this.monto = monto;
        this.referencia = referencia;
    }

    public String getRut() { return rut; }
    public void setRut(String rut) { this.rut = rut; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }
}