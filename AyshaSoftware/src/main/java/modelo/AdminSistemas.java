package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class AdminSistemas extends Funcionario {

    ArrayList<Rol> roles;

    public AdminSistemas(String nombre, String apellido, LocalDate fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, user, password);
    }

    public void asignarRol(Funcionario funcionario1, Rol rol) {
        funcionario1.setRoles(rol);
    }

    @Override
    public String toString() {
        return super.toString() + "AdminSistemas{" + "roles=" + roles + '}';
    }

}
