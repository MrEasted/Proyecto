package main.java.Modulo_Compras.Interface.Evento.Out;


import main.java.Modulo_Compras.Dominio.Tarjeta;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CompraNuevaCompra {


    private int idPos;
    private String descripcion;
    private LocalDate fecha;
    private double importe;
    private int id; //COMERCIO
    private int idCompra;

    //DATOS TARJETA SEPARADOS
    //private Tarjeta tarjeta;

    private int numeroTarjeta;
    private String marcaTarjeta;
    private LocalDate fechaVencimientoTarjeta;

}
