package Modulo_Comercio.Infraestructura.Persistencia;

import Modulo_Comercio.Dominio.Pos;
import Modulo_Comercio.Dominio.Repositorio.IRepositorioPos;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class RepositorioPosMemoria implements IRepositorioPos {
    private final Map<Integer, Pos> listaPos = new HashMap<>();

    @Override
    public void guardar(Pos pos) {
        listaPos.put(pos.getId(), pos);
    }

    @Override
    public boolean existe(int id) {
        return listaPos.containsKey(id);
    }
}