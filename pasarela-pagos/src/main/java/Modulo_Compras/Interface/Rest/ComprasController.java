package Modulo_Compras.Interface.Rest;

import Modulo_Compras.Aplicacion.IMontoVendido;
import Modulo_Compras.Aplicacion.IProcesarPagoServicio;
import Modulo_Compras.Aplicacion.IVentasDiariasServicio;
import Modulo_Compras.Interface.DTO.DatosPagos;
import Modulo_Compras.Interface.DTO.DatosVD;
import Modulo_Transferencias.Interface.Evento.In.ObserverModuloComercio;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.logging.Logger;

@Path("/Compras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ComprasController {



    @Inject
    IMontoVendido montoActualVendidoServicio;

    @Inject
    private IProcesarPagoServicio servicioPagoServicio;

    @Inject
    private IVentasDiariasServicio ventasDiariasServicio;


    private static final Logger log = Logger.getLogger(String.valueOf(ObserverModuloComercio.class));

    @POST
    public Response ProcesarPago(DatosPagos request) {


        log.info("Entre a mi response PROCESAR PAGO y obtengo los datos: POS: " + request.getPos() + "/  MarcaT : " + request.getMarcaTarjeta() + "/ RutComercio : " + request.getRutComercio());

        try {
            servicioPagoServicio.ProcesarPago(request.getPos(),request.getMonto(),request.getNumeroTarjeta(),request.getMarcaTarjeta(),request.getDescripcionCompra(),request.getRutComercio(),request.getCantidad());

            return Response.ok().build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

//    {
//
//            "Pos":1,
//            "numeroTarjeta":1,
//            "marcaTarjeta": "VISA",
//            "monto": 300,
//            "descripcionCompra": "Carrito de juguete BMW 400 caballitos de fuerza, BrianBabon.S.A.",
//            "rutComercio": 2,
//            "cantidad": 20
//
//    }


    @POST
    @Path("/VentasDiarias")
    public Response VentasDiarias(DatosVD request) {

        log.info("Entre a mi response VentasDiarios y obtengo el rut: " + request.getRut());

        try {

            return Response.ok(ventasDiariasServicio.VentasDiarias(request.getRut())).build();

        } catch (RuntimeException e) {

            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }

    }
  
  
  //{
  //
  //  "rut":1
  //
  //}
  







//    {
//
//            "rut": 12345678
//
//    }

    @GET
    @Path("/montoActualVendido")
    @Produces(MediaType.TEXT_PLAIN)
    public float montoActualVendido(@QueryParam("rut") int rut) {
        return montoActualVendidoServicio.montoActualVendido(rut);
    }


//    {
//
//            "rut": 12345678
//            "fechaInicio": "2024-05-12"
//            "fechaFin": "2024-05-17"
//    }


    //DABA ERROR USAR LOCALDATE EN JAX
//    @GET
//    @Path("/montoVendidoEntreFechas")
//    @Produces(MediaType.TEXT_PLAIN)
//    public float montoVendidoEntreFechas(@QueryParam("rut") int rut, @QueryParam("fechaInicio") LocalDate fechaInicio,  @QueryParam("fechaFin") LocalDate fechaFin) {
//        return montoActualVendidoServicio.montoVendidoentreFechas(rut, fechaInicio, fechaFin);
//    }

    @GET
    @Path("/montoVendidoEntreFechas")
    @Produces(MediaType.TEXT_PLAIN)
    public float montoVendidoEntreFechas(
            @QueryParam("rut") int rut,
            @QueryParam("fechaInicio") String fechaInicioStr,
            @QueryParam("fechaFin") String fechaFinStr) {

        LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);
        LocalDate fechaFin = LocalDate.parse(fechaFinStr);
        return montoActualVendidoServicio.montoVendidoentreFechas(rut, fechaInicio, fechaFin);
    }



    //CHEQUEAR QUE LLEGA LA CONSULTA


    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Comercio API funcionando";
    }


}
