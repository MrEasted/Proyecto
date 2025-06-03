package Aplicacion;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Random;

@ApplicationScoped
public class MedioPago implements IMedioPago{


    public boolean PagoRealiza(int numtarjeta,int rutComercio, int idCompra){

        Random rand = new Random();
        int randomNum = rand.nextInt(6);

        if(randomNum < 5){
            System.out.println("La compra fue Validada");
            return true;

        }
        return false;

    }

}
