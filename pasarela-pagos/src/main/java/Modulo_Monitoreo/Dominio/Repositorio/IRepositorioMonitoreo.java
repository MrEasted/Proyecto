package Modulo_Monitoreo.Dominio.Repositorio;

import Modulo_Monitoreo.Dominio.*;

public interface IRepositorioMonitoreo {


    public void GuardarReclamo(Reclamos reclamo);

    public void GuardarDeposito(Deposito deposito);

    public void GuardarPago(Pago pago);

}
