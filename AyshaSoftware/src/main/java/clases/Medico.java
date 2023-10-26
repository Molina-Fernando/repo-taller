package clases;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * La clase ´Medico´ implementa una interfaz ´ProfesionalSanitario´, también se
 * relaciona con la clase ´Triage´, debido a que el médico realiza el triage,
 * pasandole datos y obteniendo la información necesaria.
 *
 */
public class Medico extends Funcionario implements ProfesionalSanitario {

    /**
     * Número de matrícula del médico.
     */
    private int numMatricula;
    /**
     * Especialidades médicas asociadas al médico.
     */
    private ArrayList<Especialidad> especialidad;

    /**
     * Constructor por defecto de la clase Medico.
     */
    Triage triage = new Triage();

    public Medico() {
    }

    /**
     * Constructor de la clase Medico que copia información de otro médico y
     * establece un rol y sector.
     *
     * @param medico Médico del cual se copiará la información.
     * @param rol Rol asociado al médico.
     * @param sector Sector al que pertenece el médico.
     */
    public Medico(Medico medico, String rol, String sector) {

    }

    /**
     * Constructor de la clase Medico que inicializa sus atributos básicos.
     *
     * @param nombre Nombre del médico.
     * @param apellido Apellido del médico.
     * @param fecNacimiento Fecha de nacimiento del médico.
     * @param domicilio Domicilio del médico.
     * @param dni Número de DNI del médico.
     * @param telFijo Número de teléfono fijo del médico.
     * @param telCelular Número de teléfono celular del médico.
     * @param correoElectronico Correo electrónico del médico.
     * @param user Nombre de usuario del médico.
     * @param password Contraseña del médico.
     * @param matricula Número de matrícula del médico.
     * @param estadoCivil Estado civil del médico.
     */
    public Medico(String nombre, String apellido, String fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password, int matricula, String estadoCivil) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, user, password, estadoCivil);
        this.numMatricula = matricula;
    }

    /**
     * Constructor de la clase Medico que incluye información sobre
     * especialidades médicas.
     *
     * @param nombre Nombre del médico.
     * @param apellido Apellido del médico.
     * @param fecNacimiento Fecha de nacimiento del médico.
     * @param domicilio Domicilio del médico.
     * @param dni Número de DNI del médico.
     * @param telFijo Número de teléfono fijo del médico.
     * @param telCelular Número de teléfono celular del médico.
     * @param correoElectronico Correo electrónico del médico.
     * @param user Nombre de usuario del médico.
     * @param password Contraseña del médico.
     * @param matricula Número de matrícula del médico.
     * @param especialidad Especialidad médica del médico.
     * @param estadoCivil Estado civil del médico.
     */
    public Medico(String nombre, String apellido, String fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password, int matricula, Especialidad especialidad, String estadoCivil) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, user, password, estadoCivil);
        this.numMatricula = matricula;
        setEspecialidad(especialidad);

    }

    /**
     * Constructor de la clase Medico que no incluye información sobre usuario y
     * contraseña.
     *
     * @param nombre Nombre del médico.
     * @param apellido Apellido del médico.
     * @param fecNacimiento Fecha de nacimiento del médico.
     * @param domicilio Domicilio del médico.
     * @param dni Número de DNI del médico.
     * @param telFijo Número de teléfono fijo del médico.
     * @param telCelular Número de teléfono celular del médico.
     * @param correoElectronico Correo electrónico del médico.
     * @param matricula Número de matrícula del médico.
     * @param estadoCivil Estado civil del médico.
     */
    public Medico(String nombre, String apellido, String fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, int matricula, String estadoCivil) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, estadoCivil);
        this.numMatricula = matricula;
    }

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
     * Metodo que no cumple ninguna función.
     *
     * @param paciente1
     */
    public void asignarBox(Paciente paciente1) {
        // Método a resolver...
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

    /**
     * Obtiene el color de triage parcial del paciente.
     *
     * @return El color de triage parcial asignado al paciente.
     */
    public String getColorParcial() {
        return triage.getColorTriage();
    }

    /**
     * Obtiene el color de triage definitivo del paciente.
     *
     * @return El color de triage definitivo asignado al paciente.
     */
    public String getColorDefinitivo() {
        return triage.getColorFinal();
    }

    /**
     * Obtiene el motivo del cambio de triage.
     *
     * @return El motivo por el cual se cambió el triage del paciente.
     */
    public String getMotivoCambio() {
        return triage.getMotivoCambio();
    }

    /**
     * Visualizar la lista con los pacientes que estan esperando para ser
     * triagiados.
     *
     * @param paciente : ArrayList con los pacientes en espera del triage.
     */
    @Override
    public void verListaEsperaTriage(ArrayList<Paciente> paciente) {
        // Método a resolver...
    }

    /**
     * Muestra la lista de espera de pacientes asignados a un profesional de
     * salud en un área o especialidad específica.
     */
    public void verListaEsperaBox() {
        // Método a resolver...
    }

    /**
     * Permite a un profesional de la salud tomar a un paciente de la lista de
     * espera y comenzar su atención.
     */
    public void tomarPaciente() {
        // Método a resolver...
    }

    /**
     * Permite a un profesional de la salud acceder y tomar la historia clínica
     * de un paciente.
     */
    public void tomarHistoriaClinica() {
        // Método a resolver...
    }

    /**
     * Asigna una especialidad al profesional de salud.
     *
     * @param especialidad La especialidad que se asignará al profesional de
     * salud.
     */
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad.add(especialidad);
    }
    
    /**
     * Devuelve una representación en cadena de este objeto Medico.
     * La representación en cadena incluye el número de matrícula del médico y una lista de sus especialidades.
     *
     * @return  una cadena de caracteres que representa este objeto Medico
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Medico{");
        sb.append("numMatricula=").append(numMatricula);

        Iterator<Especialidad> iterator = especialidad.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('}');

        return super.toString() + sb.toString();
    }

    /**
     * Obtiene el número de matrícula del médico.
     *
     * @return El número de matrícula del médico.
     */
    public int getNumMatricula() {
        return numMatricula;
    }

    /**
     * Establece el número de matrícula del médico.
     *
     * @param numMatricula El nuevo número de matrícula a asignar al médico.
     */
    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

}
