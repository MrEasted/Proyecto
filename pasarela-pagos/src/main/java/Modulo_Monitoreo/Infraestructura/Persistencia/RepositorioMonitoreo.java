package Modulo_Monitoreo.Infraestructura.Persistencia;

import Modulo_Monitoreo.Dominio.Comercio;
import Modulo_Monitoreo.Dominio.Reclamos;
import Modulo_Monitoreo.Dominio.Repositorio.IRepositorioMonitoreo;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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





}
