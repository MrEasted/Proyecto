package Modulo_Compras.Interface.Rest;


import Modulo_Compras.Aplicacion.IProcesarPagoServicio;
import Modulo_Compras.Dominio.Aplicacion.IMontoActualVendidoServicio;
import Modulo_Compras.Interface.DTO.DatosPagos;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Compras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ComprasController {



    @Inject
    IMontoActualVendidoServicio montoActualVendidoServicio;

    @Inject
    private IProcesarPagoServicio servicioPagoServicio;

    @POST
    public Response ProcesarPago(DatosPagos request) {


        try {
            servicioPagoServicio.ProcesarPago(request.getMonto(),request.getNumeroTarjeta());

            return Response.ok().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    public void ProcesarPago(int tarjeta,double monto){




    }





    @GET
    @Path("/montoActualVendido")
    @Produces(MediaType.TEXT_PLAIN)
    public float montoActualVendido(@QueryParam("rut") int rut) {
        return montoActualVendidoServicio.montoActualVendido(rut);
    }



    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Comercio API funcionando";
    }


}
