package clases;

/**
 * La clase Especialidad representa una especialidad médica y su información
 * relacionada.
 */
public class Especialidad {

    /**
     * El nombre de la especialidad médica.
     */
    private String nombre;

    /**
     * El identificador unico de la especialidad
     */
    private String id;

    /**
     * La información adicional de la especialidad, como la universidad y el
     * médico relacionado.
     */
    private InfoEspecialidad info;

    /**
     * Constructor de la clase Especialidad que toma el nombre de la
     * especialidad y la información relacionada.
     *
     * @param especialidad El nombre de la especialidad médica.
     * @param informacion La información adicional de la especialidad.
     */
    public Especialidad(String especialidad, InfoEspecialidad informacion) {
        this.nombre = especialidad;
        this.info = informacion;
    }

    /**
     * Genera una representación de cadena del objeto Especialidad, incluyendo
     * su nombre y la información relacionada.
     *
     * @return Una cadena que representa el objeto Especialidad.
     */
    @Override
    public String toString() {
        return "Especialidad{" + "especialidad=" + nombre + '}' + info.toString();
    }
}
