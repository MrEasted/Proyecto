package Modulo_Monitoreo.Aplicacon;

import Modulo_Monitoreo.Dominio.Repositorio.IRepositorioMonitoreo;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;

@ApplicationScoped
public class NotificacionCuantasVentas implements INuevaNotificacionCuantasVentas {

    @Inject
    IRepositorioMonitoreo repositorioMonitoreo;

    @Inject
    MeterRegistry meterRegistry;



    public void CuantasVentas(int rut, LocalDate fechainicio, LocalDate fechafin) {

        if(fechainicio == null && fechafin == null ) {
            repositorioMonitoreo.GuardoReportedeldia(rut);
            // Incrementar el contador de reportes de venta actual
            meterRegistry.counter("comercio.reportes.venta_actual.solicitados").increment();
        }else{
            repositorioMonitoreo.GuardoReporteentreFechas(rut, fechainicio,fechafin);
            // Incrementar el contador de reportes entre fechas
            meterRegistry.counter("comercio.reportes.venta_periodo.solicitados").increment();
        }



    }



}
