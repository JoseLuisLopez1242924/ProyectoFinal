/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LOGICA;
import java.time.LocalDate;
/**
 *
 * @author jsosa
 */
public class Reserva {
    public int idReserva;
    public String idCedula;       // FK Cliente
    public String matricula;      // FK Vehículo
    public LocalDate fechaInicio;
    public LocalDate fechaFin;
    public double costoTotal;
    public String estado;         // PENDIENTE, ACTIVA, FINALIZADA, CANCELADA
 
    public Reserva(int idReserva, String idCedula, String matricula,
                   LocalDate fechaInicio, LocalDate fechaFin,
                   double costoTotal, String estado) {
        this.idReserva  = idReserva;
        this.idCedula   = idCedula;
        this.matricula  = matricula;
        this.fechaInicio = fechaInicio;
        this.fechaFin   = fechaFin;
        this.costoTotal = costoTotal;
        this.estado     = estado;
    }
 
    /** Días totales de la reserva (mínimo 1) */
    public long getDias() {
        long d = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        return d < 1 ? 1 : d;
    }
 
    @Override
    public String toString() {
        return idReserva + ";" + idCedula + ";" + matricula + ";"
             + fechaInicio + ";" + fechaFin + ";" + costoTotal + ";" + estado;
    }
}
