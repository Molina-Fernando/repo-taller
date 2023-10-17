package clases;

import java.util.ArrayList;

public class Enfermero extends Funcionario implements ProfesionalSanitario {
    Triage triage = new Triage();
    
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

    @Override
    public void cambiarTriage(String colorFinal, String motivoCambio) {
        triage.setColorFinal(colorFinal);
        triage.setMotivoCambio(motivoCambio);
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
