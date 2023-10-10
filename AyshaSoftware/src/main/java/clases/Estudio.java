package clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Estudio {
    private final String dni;
    private final LocalDate fecha;
    private final LocalTime hora;
    private final String tipo;
    private final String resultado;
    private final DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd'/'MM'/'yyyy");
    private final DateTimeFormatter formatoHora=DateTimeFormatter.ofPattern("HH':'mm':'ss");

    public Estudio(String dni,LocalDate fecha, LocalTime hora, String tipo, String resultado) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.resultado = resultado;
        this.dni = dni; 
    }    
    
    public Estudio(String tipo, String resultado, String dni) {
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        this.tipo = tipo;
        this.resultado = resultado;
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public String getTipo() {
        return tipo;
    }

    public String getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return "Estudio{" + "fecha=" + fecha.format(formatoFecha) + ", hora=" + hora.format(formatoHora) + ", tipo=" + tipo + ", resultado=" + resultado + '}';
    }
    
    

}
