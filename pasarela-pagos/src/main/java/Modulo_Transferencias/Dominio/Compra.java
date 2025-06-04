package Modulo_Transferencias.Dominio;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Transferencia_Compra")
@Table(name = "transferencia_compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "transferencia_tarjeta_id")
    private Tarjeta tarjeta;



    private float importe;
    private LocalDate fecha;
    private String descripcion;
    @OneToOne
    @JoinColumn(name = "tranferencia_compra_pos")
    private Pos pos;

    public Compra(int id, int importe, LocalDate fecha, String descripcion, Tarjeta tarjeta, Pos pos) {
        this.id = id;
        this.importe = importe;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tarjeta = tarjeta;
        this.pos = pos;
    }

    public Compra() {}



    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public float getImporte() {return importe;}
    public void setImporte(float importe) {this.importe = importe;}
    public LocalDate getFecha() {return fecha;}
    public void setFecha(LocalDate fecha) {this.fecha = fecha;}
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public Tarjeta getTarjeta() {return tarjeta;}
    public void setTarjeta(Tarjeta tarjeta) {this.tarjeta = tarjeta;}
    public Pos getPos() {return pos;}
    public void setPos(Pos pos) {this.pos = pos;}
}
