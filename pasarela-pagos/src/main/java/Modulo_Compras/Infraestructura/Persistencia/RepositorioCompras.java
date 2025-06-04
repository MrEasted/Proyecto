package Modulo_Compras.Infraestructura.Persistencia;

import Modulo_Compras.Dominio.Comercio;
import Modulo_Compras.Dominio.Compra;
import Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import Modulo_Compras.Dominio.Tarjeta;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
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

        Comercio comercio = em.find(Comercio.class, rut);

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

        Comercio comercio = em.find(Comercio.class, rut);

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
}
