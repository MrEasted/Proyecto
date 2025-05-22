package Modulo_Comercio.Interface.Rest;

import Modulo_Comercio.Aplicacion.IFuncionesComercio;
import Modulo_Comercio.Interface.DTO.AltaComercioRequest;
import jakarta.inject.Inject;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/comercios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ComercioController {

    @Inject
    private IFuncionesComercio servicioComercio;




//    public void cargarDatos() {
//        // Crear algunas instancias de los objetos
//
//        // Crear objetos Pos
//        Pos pos1 = new Pos(1,true);
//        Pos pos2 = new Pos(2,true);
//
//        // Crear objetos Tarjeta
//        Tarjeta tarjeta1 = new Tarjeta(123456789, "VISA", LocalDate.of(2026, 12, 31));
//        Tarjeta tarjeta2 = new Tarjeta(987654321, "MasterCard", LocalDate.of(2027, 1, 1));
//
//        // Crear algunas compras
//        Compra compra1 = new Compra(1, (int) 1500.50f, LocalDate.of(2025, 5, 15), "Compra de prueba", tarjeta1, pos1);
//        Compra compra2 = new Compra(2, (int) 2500.75f, LocalDate.of(2025, 5, 16), "Compra de tecnología", tarjeta2, pos2);
//
//        // Crear objetos Deposito
//        Deposito deposito1 = new Deposito(LocalDate.of(2025, 5, 16), 1000.00f, compra1);
//        Deposito deposito2 = new Deposito(LocalDate.of(2025, 5, 17), 2000.00f, compra2);
//
//        // Crear cuenta bancaria
//        CuentaBancoComercio cuentaBanco = new CuentaBancoComercio(987654321, List.of(deposito1, deposito2));
//
//        // Crear objeto Comercio
//        Comercio comercio = new Comercio(12345678, List.of(compra1, compra2), cuentaBanco, List.of(pos1, pos2));
//
//        // Simulando la alta de comercio
//        servicioComercio.altaComercio(comercio.getRut(), comercio.getCompras(), comercio.getCuenta(), comercio.getPos());
//    }

    @POST
    //ComercioRequest es el JSON que nos llega
    public Response altaComercio(AltaComercioRequest request) {
        try {
            servicioComercio.altaComercio(request.getRut(), request.getCompras(), request.getCuenta(), request.getPos());
            return Response.status(Response.Status.CREATED).build();
        } catch (RuntimeException e) {
            return Response.status(Response.Status.CONFLICT).entity(e.getMessage()).build();
        }
    }

    /*
    Llamar Post http://localhost:8080/Proyecto/api/comercios
         {
          "rut": 12345678,
          "compras": [
            {
              "id": 1,
              "importe": 2500.50,
              "fecha": "2025-05-17",
              "descripcion": "Compra de prueba",
              "tarjeta": {
                "numero": 123456789,
                "marca": "VISA",
                "vencimiento": "2026-12-31"
              },
              "pos": {
                "id": 1
              }
            }
          ],
          "cuenta": {
            "nroCuenta": 987654321,
            "depositos": [
              {
                "fecha": "2025-05-17",
                "importe": 5000.00,
                "compra": {
                  "id": 2,
                  "importe": 1500.00,
                  "fecha": "2025-05-16",
                  "descripcion": "Depósito relacionado",
                  "tarjeta": {
                    "numero": 987654321,
                    "marca": "MasterCard",
                    "vencimiento": "2027-01-01"
                  },
                  "pos": {
                    "id": 2
                  }
                }
              }
            ]
          },
          "pos": [
            {
              "id": 1
            },
            {
              "id": 2
            }
          ]
        }
    */

    @GET
    @Path("/ping")
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "Comercio API funcionando";
    }

    //Llamar GET http://localhost:8080/Proyecto/api/comercios/ping






}
