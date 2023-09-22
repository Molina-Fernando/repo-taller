package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import ventanas.MedicoTriage;
import java.util.Iterator;

public class Medico extends Funcionario implements ProfesionalSanitario {

    MedicoTriage t = new MedicoTriage();
    ///private int i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 = 0; //en estas variables se guardarian los resultados de los combobox (Logica)
    private int numMatricula;
    private ArrayList<Especialidad> especialidad;

    public Medico() {
    }

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
    public void realizarTriage(int i1, int i2,int i3, int i4, int i5, int i6,int i7, int i8,int i9, int i10, int i11, int i12, int i13) {
        Triage t = new Triage(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13);
        String color = t.obtenerColor();
        System.out.println(color);//Prueba del color
        t.setColorTriage(color);
    }

    public void asignarBox(Paciente paciente1) {
        // Método a resolver...
    }

    @Override
    public void cambiarTriage(String colorFinal) {
        //t.setColorFinal(colorFinal);
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
