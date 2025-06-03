package Modulo_Comercio.Infraestructura.Persistencia;

import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.Reclamo;
import Modulo_Comercio.Dominio.Repositorio.IRepositorioComercio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class RepositorioComercioMemoria implements IRepositorioComercio {

    @PersistenceContext(unitName = "tallerjava")
    EntityManager em;

    private final Map<Integer, Comercio> comercios = new HashMap<>();


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
        return comercios.containsKey(rut);
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
    public void realizarReclamo(String reclamo, int comercio) {
        Comercio co = em.find(Comercio.class, comercio);
        Reclamo recla = new Reclamo();
        recla.setReclamo(reclamo);
        recla.setComercio(co);
        LocalDate fecha = LocalDate.now();
        recla.setFecha(fecha);


        if (co.getReclamos() == null) {
            co.setReclamos(new ArrayList<>());
        }
        co.getReclamos().add(recla);
        em.merge(co);
    }





}
