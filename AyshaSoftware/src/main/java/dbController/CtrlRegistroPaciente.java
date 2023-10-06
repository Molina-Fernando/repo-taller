package dbController;

import clases.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CtrlRegistroPaciente {

    public static void registrarPacientes(String nombre,
            String apellido,
            String domicilio,
            String fechaFormateada,
            String dni,
            String correo,
            String estadoCivil,
            String telCelular,
            String telFijo,
            String personaContacto) {

        Paciente pac = new Paciente();
        pac.setNombre(nombre);
        pac.setApellido(apellido);
        pac.setDomicilio(domicilio);
        pac.setFecNacimiento(fechaFormateada);
        pac.setDni(dni);
        pac.setCorreoElectronico(correo);
        pac.setEstadoCivil(estadoCivil);
        pac.setTelCelular(telCelular);
        pac.setTelFijo(telFijo);
        pac.setPersonaContacto(personaContacto);

        Connection conex = null;
        try {
            conex = Conexion.conectar();
            
            String insertPaciente = "INSERT INTO Pacientes(Nombre, Apellido, FechaNacimiento, Domicilio, DNI, TelFijo, telCel, EstadoCivil, Mail, personaContacto) VALUES(?,?,?,?,?,?,?,?,?,?);";
            String insertLista = "INSERT INTO ListaTriage(Nombre, Apellido, DNI) VALUES(?,?,?);";

            PreparedStatement psi1 = conex.prepareStatement(insertLista);
            PreparedStatement psi = conex.prepareStatement(insertPaciente);
            psi1.setString(1, pac.getNombre());
            psi1.setString(2, pac.getApellido());
            psi1.setString(3, pac.getDni());

            psi.setString(1, pac.getNombre());
            psi.setString(2, pac.getApellido());
            psi.setString(3, pac.getFecNacimiento());
            psi.setString(4, pac.getDomicilio());
            psi.setString(5, pac.getDni());
            psi.setString(6, pac.getTelFijo());
            psi.setString(7, pac.getTelCelular());
            psi.setString(8, pac.getEstadoCivil());
            psi.setString(9, pac.getCorreoElectronico());
            psi.setString(10, pac.getPersonaContacto());

            psi.executeUpdate();
            psi1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Paciente registrado con éxito.");
        } catch (SQLException e) {
            System.out.println("EXCEP SQL" + e);
            JOptionPane.showMessageDialog(null, "¡Error! Contacte al administrador");
        } finally {
            try {
                if (conex != null) {
                    conex.close();
                }
            } catch (SQLException excSql) {
                System.err.println("ERROR SQL" + excSql);
            }
        }
    }
}
