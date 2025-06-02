package main.java.Modulo_Comercio.Aplicacion;

import main.java.Modulo_Comercio.Dominio.Pos;
import main.java.Modulo_Comercio.Dominio.Repositorio.IRepositorioPos;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AltaPosServicio implements IAltaPosServicio {

    @Inject
    IRepositorioPos repositorio;

    @Override
    public void altaPos(int id, boolean activo) {
        if (repositorio.existe(id)) {
            throw new RuntimeException("El pos ya existe");
        }
        Pos pos = new Pos(id, activo);
        repositorio.guardar(pos);
    }
}
