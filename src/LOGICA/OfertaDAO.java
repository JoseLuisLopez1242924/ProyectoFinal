/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA;
import java.io.*;
import java.util.*;
/**
 *
 * @author User
 */
public class OfertaDAO {
    private final String ruta = "src/DOCUMENTOS/ofertas.txt";

    // BUSCAR POR ID
    public Oferta buscarPorId(int id) throws IOException {
        for (Oferta o : listar()) {
            if (o.idOferta == id) return o;
        }
        return null;
    }

    // GUARDAR
    public void guardar(Oferta o) throws IOException {
        if (buscarPorId(o.idOferta) != null) {
            throw new IllegalArgumentException("La oferta '" + o.idOferta + "' ya existe.");
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
        bw.write(o.toString());
        bw.newLine();
        bw.close();
    }

    // LISTAR
    public List<Oferta> listar() throws IOException {
        List<Oferta> lista = new ArrayList<>();
        File file = new File(ruta);
        if (!file.exists()) return lista;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) continue;
            String[] d = linea.split(";");
            if (d.length < 4) continue;
            lista.add(new Oferta(
                Integer.parseInt(d[0]),
                d[1], d[2],
                Double.parseDouble(d[3])
            ));
        }
        br.close();
        return lista;
    }

    // ELIMINAR
    public void eliminar(int id) throws IOException {
        List<Oferta> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        for (Oferta o : lista) {
            if (o.idOferta != id) {
                bw.write(o.toString());
                bw.newLine();
            }
        }
        bw.close();
    }

    // MODIFICAR
    public void modificar(Oferta nuevo) throws IOException {
        List<Oferta> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        for (Oferta o : lista) {
            if (o.idOferta == nuevo.idOferta) {
                bw.write(nuevo.toString());
            } else {
                bw.write(o.toString());
            }
            bw.newLine();
        }
        bw.close();
    }
}
