package main.java.Modulo_Comercio.Interface.DTO;

public class ReclamoDTO {
    private int rut;
    private String reclamo;

    public ReclamoDTO() {
    }

    public ReclamoDTO(String reclamo, int rut) {
        this.reclamo = reclamo;
        this.rut = rut;
    }

    public String getReclamo() {
        return reclamo;
    }

    public void setReclamo(String reclamo) {
        this.reclamo = reclamo;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
}
