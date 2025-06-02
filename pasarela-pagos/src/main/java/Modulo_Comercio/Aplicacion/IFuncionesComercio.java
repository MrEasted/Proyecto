package main.java.Modulo_Comercio.Aplicacion;

import main.java.Modulo_Comercio.Dominio.Comercio;
import main.java.Modulo_Comercio.Dominio.Compra;
import main.java.Modulo_Comercio.Dominio.CuentaBancoComercio;
import main.java.Modulo_Comercio.Dominio.Pos;

import java.util.List;

public interface IFuncionesComercio {

    Comercio buscarComercio(int rut);
    void altaPos(int rut, boolean activo);
    void altaComercio(int rut, List<Compra> compras, CuentaBancoComercio cuenta, List<Pos> pos);



}
