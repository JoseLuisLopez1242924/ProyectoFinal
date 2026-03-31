package LOGICA;

public class Usuario {
    public int id;
    public String usuario;
    public String password;
    public String nombre;
    public String apellido;
    public String correo;
    public int acceso;

    public Usuario(int id, String usuario, String password, String nombre, String apellido, String correo, int acceso) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.acceso = acceso;
    }

    @Override
    public String toString() {
        return id + "," + usuario + "," + password + "," + nombre + "," + apellido +  "," + correo +  "," + acceso;
    }
}