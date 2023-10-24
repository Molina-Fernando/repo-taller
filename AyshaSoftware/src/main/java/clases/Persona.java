package clases;

/**
 * La clase abstracta Persona representa a un individuo con información
 * personal.
 */
public abstract class Persona {

    /**
     * El nombre de la persona.
     */
    private String nombre;

    /**
     * El apellido de la persona.
     */
    private String apellido;

    /**
     * La fecha de nacimiento de la persona.
     */
    private String fecNacimiento;

    /**
     * La dirección de domicilio de la persona.
     */
    private String domicilio;

    /**
     * El número de identificación (DNI) de la persona.
     */
    private String dni;

    /**
     * El número de teléfono fijo de la persona.
     */
    private String telFijo;

    /**
     * El número de teléfono celular de la persona.
     */
    private String telCelular;

    /**
     * El correo electrónico de la persona.
     */
    private String correoElectronico;

    /**
     * El estado civil de la persona.
     */
    private String estadoCivil;

    /**
     * Constructor vacío de la clase Persona.
     */
    public Persona() {
    }

    /**
     * Constructor de la clase Persona que toma información personal.
     *
     * @param nombre El nombre de la persona.
     * @param apellido El apellido de la persona.
     * @param fecNacimiento La fecha de nacimiento de la persona.
     * @param domicilio La dirección de domicilio de la persona.
     * @param dni El número de identificación (DNI) de la persona.
     * @param telFijo El número de teléfono fijo de la persona.
     * @param telCelular El número de teléfono celular de la persona.
     * @param correoElectronico El correo electrónico de la persona.
     * @param estadoCivil El estado civil de la persona.
     */
    public Persona(String nombre, String apellido, String fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String estadoCivil) {

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

    /**
     * Establece el nombre de la persona.
     *
     * @param nombre El nombre de la persona.
     */
    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el apellido de la persona.
     *
     * @param nombre El apellido de la persona.
     */
    public final void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     *
     * @param nombre El la fecha de nacimiento de la persona.
     */
    public final void setFecNacimiento(String fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    /**
     * Establece el domicilio de la persona.
     *
     * @param nombre El domicilio de la persona.
     */
    public final void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Establece el dni de la persona.
     *
     * @param nombre El dni de la persona.
     */
    public final void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Establece el teléfono fijo de la persona.
     *
     * @param nombre El teléfono fijo de la persona.
     */
    public final void setTelFijo(String telFijo) {
        this.telFijo = telFijo;
    }

    /**
     * Establece el teléfono celular de la persona.
     *
     * @param nombre El teléfono celular de la persona.
     */
    public final void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    /**
     * Establece el correo electrónico de la persona.
     *
     * @param nombre El correo electrónico de la persona.
     */
    public final void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el apellido de la persona.
     *
     * @return El apellido de la persona.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public String getFecNacimiento() {
        return fecNacimiento;
    }

    /**
     * Obtiene el estado civil de la persona.
     *
     * @return El estado civil de la persona.
     */
    public final void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    /**
     * Obtiene el domicilio de la persona.
     *
     * @return El domicilio de la persona.
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Obtiene el dni de la persona.
     *
     * @return El dni de la persona.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Obtiene el teléfono fijo de la persona.
     *
     * @return El teléfono fijo de la persona.
     */
    public String getTelFijo() {
        return telFijo;
    }

    /**
     * Obtiene el teléfono celular de la persona.
     *
     * @return El teléfono celular de la persona.
     */
    public String getTelCelular() {
        return telCelular;
    }

    /**
     * Obtiene el correo electrónico de la persona.
     *
     * @return El correo electrónico de la persona.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Obtiene el estado civil de la persona.
     *
     * @return El estado vicil de la persona.
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * Genera una representación de cadena del objeto Persona, incluyendo su
     * nombre, apellido y otros detalles personales.
     *
     * @return Una cadena que representa el objeto Persona.
     */
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", fecNacimiento=" + fecNacimiento + ", domicilio=" + domicilio + ", dni=" + dni + ", telFijo=" + telFijo + ", telCelular=" + telCelular + ", correoElectronico=" + correoElectronico + ", estadoCivil= " + '}';
    }

}
