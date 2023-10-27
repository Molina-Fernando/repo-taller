
package Utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * Clase que se encarga de validar fechas.
*/
public class ManejoFecha {
       /**
     * Este método verifica si una cadena dada es una fecha válida.
     * @param fecha La cadena que se va a verificar.
     * @return Verdadero si la cadena es una fecha válida, falso en caso contrario.
     */
    public static boolean esFechaValida(String fecha) {
        try {
            LocalDate localDate = LocalDate.parse(fecha, FormatosValidos.FORMATO_FECHA);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Este método verifica si una cadena de fecha dada está en un rango válido.
     * El rango válido es desde el 1 de enero de 2000 hasta la fecha actual.
     * @param fechaStr La cadena de fecha que se va a verificar.
     * @return Verdadero si la fecha está en el rango válido, falso en caso contrario.
     */
    public static boolean esFechaEnRango(String fechaStr) {
        try {
            LocalDate fecha = LocalDate.parse(fechaStr, FormatosValidos.FORMATO_FECHA);

            LocalDate hoy = LocalDate.now();
            LocalDate fechaMinima = LocalDate.of(2000, 1, 1);

            return !fecha.isAfter(hoy) && !fecha.isBefore(fechaMinima);
        } catch (DateTimeParseException e) {
            return false;
        }
    }
}
