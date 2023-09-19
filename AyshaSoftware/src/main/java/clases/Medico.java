
package clases;

import java.util.ArrayList;
public class Medico extends Funcionario implements ProfesionalSanitario {

    private int numMatricula;
    private ArrayList<Especialidad> especialidad;
    
    @Override
        public Triage realizarTriage(Paciente paciente1) {
        // Método a resolver...
        return null;
    }
    @Override
    public void asignarBox(Paciente paciente1) {
        // Método a resolver...
    }

    @Override
    public void cambiarTriage(Triage triage1) {
        // Método a resolver...
    }

    @Override
    public void verListaEsperaTriage(ArrayList<Paciente> paciente) {
        // Método a resolver...
    }


    public void verListaEsperaBox() {
        // Método a resolver...
    }

    public void tomarPaciente() {
        // Método a resolver...
    }

    public void tomarHistoriaClinica() {
        // Método a resolver...
    }

}