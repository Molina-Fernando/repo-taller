package clases;

import Utilidades.FormatosValidos;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 * Representa un registro médico.
 */
public class Registro {
    private final String dni;
    private LocalDate fecha;
    private LocalTime hora;
    private String diagnostico;
    private final Lugares lugares;
    private final int medico;

    /**
     * Construye un objeto `Registro` con los parámetros especificados.
     *
     * @param dni         el número de DNI del paciente
     * @param fecha       la fecha del registro médico
     * @param hora        la hora del registro médico
     * @param diagnostico el diagnóstico del registro médico
     * @param lugares     la ubicación del registro médico
     * @param medico      el número de identificación del médico
     */
    public Registro(String dni, LocalDate fecha, LocalTime hora, String diagnostico, Lugares lugares, int medico) {
        this.fecha = fecha;
        this.hora = hora;
        this.diagnostico = diagnostico;
        this.lugares = lugares;
        this.dni = dni;
        this.medico = medico;
    }

    /**
     * Construye un objeto `Registro` con los parámetros especificados.
     *
     * @param dni         el número de DNI del paciente
     * @param diagnostico el diagnóstico del registro médico
     * @param lugares     la ubicación del registro médico
     * @param medico      el número de identificación del médico
     */
    public Registro(String dni, String diagnostico, Lugares lugares, int medico) {
        this.dni = dni;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        this.diagnostico = diagnostico;
        this.lugares = lugares;
        this.medico = medico; 
    }

    /**
     * Establece la fecha del registro médico.
     *
     * @param fecha la fecha del registro médico
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Establece la hora del registro médico.
     *
     * @param hora la hora del registro médico
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Establece el diagnóstico del registro médico.
     *
     * @param diagnostico el diagnóstico del registro médico
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Devuelve el número de identificación del médico.
     *
     * @return un entero que representa el número de identificación del médico
     */
    public int getMedico() {
        return medico;
    }       

    /**
     * Devuelve la fecha del registro médico.
     *
     * @return un objeto `LocalDate` que representa la fecha del registro médico
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Devuelve la hora del registro médico.
     *
     * @return un objeto `LocalTime` que representa la hora del registro médico
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Devuelve el diagnóstico del registro médico.
     *
     * @return una cadena que representa el diagnóstico del registro médicoo
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
      Devuelve la ubicación del registro médicoo.

      @return un objeto `Lugares` que representa la ubicación del registro médicoo
      */
      public Lugares getLugares() {
          return lugares;
      }

      /**
       Devuelve el número de DNI del paciente.

       @return una cadena que representa el número de DNI del paciente.
       */
       public String getDni(){
           return dni;
       }

       /**
        Devuelve una representación en cadena de `Registro`.

        @return una representación en cadena de `Registro`
        */
       @Override
       public String toString() {
           return "Registro{" + "fecha=" + fecha.format(FormatosValidos.FORMATO_FECHA) + ", hora=" +
                   hora.format(FormatosValidos.FORMATO_HORA) + ", diagnostico=" + diagnostico +
                   ", lugares=" + lugares + ", medico="+medico+'}';
       }
}

