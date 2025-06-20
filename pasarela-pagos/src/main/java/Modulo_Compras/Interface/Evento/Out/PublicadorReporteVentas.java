package Modulo_Compras.Interface.Evento.Out;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

import java.time.LocalDate;

@ApplicationScoped
public class PublicadorReporteVentas {

    @Inject
    private Event<ReporteVentas> EventoReporteVentas;


    public void PublicarNuevoReporteVentas(int rut, LocalDate fechainicio, LocalDate fechafin) {


            ReporteVentas evento = new ReporteVentas(

                    rut,
                    fechainicio,
                    fechafin



            );

        EventoReporteVentas.fire(evento);


    }


}
