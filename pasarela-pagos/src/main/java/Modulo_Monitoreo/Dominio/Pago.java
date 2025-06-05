package Modulo_Monitoreo.Dominio;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity(name = "Monitoreo_Pago")
@Table(name = "monitoreo_pago")
public class Pago {

    @EmbeddedId
    private PagoId id;

    private String notificacion;

    public Pago(PagoId id, String notificacion) {
        this.id = id;
        this.notificacion = notificacion;
    }

    public Pago() {
    }

    public PagoId getId() {
        return id;
    }

    public void setId(PagoId id) {
        this.id = id;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }
}
