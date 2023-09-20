package clases;

import java.util.ArrayList;
import ventanas.MedicoTriage;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class Medico extends Funcionario implements ProfesionalSanitario {
    MedicoTriage t = new MedicoTriage();
    ///private int i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13 = 0; //en estas variables se guardarian los resultados de los combobox (Logica)
    private int numMatricula;
    private ArrayList<Especialidad> especialidad;
    
    

   
    public void realizarTriage() {
        String color = t.getcolor();
        System.out.println(color + "Hola");
        // Método a resolver...
       // return null;
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

}