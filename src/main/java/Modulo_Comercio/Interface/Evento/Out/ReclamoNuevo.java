package Modulo_Comercio.Interface.Evento.Out;


import Modulo_Comercio.Dominio.Comercio;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ReclamoNuevo {
    private String reclamo;
    private int rut;
    private LocalDate fecha;


}
