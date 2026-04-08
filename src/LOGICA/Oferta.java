/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA;

/**
 *
 * @author User
 */
public class Oferta {
    public int idOferta;
    public String idMatricula;
    public String descripcionOferta;
    public double precioOferta;

    public Oferta(int idOferta, String idMatricula, String descripcionOferta, double precioOferta) {
        this.idOferta = idOferta;
        this.idMatricula = idMatricula;
        this.descripcionOferta = descripcionOferta;
        this.precioOferta = precioOferta;
    }

    @Override
    public String toString() {
        return idOferta + ";" + idMatricula + ";" + descripcionOferta + ";" + precioOferta;
    }
}
