package Modulo_Compras.Infraestructura.Persistencia;

import Modulo_Compras.Dominio.Comercio;
import Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import Modulo_Compras.Dominio.Tarjeta;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class RepositorioCompras implements IRepositorioCompras {


    private final Map<Integer, Comercio> comercios = new HashMap<>();

    private final Map<Integer, Tarjeta> tarjetas = new HashMap<>();

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

    //tarjetas y compras
    @Override
    public void guardarTarjeta(Tarjeta tarjeta){
        tarjetas.put(tarjeta.getNumero(), tarjeta);
    }



}
