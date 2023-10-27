package clases;

import Utilidades.FormatosValidos;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Esta clase representa datos relacionados con la asignación de un box de
 * consulta médica. Puede incluir información como el número de box, número de
 * consulta, fecha y hora de asignación.
 */
public class Datos {

    private int box;
    private int consulta;
    private LocalDate fecha;
    private LocalTime horaAsignacion;

    /**
     * Constructor que inicializa una instancia de Datos con el número de box,
     * número de consulta, fecha y hora de asignación especificados.
     *
     * @param box El número de box asignado.
     * @param consulta El número de consulta asignado.
     * @param fecha La fecha de asignación en formato "dd-MM-yyyy".
     * @param horaAsignacion La hora de asignación en formato "HH:mm:ss".
     */
    public Datos(int box, int consulta, String fecha, String horaAsignacion) {
        this.box = box;
        this.consulta = consulta;
        this.fecha = LocalDate.parse(fecha, FormatosValidos.FORMATO_FECHA);
        this.horaAsignacion = LocalTime.parse(fecha, FormatosValidos.FORMATO_HORA);
    }

    /**
     * Constructor que inicializa una instancia de Datos con el número de box y
     * número de consulta especificados. La fecha y hora de asignación se
     * establecen en la fecha y hora actuales.
     *
     * @param box El número de box asignado.
     * @param consulta El número de consulta asignado.
     */
    public Datos(int box, int consulta) {
        this.box = box;
        this.consulta = consulta;
        this.fecha = LocalDate.now();
        this.horaAsignacion = LocalTime.now();
    }
}
