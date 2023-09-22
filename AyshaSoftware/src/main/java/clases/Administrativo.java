package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import ventanas.ListaTriage;

public class Administrativo extends Funcionario {

    private ArrayList<Sector> sectores;

    public Administrativo() {  }

    public Administrativo(String nombre, String apellido, LocalDate fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password, String estadoCivil) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, user, password,estadoCivil);
    }

    public void setSectores(Sector e) {
        this.sectores.add(e);
    }
    
    public void cargarPacientes(String nombre, String apellido, LocalDate fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correo, String personaContacto, String estadoCivil){
        Paciente paciente = new Paciente(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correo, personaContacto, estadoCivil);
        
        
    }

}
