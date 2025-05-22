package Modulo_Compras.Dominio.Repositorio;

import Modulo_Compras.Dominio.Comercio;
import Modulo_Compras.Dominio.Tarjeta;

public interface IRepositorioCompras {

    void guardar(Comercio comercio);
    boolean existe(int rut);
    Comercio obtener(int rut);


    //Tarjetas
    void guardarTarjeta(Tarjeta tarjeta);


}
