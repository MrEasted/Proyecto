package main.java.Modulo_Comercio.Aplicacion;
import main.java.Modulo_Comercio.Dominio.Repositorio.IRepositorioComercio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RealizarReclamo implements IRealizarReclamo {


    @Inject
    IRepositorioComercio repositorio;


    public void realizarReclamo(String reclamo, int comercio){
        if(repositorio.existe(comercio)){
                repositorio.realizarReclamo(reclamo, comercio);
        }else{
            throw new RuntimeException("El comercio no existe");
        }
    }


}
