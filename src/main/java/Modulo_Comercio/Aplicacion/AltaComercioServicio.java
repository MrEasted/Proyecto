package Modulo_Comercio.Aplicacion;

import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.Compra;
import Modulo_Comercio.Dominio.CuentaBancoComercio;
import Modulo_Comercio.Dominio.Pos;
import Modulo_Comercio.Dominio.Repositorio.IRepositorioComercio;
import Modulo_Comercio.Interface.Evento.Out.PublicadorEventoComercio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class AltaComercioServicio implements IAltaComercioServicio {

    @Inject
    IRepositorioComercio repositorio;

    @Inject
    PublicadorEventoComercio publicadorEventoComercio;

    @Override
    public void altaComercio(int rut, List<Compra> compras, CuentaBancoComercio cuenta, List<Pos> pos, String password) {
        if (repositorio.existe(rut)) {
            throw new RuntimeException("El comercio ya existe");
        }
        Comercio comercio = new Comercio(rut, compras, cuenta, pos, password);

        repositorio.guardar(comercio);
        publicadorEventoComercio.publicarNuevoComercio(comercio);

    }
}
