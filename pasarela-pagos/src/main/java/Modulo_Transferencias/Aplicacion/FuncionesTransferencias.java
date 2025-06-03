package Modulo_Transferencias.Aplicacion;

import Modulo_Compras.Interface.Evento.In.ObserverModuloComercio;
import Modulo_Transferencias.Dominio.Comercio;
import Modulo_Transferencias.Dominio.CuentaBancoComercio;
import Modulo_Transferencias.Dominio.Deposito;
import Modulo_Transferencias.Dominio.Repositorio.IRepositorioTransferencia;
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




    @Override
    public void CreoTransfererencia(int rut, int importe){
        Comercio com = repositorio.obtener(rut);
        CuentaBancoComercio cuen = com.getCuenta();
        LocalDate fecha = LocalDate.now();
        Deposito deposito = new Deposito(fecha, importe);

        //Toma el rut del comercio y el importe a pagar y setea la fecha de la transferencia en el dia que se te este ejecutando la funcion

        if(repositorio.existe(rut)){
            if(cuen!=null){
                repositorio.guardoTransferencia(com, deposito, cuen);

            }

        }else{
            throw new RuntimeException("El comercio no existe");
        }

        //Aca Seguiria con la url de la otra api mandando la transferencia

    }



}
