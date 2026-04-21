package LOGICA;

public class Gama {
    public int idGama;
    public String descripcion;
    public double precio;
    public double precioGama;

    public Gama(int idGama, String descripcion, double precio) {
        this.idGama = idGama;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return idGama + ";" + descripcion + ";" + precio;
    }
}
