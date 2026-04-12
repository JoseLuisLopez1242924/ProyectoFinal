/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author jsosa
 */
public class Reserva {
  public int    idReserva;
    public String idCedula;       // FK → Cliente
    public String matricula;      // FK → Vehículo
    public int    idOferta;       // FK → Oferta  (0 = sin oferta)
    public LocalDate fechaReserva;  // tomada del sistema al guardar
    public LocalDate fechaSalida;
    public LocalDate fechaEntrada;
    public long   diasReserva;    // calculado: fechaEntrada - fechaSalida
    public double precioUsado;    // precioGama o precioOferta
    public double totalReserva;   // diasReserva * precioUsado
    public String estado;         // PENDIENTE | CANCELADA
 
    public Reserva(int idReserva, String idCedula, String matricula,
                   int idOferta,
                   LocalDate fechaReserva, LocalDate fechaSalida, LocalDate fechaEntrada,
                   long diasReserva, double precioUsado, double totalReserva, String estado) {
        this.idReserva    = idReserva;
        this.idCedula     = idCedula;
        this.matricula    = matricula;
        this.idOferta     = idOferta;
        this.fechaReserva = fechaReserva;
        this.fechaSalida  = fechaSalida;
        this.fechaEntrada = fechaEntrada;
        this.diasReserva  = diasReserva;
        this.precioUsado  = precioUsado;
        this.totalReserva = totalReserva;
        this.estado       = estado;
    }
 
    /** Recalcula dias entre fechaSalida y fechaEntrada (minimo 1). */
    public static long calcularDias(LocalDate salida, LocalDate entrada) {
        long d = ChronoUnit.DAYS.between(salida, entrada);
        return d < 1 ? 1 : d;
    }
 
    @Override
    public String toString() {
        return idReserva    + "|" + idCedula     + "|" + matricula   + "|"
             + idOferta     + "|" + fechaReserva + "|" + fechaSalida + "|"
             + fechaEntrada + "|" + diasReserva  + "|" + precioUsado + "|"
             + totalReserva + "|" + estado;
    }
}
