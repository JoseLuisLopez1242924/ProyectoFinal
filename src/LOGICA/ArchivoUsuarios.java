package LOGICA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArchivoUsuarios {

    private final String ruta = "src/documentos/usuarios.txt";

    public boolean validarUsuario(String usuario, String clave) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String userArchivo = datos[0];
                String passArchivo = datos[1];

                if (usuario.equals(userArchivo) && clave.equals(passArchivo)) {
                    return true; // Usuario válido
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return false; // No encontrado
    }
}