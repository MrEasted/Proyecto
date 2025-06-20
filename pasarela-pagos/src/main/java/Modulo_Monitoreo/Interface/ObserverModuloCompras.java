package Modulo_Monitoreo.Interface;


import Modulo_Compras.Interface.Evento.Out.PublicadorReporteVentas;
import Modulo_Compras.Interface.Evento.Out.ReporteVentas;
import Modulo_Monitoreo.Aplicacon.INuevaNotificacionCuantasVentas;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.time.LocalDate;

@ApplicationScoped
public class ObserverModuloCompras {


    @Inject
    INuevaNotificacionCuantasVentas notificacion;




    public void accept(@Observes ReporteVentas event){

       int rut= event.getRut();
         if(event.getFechaInicio() == null && event.getFechaFin() == null){
             notificacion.CuantasVentas(rut, null, null);
         }else{
             LocalDate fechaInicio = event.getFechaInicio();
             LocalDate fechaFin = event.getFechaFin();
             notificacion.CuantasVentas(rut, fechaInicio, fechaFin);
         }





    }

}
