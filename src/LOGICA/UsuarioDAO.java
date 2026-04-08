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

            if (usuario.equals(d[1]) && clave.equals(d[2])) {
                return new Usuario(
                    Integer.parseInt(d[0]),
                    d[1],
                    d[2],
                    d[3],
                    d[4],
                    d[5],
                    Integer.parseInt(d[6])
                );
            }
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    return null;
}
   //CODIGO VIEJO DE VALIDAR
   /* public boolean validarUsuario(String usuario, String clave) {
        
       try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String userArchivo = datos[1];
                String passArchivo = datos[2];
                
            
                if (usuario.equals(userArchivo) && clave.equals(passArchivo)) {
                    return true; // Usuario válido
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    
        return true; // No encontrado
    }  */
    
    // GUARDAR
    public void guardar(Usuario u) throws IOException {
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
                    Integer.parseInt(d[0]),
                    d[1],
                    d[2],
                    d[3],
                    d[4],
                    d[5],
                    Integer.parseInt(d[6])
            );
            lista.add(u);
        }
        br.close();
        return lista;
    }

    // ELIMINAR por ID
    public void eliminar(int id) throws IOException {
        List<Usuario> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));

        for (Usuario u : lista) {
            if (u.id != id) {
                bw.write(u.toString());
                bw.newLine();
            }
        }
        bw.close();
    }

    // ELIMINAR por usuario
    public void eliminarPorUsuario(String usuario) throws IOException {
        List<Usuario> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));

        for (Usuario u : lista) {
            if (!u.usuario.equals(usuario)) {
                bw.write(u.toString());
                bw.newLine();
            }
        }
        bw.close();
    }

    // MODIFICAR por ID
    public void modificar(Usuario nuevo) throws IOException {
        List<Usuario> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));

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

    // MODIFICAR por usuario
    public void modificarPorUsuario(Usuario nuevo) throws IOException {
        List<Usuario> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));

        for (Usuario u : lista) {
            if (u.usuario.equals(nuevo.usuario)) {
                // conservar el id original
                nuevo.id = u.id;
                bw.write(nuevo.toString());
            } else {
                bw.write(u.toString());
            }
            bw.newLine();
        }
        bw.close();
    }

}