/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author joaqu
 */
public class FormatosValidos {
    public static final DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("dd'-'MM'-'yyyy");
    public static final DateTimeFormatter FORMATO_HORA=DateTimeFormatter.ofPattern("HH':'mm':'ss");
}
