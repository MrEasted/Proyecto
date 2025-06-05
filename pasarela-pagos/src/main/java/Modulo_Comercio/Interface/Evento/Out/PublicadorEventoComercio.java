package Modulo_Comercio.Interface.Evento.Out;


import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.Pos;
import Modulo_Comercio.Dominio.Reclamo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PublicadorEventoComercio {


    @Inject
    private Event<ComercioNuevoComercio> nuevoComercioEvent;

    public void publicarNuevoComercio(Comercio comercio){

        List<Integer> posList = comercio.getPos().stream()
                .map(Pos::getId)
                .collect(Collectors.toList());


        ComercioNuevoComercio evento = new ComercioNuevoComercio(
            comercio.getRut(),
                comercio.getCuenta().getNroCuenta(),
                posList



        );


        nuevoComercioEvent.fire(evento);
    }


    @Inject
    private Event<ReclamoNuevo> ReclamoEvent;

    public void publicarNuevoReclamo(int rutcomercio, Reclamo reclamo) {
        ReclamoNuevo evento = new ReclamoNuevo(
                reclamo.getReclamo(),
                reclamo.getComercio().getRut(),
                reclamo.getFecha(),
                rutcomercio
        );

        ReclamoEvent.fire(evento);
    }



}
