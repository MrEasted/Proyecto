package main.java.Modulo_Comercio.Aplicacion;

import main.java.Modulo_Comercio.Dominio.Pos;
import main.java.Modulo_Comercio.Dominio.Repositorio.IRepositorioPos;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ModificarEstadoPosServicio implements IModificarEstadoPosServicio{

    @Inject
    IRepositorioPos repositorio;

    @Override
    public void modificarEstadoPos(int rut) {
        if (!repositorio.existe(rut)) {
            throw new RuntimeException("El pos no existe");
        }else{
            Pos pos = repositorio.obtenerPosPorId(rut);
            boolean nuevoEstado = !pos.isActivo();
            pos.cambiarEstado(nuevoEstado);
            //TODO: cuando se agregue la base de datos modificar para que se actualice
        }
    }
}
