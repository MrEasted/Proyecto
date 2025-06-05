package Aplicacion.Impl;

import Aplicacion.BancoService;
import Dominio.Deposito;

import java.util.ArrayList;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;
import jakarta.annotation.PostConstruct;

@ApplicationScoped
public class BancoServiceImpl implements BancoService {

    List<Deposito> depositos;

    @PostConstruct
    private void inicializar() {
        System.out.println("Inicializando Depositos");
        this.depositos = new ArrayList<Deposito>();
    }

    @Override
    public String procesarTransferencia(String rut, double monto) {
        System.out.println("Transferencia recibida con el Rut: " + rut + " Monto: "+monto);

        // Generamos un código aleatorio de confirmación
        String referencia = UUID.randomUUID().toString();

        Deposito deposito = new Deposito(rut,monto , referencia);
        depositos.add(deposito);
        return deposito.getReferencia();
    }

    @Override
    public List<Deposito> obtenerDepositos() {
        System.out.println("Devolviendo Depositos");
        return this.depositos;
    }

}
