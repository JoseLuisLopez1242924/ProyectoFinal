package LOGICA;

import java.io.*;
import java.util.*;

public class ClienteDAO {

    private final String ruta = "src/DOCUMENTOS/clientes.txt";

    // BUSCAR POR CEDULA
    public Cliente buscarPorId(String idCedula) throws IOException {
        for (Cliente c : listar()) {
            if (c.idCedula.equals(idCedula)) return c;
        }
        return null;
    }

    // GUARDAR
    public void guardar(Cliente c) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
        bw.write(c.toString());
        bw.newLine();
        bw.close();
    }

    // LISTAR
   /* public List<Cliente> listar() {
    List<Cliente> lista = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("clientes.txt"))) {
        String linea;
        while ((linea = br.readLine()) != null) {
            linea = linea.trim();
            if (linea.isEmpty()) continue;          // saltar líneas vacías

            String[] datos = linea.split(";", -1);  // -1 conserva campos vacíos

            if (datos.length < 6) continue;         // saltar líneas incompletas

            lista.add(new Cliente(
                datos[0].trim(),
                datos[1].trim(),
                datos[2].trim(),
                datos[3].trim(),
                datos[4].trim(),
                datos[5].trim()
            ));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista;
}*/
   public List<Cliente> listar() throws IOException {
        List<Cliente> lista = new ArrayList<>();
        File file = new File(ruta);
        if (!file.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) continue;
            String[] d = linea.split(";");
            lista.add(new Cliente(
                d[0], d[1], d[2], d[3], d[4], d[5]
            ));
        }
        br.close();
        return lista;
    }

    // ELIMINAR POR CEDULA
    public void eliminar(String idCedula) throws IOException {
        List<Cliente> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        for (Cliente c : lista) {
            if (!c.idCedula.equals(idCedula)) {
                bw.write(c.toString());
                bw.newLine();
            }
        }
        bw.close();
    }

    // MODIFICAR POR CEDULA
    public void modificar(Cliente nuevo) throws IOException {
        List<Cliente> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        for (Cliente c : lista) {
            if (c.idCedula.equals(nuevo.idCedula)) {
                bw.write(nuevo.toString());
            } else {
                bw.write(c.toString());
            }
            bw.newLine();
        }
        bw.close();
    }
}
