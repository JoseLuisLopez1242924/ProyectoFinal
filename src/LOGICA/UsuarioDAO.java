package LOGICA;

import java.io.*;
import java.util.*;

public class UsuarioDAO {

    private final String archivo = "usuarios.txt";

    // GUARDAR
    public void guardar(Usuario u) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));
        bw.write(u.toString());
        bw.newLine();
        bw.close();
    }

    // LISTAR
    public List<Usuario> listar() throws IOException {
        List<Usuario> lista = new ArrayList<>();
        File file = new File(archivo);

        if (!file.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] d = linea.split(",");

            Usuario u = new Usuario(
                    Integer.parseInt(d[0]),
                    d[1],
                    d[2],
                    d[3],
                    d[4],
                    Integer.parseInt(d[5])
            );
            lista.add(u);
        }
        br.close();
        return lista;
    }

    // ELIMINAR
    public void eliminar(int id) throws IOException {
        List<Usuario> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        for (Usuario u : lista) {
            if (u.id != id) {
                bw.write(u.toString());
                bw.newLine();
            }
        }
        bw.close();
    }

    // MODIFICAR
    public void modificar(Usuario nuevo) throws IOException {
        List<Usuario> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));

        for (Usuario u : lista) {
            if (u.id == nuevo.id) {
                bw.write(nuevo.toString());
            } else {
                bw.write(u.toString());
            }
            bw.newLine();
        }
        bw.close();
    }

}