package clases;
import ventanas.MedicoTriage;
/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
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
    MedicoTriage medicoTriage = new MedicoTriage();
    
    public Triage(){}

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
        if (resultadoTriage == 0){
            colorTriage = "Azul";
        } else if(resultadoTriage >=1 && resultadoTriage <= 4){
            colorTriage = "Verde";
        } else if(resultadoTriage >= 5 && resultadoTriage <= 9){
            colorTriage = "Amarillo";
        } else if(resultadoTriage >= 10 && resultadoTriage <=14){
            colorTriage = "Naranja";
        } else{
            colorTriage = "Rojo";
        }
        
        return colorTriage;
        // Método a resolver...
        
    }

    private int calcularPuntuacion() {
        return respiracion + pulso + estadoMental + conciencia + dolorPecho + lesionGrave + edad + fiebre + vomitos + dolorAbdominal + signosDeShock + doloresLeves + sangrado;
        // Método a resolver...
    }

}