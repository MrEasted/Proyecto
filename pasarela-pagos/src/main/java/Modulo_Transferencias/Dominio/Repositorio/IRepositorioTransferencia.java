package main.java.Modulo_Transferencias.Dominio.Repositorio;

import main.java.Modulo_Transferencias.Dominio.Comercio;
import main.java.Modulo_Transferencias.Dominio.CuentaBancoComercio;
import main.java.Modulo_Transferencias.Dominio.Deposito;


public interface IRepositorioTransferencia {

    void guardar(Comercio comercio);
    boolean existe(int rut);
    Comercio obtener(int rut);
    void guardoTransferencia(Comercio comercio, Deposito dep, CuentaBancoComercio cuenta);
}
