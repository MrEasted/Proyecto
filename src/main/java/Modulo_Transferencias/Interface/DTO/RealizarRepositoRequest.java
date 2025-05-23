package Modulo_Transferencias.Interface.DTO;

public class RealizarRepositoRequest {
    int rut;
    int monto;

    public RealizarRepositoRequest() {}

    public RealizarRepositoRequest(int rut, int monto) {
        this.rut = rut;
        this.monto = monto;

    }
    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }


}
