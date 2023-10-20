package clases;

import Utilidades.FormatosValidos;
import java.time.LocalDate;
import java.time.LocalTime;

public class Datos {

    private int box;
    private int consulta;
    private LocalDate fecha;
    private LocalTime horaAsignacion;

    //Usando este constructor ya tendriamos la instancia de datos correspondiente al box y consulta especificados
    //falta ver si esto se da cuando el medico asigna el box, que seria el mejor momento
    public Datos(int box, int cons, String fecha, String horaAsignacion) {
        this.box = box;
        this.consulta = cons;
        this.fecha = LocalDate.parse(fecha, FormatosValidos.FORMATO_FECHA);
        this.horaAsignacion = LocalTime.parse(fecha, FormatosValidos.FORMATO_HORA);
    }
    
    public Datos(int box, int cons) {
        this.box = box;
        this.consulta = cons;
        this.fecha = LocalDate.now();
        this.horaAsignacion = LocalTime.now();
    }
}
