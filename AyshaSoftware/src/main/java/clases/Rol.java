package clases;

public class Rol {
    
    private String nombre;
    private int id;

    public Rol() {
    }

    public Rol(String nombreRol) {
        this.nombre = nombreRol;
    }

    public String getNombreRol() {
        return nombre;
    }

    public void setNombreRol(String nombreRol) {
        this.nombre = nombreRol;
    }

    @Override
    public String toString() {
        return "Rol{" + "nombreRol=" + nombre + '}';
    }
    
    
    
}
