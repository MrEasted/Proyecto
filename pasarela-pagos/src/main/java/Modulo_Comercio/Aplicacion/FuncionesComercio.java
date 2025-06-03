package Modulo_Comercio.Aplicacion;

import Modulo_Comercio.Dominio.Comercio;
import Modulo_Comercio.Dominio.Compra;
import Modulo_Comercio.Dominio.CuentaBancoComercio;
import Modulo_Comercio.Dominio.Pos;
import Modulo_Comercio.Dominio.Repositorio.IRepositorioComercio;
import Modulo_Comercio.Dominio.Repositorio.IRepositorioPos;
import Modulo_Comercio.Interface.Evento.Out.PublicadorEventoComercio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;



@ApplicationScoped
public class FuncionesComercio implements IFuncionesComercio {

    @Inject
    IRepositorioComercio repositorioComercio;

    @Inject
    IRepositorioPos repositorioPos;

    @Inject
    PublicadorEventoComercio publicadorEventoComercio;

    @Override
    public Comercio buscarComercio(int rut) {
        return repositorioComercio.obtener(rut);
    }

    @Override
    public void altaPos(int id, boolean activo) {
        if (repositorioPos.existe(id)) {
            throw new RuntimeException("El pos ya existe");
        }
        Pos pos = new Pos(id, activo);
        repositorioPos.guardar(pos);
    }

    @Override
    public void altaComercio(int rut, List<Compra> compras, CuentaBancoComercio cuenta, List<Pos> pos) {
        if (repositorioComercio.existe(rut)) {
            throw new RuntimeException("El comercio ya existe");
        }
        Comercio comercio = new Comercio(rut, compras, cuenta, pos);
        repositorioComercio.guardar(comercio);
        publicadorEventoComercio.publicarNuevoComercio(comercio);
    }





}
