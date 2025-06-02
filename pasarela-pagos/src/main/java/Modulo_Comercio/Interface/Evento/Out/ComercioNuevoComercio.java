package Modulo_Comercio.Interface.Evento.Out;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class ComercioNuevoComercio {

    private int rut;
    private int nroCuentaBancoComercio;
    private List<Integer> posIds;



}
