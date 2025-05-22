package Modulo_Transferencias.Interface.Evento.In;

import Modulo_Comercio.Interface.Evento.Out.ComercioNuevoComercio;
import Modulo_Transferencias.Aplicacion.IFuncionesTransferencias;
import Modulo_Transferencias.Dominio.Comercio;
import Modulo_Transferencias.Dominio.CuentaBancoComercio;
import Modulo_Transferencias.Dominio.Pos;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class ObserverModuloComercio {

    private static final Logger log = Logger.getLogger(String.valueOf(ObserverModuloComercio.class));


    @Inject
    private IFuncionesTransferencias ServicioTransferencias;


    public void accept(@Observes ComercioNuevoComercio event) {

        log.info("ACEPTE EVENTO DE MODULO COMERCIO DATOS: " + event.toString() + "//" + event.getPosIds() + "//" + event.getNroCuentaBancoComercio());

        // Convertir IDs simples a objetos del dominio de Transferencias
        CuentaBancoComercio cuenta = new CuentaBancoComercio();

        cuenta.setNroCuenta(event.getNroCuentaBancoComercio());

        List<Pos> posList = event.getPosIds().stream()
                .map(Pos::new)
                .collect(Collectors.toList());

        //DATOS COMERCIO DEL DOMINIO TRANSFERENCIA
        Comercio comercio = new Comercio();
        comercio.setRut(event.getRut());
        comercio.setPos(posList);
        comercio.setCuenta(cuenta);




        // Guardar en el repositorio de Transferencias
        ServicioTransferencias.AltaComercio(comercio);

        log.info("Comercio recibido del módulo Comercio y almacenado en Transferencias: " + comercio.getRut());
    }


}
