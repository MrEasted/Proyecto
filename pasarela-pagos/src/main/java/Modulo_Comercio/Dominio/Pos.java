package Modulo_Comercio.Dominio;

import jakarta.persistence.*;

@Entity(name = "Comercio_Pos")
@Table(name = "comercio_pos")
public class Pos {
    @Id
    private int id;
    @Column(columnDefinition = "TINYINT(1)")
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
