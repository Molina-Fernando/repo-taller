
package Utilidades;

import java.time.format.DateTimeFormatter;

/**
 * Esta clase proporciona formatos válidos predefinidos para fechas y horas usando la clase DateTimeFormatter de Java.
 */
public class FormatosValidos {
    public static final DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("dd'-'MM'-'yyyy");
    public static final DateTimeFormatter FORMATO_HORA=DateTimeFormatter.ofPattern("HH':'mm':'ss");
}
