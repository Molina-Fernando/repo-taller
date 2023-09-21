package clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Funcionario extends Persona {

    private String usuario;
    private String contrasenia;
    private ArrayList<Rol> roles;

    public Funcionario() {
    }

    public Funcionario(String nombre, String apellido, LocalDate fecNacimiento, String domicilio, String dni, String telFijo, String telCelular, String correoElectronico, String user, String password) {
        super(nombre, apellido, fecNacimiento, domicilio, dni, telFijo, telCelular, correoElectronico);
        setUsuario(usuario);
        setContrasenia(contrasenia);
    }

    public void setRoles(Rol e) {
        this.roles.add(e);
    }

    public ArrayList<Rol> getRol() {
        return this.roles;
    }

    public void borrarRol(Rol e) {
        Iterator<Rol> it = this.roles.iterator();
        while (it.hasNext()) {
            Rol r = it.next();
            if (r.equals(e)) {
                this.roles.remove(r);
            }
        }
    }

    public final void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public final void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

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
