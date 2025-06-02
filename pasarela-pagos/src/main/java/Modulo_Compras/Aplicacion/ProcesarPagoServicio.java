package main.java.Modulo_Compras.Aplicacion;

import main.java.Modulo_Compras.Dominio.Comercio;
import main.java.Modulo_Compras.Dominio.Compra;
import main.java.Modulo_Compras.Dominio.Tarjeta;
import main.java.Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import main.java.Modulo_Compras.Interface.Evento.Out.PublicadorEventoCompra;
import main.java.Modulo_Transferencias.Interface.Evento.In.ObserverModuloComercio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class ProcesarPagoServicio  implements IProcesarPagoServicio{

    @Inject
    private IRepositorioCompras repositorio;

    @Inject
    PublicadorEventoCompra publicadorEvento;


    private static final Logger log = Logger.getLogger(String.valueOf(ObserverModuloComercio.class));

    @Override
    public void ProcesarPago(int Pos,double Monto, int tarjeta, String marcaTarjeta, String descripcionCompra,int rutComercio,int cantidad) {


        log.info("Procesar Pago");

        log.info("Pos = "+Pos);


        //existe comercio?
        if (repositorio.existe(rutComercio)) {

            log.info("existe un comercio -ProcesarPago");

            LocalDate fechaVencimientoT = LocalDate.of(2026, 5, 22);

            //fecha actual LOCALDATE PARA LA COMPRA
            LocalDate fechaVencimientoC = LocalDate.now();

            //Creo tarjeta y la guardo en mi repositorio
            log.info("Creando tarjeta... -ProcesarPago");
            Tarjeta t = new Tarjeta(tarjeta,fechaVencimientoT,marcaTarjeta);

            log.info(" Datos tarjeta: fechaV:  " + t.getFechaVencimiento() + " Marca: " + t.getMarca() + "  numeroTarjeta: " + t.getNumero());

            repositorio.guardarTarjeta(t);

            log.info("01 -ProcesarPago");

            //creo compra
            Compra compra = new Compra(Pos,descripcionCompra,fechaVencimientoC,Monto,t);

            // Guardar la compra en la lista del comercio
            Comercio comercio = repositorio.obtener(rutComercio);

            log.info("1 -ProcesarPago");

            //si ya tiene o no compras
            if (comercio.getCompras() == null) {

                List<Compra> compras = new ArrayList<>();

                compras.add(compra);
                comercio.setCompras(compras);
            }else{

                comercio.getCompras().add(compra);

            }


            log.info("2 -ProcesarPago");

            // Si es necesario, actualizar el comercio en el repositorio
            repositorio.guardar(comercio);

            log.info("2.5 -ProcesarPago");

            //Llamo publicador para publicar datos compra y rut del comercio.
            publicadorEvento.publicarNuevaCompra(compra,rutComercio,t);

            log.info("3 -ProcesarPago");

            //

        }else{

            log.info("No existe un comercio -ProcesarPago");

        }
    }
}
