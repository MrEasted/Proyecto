package Modulo_Compras.Dominio.Repositorio;

import Modulo_Compras.Dominio.Comercio;
import Modulo_Compras.Dominio.Tarjeta;

import java.time.LocalDate;

public interface IRepositorioCompras {

    void guardar(Comercio comercio);
    boolean existe(int rut);
    Comercio obtener(int rut);


    //Tarjetas
    void guardarTarjeta(Tarjeta tarjeta);

    //Ventas
    float   montoVendidoactual(int rut);
    float montoVendidoEntreFechas(int rut, LocalDate fecha, LocalDate fechafin);




}
