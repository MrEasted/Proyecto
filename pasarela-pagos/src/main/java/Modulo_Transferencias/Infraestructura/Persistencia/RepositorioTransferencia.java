package Modulo_Transferencias.Infraestructura.Persistencia;

import Modulo_Transferencias.Dominio.Comercio;
import Modulo_Transferencias.Dominio.CuentaBancoComercio;
import Modulo_Transferencias.Dominio.Deposito;
import Modulo_Transferencias.Dominio.Repositorio.IRepositorioTransferencia;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class RepositorioTransferencia implements IRepositorioTransferencia {

    //JPA
    @PersistenceContext(unitName = "tallerjava")
    EntityManager em;

    @Override
    public void guardar(Comercio comercio) {
        em.merge(comercio);
    }


    @Override
    public boolean existe(int rut) {

        return em.find(Comercio.class, rut) != null;

    }

    @Override
    public Comercio obtener(int rut) {

        return em.find(Comercio.class, rut);

    }

    @Override
    public void guardoTransferencia(Comercio comercio, Deposito dep, CuentaBancoComercio cuenta) {

        //si tiene lista le añado deposito
        if (comercio.getCuenta().getDepositos() != null) {

            List<Deposito> depositos = comercio.getCuenta().getDepositos();
            depositos.add(dep);
            comercio.getCuenta().setDepositos(depositos);

        }else{ //sino tiene lista le creo una con el dep

            List<Deposito> depositos = new ArrayList<>();
            depositos.add(dep);
            comercio.getCuenta().setDepositos(depositos);

        }

        //ACTUALIZO ESE COMERCIO EN MI REPOSITORIO
        em.merge(comercio);

    }

}
