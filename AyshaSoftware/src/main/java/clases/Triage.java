package clases;

/**
 * Clase que representa la información de triage médico para evaluar el estado
 * de un paciente.
 */
public class Triage {

    /**
     * Puntos correspondientes a la respiración.
     */
    private int respiracion;

    /**
     * Puntos correspondientes al pulso.
     */
    private int pulso;

    /**
     * Puntos correspondientes al estado mental.
     */
    private int estadoMental;

    /**
     * Puntos correspondientes a la conciencia.
     */
    private int conciencia;

    /**
     * Puntos correspondientes al dolor de pecho.
     */
    private int dolorPecho;

    /**
     * Puntos correspondientes a las lesiones graves.
     */
    private int lesionGrave;

    /**
     * Puntos correspondientes a la edad.
     */
    private int edad;

    /**
     * Puntos correspondientes a la fiebre.
     */
    private int fiebre;

    /**
     * Puntos correspondientes a los vómitos.
     */
    private int vomitos;

    /**
     * Puntos correspondientes al dolor abdominal.
     */
    private int dolorAbdominal;

    /**
     * Puntos correspondientes a los signos de shock.
     */
    private int signosDeShock;

    /**
     * Puntos correspondientes a los dolores leves.
     */
    private int doloresLeves;

    /**
     * Puntos correspondientes al sangrado.
     */
    private int sangrado;

    /**
     * Puntos correspondientes a la respiración.
     */
    private String colorTriage;

    /**
     * Puntos correspondientes a la respiración.
     */
    private String colorFinal;

    /**
     * Puntos correspondientes a la respiración.
     */
    private String motivoCambio;

    /**
     * Constructor vacío para crear un objeto Triage.
     */
    public Triage() {
    }

    /**
     * Obtiene el color de triage asignado.
     *
     * @return El color de triage.
     */
    public String getColorTriage() {
        return colorTriage;
    }

    /**
     * Establece el color de triage asignado.
     *
     * @param colorTriage El color de triage a establecer.
     */
    public void setColorTriage(String colorTriage) {
        this.colorTriage = colorTriage;
    }

    /**
     * Obtiene el color de triage final asignado.
     *
     * @return El color de triage final.
     */
    public String getColorFinal() {
        return colorFinal;
    }

    /**
     * Establece el color de triage final asignado.
     *
     * @param colorFinal El color de triage final a establecer.
     */
    public void setColorFinal(String colorFinal) {
        this.colorFinal = colorFinal;
    }

    /**
     * Obtiene el motivo de cambio de triage.
     *
     * @return El motivo de cambio de triage.
     */
    public String getMotivoCambio() {
        return motivoCambio;
    }

    /**
     * Establece el motivo de cambio de triage.
     *
     * @param motivoCambio El motivo de cambio de triage a establecer.
     */
    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }

    /**
     * Mediante el método ´calcularPuntuacion()´ obtiende la cantidad de puntos
     * total, definiendo asi el color parcial.
     *
     * @return resultadoTriage : color parcial del triage.
     */
    public String obtenerColor() {
        //medicoTriage.instanciarTriage();

        int resultadoTriage = calcularPuntuacion();
        if (resultadoTriage == 0) {
            colorTriage = "Azul";
        } else if (resultadoTriage >= 1 && resultadoTriage <= 4) {
            colorTriage = "Verde";
        } else if (resultadoTriage >= 5 && resultadoTriage <= 9) {
            colorTriage = "Amarillo";
        } else if (resultadoTriage >= 10 && resultadoTriage <= 14) {
            colorTriage = "Naranja";
        } else {
            colorTriage = "Rojo";
        }

        return colorTriage;
        // Método a resolver...

        //Este llama a calcularPuntuacion
    }

    /**
     * Suma todos los respectivos puntos de los signos vitales y retorna el
     * resultado.
     *
     * @return puntaje total.
     */
    private int calcularPuntuacion() {
        return respiracion + pulso + estadoMental + conciencia + dolorPecho + lesionGrave + edad + fiebre + vomitos + dolorAbdominal + signosDeShock + doloresLeves + sangrado;
        // Método a resolver...
    }

    /**
     * Establece el puntaje de respiracion del paciente.
     *
     * @param respiracion puntaje correspondiente a la respiracion.
     */
    public void setRespiracion(int respiracion) {
        this.respiracion = respiracion;
    }

    /**
     * Establece el puntaje de pulso del paciente.
     *
     * @param pulso puntaje correspondiente al pulso.
     */
    public void setPulso(int pulso) {
        this.pulso = pulso;
    }

    /**
     * Establece el puntaje del estado mental del paciente.
     *
     * @param estadoMental puntaje correspondiente al estado mental.
     */
    public void setEstadoMental(int estadoMental) {
        this.estadoMental = estadoMental;
    }

    /**
     * Establece el puntaje de conciencia del paciente.
     *
     * @param conciencia puntaje correspondiente a la conciencia.
     */
    public void setConciencia(int conciencia) {
        this.conciencia = conciencia;
    }

    /**
     * Establece el puntaje del dolor de pecho del paciente.
     *
     * @param dolorPecho puntaje correspondiente al dolor de pecho.
     */
    public void setDolorPecho(int dolorPecho) {
        this.dolorPecho = dolorPecho;
    }

    /**
     * Establece el puntaje de lesiones graves del paciente.
     *
     * @param lesionGrave puntaje correspondiente a las lesiones graves.
     */
    public void setLesionGrave(int lesionGrave) {
        this.lesionGrave = lesionGrave;
    }

    /**
     * Establece el puntaje de la edad del paciente.
     *
     * @param edad puntaje correspondiente a la edad.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Establece el puntaje de la fiebre del paciente.
     *
     * @param fiebre puntaje correspondiente a la fiebre.
     */
    public void setFiebre(int fiebre) {
        this.fiebre = fiebre;
    }

    /**
     * Establece el puntaje de vómitos del paciente.
     *
     * @param vomitos puntaje correspondiente a los vómitos.
     */
    public void setVomitos(int vomitos) {
        this.vomitos = vomitos;
    }

    /**
     * Establece el puntaje del dolor abdominal del paciente.
     *
     * @param dolorAbdominal puntaje correspondiente al dolor abdominal.
     */
    public void setDolorAbdominal(int dolorAbdominal) {
        this.dolorAbdominal = dolorAbdominal;
    }

    /**
     * Establece el puntaje de signos de shock del paciente.
     *
     * @param signosDeShock puntaje correspondiente a los signos de shock.
     */
    public void setSignosDeShock(int signosDeShock) {
        this.signosDeShock = signosDeShock;
    }

    /**
     * Establece el puntaje de dolores leves del paciente.
     *
     * @param doloresLeves puntaje correspondiente a los dolores leves.
     */
    public void setDoloresLeves(int doloresLeves) {
        this.doloresLeves = doloresLeves;
    }

    /**
     * Establece el puntaje de sangrado del paciente.
     *
     * @param sangrado puntaje correspondiente al sangrado.
     */
    public void setSangrado(int sangrado) {
        this.sangrado = sangrado;
    }

}
