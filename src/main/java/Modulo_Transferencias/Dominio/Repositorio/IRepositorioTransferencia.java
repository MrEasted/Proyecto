package Modulo_Transferencias.Dominio.Repositorio;

import Modulo_Transferencias.Dominio.Comercio;
import Modulo_Transferencias.Dominio.CuentaBancoComercio;
import Modulo_Transferencias.Dominio.Deposito;


public interface IRepositorioTransferencia {

    void guardar(Comercio comercio);
    boolean existe(int rut);
    Comercio obtener(int rut);
    void guardoTransferencia(Comercio comercio, Deposito dep, CuentaBancoComercio cuenta);
}
