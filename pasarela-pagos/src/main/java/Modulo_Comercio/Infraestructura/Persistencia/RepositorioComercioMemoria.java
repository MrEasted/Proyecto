package Modulo_Comercio.Infraestructura.Persistencia;

import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.Reclamo;
import Modulo_Comercio.Dominio.Repositorio.IRepositorioComercio;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Stateless
public class RepositorioComercioMemoria implements IRepositorioComercio {

    //JPA
    @PersistenceContext(unitName = "tallerjava")
    EntityManager em;

    @Override
    public void guardar(Comercio comercio) {
        em.merge(comercio);
    }

    @Override
    public Comercio obtener(int rut) {
        Comercio comercio = em.find(Comercio.class, rut);
        if (comercio != null) { return comercio; }
        else throw new RuntimeException("No existe un comercio con el rut: " + rut);
    }

    @Override
    public boolean existe(int rut) {
        return em.find(Comercio.class, rut) != null;
    }

    @Override
    public boolean existeConConsulta(int rut) {
        Long count = em.createQuery(
                        "SELECT COUNT(c) FROM Comercio_Comercio c WHERE c.rut = :rut", Long.class)
                .setParameter("rut", rut)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public Comercio obtenerSiExiste(int rut) {
        try {
            return em.createQuery(
                            "SELECT c FROM Comercio_Comercio c WHERE c.rut = :rut", Comercio.class)
                    .setParameter("rut", rut)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public void actualizar(Comercio comercio) {
        //TODO Actualizar la funcion cuando se agregue la BD
        Comercio co = em.find(Comercio.class, comercio.getRut());
        if (co == null) {
            throw new RuntimeException("El comercio no existe");
        }
        em.merge(comercio);
    }


    @Override
    public void realizarReclamo(Comercio comercio, Reclamo reclamo) {
        Comercio co = this.obtenerSiExiste(comercio.getRut());

        if (co.getReclamos() == null) {
            co.setReclamos(new ArrayList<>());
        }
        co.getReclamos().add(reclamo);
        em.merge(co);
    }



}
