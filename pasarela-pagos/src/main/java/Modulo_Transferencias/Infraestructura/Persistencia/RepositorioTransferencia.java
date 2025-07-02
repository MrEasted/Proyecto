package Modulo_Transferencias.Infraestructura.Persistencia;

import Modulo_Transferencias.Dominio.Comercio;
import Modulo_Transferencias.Dominio.CuentaBancoComercio;
import Modulo_Transferencias.Dominio.Deposito;
import Modulo_Transferencias.Dominio.Repositorio.IRepositorioTransferencia;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

@Stateless
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
        Long longRut = Long.valueOf(rut);

        Long count = ((Number) em.createNativeQuery(
                        "SELECT COUNT(*) FROM transferencia_comercio WHERE rut = ?")
                .setParameter(1, longRut)
                .getSingleResult()).longValue();

        return count > 0;
    }



    @Override
    public Comercio obtener(int rut) {
        try {
            Long rutLong = Long.valueOf(rut); // conversión segura
            return (Comercio) em.createNativeQuery(
                            "SELECT * FROM transferencia_comercio WHERE rut = ?",
                            Comercio.class
                    )
                    .setParameter(1, rutLong) // pasar como Long
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void guardoTransferencia(Comercio comercio, Deposito dep, CuentaBancoComercio cuenta) {

        Comercio cum = this.obtener(comercio.getRut());


        //si tiene lista le añado deposito
        if (cum.getCuenta().getDepositos() != null) {

            List<Deposito> depositos = cum.getCuenta().getDepositos();
            depositos.add(dep);
            cum.getCuenta().setDepositos(depositos);

        }else{ //sino tiene lista le creo una con el dep

            List<Deposito> depositos = new ArrayList<>();
            depositos.add(dep);
            cum.getCuenta().setDepositos(depositos);

        }

        //ACTUALIZO ESE COMERCIO EN MI REPOSITORIO
        em.merge(cum);

    }


    @Override
    public CuentaBancoComercio cuentadebancocomercio(int rut){
        Comercio comercio = this.obtener(rut);
        if (comercio == null) {
            return null; // comercio no existe
        }
        return comercio.getCuenta(); // ya tenés la cuenta asociada
    }




}
