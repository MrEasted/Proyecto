package Modulo_Monitoreo.Aplicacon;

import Modulo_Monitoreo.Dominio.Comercio;
import Modulo_Monitoreo.Dominio.Reclamos;
import Modulo_Monitoreo.Dominio.Repositorio.IRepositorioMonitoreo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RealizarReclamoNotificacion  implements IRealizarReclamoNotificacion {


    @Inject
    IRepositorioMonitoreo repositorioMonitoreo;

    public void realizarReclamoNotificacion(int  comercio, Reclamos reclamoreclamos) {

        repositorioMonitoreo.GuardarReclamo(comercio, reclamoreclamos);



    }


}
