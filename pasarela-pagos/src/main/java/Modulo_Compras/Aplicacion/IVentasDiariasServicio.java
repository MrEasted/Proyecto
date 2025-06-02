package main.java.Modulo_Compras.Aplicacion;

import main.java.Modulo_Compras.Dominio.Compra;

import java.util.List;

public interface IVentasDiariasServicio {

    List<Compra> VentasDiarias(int rut);

}
