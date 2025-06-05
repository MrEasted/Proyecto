package Modulo_Compras.Interface.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatosPagos {

    int pos;
    int numeroTarjeta;
    String marcaTarjeta;
    double monto; //importe de la compra
    String descripcionCompra;
    int rutComercio;
    int cantidad;

}
