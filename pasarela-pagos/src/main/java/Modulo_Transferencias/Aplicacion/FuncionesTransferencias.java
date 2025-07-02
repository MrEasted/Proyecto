package Modulo_Transferencias.Aplicacion;

import Modulo_Compras.Interface.Evento.In.ObserverModuloComercio;
import Modulo_Transferencias.Dominio.Comercio;
import Modulo_Transferencias.Dominio.CuentaBancoComercio;
import Modulo_Transferencias.Dominio.Deposito;
import Modulo_Transferencias.Dominio.Repositorio.IRepositorioTransferencia;
import Modulo_Transferencias.soap.Resultado;
import io.micrometer.core.instrument.MeterRegistry;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import Modulo_Transferencias.soap.BancoSOAP;
import Modulo_Transferencias.soap.BancoSOAPService;
import java.net.URL;

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
    public void CreoTransfererencia(int rut, int importe) {
        if (!repositorio.existe(rut)) {
            throw new RuntimeException("El comercio no existe");


        Comercio com = repositorio.obtener(rut);
        CuentaBancoComercio cuen = repositorio.cuentadebancocomercio(rut);

        if (cuen == null) {
            throw new RuntimeException("El comercio no tiene cuenta bancaria asociada");
        }

        LocalDate fecha = LocalDate.now();
        Deposito deposito = new Deposito(fecha, importe);
        System.out.println("LLEGUE PUTA");
        // bd
        repositorio.guardoTransferencia(com, deposito, cuen);
        System.out.println("LLEGUE PUTA2");
        // soap
        try {
            BancoSOAPService service = new BancoSOAPService();
            BancoSOAP soap = service.getBancoSOAPPort();
            Resultado resultado = soap.procesarTransferencia(String.valueOf(rut), importe);

            System.out.println("Transferencia confirmada por el banco. Resultado: " + resultado.getReferencia());
        } catch (Exception e) {
            System.err.println("Error al llamar al servicio SOAP del banco: " + e.getMessage());
            e.printStackTrace();
        }
    }




}
