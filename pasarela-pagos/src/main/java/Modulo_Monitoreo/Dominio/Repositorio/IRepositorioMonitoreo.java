package Modulo_Monitoreo.Dominio.Repositorio;

import Modulo_Monitoreo.Dominio.Comercio;
import Modulo_Monitoreo.Dominio.Reclamos;

public interface IRepositorioMonitoreo {


    public void GuardarReclamo(int  comercio, Reclamos reclamo);

}
