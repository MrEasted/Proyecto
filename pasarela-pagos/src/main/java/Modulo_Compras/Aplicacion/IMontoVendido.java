package Modulo_Compras.Aplicacion;

import java.time.LocalDate;

public interface IMontoVendido {


    float montoActualVendido(int rutcomercio);
    float montoVendidoentreFechas(int rutcomercio, LocalDate fechaInicio, LocalDate fechaFin);

    }
