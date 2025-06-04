package Modulo_Monitoreo.Infraestructura.Persistencia;

import Modulo_Monitoreo.Dominio.Reclamos;
import Modulo_Monitoreo.Dominio.Repositorio.IRepositorioMonitoreo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class RepositorioMonitoreo implements IRepositorioMonitoreo {

    //JPA
    @PersistenceContext(unitName = "tallerjava")
    EntityManager em;

    @Override
    public void GuardarReclamo(Reclamos reclamo) {

        em.merge(reclamo);

    }




}
