package Interface;

import Aplicacion.IMedioPago;
import Interface.DTOs.DatosCompraDTO;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

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

}