package LOGICA;

public class Reserva {

    public String idMatricula;
    public String idCedula;
    public String idOferta;       // puede ser vacío
    public String fechaReserva;
    public String fechaSalida;
    public String fechaEntrada;
    public String observacion;
    public int diaReserva;
    public double totalReservas;
    public String entregado;

    public Reserva(String idMatricula, String idCedula, String idOferta,
                   String fechaReserva, String fechaSalida, String fechaEntrada,
                   String observacion, int diaReserva, double totalReservas, String entregado) {
        this.idMatricula  = idMatricula;
        this.idCedula     = idCedula;
        this.idOferta     = idOferta;
        this.fechaReserva = fechaReserva;
        this.fechaSalida  = fechaSalida;
        this.fechaEntrada = fechaEntrada;
        this.observacion  = observacion;
        this.diaReserva   = diaReserva;
        this.totalReservas = totalReservas;
        this.entregado       = entregado;
    }

    public Reserva(String idMatricula, String idCedula, String idOferta,
                   String fechaReserva, String fechaSalida, String fechaEntrada,
                   String observacion, int diaReserva, double totalReservas) {
        this(idMatricula, idCedula, idOferta, fechaReserva, fechaSalida, fechaEntrada, observacion, diaReserva, totalReservas, "false");
    }

    @Override
    public String toString() {
        return idMatricula + ";" + idCedula + ";" + idOferta + ";" +
               fechaReserva + ";" + fechaSalida + ";" + fechaEntrada + ";" +
               observacion + ";" + diaReserva + ";" + totalReservas + ";" + entregado;
    }
}
