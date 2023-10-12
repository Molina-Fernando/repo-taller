package dbController;

import clases.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CtrlRegistroMedicos {
    
    private String matricula;

    public void setMatricula(String matricula) {
        
        this.matricula = matricula;
    }
    

    public void registrarMedico(
            String nombre,
            String apellido,
            String fechaFormateada,
            String domicilio,
            String dni,
            String telFijo,
            String telCelular,
            String estadoCivil,
            String correoElectronico,
            String matricula
    ) {
        Funcionario func = new Funcionario();
        func.setNombre(nombre);
        func.setApellido(apellido);
        func.setFecNacimiento(fechaFormateada);
        func.setDomicilio(domicilio);
        func.setDni(dni);
        func.setTelFijo(telFijo);
        func.setTelCelular(telCelular);
        func.setEstadoCivil(estadoCivil);
        func.setCorreoElectronico(correoElectronico);

        Connection conex = null;
        try {
            conex = Conexion.conectar();

            String query = "SELECT * FROM Funcionarios WHERE DNI = ?";

            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dni);

            ResultSet rs = psq.executeQuery();

            if (!rs.next()) {

                String insert = "INSERT INTO Funcionarios(Nombre, Apellido, FechaNacimiento, Domicilio, DNI, TelFijo, telCel, EstadoCivil, Mail, Matricula) VALUES(?,?,?,?,?,?,?,?,?,?);";
                
                PreparedStatement psi = conex.prepareStatement(insert);

                psi.setString(1, func.getNombre());
                psi.setString(2, func.getApellido());
                psi.setString(3, func.getFecNacimiento());
                psi.setString(4, func.getDomicilio());
                psi.setString(5, func.getDni());
                psi.setString(6, func.getTelFijo());
                psi.setString(7, func.getTelCelular());
                psi.setString(8, func.getDomicilio());
                psi.setString(9, func.getCorreoElectronico());
                psi.setString(10, matricula);

                psi.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito - Recuerde que un informático deberá validar el usuario para su posterior ingreso al sistema.");

            } else {
                JOptionPane.showMessageDialog(null, "DNI ya registrado");
            }

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

    public static void registrarMedicos(String especialidad, String fecha, String universidad, String dni, String matricula) {
        Connection conex = null;
        try {
            conex = Conexion.conectar();

            String insert = "INSERT INTO AsignacionEspecialidad(DNI, Especialidad, Fecha, Universidad, Matricula) VALUES (?,?,?,?,?)";
            PreparedStatement psi = conex.prepareStatement(insert);
            psi.setString(1, dni);
            psi.setString(2, especialidad);
            psi.setString(3, fecha);
            psi.setString(4, universidad);
            psi.setString(5, matricula);

            psi.executeUpdate();

            // JOptionPane.showMessageDialog(null, "Usuario registrado con éxito - Recuerde que un informático deberá validar el usuario para su posterior ingreso al sistema.");
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

  
    
     public ArrayList cargaComboBoxEspecialidades() {
        
        ArrayList<String> arrayOpciones = new ArrayList<>();
        
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            PreparedStatement psq = conex.prepareStatement("SELECT Nombre FROM Especialidad");
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                arrayOpciones.add(rs.getString("Nombre"));

            }

        } catch (Exception e) {
        }

        return arrayOpciones;
    }

}
