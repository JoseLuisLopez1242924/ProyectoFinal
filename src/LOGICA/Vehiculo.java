/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA;


public class Vehiculo {

    public String matricula;
    public String marca;
    public String modelo;
    public int tipoVehiculo;      // 0=Turístico, 1=Normal
    public int tipoMotor;         // 0=Diésel, 1=Gasolina
    public int idGama;
    public String descripcionVeh;
    public boolean techoElectrico;
    public boolean aireAcondicionado;
    public boolean interiorCuero;
    public String colorVeh;
    public boolean cambioAuto;
    public boolean statusVeh;
 
    public Vehiculo(String matricula, String marca, String modelo,
                    int tipoVehiculo, int tipoMotor, int idGama,
                    String descripcionVeh, boolean techoElectrico,
                    boolean aireAcondicionado, boolean interiorCuero,
                    String colorVeh, boolean cambioAuto, boolean statusVeh) {
        this.matricula       = matricula;
        this.marca           = marca;
        this.modelo          = modelo;
        this.tipoVehiculo    = tipoVehiculo;
        this.tipoMotor       = tipoMotor;
        this.idGama          = idGama;
        this.descripcionVeh  = descripcionVeh;
        this.techoElectrico  = techoElectrico;
        this.aireAcondicionado = aireAcondicionado;
        this.interiorCuero   = interiorCuero;
        this.colorVeh        = colorVeh;
        this.cambioAuto      = cambioAuto;
        this.statusVeh       = statusVeh;
    }
 
    @Override
    public String toString() {
        return matricula + ";" + marca + ";" + modelo + ";" + tipoVehiculo + ";" + tipoMotor + ";" + idGama + ";" +
        descripcionVeh + ";" + techoElectrico + ";" + aireAcondicionado + ";" + interiorCuero + ";" + colorVeh + ";" +
        cambioAuto + ";" + statusVeh;
    }
}
