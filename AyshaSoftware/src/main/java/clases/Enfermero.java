package clases;

import java.util.ArrayList;

public class Enfermero extends Funcionario implements ProfesionalSanitario {

    @Override
    public void realizarTriage() {
        // Método a resolver... 
    }

    @Override
    public void cambiarTriage(String color) {
        // Método a resolver...
    }

    @Override
    public void verListaEsperaTriage(ArrayList<Paciente> paciente) {
        // Método a resolver...
    }

    @Override
    public String toString() {
        return "Enfermero{" + super.toString() + '}';
    }

}
