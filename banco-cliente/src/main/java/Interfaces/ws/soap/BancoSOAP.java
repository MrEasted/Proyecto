package Interfaces.ws.soap;

import Aplicacion.BancoService;
import Dominio.Deposito;
import Dominio.Resultado;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.Inject;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style= SOAPBinding.Style.RPC)
public class BancoSOAP {

    //http://localhost:8080/BancoClienteMock/BancoSOAP?wsdl

    @Inject
    private BancoService bancoService;

    @WebMethod
    @WebResult(name = "resultado")
    public Resultado procesarTransferencia(@WebParam(name = "rut") String rut, @WebParam(name = "monto") double monto) {
        Resultado resultado = new Resultado();

        if (rut == null || rut.isBlank()) {
            resultado.setCodigo("ERR-001");
            resultado.setMensaje("RUT inválido");
            return resultado;
        }

        if (monto <= 0) {
            resultado.setCodigo("ERR-002");
            resultado.setMensaje("Monto debe ser mayor a cero");
            return resultado;
        }

        String referencia = bancoService.procesarTransferencia(rut, monto);
        resultado.setCodigo("OK-200");
        resultado.setMensaje("Transferencia procesada con éxito");
        resultado.setReferencia(referencia);
        return resultado;
    }


    @WebMethod
    @WebResult(name = "depositos")
    public List<Deposito> obtenerDepositos() {
        return bancoService.obtenerDepositos();
    }

}
