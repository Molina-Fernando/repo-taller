package clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Administrativo extends Funcionario {

    private ArrayList<Sector> sectores;

    public Administrativo(String nombre, String apellido, LocalDate fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, user, password);
    }

    public void setSectores(Sector e) {
        this.sectores.add(e);
    }

}
