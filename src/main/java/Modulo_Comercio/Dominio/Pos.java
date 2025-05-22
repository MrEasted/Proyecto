package Modulo_Comercio.Dominio;

public class Pos {
    private int id;
    private boolean activo;

    public Pos(int id, boolean activo) {
        this.id = id;
        this.activo = activo;
    }

    public Pos(){}



    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public boolean isActivo() { return activo; }


    public void setActivo(boolean activo) { this.activo = activo; }

    public void cambiarEstado(boolean activo) { this.activo = activo; }

}
