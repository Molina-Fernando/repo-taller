package clases;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La clase AdminSistemas representa a un administrador de sistemas, que es un tipo de funcionario.
 */

public class AdminSistemas extends Funcionario {
    
    /**
     * Lista de roles asignados al administrador de sistemas.
     */

    ArrayList<Rol> roles;
    
    /**
     * Constructor para crear un objeto AdminSistemas con información básica.
     *
     * @param nombre           El nombre del administrador de sistemas.
     * @param apellido         El apellido del administrador de sistemas.
     * @param fecNacimiento    La fecha de nacimiento del administrador de sistemas.
     * @param domicilio        La dirección de domicilio del administrador de sistemas.
     * @param dni              El número de identificación (DNI) del administrador de sistemas.
     * @param telFijo          El número de teléfono fijo del administrador de sistemas.
     * @param telCelular       El número de teléfono celular del administrador de sistemas.
     * @param correoElectronico El correo electrónico del administrador de sistemas.
     * @param user             El nombre de usuario del administrador de sistemas.
     * @param password         La contraseña del administrador de sistemas.
     * @param estadoCivil      El estado civil del administrador de sistemas.
     */
    

    public AdminSistemas(String nombre, String apellido, String fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password, String estadoCivil) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, user, password, estadoCivil);
    }
    
     /**
     * Constructor vacío de la clase AdminSistemas.
     */

    public AdminSistemas(){
        
    }
    
    /**
     * Asigna un rol a un funcionario, incluyendo al administrador de sistemas.
     *
     * @param funcionario1 El funcionario al que se le asignará el rol.
     * @param rol El rol que se asignará al funcionario.
     */
    
    public void asignarRol(Funcionario funcionario1, Rol rol) {
        funcionario1.setRol(rol);
    }

    @Override
    public String toString() {
        return super.toString() + "AdminSistemas{" + "roles=" + roles + '}';
    }

}
