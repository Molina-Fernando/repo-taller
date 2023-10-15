package clases;

import java.time.LocalDate;
import java.time.LocalTime;


public class Registro {
    
    private final String dni;
    private final LocalDate fecha;
    private final LocalTime hora;
    private final String diagnostico;
    private final Lugares lugares;


    public Registro(String dni,LocalDate fecha, LocalTime hora, String diagnostico, Lugares lugares) {
        this.fecha = fecha;
        this.hora = hora;
        this.diagnostico = diagnostico;
        this.lugares = lugares;
        this.dni = dni;
    }
    
    public Registro(String dni, String diagnostico, Lugares lugares) {
        this.dni = dni;
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
    
    public String getDni(){
        return dni;
    }
    

    @Override
    public String toString() {
        return "Registro{" + "fecha=" + fecha.format(FormatosValidos.FORMATO_FECHA) + ", hora=" + hora.format(FormatosValidos.FORMATO_HORA) + ", diagnostico=" + diagnostico + ", lugares=" + lugares + '}';
    }

    
}
