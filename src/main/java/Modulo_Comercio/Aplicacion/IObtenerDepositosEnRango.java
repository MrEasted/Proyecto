package Modulo_Comercio.Aplicacion;

import Modulo_Comercio.Dominio.Deposito;

import java.time.LocalDate;
import java.util.List;

public interface IObtenerDepositosEnRango {

    List<Deposito> ObtenerDepositosRango(int rut, LocalDate fecha, LocalDate fecha1);

}
