package Modulo_Comercio.Infraestructura.Persistencia;

import Modulo_Comercio.Dominio.Pos;
import Modulo_Comercio.Dominio.Repositorio.IRepositorioPos;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@ApplicationScoped
public class RepositorioPosMemoria implements IRepositorioPos {


    @PersistenceContext(unitName = "tallerjava")
    EntityManager em;

    @Override
    public void guardar(Pos pos) {

        em.merge(pos);

    }

    @Override
    public boolean existe(int id) {

        return em.find(Pos.class, id) != null;

    }


    @Override
    public Pos obtenerPosPorId(int id) {

        return em.find(Pos.class, id);

    }

}