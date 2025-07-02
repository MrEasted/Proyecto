package Modulo_Monitoreo.Infraestructura.Persistencia;

import Modulo_Comercio.Dominio.Reclamo;
import Modulo_Monitoreo.Dominio.*;
import Modulo_Monitoreo.Dominio.Repositorio.IRepositorioMonitoreo;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;

@Stateless
public class RepositorioMonitoreo implements IRepositorioMonitoreo {

    //JPA
    @PersistenceContext(unitName = "tallerjava")
    EntityManager em;

    @Override
    public void GuardarReclamo(int comercio, Reclamos reclamo) {
    reclamo.setRutcomercio(comercio);
        em.merge(reclamo);

    }

    @Override
    public void ActualizoReclamo(int id, String categoria){

        System.out.println("ACTUALIZADO");

        System.out.println("el id: "+ id);

        System.out.println("LA CATEGORIA: "+categoria);

        Reclamos r = em.find(Reclamos.class, Long.valueOf(id));

        r.setClificacion(categoria);

        em.merge(r);

    }


    @Override
    public void GuardarDeposito(Deposito deposito) {

        em.merge(deposito);

    }

    @Override
    public void GuardarPago(Pago pago) {

        em.merge(pago);

    }

    @Override
    public void GuardoReportedeldia(int rut){
        LocalDate fechahoy = LocalDate.now();
        Reportes re = new Reportes(null, fechahoy, rut);
        em.merge(re);

    }

    @Override
    public void GuardoReporteentreFechas(int rut, LocalDate fechainicio, LocalDate fechafin){
        Reportes re = new Reportes(fechainicio, fechafin, rut);
        em.merge(re);






    }



}
