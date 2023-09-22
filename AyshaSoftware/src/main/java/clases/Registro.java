package clases;

import java.time.LocalDate;
import java.time.LocalTime;

public class Registro {

    private final LocalDate fecha;
    private final LocalTime hora;
    private final String diagnostico;
    private final Lugares lugares;

    public Registro(LocalDate fecha, LocalTime hora, String diagnostico, Lugares lugares, Estudio sinNombre) {
        this.fecha = fecha;
        this.hora = hora;
        this.diagnostico = diagnostico;
        this.lugares = lugares;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public Lugares getLugares() {
        return lugares;
    }

}
