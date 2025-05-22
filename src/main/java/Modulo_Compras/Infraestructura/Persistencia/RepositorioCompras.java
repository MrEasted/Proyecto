package Modulo_Compras.Infraestructura.Persistencia;

import Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import Modulo_Compras.Dominio.Tarjeta;
import Modulo_Transferencias.Dominio.Comercio;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class RepositorioCompras implements IRepositorioCompras {


    private final Map<Integer, Tarjeta> comercios = new HashMap<>();


    @Override
    public float montoVendidoactual(int rut) {
        return 0;
    }
}
