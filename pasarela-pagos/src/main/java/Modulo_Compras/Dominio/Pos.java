package main.java.Modulo_Compras.Dominio;

public class Pos {
    private int id;
    private boolean activo;

    public Pos(int id, boolean activo) {
        this.id = id;
        this.activo = activo;
    }

    public Pos(){}

    public Pos(Integer integer) {
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public boolean isActivo() { return activo; }
}
