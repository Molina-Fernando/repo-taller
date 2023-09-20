package clases;

import java.util.ArrayList;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public interface ProfesionalSanitario {


    public Triage realizarTriage(Paciente paciente1);


    public void cambiarTriage(Triage triage1);
    
    public void verListaEsperaTriage(ArrayList<Paciente> paciente);
}