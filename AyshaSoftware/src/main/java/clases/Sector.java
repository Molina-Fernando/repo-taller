package clases;

/**
 * La clase Sector representa una unidad o área dentro de una organización o
 * instalación.
 */
public class Sector {

    /**
     * El nombre del sector.
     */
    private String nombre;

    /**
     * El identificador del sector.
     */
    private int id;

    /**
     * Constructor de la clase Sector que toma el nombre y el identificador del
     * sector como argumento.
     *
     * @param nombre El nombre del sector.
     * @param id El identificador del sector
     */
    public Sector(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    /**
     * Genera una representación de cadena del objeto Sector, incluyendo su
     * nombre.
     *
     * @return Una cadena que representa el objeto Sector.
     */
    @Override
    public String toString() {
        return "Sector{" + "sector=" + nombre + '}';
    }
}
