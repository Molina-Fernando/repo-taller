package clases;

import java.time.LocalDate;

public class Paciente extends Persona {

    private String personaContacto;

    public Paciente(String nombre, String apellido, LocalDate fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String personaContacto) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico);
        this.personaContacto=personaContacto;
    }

    @Override
    public String toString() {
        return super.toString()+"Paciente{" + "personaContacto=" + personaContacto + '}';
    }
    
}
