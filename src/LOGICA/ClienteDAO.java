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
