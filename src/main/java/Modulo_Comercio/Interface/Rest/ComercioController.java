package Modulo_Comercio.Interface.Rest;

import Modulo_Comercio.Aplicacion.IAltaComercioServicio;
import jakarta.inject.Inject;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/comercios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ComercioController {

    @Inject
    private IAltaComercioServicio servicio;

    @POST
    public Response altaComercio(Modulo_Comercio.Dominio.Comercio comercio) {
        try {
            servicio.crearComercio(comercio);
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

//    Llamar Post http://localhost:8080/Proyecto/api/comercios

//    {
//        "rut":"numRut",
//        "micompra":"micompra",
//        "cuentabanco":cuentabanco
//    }


    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Comercio API funcionando";
    }

    //    Llamar GET http://localhost:8080/Proyecto/api/comercios/ping

}
