package Modulo_Monitoreo.Aplicacon;

import Modulo_Monitoreo.Dominio.Comercio;
import Modulo_Monitoreo.Dominio.Reclamos;
import Modulo_Monitoreo.Dominio.Repositorio.IRepositorioMonitoreo;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.Queue;

import jakarta.jms.JMSContext;



@ApplicationScoped
public class RealizarReclamoNotificacion  implements IRealizarReclamoNotificacion {

    //MESAGGING
    @Resource(lookup = "java:jboss/exported/jms/queue/servicioReclamo" )
    private Queue queueRegistroReclamos;

    @Inject
    private JMSContext jmsContext;

    @Inject
    IRepositorioMonitoreo repositorioMonitoreo;

    @Inject
    MeterRegistry meterRegistry;

    public void realizarReclamoNotificacion(int  comercio, Reclamos reclamoreclamos) {

        repositorioMonitoreo.GuardarReclamo(comercio, reclamoreclamos);

        meterRegistry.counter("comercio.reclamos.realizados").increment();

        //ENVIA MENSAJE
        jmsContext.createProducer().send( queueRegistroReclamos , reclamoreclamos.getReclamo());



    }


}
