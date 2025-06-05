package Modulo_Comercio.Aplicacion;
import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.Reclamo;
import Modulo_Comercio.Dominio.Repositorio.IRepositorioComercio;
import Modulo_Comercio.Interface.Evento.Out.PublicadorEventoComercio;
import Modulo_Monitoreo.Interface.ObserverModuloComercio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

@ApplicationScoped
public class RealizarReclamo implements IRealizarReclamo {


    @Inject
    IRepositorioComercio repositorio;


    @Inject
    PublicadorEventoComercio publicadorEventoComercio;

    private static final Logger log = Logger.getLogger(ObserverModuloComercio.class.getName());



    public void realizarReclamo(String reclamo, int comercio){
        if(repositorio.existeConConsulta(comercio)){
            Comercio co = repositorio.obtenerSiExiste(comercio);
            log.info("Reclamo comercio encontrado");
            Reclamo recla = new Reclamo();
            recla.setReclamo(reclamo);
            recla.setComercio(co);
            LocalDate fecha = LocalDate.now();
            recla.setFecha(fecha);

          log.info("ENCONTRE PREVIO AL REALIZARECLAMO");
                repositorio.realizarReclamo(co, recla);
                publicadorEventoComercio.publicarNuevoReclamo(co.getRut(),recla);

        }else{
            throw new RuntimeException("El comercio no existe");
        }
    }


}
