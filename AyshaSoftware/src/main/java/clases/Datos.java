package clases;

import java.time.LocalDate;
import java.time.LocalTime;

public class Datos {
    
    private Box box;
    private Consulta cons;
    private LocalDate fecha;
    private LocalTime horaAsignacion;
    
    //Usando este constructor ya tendriamos la instancia de datos correspondiente al box y consulta especificados
    //falta ver si esto se da cuando el medico asigna el box, que seria el mejor momento
    public Datos(Box box, Consulta cons, LocalDate fecha, LocalTime horaAsignacion) {
        this.box = box;
        this.cons = cons;
        this.fecha = fecha;
        this.horaAsignacion = horaAsignacion;
    }
    
}