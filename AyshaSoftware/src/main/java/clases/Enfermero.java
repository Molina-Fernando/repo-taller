package clases;
import java.util.ArrayList;

public class Enfermero implements ProfesionalSanitario {
    @Override
    public Triage realizarTriage(Paciente paciente1) {
        // Método a resolver...
        return null;
    }

    @Override
    public void cambiarTriage(Triage triage1) {
        // Método a resolver...
    }

    @Override
    public void verListaEsperaTriage(ArrayList<Paciente> paciente) {
        // Método a resolver...
    }

    @Override
    public String toString() {
        return "Enfermero{" + super.toString()+'}';
    }
    
}