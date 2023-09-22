package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Estudio {

    private final LocalDate fecha;
    private final LocalTime hora;
    private final String tipo;
    private final String resultado;

    public Estudio(LocalDate fecha, LocalTime hora, String tipo, String resultado) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.resultado = resultado;
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

}
