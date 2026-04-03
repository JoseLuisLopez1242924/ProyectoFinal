/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA;

import java.io.*;
import java.util.*;
 

public class VehiculoDAO {
    private final String ruta = "src/DOCUMENTOS/vehiculos.txt";
 
    // BUSCAR POR MATRICULA
    public Vehiculo buscarPorMatricula(String matricula) throws IOException {
        for (Vehiculo v : listar()) {
            if (v.matricula.equals(matricula)) return v;
        }
        return null;
    }
 
    // VERIFICAR SI LA MATRICULA YA EXISTE
    public boolean existe(String matricula) throws IOException {
        for (Vehiculo v : listar()) {
            if (v.matricula.equals(matricula)) return true;
        }
        return false;
    }
 
    // GUARDAR
    public void guardar(Vehiculo v) throws IOException {
        if (existe(v.matricula)) {
            throw new IllegalArgumentException("El vehículo con matrícula '" + v.matricula + "' ya existe.");
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, true));
        bw.write(v.toString());
        bw.newLine();
        bw.close();
    }
 
    // LISTAR
    public List<Vehiculo> listar() throws IOException {
        List<Vehiculo> lista = new ArrayList<>();
        File file = new File(ruta);
        if (!file.exists()) return lista;
 
        BufferedReader br = new BufferedReader(new FileReader(file));
        String linea;
        while ((linea = br.readLine()) != null) {
            if (linea.trim().isEmpty()) continue;
            String[] d = linea.split("\\|");
            lista.add(new Vehiculo(
                d[0],                        // matricula
                d[1],                        // marca
                d[2],                        // modelo
                Integer.parseInt(d[3]),      // anio
                d[4],                        // color
                Integer.parseInt(d[5]),      // idGama
                Double.parseDouble(d[6]),    // precioPorDia
                d[7],                        // estado (DISPONIBLE / RENTADO)
                d[8]                         // imagen (ruta o nombre)
            ));
        }
        br.close();
        return lista;
    }
 
    // ELIMINAR POR MATRICULA
    public void eliminar(String matricula) throws IOException {
        List<Vehiculo> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        for (Vehiculo v : lista) {
            if (!v.matricula.equals(matricula)) {
                bw.write(v.toString());
                bw.newLine();
            }
        }
        bw.close();
    }
 
    // MODIFICAR POR MATRICULA
    public void modificar(Vehiculo nuevo) throws IOException {
        List<Vehiculo> lista = listar();
        BufferedWriter bw = new BufferedWriter(new FileWriter(ruta));
        for (Vehiculo v : lista) {
            if (v.matricula.equals(nuevo.matricula)) {
                bw.write(nuevo.toString());
            } else {
                bw.write(v.toString());
            }
            bw.newLine();
        }
        bw.close();
    }
 
    // LISTAR SOLO DISPONIBLES
    public List<Vehiculo> listarDisponibles() throws IOException {
        List<Vehiculo> lista = new ArrayList<>();
        for (Vehiculo v : listar()) {
            if (v.estado.equalsIgnoreCase("DISPONIBLE")) lista.add(v);
        }
        return lista;
    }
 
    // LISTAR SOLO RENTADOS
    public List<Vehiculo> listarRentados() throws IOException {
        List<Vehiculo> lista = new ArrayList<>();
        for (Vehiculo v : listar()) {
            if (v.estado.equalsIgnoreCase("RENTADO")) lista.add(v);
        }
        return lista;
    }
 
    // LISTAR POR MARCA
    public List<Vehiculo> listarPorMarca(String marca) throws IOException {
        List<Vehiculo> lista = new ArrayList<>();
        for (Vehiculo v : listar()) {
            if (v.marca.equalsIgnoreCase(marca)) lista.add(v);
        }
        return lista;
    }
 
    // LISTAR POR GAMA
    public List<Vehiculo> listarPorGama(int idGama) throws IOException {
        List<Vehiculo> lista = new ArrayList<>();
        for (Vehiculo v : listar()) {
            if (v.idGama == idGama) lista.add(v);
        }
        return lista;
    }
 
    // LISTAR POR RANGO DE PRECIO
    public List<Vehiculo> listarPorRangoPrecio(double precioMin, double precioMax) throws IOException {
        List<Vehiculo> lista = new ArrayList<>();
        for (Vehiculo v : listar()) {
            if (v.precioPorDia >= precioMin && v.precioPorDia <= precioMax) lista.add(v);
        }
        return lista;
    }
 
    // CAMBIAR ESTADO (DISPONIBLE <-> RENTADO)
    public void cambiarEstado(String matricula, String nuevoEstado) throws IOException {
        Vehiculo v = buscarPorMatricula(matricula);
        if (v != null) {
            v.estado = nuevoEstado;
            modificar(v);
        }
    }
}
