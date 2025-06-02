package main.java.Modulo_Comercio.Interface.Rest;

import main.java.Modulo_Comercio.Aplicacion.IAltaPosServicio;
import main.java.Modulo_Comercio.Aplicacion.IModificarEstadoPosServicio;
import main.java.Modulo_Comercio.Interface.DTO.AltaPosRequest;
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
    private IAltaPosServicio altaPosServicio;
    @Inject
    private IModificarEstadoPosServicio modificarEstadoPosServicio;

    @POST
    public Response altaPos(AltaPosRequest request) {
        try {
            altaPosServicio.altaPos(request.getId(), request.isActivo()); //Se da por hecho que se activa inicialmente
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}/estado") //http://localhost:8080/Proyecto/api/pos/1/estado
    public Response cambiarEstadoPos(@PathParam("id") int id) {
        try {
            modificarEstadoPosServicio.modificarEstadoPos(id);
            return Response.ok().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/ping") //http://localhost:8080/Proyecto/api/pos/ping
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Pos API funcionando";
    }

}
