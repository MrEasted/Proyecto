package main.java.Modulo_Comercio.Dominio.Repositorio;
import main.java.Modulo_Comercio.Dominio.Pos;

public interface IRepositorioPos {
    void guardar(Pos pos);
    boolean existe(int id);
    Pos obtenerPosPorId(int id);
}
