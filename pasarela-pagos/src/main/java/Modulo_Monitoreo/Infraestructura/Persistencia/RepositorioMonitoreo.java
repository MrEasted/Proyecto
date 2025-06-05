package Modulo_Monitoreo.Infraestructura.Persistencia;

import Modulo_Monitoreo.Dominio.Deposito;
import Modulo_Monitoreo.Dominio.Pago;
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

    @Override
    public void GuardarDeposito(Deposito deposito) {

        em.merge(deposito);

    }

    @Override
    public void GuardarPago(Pago pago) {

        em.merge(pago);

    }
}
