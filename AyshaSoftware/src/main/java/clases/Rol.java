package clases;

/**
 * La clase Rol representa un rol o puesto en una organización o sistema.
 */
public class Rol {

    /**
     * El nombre del rol.
     */
    private String nombre;

    /**
     * El identificador único del rol.
     */
    private int id;

    /**
     * Constructor vacío de la clase Rol.
     */
    public Rol() {
    }

    /**
     * Constructor de la clase Rol que toma el nombre del rol como argumento.
     *
     * @param nombreRol El nombre del rol.
     */
    public Rol(String nombreRol) {
        this.nombre = nombreRol;
    }

    /**
     * Obtiene el nombre del rol.
     *
     * @return El nombre del rol.
     */
    public String getNombreRol() {
        return nombre;
    }

    /**
     * Establece el nombre del rol.
     *
     * @param nombreRol El nombre del rol a establecer.
     */
    public void setNombreRol(String nombreRol) {
        this.nombre = nombreRol;
    }

    /**
     * Genera una representación de cadena del objeto Rol, incluyendo su nombre.
     *
     * @return Una cadena que representa el objeto Rol.
     */
    @Override
    public String toString() {
        return "Rol{" + "nombreRol=" + nombre + '}';
    }
}
