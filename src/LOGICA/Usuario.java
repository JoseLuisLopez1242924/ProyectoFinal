package LOGICA;

public class Usuario {
    public int id;
    public String nombre;
    public String usuario;
    public String correo;
    public String password;
    public int acceso;

    public Usuario(int id, String nombre, String usuario, String correo, String password, int acceso) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
        this.acceso = acceso;
    }

    @Override
    public String toString() {
        return id + "," + nombre + "," + usuario + "," + correo + "," + password + "," + acceso;
    }
}