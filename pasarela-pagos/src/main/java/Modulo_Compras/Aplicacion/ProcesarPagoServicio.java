package Modulo_Compras.Aplicacion;

import Modulo_Compras.Dominio.Comercio;
import Modulo_Compras.Dominio.Compra;
import Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import Modulo_Compras.Dominio.Tarjeta;
import Modulo_Compras.Interface.DTO.DatosCompraDTO;
import Modulo_Compras.Interface.Evento.Out.PublicadorEventoCompra;
import Modulo_Transferencias.Interface.Evento.In.ObserverModuloComercio;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

//@Slf4j
@ApplicationScoped
public class ProcesarPagoServicio  implements IProcesarPagoServicio {

    @Inject
    private IRepositorioCompras repositorio;

    @Inject
    PublicadorEventoCompra publicadorEvento;

    private static final Logger log = Logger.getLogger(String.valueOf(ObserverModuloComercio.class));

    @Transactional/*"Todo lo que pase dentro de este método se hace como una sola unidad de trabajo. Si algo falla, se revierte todo."*/
    @Override
    public void ProcesarPago(int Pos,double Monto, int tarjeta, String marcaTarjeta, String descripcionCompra,int rutComercio,int cantidad) {

        //existe comercio?
        if (repositorio.existeConConsulta(rutComercio)) {

            LocalDate fechaVencimientoT = LocalDate.of(2026, 5, 22);

            //fecha actual LOCALDATE PARA LA COMPRA
            LocalDate fechaVencimientoC = LocalDate.now();

            //Creo tarjeta y la guardo en mi repositorio
            Tarjeta t = new Tarjeta(tarjeta, fechaVencimientoT, marcaTarjeta);

            //GUARDAR TARJETA
            repositorio.guardarTarjeta(t);



            //creo compra
            Compra compra = new Compra(Monto,fechaVencimientoC, descripcionCompra,t , Pos);


          try {
              boolean bol = ValidoCompra(t, compra.getId(), rutComercio);
              if (bol) {
                  // Guardar la compra en la lista del comercio
                  Comercio comercio = repositorio.obtenerSiExiste(rutComercio);

                  //si ya tiene o no compras
                  if (comercio.getCompras() == null) {
                      List<Compra> compras = new ArrayList<>();

                      compras.add(compra);
                      comercio.setCompras(compras);
                  } else {
                      comercio.getCompras().add(compra);

                  }




                  // Si es necesario, actualizar el comercio en el repositorio
                  repositorio.guardar(comercio);


                  //Llamo publicador para publicar datos compra y rut del comercio.
                  publicadorEvento.publicarNuevaCompra(compra, rutComercio, t);


              }else {
                  log.info("COMPRA RECHAZADA");
              }

          }catch (Exception e) {
              e.printStackTrace();
          }

        }else {

            log.info("NO EXISTE EL COMERCIO");

        }
    }


    public boolean ValidoCompra(Tarjeta t, int CompraId, int RutComercio) throws IOException, InterruptedException {

        // Crear el DTO con los datos de la compra
        DatosCompraDTO dto = new DatosCompraDTO(t.getNumero(), CompraId, RutComercio);

        // Convertir el DTO a JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(dto);

        // Crear el cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Construir la solicitud HTTP
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/MedioPago/MedioPagoApi/Medio/PagoARealizar"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        // Enviar la solicitud y obtener la respuesta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Analizar la respuesta
        boolean compraExitosa = Boolean.parseBoolean(response.body());



        if (compraExitosa == true) {

            return true;

        } else {

            return false;
        }
    }

}
