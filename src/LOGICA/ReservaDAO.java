/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
/**
 *
 * @author jsosa
 */
public class ReservaDAO {
private final String ruta = "src/DOCUMENTOS/reservas.txt";
 
    // ── SIGUIENTE ID ─────────────────────────────────────────────────────────
    public int siguienteId() throws IOException {
        List<Reserva> lista = listar();
        if (lista.isEmpty()) return 1;
        return lista.stream().mapToInt(r -> r.idReserva).max().getAsInt() + 1;
    }
 
    // ── BUSCAR POR ID ────────────────────────────────────────────────────────
    public Reserva buscarPorId(int id) throws IOException {
        for (Reserva r : listar()) {
            if (r.idReserva == id) return r;
        }
        return null;
    }
 
    // ── GUARDAR ──────────────────────────────────────────────────────────────
    public void guardar(Reserva r) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
        bw.write(r.toString());
        bw.newLine();
        bw.close();
    }
 
    // ── LISTAR ───────────────────────────────────────────────────────────────
    public List<Reserva> listar() throws IOException {
        List<Reserva> lista = new ArrayList<>();
        File file = new File(ruta);
        if (!file.exists()) return lista;
 
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;
        while ((linea = br.readLine()) != null) {
            linea = linea.trim();
            if (linea.isEmpty()) continue;
            String[] d = linea.split("\\|");
            lista.add(new Reserva(
                Integer.parseInt(d[0]),   // idReserva
                d[1],                     // idCedula
                d[2],                     // matricula
                Integer.parseInt(d[3]),   // idOferta
                LocalDate.parse(d[4]),    // fechaReserva
                LocalDate.parse(d[5]),    // fechaSalida
                LocalDate.parse(d[6]),    // fechaEntrada
                Long.parseLong(d[7]),     // diasReserva
                Double.parseDouble(d[8]), // precioUsado
                Double.parseDouble(d[9]), // totalReserva
                d[10]                     // estado
            ));
        }
        br.close();
        return lista;
    }
 
    // ── ELIMINAR (solo admin) ─────────────────────────────────────────────────
    public void eliminar(int id) throws IOException {
        List<Reserva> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        for (Reserva r : lista) {
            if (r.idReserva != id) {
                bw.write(r.toString());
                bw.newLine();
            }
        }
        bw.close();
    }
 
    // ── LISTAR POR CLIENTE ────────────────────────────────────────────────────
    public List<Reserva> listarPorCliente(String idCedula) throws IOException {
        List<Reserva> res = new ArrayList<>();
        for (Reserva r : listar()) {
            if (r.idCedula.equals(idCedula)) res.add(r);
        }
        return res;
    }
 
    // ── LISTAR POR RANGO DE FECHAS ────────────────────────────────────────────
    public List<Reserva> listarPorRango(LocalDate desde, LocalDate hasta) throws IOException {
        List<Reserva> res = new ArrayList<>();
        for (Reserva r : listar()) {
            if (!r.fechaReserva.isBefore(desde) && !r.fechaReserva.isAfter(hasta))
                res.add(r);
        }
        return res;
    }
}
