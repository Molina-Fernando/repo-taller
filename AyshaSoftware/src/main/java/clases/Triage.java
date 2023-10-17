package clases;



public class Triage {

    private int respiracion;
    private int pulso;
    private int estadoMental;
    private int conciencia;
    private int dolorPecho;
    private int lesionGrave;
    private int edad;
    private int fiebre;
    private int vomitos;
    private int dolorAbdominal;
    private int signosDeShock;
    private int doloresLeves;
    private int sangrado;
    private String colorTriage;
    private String colorFinal;
    private String motivoCambio;


    public Triage() {
    }

    public Triage(int respiracion, int pulso, int estadoMental, int conciencia, int dolorPecho, int lesionGrave, int edad, int fiebre, int vomitos, int dolorAbdominal, int signosDeShock, int doloresLeves, int sangrado) {
        this.respiracion = respiracion;
        this.pulso = pulso;
        this.estadoMental = estadoMental;
        this.conciencia = conciencia;
        this.dolorPecho = dolorPecho;
        this.lesionGrave = lesionGrave;
        this.edad = edad;
        this.fiebre = fiebre;
        this.vomitos = vomitos;
        this.dolorAbdominal = dolorAbdominal;
        this.signosDeShock = signosDeShock;
        this.doloresLeves = doloresLeves;
        this.sangrado = sangrado;
    }

    public String getColorTriage() {
        return colorTriage;
    }

    public void setColorTriage(String colorTriage) {
        this.colorTriage = colorTriage;
    }

    public String getColorFinal() {
        return colorFinal;
    }

    public void setColorFinal(String colorFinal) {
        this.colorFinal = colorFinal;
    }

    public String getMotivoCambio() {
        return motivoCambio;
    }

    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }

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

    private int calcularPuntuacion() {
        return respiracion + pulso + estadoMental + conciencia + dolorPecho + lesionGrave + edad + fiebre + vomitos + dolorAbdominal + signosDeShock + doloresLeves + sangrado;
        // Método a resolver...
    }

    public void setRespiracion(int respiracion) {
        this.respiracion = respiracion;
    }

    public void setPulso(int pulso) {
        this.pulso = pulso;
    }

    public void setEstadoMental(int estadoMental) {
        this.estadoMental = estadoMental;
    }

    public void setConciencia(int conciencia) {
        this.conciencia = conciencia;
    }

    public void setDolorPecho(int dolorPecho) {
        this.dolorPecho = dolorPecho;
    }

    public void setLesionGrave(int lesionGrave) {
        this.lesionGrave = lesionGrave;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFiebre(int fiebre) {
        this.fiebre = fiebre;
    }

    public void setVomitos(int vomitos) {
        this.vomitos = vomitos;
    }

    public void setDolorAbdominal(int dolorAbdominal) {
        this.dolorAbdominal = dolorAbdominal;
    }

    public void setSignosDeShock(int signosDeShock) {
        this.signosDeShock = signosDeShock;
    }

    public void setDoloresLeves(int doloresLeves) {
        this.doloresLeves = doloresLeves;
    }

    public void setSangrado(int sangrado) {
        this.sangrado = sangrado;
    }
    
    

}
