package Modulo_Monitoreo.Aplicacon;

import Modulo_Monitoreo.Dominio.Deposito;
import Modulo_Monitoreo.Dominio.Repositorio.IRepositorioMonitoreo;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;

@ApplicationScoped
public class AltaTransferenciaServicio implements IAltaTransferenciaServicio{

    @Inject
    IRepositorioMonitoreo repositorioMonitoreo;

    @Inject
    MeterRegistry meterRegistry;


    @Override
    public void AltaTransferencia(int rut, LocalDate fechaDeposito, float importe) {

        Deposito d = new Deposito();
        d.setImporte(importe);
        d.setFecha(fechaDeposito);

        //Ya sabemos que el rut existe porque realizar pago ya lo confirmo
        d.setRutComercio(rut);

        repositorioMonitoreo.GuardarDeposito(d);

        // Incrementar el contador de reportes de venta actual
        meterRegistry.counter("comercio.reportes.deposito_cuenta.realizada").increment();


    }




}
