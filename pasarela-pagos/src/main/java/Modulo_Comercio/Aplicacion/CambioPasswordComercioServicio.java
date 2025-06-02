package main.java.Modulo_Comercio.Aplicacion;

import main.java.Modulo_Comercio.Dominio.Comercio;
import main.java.Modulo_Comercio.Dominio.Repositorio.IRepositorioComercio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CambioPasswordComercioServicio implements ICambioPasswordComercioServicio {

    @Inject
    IRepositorioComercio repositorio;

    @Override
    public void cambiarPassword(int id, String passwordActual, String passwordNueva) {
        if(!repositorio.existe(id)){
            throw new RuntimeException("El comercio no existe");
        }

        Comercio comercio = repositorio.obtener(id);
        if(!comercio.getPassword().equals(passwordActual)){
            throw new RuntimeException("La contraseña es incorrecta");
        }
        ValidarPassword.validar(passwordNueva);
        comercio.setPassword(passwordNueva);
        repositorio.actualizar(comercio);
    }
}
