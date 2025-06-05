package Modulo_Compras.Infraestructura.Persistencia;

import Modulo_Compras.Dominio.Comercio;
import Modulo_Compras.Dominio.Compra;
import Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import Modulo_Compras.Dominio.Tarjeta;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless
public class RepositorioCompras implements IRepositorioCompras {

    //JPA
    @PersistenceContext(unitName = "tallerjava")
    EntityManager em;

    @Override
    public void guardar(Comercio comercio) {

        em.persist(comercio);

    }

    @Override
    public boolean existe(int rut) {

        return em.contains(em.find(Comercio.class, rut));

    }

    @Override
    public Comercio obtener(int rut) {

        return em.find(Comercio.class, rut);

    }

    //tarjetas y compras
    @Override
    public void guardarTarjeta(Tarjeta tarjeta){

        em.merge(tarjeta);

    }

    @Override
    public float montoVendidoactual(int rut) {

        Comercio comercio = this.obtenerSiExiste(rut);
        if (comercio != null) {

            List<Compra> compras = comercio.getCompras();
            LocalDate hoy = LocalDate.now();

            float total = (float) compras.stream()
                    .filter(compra -> compra.getFecha().equals(hoy))
                    .mapToDouble(Compra::getImporte)
                    .sum();

            return total;
        }

        return 0;

    }


    public float montoVendidoEntreFechas(int rut, LocalDate fechaInicio, LocalDate fechaFin) {

        Comercio comercio = this.obtenerSiExiste(rut);

        List<Compra> compras = comercio.getCompras();

        float total = (float) compras.stream()
                .filter(compra -> {
                    LocalDate fechaCompra = compra.getFecha();
                    return (fechaCompra.isEqual(fechaInicio) || fechaCompra.isAfter(fechaInicio)) &&
                            (fechaCompra.isEqual(fechaFin) || fechaCompra.isBefore(fechaFin));
                })
                .mapToDouble(Compra::getImporte)
                .sum();

        return total;

    }


    @Override
    public boolean existeConConsulta(int rut) {
        Long count = em.createQuery(
                        "SELECT COUNT(c) FROM Compra_Comercio c WHERE c.rut = :rut", Long.class)
                .setParameter("rut", rut)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public Comercio obtenerSiExiste(int rut) {
        try {
            return em.createQuery(
                            "SELECT c FROM Compra_Comercio c WHERE c.rut = :rut", Comercio.class)
                    .setParameter("rut", rut)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
