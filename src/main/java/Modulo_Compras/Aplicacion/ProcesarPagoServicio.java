package Modulo_Compras.Aplicacion;

import Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProcesarPagoServicio  implements IProcesarPagoServicio{

    @Inject
    private IRepositorioCompras repositorio;

    @Override
    public void ProcesarPago(double Monto, int tarjeta) {







    }

}
