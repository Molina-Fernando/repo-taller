package clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Registro {

    private final LocalDate fecha;
    private final LocalTime hora;
    private final String diagnostico;
    private final Lugares lugares;
    private final DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd'/'MM'/'yyyy");
    private final DateTimeFormatter formatoHora=DateTimeFormatter.ofPattern("HH':'mm':'ss");


    public Registro(LocalDate fecha, LocalTime hora, String diagnostico, Lugares lugares) {
        this.fecha = fecha;
        this.hora = hora;
        this.diagnostico = diagnostico;
        this.lugares = lugares;
    }
        public Registro( String diagnostico, Lugares lugares) {
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
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
    
    

    @Override
    public String toString() {
        return "Registro{" + "fecha=" + fecha.format(formatoFecha) + ", hora=" + hora.format(formatoHora) + ", diagnostico=" + diagnostico + ", lugares=" + lugares + '}';
    }
    
    
}
