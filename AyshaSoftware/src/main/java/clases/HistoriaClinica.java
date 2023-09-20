package clases;
import java.util.ArrayList;



public class HistoriaClinica {

    private final ArrayList<Registro> registros;
    private final ArrayList<Estudio> estudios;

    public HistoriaClinica() {
        this.registros = new ArrayList<>();
        this.estudios = new ArrayList<>();
    }

    public void setRegistros(Registro registro) {
       this.registros.add(registro);
    }

    public void setEstudios(Estudio estudio) {
        this.estudios.add(estudio);
    }

    public ArrayList<Registro> getRegistros() {
        return this.registros;
    }

    public ArrayList<Estudio> getEstudios() {
        return this.estudios;
    }
    
   
}