package Modulo_Comercio.Aplicacion;

import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.Repositorio.IRepositorioComercio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AltaComercioServicio implements IAltaComercioServicio {

    @Inject
    IRepositorioComercio repositorio;

    @Override
    public void crearComercio(Comercio comercio) {
        if (repositorio.existe(comercio.getRut())) {
            throw new RuntimeException("El comercio ya existe");
        }
        repositorio.guardar(comercio);
    }
}
