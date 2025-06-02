package Modulo_Compras.Infraestructura.Persistencia;

import Modulo_Compras.Dominio.Comercio;
import Modulo_Compras.Dominio.Compra;
import Modulo_Compras.Dominio.Repositorio.IRepositorioCompras;
import Modulo_Compras.Dominio.Tarjeta;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class RepositorioCompras implements IRepositorioCompras {


    private final Map<Integer, Comercio> comercios = new HashMap<>();

    private final Map<Integer, Tarjeta> tarjetas = new HashMap<>();

    @Override
    public void guardar(Comercio comercio) {
        comercios.put(comercio.getRut(), comercio);
    }

    @Override
    public boolean existe(int rut) {
        return comercios.containsKey(rut);
    }

    @Override
    public Comercio obtener(int rut) {
        return comercios.get(rut);
    }

    //tarjetas y compras
    @Override
    public void guardarTarjeta(Tarjeta tarjeta){
        tarjetas.put(tarjeta.getNumero(), tarjeta);
    }

    @Override
    public float montoVendidoactual(int rut) {

        Comercio comercio = comercios.get(rut);
        List<Compra> compras = comercio.getCompras();
        LocalDate hoy = LocalDate.now();

        float total = (float) compras.stream()
                .filter(compra -> compra.getFecha().equals(hoy))
                .mapToDouble(Compra::getImporte)
                .sum();

        return total;
    }


    public float montoVendidoEntreFechas(int rut, LocalDate fechaInicio, LocalDate fechaFin) {
        Comercio comercio = comercios.get(rut);

        List<Compra> compras = comercio.getCompras();

        float total = (float) compras.stream()
                .filter(compra -> {
                    LocalDate fechaCompra = compra.getFecha();
                    return (fechaCompra.isEqual(fechaInicio) || fechaCompra.isAfter(fechaInicio)) &&
                            (fechaCompra.isEqual(fechaFin) || fechaCompra.isBefore(fechaFin));
                })
                .mapToDouble(Compra::getImporte)
                .sum();


        return total;
    }
}
