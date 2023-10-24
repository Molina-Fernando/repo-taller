package clases;

/**
 * La clase Consulta representa una consulta médica realizada a un paciente
 * registra la visita completa del paciente al hospital.
 */
public class Consulta {

    /**
     * El resultado del triaje en la consulta.
     */
    private String resultadoTriage;

    /**
     * El triaje definitivo asignado en la consulta.
     */
    private String triageDefinitivo;

    /**
     * La fecha en la que se realizó la consulta.
     */
    private String fecha;

    /**
     * La hora en la que se realizó la consulta.
     */
    private String hora;

    /**
     * El motivo de la consulta.
     */
    private String motivo;

    /**
     * El médico que realizó la consulta.
     */
    private Medico medico;

    /**
     * El paciente atendido en la consulta.
     */
    private Paciente paciente;

    /**
     * El box en el que se llevó a cabo la consulta.
     */
    private Box box;

    /**
     * El triaje asociado a la consulta.
     */
    private Triage triage;

    /**
     * El registro de la consulta.
     */
    private Registro registro;

    /**
     * Constructor de la clase Consulta que toma un paciente y un motivo como
     * argumentos.
     *
     * @param paciente El paciente que se someterá a la consulta.
     * @param motivo El motivo de la consulta.
     */
    public Consulta(Paciente paciente, String motivo) {
        this.paciente = paciente;
        this.motivo = motivo;
    }

}
