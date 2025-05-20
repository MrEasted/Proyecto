package Modulo_Comercio.Infraestructura.Persistencia;

import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.CuentaBancoComercio;
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
        return comercios.get(rut);
    }
}
