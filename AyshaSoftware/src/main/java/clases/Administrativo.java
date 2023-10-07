package clases;

import java.time.LocalDate;
import java.util.ArrayList;


public class Administrativo extends Funcionario {

    private Sector sector;

    public Administrativo() {  }

    public Administrativo(String nombre, String apellido, String fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password, String estadoCivil) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, user, password,estadoCivil);
    }

    public void setSector(Sector e) {
        this.sector = e;
    }
    
    public void cargarPacientes(String nombre, String apellido, String fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correo, String personaContacto, String estadoCivil){
        Paciente paciente = new Paciente(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correo, personaContacto, estadoCivil);
        
        
    }

    public Sector getSector() {
        return sector;
    }
    
    

}
