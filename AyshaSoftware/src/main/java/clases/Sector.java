package clases;

/**
 * La clase Sector representa una unidad o área dentro de una organización o
 * instalación.
 */
public class Sector {

    /**
     * El nombre del sector.
     */
    private String sector;

    /**
     * Constructor de la clase Sector que toma el nombre del sector como
     * argumento.
     *
     * @param sector El nombre del sector.
     */
    public Sector(String sector) {
        this.sector = sector;
    }

    /**
     * Obtiene el nombre del sector.
     *
     * @return El nombre del sector.
     */
    public String getSector() {
        return sector;
    }

    /**
     * Establece el nombre del sector.
     *
     * @param sector El nombre del sector a establecer.
     */
    public void setSector(String sector) {
        this.sector = sector;
    }

    /**
     * Genera una representación de cadena del objeto Sector, incluyendo su
     * nombre.
     *
     * @return Una cadena que representa el objeto Sector.
     */
    @Override
    public String toString() {
        return "Sector{" + "sector=" + sector + '}';
    }
}
