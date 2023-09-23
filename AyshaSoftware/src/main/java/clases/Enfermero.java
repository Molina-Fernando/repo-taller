package clases;

import java.util.ArrayList;

public class Enfermero extends Funcionario implements ProfesionalSanitario {

    @Override
    public String realizarTriage(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        Triage t = new Triage(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13);
        String color = t.obtenerColor();
        t.setColorTriage(color);
        return color;// Método a resolver... 
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
