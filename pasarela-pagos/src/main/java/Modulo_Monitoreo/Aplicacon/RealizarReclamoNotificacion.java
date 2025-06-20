package Modulo_Monitoreo.Aplicacon;

import Modulo_Monitoreo.Dominio.Comercio;
import Modulo_Monitoreo.Dominio.Reclamos;
import Modulo_Monitoreo.Dominio.Repositorio.IRepositorioMonitoreo;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RealizarReclamoNotificacion  implements IRealizarReclamoNotificacion {


    @Inject
    IRepositorioMonitoreo repositorioMonitoreo;

    @Inject
    MeterRegistry meterRegistry;

    public void realizarReclamoNotificacion(int  comercio, Reclamos reclamoreclamos) {

        repositorioMonitoreo.GuardarReclamo(comercio, reclamoreclamos);

        meterRegistry.counter("comercio.reclamos.realizados").increment();



    }


}
