package Modulo_Comercio.Dominio.Repositorio;
import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.CuentaBancoComercio;

public interface IRepositorioComercio {
  
    void guardar(Comercio comercio);
    boolean existe(int rut);

    Comercio obtener(int rut);
    void actualizar(Comercio comercio);

    void realizarReclamo(String reclamo, int comercio);
    Comercio obtener(int rut);
  
}
