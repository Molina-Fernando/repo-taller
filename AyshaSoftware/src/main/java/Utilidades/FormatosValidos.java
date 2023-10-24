
package Utilidades;

import java.time.format.DateTimeFormatter;


public class FormatosValidos {
    public static final DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("dd'-'MM'-'yyyy");
    public static final DateTimeFormatter FORMATO_HORA=DateTimeFormatter.ofPattern("HH':'mm':'ss");
}
