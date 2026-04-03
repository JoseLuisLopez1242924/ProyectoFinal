package LOGICA;

public class Usuario {
    public String usuario;
    public String password;
    public String nombre;
    public String apellido;
    public String correo;
    public int acceso;

    public Usuario(String usuario, String password, String nombre, String apellido, String correo, int acceso) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.acceso = acceso;
    }

    @Override
    public String toString() {
        return usuario + "," + password + "," + nombre + "," + apellido +  "," + correo +  "," + acceso;
    }
}