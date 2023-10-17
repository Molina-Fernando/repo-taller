package clases;

//import java.time.LocalDate;
//import java.time.LocalTime;
public class Consulta {

    private String resultadoTriage;
    private String triageDefinitivo;
    private String fecha;
    private String hora;
    private String motivo;
    private Medico medico;

    private Paciente paciente;
    private Box box;
    private Triage triage;
    private Registro registro;

    public Consulta(Paciente paciente, String motivo) {
        this.paciente = paciente;
        this.motivo = motivo;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    

    public String getResultadoTriage() {
        return resultadoTriage;
    }

    public void setResultadoTriage(String resultadoTriage) {
        this.resultadoTriage = resultadoTriage;
    }

    public String getTriageDefinitivo() {
        return triageDefinitivo;
    }

    public void setTriageDefinitivo(String triageDefinitivo) {
        this.triageDefinitivo = triageDefinitivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Triage getTriage() {
        return triage;
    }

    public void setTriage(Triage triage) {
        this.triage = triage;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public Box getBox() {
        return box;
    }

    //El atributo box es el último en instanciarse o guardarse dentro de la lógica de la relacion box-datos-consulta
    public void setBox(Box box) {
        this.box = box;
    }

}
