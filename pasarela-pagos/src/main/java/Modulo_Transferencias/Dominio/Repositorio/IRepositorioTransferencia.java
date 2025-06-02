package Modulo_Transferencias.Dominio.Repositorio;

import Modulo_Transferencias.Dominio.Comercio;

public interface IRepositorioTransferencia {

    void guardar(Comercio comercio);
    boolean existe(int rut);
    Comercio obtener(int rut);

}
