package clases;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La clase Administrativo representa a un funcionario que trabaja en tareas
 * administrativas.
 */
public class Administrativo extends Funcionario {

    /**
     * El sector en el que trabaja el administrativo.
     */
    private Sector sector;

    /**
     * Constructor vacío de la clase Administrativo.
     */
    public Administrativo() {
    }

    /**
     * Constructor para crear un objeto Administrativo con información básica.
     *
     * @param nombre El nombre del administrativo.
     * @param apellido El apellido del administrativo.
     * @param fecNacimiento La fecha de nacimiento del administrativo.
     * @param domicilio La dirección de domicilio del administrativo.
     * @param dni El número de identificación (DNI) del administrativo.
     * @param telFijo El número de teléfono fijo del administrativo.
     * @param telCelular El número de teléfono celular del administrativo.
     * @param correoElectronico El correo electrónico del administrativo.
     * @param user El nombre de usuario del administrativo.
     * @param password La contraseña del administrativo.
     * @param estadoCivil El estado civil del administrativo.
     */
    public Administrativo(String nombre, String apellido, String fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password, String estadoCivil) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, user, password, estadoCivil);
    }

    /**
     * Establece el sector en el que trabaja el administrativo.
     *
     * @param e El sector al que se asignará el administrativo.
     */
    public void setSector(Sector e) {
        this.sector = e;
    }

    /**
     * Carga información de un paciente.
     *
     * @param nombre El nombre del paciente.
     * @param apellido El apellido del paciente.
     * @param fecNacimiento La fecha de nacimiento del paciente.
     * @param domicilio La dirección de domicilio del paciente.
     * @param dni El número de identificación (DNI) del paciente.
     * @param telFijo El número de teléfono fijo del paciente.
     * @param telCelular El número de teléfono celular del paciente.
     * @param correo El correo electrónico del paciente.
     * @param personaContacto La persona de contacto del paciente.
     * @param estadoCivil El estado civil del paciente.
     */
    public void cargarPacientes(String nombre, String apellido, String fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correo, String personaContacto, String estadoCivil) {
        Paciente paciente = new Paciente(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correo, personaContacto, estadoCivil);

    }

    /**
     * Obtiene el sector en el que trabaja el administrativo.
     *
     * @return El sector en el que trabaja el administrativo.
     */
    public Sector getSector() {
        return sector;
    }

}
