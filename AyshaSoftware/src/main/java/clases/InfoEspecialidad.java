
package clases;

import java.time.LocalDate;

public class InfoEspecialidad {

    private LocalDate fecha;
    private String universidad;
    private Especialidad especialidad;
    private Medico medico;

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