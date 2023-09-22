package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {

    private String resultadoTriage;
    private String triageDefinitivo;
    private LocalDate fecha;
    private LocalTime hora;
    private String motivo;

    private Paciente paciente;
    private Box box;
    private Triage triage;
    private Registro registro;

    //El atributo box es el último en instanciarse o guardarse dentro de la lógica de la relacion box-datos-consulta
    public void setBox(Box box) {
        this.box = box;
    }

}
