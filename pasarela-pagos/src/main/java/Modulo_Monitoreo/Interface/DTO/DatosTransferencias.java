package main.java.Modulo_Monitoreo.Interface.DTO;

import java.time.LocalDate;

public class DatosTransferencias {

    int rutComercio;

    LocalDate fechaDeposito;

    float importe;



    public int getRutComercio() {
        return rutComercio;
    }

    public void setRutComercio(int rutComercio) {
        this.rutComercio = rutComercio;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public LocalDate getFechaDeposito() {
        return fechaDeposito;
    }

    public void setFechaDeposito(LocalDate fechaDeposito) {
        this.fechaDeposito = fechaDeposito;
    }
}