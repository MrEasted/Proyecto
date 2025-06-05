package Interface;

import Aplicacion.IMedioPago;
import Interface.DTOs.DatosCompraDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/Medio")
public class InterfaceMedioPago {


    @Inject
    private IMedioPago medioServicio;


    @POST
    @Path("/PagoARealizar")
    public boolean PagoARealizar(DatosCompraDTO compraDTO) {
        int tar = compraDTO.numeroTarjeta;
        int idCompra = compraDTO.idCompra;
        int rutComercio = compraDTO.idComercio;
        return medioServicio.PagoRealiza(tar, rutComercio, idCompra);
    }



    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Comercio API funcionando";
    }



}