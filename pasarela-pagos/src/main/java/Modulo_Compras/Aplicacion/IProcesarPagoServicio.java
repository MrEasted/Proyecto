package Modulo_Compras.Aplicacion;
public interface IProcesarPagoServicio {

    void ProcesarPago(int Pos,double Monto, int tarjeta,  String marcaTarjeta,String descripcionCompra,int rutComercio,int cantidad);

}
