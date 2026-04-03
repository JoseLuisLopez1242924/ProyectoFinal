/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA;


public class Vehiculo {
    String matricula;
    String marca;
    String modelo;
    int tipoVehiculo;
    int tipoMotor;
    int gama;
    String descripcionVeh;
    boolean techoElectrico;
    boolean aireAcondicionado;
    boolean interiorCuero;
    String colorVeh;
    boolean cambioAuto;
    boolean statusVeh;

      public Vehiculo(String matricula, String marca, String modelo, int tipoVehiculo, int tipoMotor,
                    int gama, String descripcionVeh, boolean techoElectrico,
                    boolean aireAcondicionado, boolean interiorCuero,
                    String colorVeh, boolean cambioAuto, boolean statusVeh) {

        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoVehiculo = tipoVehiculo;
        this.tipoMotor = tipoMotor;
        this.gama = gama;
        this.descripcionVeh = descripcionVeh;
        this.techoElectrico = techoElectrico;
        this.aireAcondicionado = aireAcondicionado;
        this.interiorCuero = interiorCuero;
        this.colorVeh = colorVeh;
        this.cambioAuto = cambioAuto;
        this.statusVeh = statusVeh;
    }
}
