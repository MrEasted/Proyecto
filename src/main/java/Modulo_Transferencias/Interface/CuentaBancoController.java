package Modulo_Transferencias.Interface;


import Modulo_Comercio.Aplicacion.ObtenerDepositosEnRango;
import Modulo_Comercio.Interface.Rest.ComercioController;
import Modulo_Transferencias.Interface.DTO.ObtenerDepositosRequest;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDate;
import java.util.List;

@Path("/Depositos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class CuentaBancoController {

    @Inject
    ComercioController ctrl;

    @POST
    public Response ConsultarDepositosFecha(ObtenerDepositosRequest request) {

        try {
            return Response.ok(ctrl.ObtenerDepositosEnRango(request.rut, request.fechaInicio, request.fechaFin)).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

}
