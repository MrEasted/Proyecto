package Modulo_Comercio.Interface.Rest;

import Modulo_Comercio.Aplicacion.IAltaPosServicio;
import Modulo_Comercio.Interface.DTO.AltaPosRequest;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class PosController {
    @Inject
    private IAltaPosServicio servicioPos;

    @POST
    public Response altaPos(AltaPosRequest request) {
        try {
            servicioPos.altaPos(request.getId(), request.isActivo()); //Se da por hecho que se activa inicialmente
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/ping") //http://localhost:8080/Proyecto/api/pos/ping
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Pos API funcionando";
    }

}
