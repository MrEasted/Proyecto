package Modulo_Monitoreo.Aplicacon;


import Modulo_Monitoreo.Dominio.Pago;
import Modulo_Monitoreo.Dominio.PagoId;
import Modulo_Monitoreo.Dominio.Repositorio.IRepositorioMonitoreo;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AltaPagoServicio implements IAltaPagoServicio{

    @Inject
    IRepositorioMonitoreo repositorioMonitoreo;

    @Inject
    MeterRegistry meterRegistry;



    @Override
    public void AltaPago(int rut, int idCompra, String notificacion) {

        //creo la id compuesta del pago
        PagoId pagoid= new PagoId();

        pagoid.setRut(rut);
        pagoid.setIdCompra(idCompra);

        //creo el pago y le aplico su id con la notificacion
        Pago pago = new Pago();

        pago.setId(pagoid);
        pago.setNotificacion(notificacion);

        //lo guardo en el respositorio
        repositorioMonitoreo.GuardarPago(pago);

        // Incrementar el contador de reportes de venta actual
        meterRegistry.counter("comercio.reportes.Pagos_realizados.solicitado").increment();




    }
}
