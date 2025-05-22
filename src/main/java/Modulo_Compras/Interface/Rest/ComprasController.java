package Modulo_Compras.Interface.Rest;


import Modulo_Compras.Aplicacion.IProcesarPagoServicio;
import Modulo_Compras.Interface.DTO.DatosPagos;
import Modulo_Transferencias.Interface.Evento.In.ObserverModuloComercio;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.logging.Logger;

@Path("/Compras")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ComprasController {


    @Inject
    private IProcesarPagoServicio servicioPagoServicio;


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




}
