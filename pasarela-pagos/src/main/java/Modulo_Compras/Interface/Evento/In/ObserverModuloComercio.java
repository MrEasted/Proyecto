package main.java.Modulo_Compras.Interface.Evento.In;


import main.java.Modulo_Compras.Aplicacion.IAltaComercioServicio;
import main.java.Modulo_Comercio.Interface.Evento.Out.ComercioNuevoComercio;
import main.java.Modulo_Compras.Dominio.Comercio;
import main.java.Modulo_Compras.Dominio.CuentaBancoComercio;
import main.java.Modulo_Compras.Dominio.Pos;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class ObserverModuloComercio {

    private static final Logger log = Logger.getLogger(String.valueOf(ObserverModuloComercio.class));

    @Inject
    IAltaComercioServicio altaComercioServicio;

    public void accept(@Observes ComercioNuevoComercio event) {

        log.info("Acepte evento de moudulo comercio en modulo compras");

        CuentaBancoComercio cuenta = new CuentaBancoComercio();

        cuenta.setNroCuenta(event.getNroCuentaBancoComercio());

        List<Pos> posList = event.getPosIds().stream()
                .map(Pos::new)
                .collect(Collectors.toList());

        //DATOS COMERCIO DEL DOMINIO TRANSFERENCIA
        Comercio comercio = new Comercio();
        comercio.setRut(event.getRut());
        comercio.setPos(posList);
        comercio.setCuentabanco(cuenta);


        altaComercioServicio.AltaComercio(comercio);


    }




}
