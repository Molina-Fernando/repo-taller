package clases;

import java.util.ArrayList;

/**
 * Clase que representa a un paciente en un entorno de atención médica.
 */
public class Paciente extends Persona {

    /**
     * El nombre de la persona de contacto del paciente.
     */
    private String personaContacto;

    /**
     * Lista de registros médicos asociados al paciente.
     */
    private final ArrayList<Registro> registros;

    /**
     * Lista de estudios médicos asociados al paciente.
     */
    private final ArrayList<Estudio> estudios;

    /**
     * Constructor para crear un objeto Paciente con información personal y de
     * contacto.
     *
     * @param nombre El nombre del paciente.
     * @param apellido El apellido del paciente.
     * @param fecNacimiento La fecha de nacimiento del paciente.
     * @param domicilio La dirección de domicilio del paciente.
     * @param dni El número de documento de identidad del paciente.
     * @param telFijo El número de teléfono fijo del paciente.
     * @param telCelular El número de teléfono celular del paciente.
     * @param correoElectronico El correo electrónico del paciente.
     * @param personaContacto El nombre de la persona de contacto del paciente.
     * @param estadoCivil El estado civil del paciente.
     */
    public Paciente(String nombre, String apellido, String fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String personaContacto, String estadoCivil) {

        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, estadoCivil);
        this.personaContacto = personaContacto;
        this.registros = new ArrayList<>();
        this.estudios = new ArrayList<>();
    }

    /**
     * Constructor vacío para crear un objeto Paciente sin información personal.
     */
    public Paciente() {
        this.registros = new ArrayList<>();
        this.estudios = new ArrayList<>();
    }

    /**
     * Obtiene el nombre de la persona de contacto del paciente.
     *
     * @return El nombre de la persona de contacto del paciente.
     */
    public String getPersonaContacto() {
        return personaContacto;
    }

    /**
     * Establece el nombre de la persona de contacto del paciente.
     *
     * @param personaContacto El nuevo nombre de la persona de contacto.
     */
    public void setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }

    /**
     * Agrega un registro médico a la lista de registros del paciente.
     *
     * @param registro El registro médico a agregar.
     */
    public void setRegistros(Registro registro) {
        this.registros.add(registro);
    }

    /**
     * Agrega un estudio médico a la lista de estudios del paciente.
     *
     * @param estudio El estudio médico a agregar.
     */
    public void setEstudios(Estudio estudio) {
        this.estudios.add(estudio);
    }

    /**
     * Obtiene la lista de registros médicos asociados al paciente.
     *
     * @return La lista de registros médicos del paciente.
     */
    public ArrayList<Registro> getRegistros() {
        return this.registros;
    }

    /**
     * Obtiene la lista de estudios médicos asociados al paciente.
     *
     * @return La lista de estudios médicos del paciente.
     */
    public ArrayList<Estudio> getEstudios() {
        return this.estudios;
    }

    @Override
    public String toString() {
        return super.toString() + "Paciente{" + "personaContacto=" + personaContacto + '}';
    }

}
