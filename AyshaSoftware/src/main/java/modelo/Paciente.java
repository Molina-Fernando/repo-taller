package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Paciente extends Persona {

    private String personaContacto;
    private final ArrayList<Registro> registros;
    private final ArrayList<Estudio> estudios;

    public Paciente(String nombre, String apellido, LocalDate fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String personaContacto) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico);
        this.personaContacto = personaContacto;
        this.registros = new ArrayList<>();
        this.estudios = new ArrayList<>();
    }

    public String getPersonaContacto() {
        return personaContacto;
    }

    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    public void setRegistros(Registro registro) {
        this.registros.add(registro);
    }

    public void setEstudios(Estudio estudio) {
        this.estudios.add(estudio);
    }

    public ArrayList<Registro> getRegistros() {
        return this.registros;
    }

    public ArrayList<Estudio> getEstudios() {
        return this.estudios;
    }

    @Override
    public String toString() {
        return super.toString() + "Paciente{" + "personaContacto=" + personaContacto + '}';
    }

}
