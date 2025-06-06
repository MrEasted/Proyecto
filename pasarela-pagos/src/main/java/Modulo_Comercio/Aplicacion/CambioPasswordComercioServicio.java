package Modulo_Comercio.Aplicacion;

import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.Repositorio.IRepositorioComercio;
import Modulo_Comercio.Seguridad.HASH;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CambioPasswordComercioServicio implements ICambioPasswordComercioServicio {

    @Inject
    IRepositorioComercio repositorio;

    //GASTON DE TOQUE LA FUNCION PARA GUARDAR CON HASH

    @Override
    public void cambiarPassword(int id, String passwordActual, String passwordNueva) {
        if(!repositorio.existe(id)){
            throw new RuntimeException("El comercio no existe");
        }

        Comercio comercio = repositorio.obtener(id);
        //DESCOMVIERTO DE HASH LA CONTRASEÑA DEL COMERCIO PARA COMPARAR

        String contrasenaActualSinHash = HASH.toHexString(comercio.getPassword().getBytes());

        if(!contrasenaActualSinHash.equals(passwordActual)){
            throw new RuntimeException("La contraseña es incorrecta");
        }

        ValidarPassword.validar(passwordNueva);

        String contrasenaNuevaConHash = HASH.convertToHas(passwordNueva);

        comercio.setPassword(contrasenaNuevaConHash);
        repositorio.actualizar(comercio);
    }
}
