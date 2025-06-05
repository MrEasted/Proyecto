package Modulo_Comercio.Dominio.Repositorio;
import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.Reclamo;

public interface IRepositorioComercio {
  
    void guardar(Comercio comercio);
    boolean existe(int rut);

    Comercio obtener(int rut);
    void actualizar(Comercio comercio);

    void realizarReclamo(Comercio comercio, Reclamo relamo);

    Comercio obtenerSiExiste(int rut);
    boolean existeConConsulta(int rut);

}
