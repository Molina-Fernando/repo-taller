package clases;

import java.util.ArrayList;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public interface ProfesionalSanitario {


    public void realizarTriage();

    public void cambiarTriage(String color);

    
    public void verListaEsperaTriage(ArrayList<Paciente> paciente);
}