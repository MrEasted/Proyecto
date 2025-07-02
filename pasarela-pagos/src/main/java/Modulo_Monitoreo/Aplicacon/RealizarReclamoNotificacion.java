package Modulo_Monitoreo.Aplicacon;

import Modulo_Monitoreo.Dominio.Comercio;
import Modulo_Monitoreo.Dominio.Reclamos;
import Modulo_Monitoreo.Dominio.Repositorio.IRepositorioMonitoreo;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.jms.Queue;

import jakarta.jms.JMSContext;
import jakarta.jms.TextMessage;

import java.util.HashMap;
import java.util.Map;


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

        try {
            // Convertir el objeto a JSON
            ObjectMapper objectMapper = new ObjectMapper();

            // Si solo querés pasar getReclamo() y getId(), podés crear un Map o usar un DTO
            Map<String, Object> mensajeMap = new HashMap<>();
            mensajeMap.put("id", reclamoreclamos.getId());
            mensajeMap.put("reclamo", reclamoreclamos.getReclamo());

            String jsonMensaje = objectMapper.writeValueAsString(mensajeMap);

            // Crear mensaje JMS tipo TextMessage con JSON
            TextMessage mensaje = jmsContext.createTextMessage(jsonMensaje);

            // Enviar
            jmsContext.createProducer().send(queueRegistroReclamos, mensaje);

        } catch (Exception e) {
            e.printStackTrace(); // o loguearlo
        }

    }


}
