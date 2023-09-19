/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author joaqu
 */
public interface ProfesionalSanitario {


    public Triage realizarTriage(Paciente paciente1);

    public void asignarBox(Paciente paciente1);

    public void cambiarTriage(Triage triage1);
    
    public void verListaEsperaTriage(ArrayList<Paciente> paciente);
}
