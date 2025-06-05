package Aplicacion;

import Dominio.Deposito;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

import java.util.List;

@WebService
public interface BancoService {
    public String procesarTransferencia(String rut, double monto);
    public List<Deposito> obtenerDepositos();
}

