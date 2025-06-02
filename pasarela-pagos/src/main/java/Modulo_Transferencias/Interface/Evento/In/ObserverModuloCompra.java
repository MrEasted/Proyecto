package main.java.Modulo_Transferencias.Interface.Evento.In;


import main.java.Modulo_Compras.Interface.Evento.Out.CompraNuevaCompra;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.logging.Logger;

@ApplicationScoped
public class ObserverModuloCompra {



    private static final Logger log = Logger.getLogger(String.valueOf(ObserverModuloComercio.class));

    public void accept(@Observes CompraNuevaCompra event) {

        log.info("ObserverModuloCompra event en Modulo transferencia: , idCompra: " + event.getIdCompra() + " Pos: " + event.getIdPos());


    }


}
