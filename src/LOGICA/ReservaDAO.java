package LOGICA;

import java.io.*;
import java.util.*;

public class ReservaDAO {

    private final String ruta = "src/DOCUMENTOS/reservas.txt";

    // BUSCAR POR MATRICULA
    public Reserva buscarPorMatricula(String idMatricula) throws IOException {
        for (Reserva r : listar()) {
            if (r.idMatricula.equalsIgnoreCase(idMatricula)) return r;
        }
        return null;
    }

    // GUARDAR
    public void guardar(Reserva r) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
        bw.write(r.toString());
        bw.newLine();
        bw.close();
    }

    // LISTAR
    public List<Reserva> listar() throws IOException {
        List<Reserva> lista = new ArrayList<>();
        File file = new File(ruta);
        if (!file.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) continue;
            String[] d = linea.split(";", -1);
            lista.add(new Reserva(
                d[0], d[1], d[2], d[3], d[4], d[5],
                d[6],
                Integer.parseInt(d[7]),
                Double.parseDouble(d[8])
            ));
        }
        br.close();
        return lista;
    }

    // ELIMINAR POR MATRICULA (solo Admin)
    public void eliminar(String idMatricula) throws IOException {
        List<Reserva> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        for (Reserva r : lista) {
            if (!r.idMatricula.equalsIgnoreCase(idMatricula)) {
                bw.write(r.toString());
                bw.newLine();
            }
        }
        bw.close();
    }
}
