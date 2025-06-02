package main.java.Modulo_Monitoreo.Interface;

import main.java.Modulo_Monitoreo.Interface.DTO.DatosPago;
import main.java.Modulo_Monitoreo.Interface.DTO.DatosTransferencias;
import main.java.Modulo_Transferencias.Interface.Evento.In.ObserverModuloComercio;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/Monitoreo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class MonitoreoController {

    private static final Logger log = Logger.getLogger(String.valueOf(ObserverModuloComercio.class));

    @POST
    @Path("/Transferencia")
    public Response NotificarDeposito(DatosTransferencias request) {

        try {

            log.info("Entre a mi response AltaDeposito y obtengo el rut comercio : " + request.getRutComercio());
            log.info("Fecha deposito : " + request.getRutComercio());
            log.info("Importe deposito : " + request.getImporte());

            return Response.ok().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

//    {
//
//             "rutComercio": 1,
//
//            "fechaDeposito": "2023-05-01",
//
//            "importe": 444
//
//    }




    @POST
    @Path("/Pago")
    public Response NotificarPago(DatosPago request) {

        try {

            log.info("Notificacion del Pago- : Rut: " + request.getIdComercio());
            log.info("Notificacion del Pago- : idCompra: " + request.getIdCompra());
            log.info("Notificacion del Pago- : Notificacion: " + request.getNotificacion());


            return Response.ok().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }

    }

//    {
//
//            "idComercio":1,
//            "idCompra":1,
//            "notificacion":"OK"
//
//    }

}
