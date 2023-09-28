package clases;

import java.time.LocalDate;

public abstract class Persona {

    private String nombre;
    private String apellido;
    private LocalDate fecNacimiento;
    private String domicilio;
    private String dni;
    private String telFijo;
    private String telCelular;
    private String correoElectronico;
    private String estadoCivil;

    public Persona() {
    }

    public Persona(String nombre, String apellido, LocalDate fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String estadoCivil) {
        setNombre(nombre);
        setApellido(apellido);
        setFecNacimiento(fecNacimiento);
        setDomicilio(domicilio);
        setDni(dni);
        setTelCelular(telCelular);
        setTelFijo(telFijo);
        setCorreoElectronico(correoElectronico);
        setEstadoCivil(estadoCivil);
    }

    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public final void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public final void setFecNacimiento(LocalDate fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public final void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public final void setDni(String dni) {
        this.dni = dni;
    }

    public final void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    public final void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public final void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFecNacimiento() {
        return fecNacimiento;
    }
    
    public final void setEstadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getDni() {
        return dni;
    }

    public String getTelFijo() {
        return telFijo;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }
    
    

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", fecNacimiento=" + fecNacimiento + ", domicilio=" + domicilio + ", dni=" + dni + ", telFijo=" + telFijo + ", telCelular=" + telCelular + ", correoElectronico=" + correoElectronico + ", estadoCivil= " +'}';
    }

}
