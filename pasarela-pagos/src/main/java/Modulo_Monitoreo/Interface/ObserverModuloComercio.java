package Modulo_Monitoreo.Interface;


import Modulo_Comercio.Interface.Evento.Out.ReclamoNuevo;
import Modulo_Monitoreo.Aplicacon.IRealizarReclamoNotificacion;
import Modulo_Monitoreo.Dominio.Comercio;
import Modulo_Monitoreo.Dominio.Reclamos;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.logging.Logger;

@ApplicationScoped
public class ObserverModuloComercio {



    IRealizarReclamoNotificacion notificacion;

    private static final Logger log = Logger.getLogger(ObserverModuloComercio.class.getName());

    public void accept(@Observes ReclamoNuevo event) {
        log.info("Evento de nuevo reclamo recibido: " + event.toString());

        // Crear una instancia de Reclamos y asignar los datos del evento
        Reclamos reclamo = new Reclamos();
        reclamo.setReclamo(event.getReclamo());
        reclamo.setFecha(event.getFecha());

        // Crear una instancia de Comercio y asignar el RUT
        Comercio comercio = new Comercio();
        comercio.setRut(event.getRut());

        // Asociar el comercio al reclamo
        reclamo.setComercio(comercio);

        // Guardar el reclamo en el sistema de transferencias
        notificacion.realizarReclamoNotificacion(comercio, reclamo);

        log.info("Reclamo almacenado en el sistema de transferencias para el comercio: " + comercio.getRut());
    }

}
