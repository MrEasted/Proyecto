package Modulo_Monitoreo;


import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
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

    @Override
    public void onMessage(Message message) {
//
//        try {
//            if (message instanceof TextMessage textMessage) {
//                String reclamo = textMessage.getText();
//
//                String promptJson = """
//                {
//                    "model": "llama2",
//                    "prompt": "Cataloga el siguiente texto como positivo, problematico, o neutro: %s",
//                    "stream": false
//                }
//                """.formatted(reclamo);
//
//                HttpRequest request = HttpRequest.newBuilder()
//                        .uri(URI.create("http://localhost:11434/api/generate"))
//                        .header("Content-Type", "application/json")
//                        .POST(HttpRequest.BodyPublishers.ofString(promptJson))
//                        .build();
//
//                HttpClient client = HttpClient.newHttpClient();
//                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//
//                System.out.println("[IA RESPONSE] " + response.body());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    }
}
