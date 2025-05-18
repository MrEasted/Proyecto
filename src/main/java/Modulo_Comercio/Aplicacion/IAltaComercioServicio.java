package Modulo_Comercio.Aplicacion;

import Modulo_Comercio.Dominio.Compra;
import Modulo_Comercio.Dominio.CuentaBancoComercio;
import Modulo_Comercio.Dominio.Pos;

import java.util.List;

public interface  IAltaComercioServicio {

    void altaComercio(int rut, List<Compra> compras, CuentaBancoComercio cuenta, List<Pos> pos);

}
