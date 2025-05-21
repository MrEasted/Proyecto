package Modulo_Comercio.Aplicacion;

import java.util.Arrays;
import java.util.List;

public class ValidarPassword {
    private static final int MIN_LONGITUD = 8;
    private static final int MAX_LONGITUD = 16;
    private static final String COMPLEJIDAD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()-_+=]).{" + MIN_LONGITUD + "," + MAX_LONGITUD + "}$";

    public static void validar(String nuevaPassword) {
        if (nuevaPassword == null || nuevaPassword.isEmpty()) {
            throw new RuntimeException("La contraseña no puede estar vacía.");
        }

        if (nuevaPassword.length() < MIN_LONGITUD || nuevaPassword.length() > MAX_LONGITUD) {
            throw new RuntimeException("La contraseña debe tener entre " + MIN_LONGITUD + " y " + MAX_LONGITUD + " caracteres.");
        }

        if (!nuevaPassword.matches(COMPLEJIDAD)) {
            throw new RuntimeException("La contraseña debe contener al menos: una mayúscula, una minúscula, un número y un carácter especial.");
        }

        if (esPasswordComún(nuevaPassword)) {
            throw new RuntimeException("La contraseña es demasiado común y no es segura.");
        }
    }

    private static boolean esPasswordComún(String nuevaContraseña) {
        //TODO agregar nuevas posibles passwords tipicas
        List<String> PasswordComunes = Arrays.asList("12345678", "password1", "contraseña", "qwertyuiop");
        return PasswordComunes.contains(nuevaContraseña);
    }
}
