package Modulo_Compras.Interface.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class DatosVD {

    int rut;
    LocalDate FechaInicio;
    LocalDate FechaFin;

}
