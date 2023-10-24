package clases;

import java.util.ArrayList;

/**
 * La clase ´Enfermero´ implementa una interfaz ´ProfesionalSanitario´, también
 * se relaciona con la clase ´Triage´, debido a que el médico realiza el triage,
 * pasandole datos y obteniendo la información necesaria.
 *
 * @author Jeremías Simian
 */
public class Enfermero extends Funcionario implements ProfesionalSanitario {

    Triage triage = new Triage();

    /**
     * Setea los puntos de cada signo vital a la clase ´Triage´, para luego
     * llamar al método´obtenerColor()´ de dicha clase y conseguir el nombre del
     * color parcial, para posteriormente setearselo a la clase ´Triage´.
     *
     * @param i1 puntos correspondientes a la respiraión del paciente.
     * @param i2 puntos correspondientes al pulso del paciente.
     * @param i3 puntos correspondientes al estado mental del paciente.
     * @param i4 puntos correspondientes a la conciencia del paciente.
     * @param i5 puntos correspondientes al dolor en el pecho del paciente.
     * @param i6 puntos correspondientes a las lesiones graves del paciente.
     * @param i7 puntos correspondientes a la edad del paciente.
     * @param i8 puntos correspondientes a la fiebre del paciente.
     * @param i9 puntos correspondientes a los vomitos del paciente.
     * @param i10 puntos correspondientes al dolor abdominal del paciente.
     * @param i11 puntos correspondientes a los signos de shock del paciente.
     * @param i12 puntos correspondientes a los dolores leves del paciente.
     * @param i13 puntos correspondientes al sangrado del paciente.
     * @return color: color parcial del triage.
     */
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

    /**
     * Toma por parámetro el color final y el motivo de cambio para setearselos
     * a la clase ´Triage´.
     *
     * @param colorFinal : color definitivo del triage.
     * @param motivoCambio : motivo del cambio del color del triage.
     */
    @Override
    public void cambiarTriage(String colorFinal, String motivoCambio) {
        triage.setColorFinal(colorFinal);
        triage.setMotivoCambio(motivoCambio);
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
