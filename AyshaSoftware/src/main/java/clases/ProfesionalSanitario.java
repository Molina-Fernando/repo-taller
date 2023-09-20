package clases;

import java.util.ArrayList;

public interface ProfesionalSanitario {


    public Triage realizarTriage(Paciente paciente1);

    public void cambiarTriage(Triage triage1);
    
    public void verListaEsperaTriage(ArrayList<Paciente> paciente);
}

