package Modulo_Compras.Aplicacion;

import Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;

@ApplicationScoped
public class MontoVendido implements IMontoVendido {



    @Inject
    MeterRegistry meterRegistry;

    @Inject
    IRepositorioCompras repositorioCompras;

    public float montoActualVendido(int rutcomercio) {
        if (repositorioCompras.existeConConsulta(rutcomercio)) {
            float res = repositorioCompras.montoVendidoactual(rutcomercio);

            if (res == 0) {
                throw new RuntimeException("No hay compras el dia de hoy");
            } else{
                // Incrementar el contador de reportes de venta actual
                meterRegistry.counter("comercio.reportes.venta_actual.solicitados").increment();

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
            // Incrementar el contador de reportes entre fechas
            meterRegistry.counter("comercio.reportes.venta_periodo.solicitados").increment();
           return res;
       }
        throw new RuntimeException("El comercio no existe");

    }

}



