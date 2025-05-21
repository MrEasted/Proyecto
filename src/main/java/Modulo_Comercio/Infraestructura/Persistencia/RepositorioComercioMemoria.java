package Modulo_Comercio.Infraestructura.Persistencia;

import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.Repositorio.IRepositorioComercio;
import jakarta.enterprise.context.ApplicationScoped;


import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class RepositorioComercioMemoria implements IRepositorioComercio {

    private final Map<Integer, Comercio> comercios = new HashMap<>();

    @Override
    public void guardar(Comercio comercio) {
        comercios.put(comercio.getRut(), comercio);
    }

    @Override
    public boolean existe(int rut) {
        return comercios.containsKey(rut);
    }

    @Override
    public Comercio obtener(int rut) {
        Comercio comercio = comercios.get(rut);
        if (comercio != null) { return comercio; }
        else throw new RuntimeException("No existe un comercio con el rut: " + rut);
    }

    @Override
    public void actualizar(Comercio comercio) {
        //TODO Actualizar la funcion cuando se agregue la BD
        if (!existe(comercio.getRut())) {
            throw new RuntimeException("El comercio no existe");
        }
        comercios.put(comercio.getRut(), comercio);
    }


}
