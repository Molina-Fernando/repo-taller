package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Medico extends Funcionario implements ProfesionalSanitario {

   
    private int numMatricula;
    private ArrayList<Especialidad> especialidad;
    
    public Medico() {
    }
    Triage triage = new Triage();
    public Medico(String nombre, String apellido, LocalDate fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password, int matricula, String estadoCivil) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, user, password, estadoCivil);
        this.numMatricula = matricula;
    }

    public Medico(String nombre, String apellido, LocalDate fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password, int matricula, Especialidad especialidad, String estadoCivil) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, user, password, estadoCivil);
        this.numMatricula = matricula;
        setEspecialidad(especialidad);

    }

    @Override
    public String realizarTriage(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        triage.setRespiracion(i1);
        triage.setPulso(i2);
        triage.setEstadoMental(i3);
        triage.setConciencia(i4);
        triage.setDolorPecho(i5);
        triage.setLesionGrave(i6);
        triage.setEdad(i7);
        triage.setFiebre(i8);
        triage.setVomitos(i9);
        triage.setDolorAbdominal(i10);
        triage.setSignosDeShock(i11);
        triage.setDoloresLeves(i12);
        triage.setSangrado(i13);
        
        String color = triage.obtenerColor();
        triage.setColorTriage(color);
        return color;
    }
    
           

    public void asignarBox(Paciente paciente1) {
        // Método a resolver...
    }

    @Override
    public void cambiarTriage(String colorFinal, String motivoCambio) {
        triage.setColorFinal(colorFinal);
        triage.setMotivoCambio(motivoCambio);
        System.out.println("El color final es: " + colorFinal + " y lo cambie al original por: " + motivoCambio);
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

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad.add(especialidad);
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

        return super.toString() + sb.toString();
    }

}
