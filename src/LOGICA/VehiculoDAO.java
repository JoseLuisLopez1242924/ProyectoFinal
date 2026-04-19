/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA;

import java.io.*;
import java.util.*;
 
public class VehiculoDAO {
    private final String ruta = System.getProperty("user.dir").replace("\\", "/") + "/src/DOCUMENTOS/vehiculos.txt";
 
    // BUSCAR POR MATRICULA
    public Vehiculo buscarPorMatricula(String matricula) throws IOException {
        for (Vehiculo v : listar()) {
            if (v.matricula.equalsIgnoreCase(matricula)) return v;
        }
        return null;
    }
 
    // VERIFICAR SI EXISTE
    public boolean existe(String matricula) throws IOException {
        return buscarPorMatricula(matricula) != null;
    }
 
    // GUARDAR
    public void guardar(Vehiculo v) throws IOException {
        if (existe(v.matricula)) {
            throw new IllegalArgumentException("La matrícula '" + v.matricula + "' ya existe.");
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
            String[] d = linea.split(";");
            lista.add(new Vehiculo(
                d[0],
                d[1],
                d[2],
                Integer.parseInt(d[3]),
                Integer.parseInt(d[4]),
                Integer.parseInt(d[5]),
                d[6],
                Boolean.parseBoolean(d[7]),
                Boolean.parseBoolean(d[8]),
                Boolean.parseBoolean(d[9]),
                d[10],
                Boolean.parseBoolean(d[11]),
                Boolean.parseBoolean(d[12])
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
            if (!v.matricula.equalsIgnoreCase(matricula)) {
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
            if (v.matricula.equalsIgnoreCase(nuevo.matricula)) {
                bw.write(nuevo.toString());
            } else {
                bw.write(v.toString());
            }
            bw.newLine();
        }
        bw.close();
    }

    // BUSCAR POR MARCA (contiene, sin distinción de mayúsculas)
    public List<Vehiculo> buscarPorMarca(String marca) throws IOException {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : listar()) {
            if (v.marca.equalsIgnoreCase(marca.trim())) resultado.add(v);
        }
        return resultado;
    }

    // LISTAR DISPONIBLES (statusVeh = true)
    public List<Vehiculo> listarDisponibles() throws IOException {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : listar()) {
            if (v.statusVeh) resultado.add(v);
        }
        return resultado;
    }

    // LISTAR RENTADOS (statusVeh = false)
    public List<Vehiculo> listarRentados() throws IOException {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : listar()) {
            if (!v.statusVeh) resultado.add(v);
        }
        return resultado;
    }

    // BUSCAR POR GAMA
    public List<Vehiculo> buscarPorGama(int idGama) throws IOException {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : listar()) {
            if (v.idGama == idGama) resultado.add(v);
        }
        return resultado;
    }
}
