package Modulo_Comercio.Aplicacion;

import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.Deposito;
import Modulo_Comercio.Dominio.Repositorio.IRepositorioComercio;
import Modulo_Comercio.Infraestructura.Persistencia.RepositorioComercioMemoria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ObtenerDepositosEnRango implements IObtenerDepositosEnRango {

    @Inject
    private IRepositorioComercio repositorio;

    @Override
    public  List<Deposito> ObtenerDepositosRango(int rut, LocalDate fecha, LocalDate fecha1) {




        Comercio comercio = repositorio.obtener(rut);


        List<Deposito> depositos = comercio.getCuenta().getDepositos();


        List<Deposito> depositosEnRango  = new ArrayList<>();

        for (Deposito d : depositos) {

            if (d.getFecha().isAfter(fecha) & d.getFecha().isBefore(fecha1)) {

                depositosEnRango.add(d);

            }

        }

        if (depositosEnRango == null) {
            System.out.println("Depositos no encontrados");
            return null;
        }else{
            System.out.println("Depositos encontrados");
            return depositosEnRango;
        }
    }
}
