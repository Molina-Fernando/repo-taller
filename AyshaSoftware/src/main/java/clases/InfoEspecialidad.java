package clases;

import java.time.LocalDate;
/**
 * La clase InfoEspecialidad es una clase asociación que
 * representa información relacionada con la especialidad de un médico.
 */
public class InfoEspecialidad {

    /**
     * La fecha en la que se obtuvo la información sobre la especialidad.
     */
    private LocalDate fecha;

    /**
     * La universidad en la que el médico obtuvo la especialidad.
     */
    private String universidad;

    /**
     * La especialidad del médico.
     */
    private Especialidad especialidad;

    /**
     * El médico al que se refiere la información de la especialidad.
     */
    private Medico medico;

    /**
     * Constructor de la clase InfoEspecialidad que toma como argumentos la fecha, universidad, especialidad y médico.
     *
     * @param fecha       La fecha en la que se obtuvo la información sobre la especialidad.
     * @param universidad La universidad en la que el médico obtuvo la especialidad.
     * @param especialidad La especialidad del médico.
     * @param medico      El médico al que se refiere la información de la especialidad.
     */
    public InfoEspecialidad(LocalDate fecha, String universidad, Especialidad especialidad, Medico medico) {
        this.fecha = fecha;
        this.universidad = universidad;
        this.especialidad = especialidad;
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "InfoEspecialidad{" + "fecha=" + fecha + ", universidad=" + universidad + '}';
    }

}
