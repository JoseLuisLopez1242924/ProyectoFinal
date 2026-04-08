package LOGICA;

import java.io.*;
import java.util.*;

public class GamaDAO {

    private final String ruta = "src/DOCUMENTOS/gamas.txt";

    // BUSCAR POR ID
    public Gama buscarPorId(int id) throws IOException {
        for (Gama g : listar()) {
            if (g.idGama == id) return g;
        }
        return null;
    }

    // GUARDAR
    public void guardar(Gama g) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
        bw.write(g.toString());
        bw.newLine();
        bw.close();
    }

    // LISTAR
    public List<Gama> listar() throws IOException {
        List<Gama> lista = new ArrayList<>();
        File file = new File(ruta);
        if (!file.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) continue;
            String[] d = linea.split(";");
            lista.add(new Gama(Integer.parseInt(d[0]), d[1], Double.parseDouble(d[2])));
        }
        br.close();
        return lista;
    }

    // ELIMINAR POR ID
    public void eliminar(int id) throws IOException {
        List<Gama> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        for (Gama g : lista) {
            if (g.idGama != id) {
                bw.write(g.toString());
                bw.newLine();
            }
        }
        bw.close();
    }

    // MODIFICAR POR ID
    public void modificar(Gama nuevo) throws IOException {
        List<Gama> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        for (Gama g : lista) {
            if (g.idGama == nuevo.idGama) {
                bw.write(nuevo.toString());
            } else {
                bw.write(g.toString());
            }
            bw.newLine();
        }
        bw.close();
    }
}
