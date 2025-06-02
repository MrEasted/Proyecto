package main.java.Modulo_Transferencias.Aplicacion;

import main.java.Modulo_Transferencias.Dominio.Comercio;
import main.java.Modulo_Transferencias.Dominio.Deposito;

import java.time.LocalDate;
import java.util.List;

public interface IFuncionesTransferencias {

    List<Deposito> ObtenerDepositosRango(int rut, LocalDate fecha, LocalDate fecha1);

    void AltaComercio(Comercio Comercio);

    void CreoTransfererencia(int rut, int monto);

}
