package Modulo_Comercio.Dominio.Repositorio;
import Modulo_Comercio.Dominio.Pos;

public interface IRepositorioPos {
    void guardar(Pos pos);
    boolean existe(int id);
}
