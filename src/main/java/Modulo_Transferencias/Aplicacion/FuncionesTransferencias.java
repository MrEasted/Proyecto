package Modulo_Transferencias.Aplicacion;

import Modulo_Comercio.Interface.Rest.ComercioController;
import Modulo_Transferencias.Dominio.Comercio;
import Modulo_Transferencias.Dominio.Deposito;
import Modulo_Transferencias.Dominio.Repositorio.IRepositorioTransferencia;
import Modulo_Transferencias.Interface.Evento.In.ObserverModuloComercio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class FuncionesTransferencias implements IFuncionesTransferencias {

    @Inject
    private IRepositorioTransferencia repositorio;

    private static final Logger log = Logger.getLogger(String.valueOf(ObserverModuloComercio.class));


    @Override
    public  List<Deposito> ObtenerDepositosRango(int rut, LocalDate fecha, LocalDate fecha1) {

        log.info("ObtenerDepositosRango rut: " + rut);


        //OBTENGO LOS COMERCIOS DE MODULO COMERCIO
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


    @Override
    public void AltaComercio(Comercio comercio) {


        repositorio.guardar(comercio);


    }



}
