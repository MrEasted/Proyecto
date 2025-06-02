package main.java.Modulo_Transferencias.Interface.Rest;


import main.java.Modulo_Transferencias.Aplicacion.IFuncionesTransferencias;
import main.java.Modulo_Transferencias.Interface.DTO.ObtenerDepositosRequest;
import main.java.Modulo_Transferencias.Interface.DTO.RealizarRepositoRequest;
import main.java.Modulo_Transferencias.Interface.Evento.In.ObserverModuloComercio;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.logging.Logger;


@Path("/Depositos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class TransferenciasController {

    @Inject
    private IFuncionesTransferencias servicioCuentaBanco;


    private static final Logger log = Logger.getLogger(String.valueOf(ObserverModuloComercio.class));

    @POST
    public Response ConsultarDepositosFecha(ObtenerDepositosRequest request) {

        log.info("Entre a mi response ConsultarDepositosFecha y obtengo el rut: " + request.getRut());

        try {
            return Response.ok(servicioCuentaBanco.ObtenerDepositosRango(request.rut, request.fechaInicio, request.fechaFin)).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    //Datos transferencias en rango

//    {
//        "rut": 2,
//            "fechaInicio": "2024-05-01",
//            "fechaFin": "2026-05-20"
//    }


    @POST
    @Path("/NuevaTransferencia")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response RealizarDeposito(RealizarRepositoRequest request) {


        try {

            servicioCuentaBanco.CreoTransfererencia(request.getRut(), request.getMonto());

             return Response.ok("Transferencia realizada exitosamente").build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Error: " + e.getMessage())
                    .build();
        }

    }


    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Comercio API funcionando";
    }


}
