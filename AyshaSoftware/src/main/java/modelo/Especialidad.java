package modelo;

public class Especialidad {

    private String especialidad;
    private InfoEspecialidad info;

    public Especialidad(String especialidad, InfoEspecialidad informacion) {
        this.especialidad = especialidad;
        this.info = informacion;

    }

    @Override
    public String toString() {
        return "Especialidad{" + "especialidad=" + especialidad + '}' + info.toString();
    }

}
