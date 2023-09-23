package clases;

import java.util.ArrayList;

public interface ProfesionalSanitario {

    public String realizarTriage(int i1, int i2,int i3, int i4, int i5, int i6,int i7, int i8,int i9, int i10, int i11, int i12, int i13);

    public void cambiarTriage(String color);

    public void verListaEsperaTriage(ArrayList<Paciente> paciente);
}
