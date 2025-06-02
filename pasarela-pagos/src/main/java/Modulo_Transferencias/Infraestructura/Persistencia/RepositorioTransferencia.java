package Modulo_Transferencias.Infraestructura.Persistencia;

import Modulo_Transferencias.Dominio.Comercio;
import Modulo_Transferencias.Dominio.Repositorio.IRepositorioTransferencia;
import Modulo_Transferencias.Interface.Evento.In.ObserverModuloComercio;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@ApplicationScoped
public class RepositorioTransferencia implements IRepositorioTransferencia {


    private static final Logger log = Logger.getLogger(String.valueOf(ObserverModuloComercio.class));

    private final Map<Integer, Comercio> comercios = new HashMap<>();

    @Override
    public void guardar(Comercio comercio) {
        log.info("Guardando comercio: " + comercio.getRut());
        comercios.put(comercio.getRut(), comercio);
        log.info("Total comercios guardados: " + comercios.size());
    }


    @Override
    public boolean existe(int rut) {
        return comercios.containsKey(rut);
    }

    @Override
    public Comercio obtener(int rut) {
        Comercio c = comercios.get(rut);
        log.info("Buscando comercio con rut: " + rut + " - Encontrado: " + (c != null));
        return c;
    }

}
