package clases;

import Utilidades.FormatosValidos;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * La clase Estudio representa un estudio médico realizado a un paciente.
 * Cada estudio tiene un DNI de paciente, fecha, hora, tipo de estudio, resultado del estudio y el médico que lo realizó.
 */
public class Estudio {
    private final String dni; // El DNI del paciente
    private final LocalDate fecha; // La fecha en que se realizó el estudio
    private final LocalTime hora; // La hora en que se realizó el estudio
    private final String tipo; // El tipo de estudio realizado
    private final String resultado; // El resultado del estudio
    private final int medico; // Matricula del médico que realizó el estudio

    /**
     * Constructor para la clase Estudio.
     * @param dni El DNI del paciente.
     * @param fecha La fecha en que se realizó el estudio.
     * @param hora La hora en que se realizó el estudio.
     * @param tipo El tipo de estudio realizado.
     * @param resultado El resultado del estudio.
     * @param medico El médico que realizó el estudio.
     */
    public Estudio(String dni, LocalDate fecha, LocalTime hora, String tipo, String resultado,int medico) {
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
        this.resultado = resultado;
        this.dni = dni; 
        this.medico = medico;
    }    

    /**
     * Constructor para la clase Estudio con la fecha y la hora establecidas en la actual.
     * @param dni El DNI del paciente.
     * @param tipo El tipo de estudio realizado.
     * @param resultado El resultado del estudio.
     * @param medico El médico que realizó el estudio.
     */
    public Estudio(String dni, String tipo, String resultado,int medico) {
        this.dni = dni;
        this.fecha = LocalDate.now();
        this.hora = LocalTime.now();
        this.tipo = tipo;
        this.resultado = resultado;        
        this.medico = medico;
    }

    /**
     * Devuelve el DNI del paciente.
     * @return El DNI del paciente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Devuelve la fecha en que se realizó el estudio.
     * @return La fecha en que se realizó el estudio.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Devuelve la hora en que se realizó el estudio.
     * @return La hora en que se realizó el estudio.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Devuelve el tipo de estudio realizado.
     * @return El tipo de estudio realizado.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve el resultado del estudio.
     * @return El resultado del estudio.
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Devuelve el médico que realizó el estudio.
     * @return El médico que realizó el estudio.
     */
    public int getMedico() {
        return medico;
    }

   /**
   * Devuelve una representación en cadena de este objeto Estudio. 
   *
   * @return  una cadena de caracteres que representa este objeto Estudio
   */
   @Override
   public String toString() {
       return "Estudio{" + "fecha=" + fecha.format(FormatosValidos.FORMATO_FECHA) +
               ", hora=" + hora.format(FormatosValidos.FORMATO_HORA) + ", tipo=" +
               tipo + ", resultado=" + resultado + ",medico="+medico+'}';
   }
}
