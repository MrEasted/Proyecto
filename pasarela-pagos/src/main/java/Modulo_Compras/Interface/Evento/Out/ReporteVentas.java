package Modulo_Compras.Interface.Evento.Out;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReporteVentas {

    private int rut;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;


}
