package LOGICA;

import java.io.*;
import java.util.*;

public class UsuarioDAO {

    private final String ruta = "src/DOCUMENTOS/usuarios.txt";
     // VALIDAR USUARIO
    public Usuario validarUsuario(String usuario, String clave) {
    try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] d = linea.split(",");

            if (usuario.equals(d[0]) && clave.equals(d[1])) {
                return new Usuario(
                    d[0],
                    d[1],
                    d[2],
                    d[3],
                    d[4],
                    Integer.parseInt(d[5])
                );
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
}
    // VERIFICAR SI EL USUARIO YA EXISTE
    public boolean existe(String usuario) throws IOException {
         for (Usuario u : listar()) {
        if (u.usuario.equals(usuario)) {
            return true;
        }
    }
    return false;
}
    // GUARDAR
    public void guardar(Usuario u) throws IOException {
    if (existe(u.usuario)) {
        throw new IllegalArgumentException("El usuario '" + u.usuario + "' ya existe.");
    }
    BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
    bw.write(u.toString());
    bw.newLine();
    bw.close();
    }
    // LISTAR
    public List<Usuario> listar() throws IOException {
        List<Usuario> lista = new ArrayList<>();
        File file = new File(ruta);

        if (!file.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] d = linea.split(",");

            Usuario u = new Usuario(
                    d[0],
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
   public void eliminar(String usuario) throws IOException {
    List<Usuario> lista = listar();
    BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
    for (Usuario u : lista) {
        if (!u.usuario.equals(usuario)) {  // ← .equals() y negado
            bw.write(u.toString());
            bw.newLine();
        }
    }
    bw.close();
}
    // MODIFICAR
    public void modificar(Usuario nuevo) throws IOException {
       List<Usuario> lista = listar();
    BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
    for (Usuario u : lista) {
        if (u.usuario.equals(nuevo.usuario)) {  // ← .equals() no ==
            bw.write(nuevo.toString());          // escribe el usuario modificado
        } else {
            bw.write(u.toString());              // escribe el resto igual
        }
        bw.newLine();
    }
    bw.close();
    }
}