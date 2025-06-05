package Modulo_Monitoreo.Aplicacon;

import java.time.LocalDate;

public interface IAltaTransferenciaServicio {

    void AltaTransferencia(int rut, LocalDate fechaDeposito, float importe);

}
