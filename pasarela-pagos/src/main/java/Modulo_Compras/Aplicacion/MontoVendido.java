package Modulo_Compras.Aplicacion;

import Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import Modulo_Compras.Interface.Evento.Out.PublicadorReporteVentas;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;

@ApplicationScoped
public class MontoVendido implements IMontoVendido {




    @Inject
    IRepositorioCompras repositorioCompras;

    @Inject
    PublicadorReporteVentas notificacion;


    public float montoActualVendido(int rutcomercio) {
        if (repositorioCompras.existeConConsulta(rutcomercio)) {
            float res = repositorioCompras.montoVendidoactual(rutcomercio);

            if (res == 0) {
                throw new RuntimeException("No hay compras el dia de hoy");

            } else{
                notificacion.PublicarNuevoReporteVentas(rutcomercio,null,null);
                return res;
            }

        }
        throw new RuntimeException("El comercio no existe");
    }

    public float montoVendidoentreFechas(int rutcomercio, LocalDate fechaInicio, LocalDate fechaFin) {
       if(repositorioCompras.existeConConsulta(rutcomercio)) {
        float res = repositorioCompras.montoVendidoEntreFechas(rutcomercio, fechaInicio, fechaFin);
        if (res == 0){
            throw new RuntimeException("No hay compras en ese periodo");
        }else
            notificacion.PublicarNuevoReporteVentas(rutcomercio,fechaInicio,fechaFin);
           return res;
       }
        throw new RuntimeException("El comercio no existe");

    }

}



