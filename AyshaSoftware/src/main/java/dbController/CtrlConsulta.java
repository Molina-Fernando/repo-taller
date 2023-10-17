package dbController;

import clases.Box;
import clases.Consulta;
import clases.Medico;
import clases.Paciente;

public class CtrlConsulta {

    private Consulta consulta;
    private String nombreMedico;

    public CtrlConsulta(Paciente pac, String motivo) {
        consulta = new Consulta(pac, motivo);
    }

    public void agregarMedico(Medico medico) {
        nombreMedico = medico.getNombre();
        
        consulta.setMedico(medico);
    }

    public void agregarFecha(String fecha) {
        consulta.setFecha(fecha);
    }

    public void agregarHora(String hora) {
        consulta.setHora(hora);
    }

    public void agregarColorParcial(String colorParcial) {
        consulta.setResultadoTriage(colorParcial);
    }

    public void agregarColorDefinitivo(String colorDefinitivo) {
        consulta.setTriageDefinitivo(colorDefinitivo);
    }
    
    public void agregarBox(Box box){
        consulta.setBox(box);
        
        Medico t = consulta.getMedico();
        String nombreMedicoo = t.getNombre();
        
    }
    
    
    

}
