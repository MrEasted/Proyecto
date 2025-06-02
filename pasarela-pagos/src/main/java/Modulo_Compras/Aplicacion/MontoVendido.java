package main.java.Modulo_Compras.Aplicacion;

import main.java.Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;

@ApplicationScoped
public class MontoVendido implements IMontoVendido {


    @Inject
    IRepositorioCompras repositorioCompras;

    public float montoActualVendido(int rutcomercio) {
        if (repositorioCompras.existe(rutcomercio)) {
            float res = repositorioCompras.montoVendidoactual(rutcomercio);

            if (res == 0) {
                throw new RuntimeException("No hay compras el dia de hoy");
            } else{
                return res;
            }

        }
        throw new RuntimeException("El comercio no existe");
    }

    public float montoVendidoentreFechas(int rutcomercio, LocalDate fechaInicio, LocalDate fechaFin) {
       if(repositorioCompras.existe(rutcomercio)) {
        float res = repositorioCompras.montoVendidoEntreFechas(rutcomercio, fechaInicio, fechaFin);
        if (res == 0){
            throw new RuntimeException("No hay compras en ese periodo");
        }else
            return res;
       }
        throw new RuntimeException("El comercio no existe");

    }

}



