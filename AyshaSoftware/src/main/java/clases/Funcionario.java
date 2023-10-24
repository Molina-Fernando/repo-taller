package clases;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * La clase Funcionario representa a un individuo que trabaja en una
 * organización y tiene roles y credenciales de acceso.
 */
public class Funcionario extends Persona {

    /**
     * El nombre de usuario del funcionario para acceder al sistema.
     */
    private String usuario;

    /**
     * La contraseña del funcionario para acceder al sistema.
     */
    private String contrasenia;

    /**
     * La lista de roles asociados al funcionario.
     */
    private ArrayList<Rol> roles;

    /**
     * Constructor vacío de la clase Funcionario.
     */
    public Funcionario() {
    }

    /**
     * Constructor de la clase Funcionario que toma información básica y
     * credenciales de acceso.
     *
     * @param nombre El nombre del funcionario.
     * @param apellido El apellido del funcionario.
     * @param fecNacimiento La fecha de nacimiento del funcionario.
     * @param domicilio La dirección de domicilio del funcionario.
     * @param dni El número de identificación (DNI) del funcionario.
     * @param telFijo El número de teléfono fijo del funcionario.
     * @param telCelular El número de teléfono celular del funcionario.
     * @param correoElectronico El correo electrónico del funcionario.
     * @param user El nombre de usuario del funcionario para acceder al sistema.
     * @param password La contraseña del funcionario para acceder al sistema.
     * @param estadoCivil El estado civil del funcionario.
     */
    public Funcionario(String nombre, String apellido, String fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password, String estadoCivil) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, estadoCivil);
        setUsuario(user);
        setContrasenia(password);
    }

    /**
     * Constructor de la clase Funcionario que toma información básica sin
     * credenciales de acceso.
     *
     * @param nombre El nombre del funcionario.
     * @param apellido El apellido del funcionario.
     * @param fecNacimiento La fecha de nacimiento del funcionario.
     * @param domicilio La dirección de domicilio del funcionario.
     * @param dni El número de identificación (DNI) del funcionario.
     * @param telFijo El número de teléfono fijo del funcionario.
     * @param telCelular El número de teléfono celular del funcionario.
     * @param correoElectronico El correo electrónico del funcionario.
     * @param estadoCivil El estado civil del funcionario.
     */
    public Funcionario(String nombre, String apellido, String fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String estadoCivil) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico, estadoCivil);
    }

    /**
     * Asigna un rol al funcionario.
     *
     * @param e El rol que se asignará al funcionario.
     */
    public void setRol(Rol e) {
        this.roles.add(e);
    }

    /**
     * Obtiene la lista de roles asociados al funcionario.
     *
     * @return La lista de roles del funcionario.
     */
    public ArrayList<Rol> getRol() {
        return this.roles;
    }

    /**
     * Elimina un rol específico del funcionario.
     *
     * @param e El rol que se eliminará del funcionario.
     */
    public void borrarRol(Rol e) {
        Iterator<Rol> it = this.roles.iterator();
        while (it.hasNext()) {
            Rol r = it.next();
            if (r.equals(e)) {
                this.roles.remove(r);
            }
        }
    }

    /**
     * Establece el nombre de usuario del funcionario.
     *
     * @param usuario El nombre de usuario para acceder al sistema.
     */
    public final void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Establece la contraseña del funcionario.
     *
     * @param contrasenia La contraseña para acceder al sistema.
     */
    public final void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Genera una representación de cadena del objeto Funcionario, incluyendo su
     * nombre de usuario y roles.
     *
     * @return Una cadena que representa el objeto Funcionario.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Funcionario{");
        sb.append("usuario=").append(usuario);
        sb.append(", contrasenia=").append(contrasenia);
        sb.append(", roles=[");

        Iterator<Rol> iterator = roles.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }

        sb.append("]}");
        return super.toString() + sb.toString();
    }

}
