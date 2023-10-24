package clases;

import java.util.ArrayList;

/**
 * La interfaz ProfesionalSanitario define las operaciones que puede realizar un
 * profesional sanitario.
 */
public interface ProfesionalSanitario {

    /**
     * Realiza un triaje utilizando una serie de valores de evaluación médica.
     *
     * @param i1 Valor 1 de evaluación médica.
     * @param i2 Valor 2 de evaluación médica.
     * @param i3 Valor 3 de evaluación médica.
     * @param i4 Valor 4 de evaluación médica.
     * @param i5 Valor 5 de evaluación médica.
     * @param i6 Valor 6 de evaluación médica.
     * @param i7 Valor 7 de evaluación médica.
     * @param i8 Valor 8 de evaluación médica.
     * @param i9 Valor 9 de evaluación médica.
     * @param i10 Valor 10 de evaluación médica.
     * @param i11 Valor 11 de evaluación médica.
     * @param i12 Valor 12 de evaluación médica.
     * @param i13 Valor 13 de evaluación médica.
     * @return El resultado del triaje, generalmente un código de color o
     * prioridad.
     */
    public String realizarTriage(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13);

    /**
     * Cambia el triaje asignado a un paciente, actualizando su color y motivo
     * de cambio.
     *
     * @param color El nuevo color de triaje asignado al paciente.
     * @param motivoCambio El motivo del cambio de triaje.
     */
    public void cambiarTriage(String color, String motivoCambio);

    /**
     * Visualiza la lista de espera de pacientes que han sido triados.
     *
     * @param pacientes La lista de pacientes en espera de triaje.
     */
    public void verListaEsperaTriage(ArrayList<Paciente> paciente);
}
