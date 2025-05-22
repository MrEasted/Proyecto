package Modulo_Compras.Aplicacion;

import Modulo_Compras.Dominio.Comercio;
import Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import Modulo_Compras.Interface.Evento.In.ObserverModuloComercio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.logging.Logger;


@ApplicationScoped
public class AltaComercioServicio implements IAltaComercioServicio{

    @Inject
    private IRepositorioCompras repositorioCompras;

    private static final Logger log = Logger.getLogger(String.valueOf(ObserverModuloComercio.class));

    @Override
    public void AltaComercio(Comercio comercio) {

        log.info("Creando Comercio en Modulo Compra rut: " + comercio.getRut());

        repositorioCompras.guardar(comercio);


    }



}
