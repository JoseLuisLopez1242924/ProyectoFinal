/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA;


public class Vehiculo {

    public String matricula;
    public String marca;
    public String modelo;
    public int anio;
    public String color;
    public int idGama;
    public double precioPorDia;
    public String estado;   // "DISPONIBLE" o "RENTADO"
    public String imagen;   // ruta o nombre del archivo
 
    public Vehiculo(String matricula, String marca, String modelo, int anio,
                    String color, int idGama, double precioPorDia,
                    String estado, String imagen) {
        this.matricula    = matricula;
        this.marca        = marca;
        this.modelo       = modelo;
        this.anio         = anio;
        this.color        = color;
        this.idGama       = idGama;
        this.precioPorDia = precioPorDia;
        this.estado       = estado;
        this.imagen       = imagen;
    }
 
    @Override
    public String toString() {
        return matricula + "," + marca + "," + modelo + "," + anio + "," +
               color + "," + idGama + "," + precioPorDia + "," + estado + "," + imagen;
    }
}
