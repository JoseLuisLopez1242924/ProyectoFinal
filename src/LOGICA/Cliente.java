package LOGICA;

public class Cliente {
    public String idCedula;
    public String nombre;
    public String apellidos;
    public String direccion;
    public String email;
    public String telefono;

    public Cliente(String idCedula, String nombre, String apellidos, String direccion, String email, String telefono) {
        this.idCedula = idCedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
    }

  @Override
    public String toString() {
        return idCedula + ";" + nombre + ";" + apellidos + ";" + direccion + ";" + email + ";" + telefono;
    
    }
}
