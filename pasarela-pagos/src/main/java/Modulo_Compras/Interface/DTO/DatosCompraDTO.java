package Modulo_Compras.Interface.DTO;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DatosCompraDTO {

        public int numeroTarjeta;
        public int idCompra;
        public int idComercio;

        public DatosCompraDTO(int numeroTarjeta, int idCompra, int idComercio) {
            this.numeroTarjeta = numeroTarjeta;
            this.idCompra = idCompra;
            this.idComercio = idComercio;
        }
    }


