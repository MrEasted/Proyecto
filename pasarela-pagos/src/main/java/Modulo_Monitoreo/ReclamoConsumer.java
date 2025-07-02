package Modulo_Monitoreo;


import Modulo_Monitoreo.Dominio.Repositorio.IRepositorioMonitoreo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.inject.Inject;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "jakarta.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:jboss/exported/jms/queue/servicioReclamo")
        }
)
public class ReclamoConsumer implements MessageListener{

    @Inject
    IRepositorioMonitoreo repo;

    @Inject
    MeterRegistry JMeter;

    @Override
    public void onMessage(Message message) {

        try {
            if (message instanceof TextMessage textMessage) {
                String reclamoJson = textMessage.getText();

                // Extraer campos del JSON original (reclamo e id)
                ObjectMapper mapper = new ObjectMapper();
                JsonNode root = mapper.readTree(reclamoJson);
                String reclamoTexto = root.get("reclamo").asText();
                int idReclamo = root.get("id").asInt();

                // Armar prompt para la IA
                String promptJson = """
                {
                "model": "llama2",
                "prompt": "Cataloga el siguiente texto como 'positivo', 'negativo' o 'neutro' y respondeme solo la categoria correspondiente. Texto: %s",
                "stream": false
                }
                """.formatted(reclamoTexto);

                // Enviar petición a la IA
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:11435/api/generate"))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(promptJson))
                        .build();

                HttpClient client = HttpClient.newHttpClient();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Parsear respuesta de la IA
                JsonNode respuestaIA = mapper.readTree(response.body());
                String categoria = respuestaIA.get("response").asText();

                System.out.println("LO QUE DICE LA PUTA IA" + categoria);

                String cate = "desconocido";
                if (categoria.contains("Negativo")) {
                    cate = "negativo";
                } else if (categoria.contains("Positivo")) {
                    cate = "positivo";
                } else if (categoria.contains("Neutro")) {
                    cate = "neutro";
                }

                repo.ActualizoReclamo(idReclamo, cate);


                if(cate.equalsIgnoreCase("negativo")){
                    System.out.println("ENTRE AL IF");
                    JMeter.counter("comercio.reclamos.realizados.problematicos").increment();
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    }

