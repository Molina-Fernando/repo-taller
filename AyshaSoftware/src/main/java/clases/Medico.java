package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Medico extends Funcionario implements ProfesionalSanitario {

    private int numMatricula;
    private ArrayList<Especialidad> especialidad;

    public Medico(String nombre, String apellido, LocalDate fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password, int matricula) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, user, password);
        this.numMatricula=matricula;
        
    }
    
    @Override
        public Triage realizarTriage(Paciente paciente1) {
        // Método a resolver...
        return null;
    }
    
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Medico{");
        sb.append("numMatricula=").append(numMatricula);
        
        
        Iterator<Especialidad> iterator = especialidad.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('}');
        
        return super.toString()+sb.toString();
    }
    
    
}