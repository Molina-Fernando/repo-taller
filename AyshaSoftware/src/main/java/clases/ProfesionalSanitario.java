package clases;

import java.util.ArrayList;

public interface ProfesionalSanitario {


    public void realizarTriage();


    public void cambiarTriage(String color);


    
    public void verListaEsperaTriage(ArrayList<Paciente> paciente);
}

