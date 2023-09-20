package clases;

import java.time.LocalDate;

public class Paciente extends Persona {

    private String personaContacto;
    private HistoriaClinica historia;

    public Paciente(String nombre, String apellido, LocalDate fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String personaContacto) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico);
        this.personaContacto = personaContacto;
        historia = new HistoriaClinica();
    }

    public String getPersonaContacto() {
        return personaContacto;
    }

    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    public HistoriaClinica getHistoria() {
        return historia;
    }

    public void setHistoria(Estudio estudio) {
        this.historia.setEstudios(estudio);
    }

    public void setHistoria(Registro registro) {
        this.historia.setRegistros(registro);
    }

    @Override
    public String toString() {
        return super.toString() + "Paciente{" + "personaContacto=" + personaContacto + '}';
    }

}
