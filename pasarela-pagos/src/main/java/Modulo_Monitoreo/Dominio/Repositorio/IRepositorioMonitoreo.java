package Modulo_Monitoreo.Dominio.Repositorio;

import Modulo_Monitoreo.Dominio.*;

import java.time.LocalDate;

public interface IRepositorioMonitoreo {


    public void GuardarDeposito(Deposito deposito);

    public void GuardarPago(Pago pago);

    public void GuardarReclamo(int  comercio, Reclamos reclamo);

    public void GuardoReportedeldia(int rut);
    public void GuardoReporteentreFechas(int rut, LocalDate fechainicio,LocalDate fechafin);


}
