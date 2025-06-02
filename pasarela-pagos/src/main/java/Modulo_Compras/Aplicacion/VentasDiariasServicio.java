package main.java.Modulo_Compras.Aplicacion;


import main.java.Modulo_Compras.Dominio.Comercio;
import main.java.Modulo_Compras.Dominio.Compra;
import main.java.Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import main.java.Modulo_Transferencias.Interface.Evento.In.ObserverModuloComercio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class VentasDiariasServicio  implements IVentasDiariasServicio{


    private static final Logger log = Logger.getLogger(String.valueOf(ObserverModuloComercio.class));


    @Inject
    private IRepositorioCompras repositorio;

    @Override
    public List<Compra> VentasDiarias(int rut) {

        Comercio comercio = repositorio.obtener(rut);

        if (comercio == null) {

            log.info("No existe comercio -VentasDiarias");

            return null;

        }else{

            List<Compra> compras = new ArrayList<>(); //compras del dia
            List<Compra> comprasDelComercio = comercio.getCompras(); //compras del comercio a sortear que sean del dia

            if (comprasDelComercio != null) {

                for (Compra c : comprasDelComercio) {

                    if (c.getFecha().equals(LocalDate.now())){

                        compras.add(c);

                    }

                }

            }

            return compras;
        }
    }
}
