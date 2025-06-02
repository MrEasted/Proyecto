package main.java.Modulo_Compras.Interface.Evento.Out;

import main.java.Modulo_Compras.Dominio.Compra;
import main.java.Modulo_Compras.Dominio.Tarjeta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.enterprise.event.Event;

@ApplicationScoped
public class PublicadorEventoCompra {

    @Inject
    private Event<CompraNuevaCompra> compraNuevaCompra;

    public void publicarNuevaCompra(Compra compra, int rutComercio, Tarjeta tarjeta){

        CompraNuevaCompra evento = new CompraNuevaCompra(

                //datos compra
                compra.getIdPos(),
                compra.getDescripcion(),
                compra.getFecha(),
                compra.getImporte(),
                rutComercio,
                compra.getId(),

                //datos tarjeta
                tarjeta.getNumero(),
                tarjeta.getMarca(),
                tarjeta.getFechaVencimiento()

        );


        compraNuevaCompra.fire(evento);
    }

}
