package dbController;

import clases.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlRegistroMedicos {


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

                String insert = "INSERT INTO Funcionarios(Nombre, Apellido, FechaNacimiento, Domicilio, DNI, TelFijo, telCel, EstadoCivil, Mail) VALUES(?,?,?,?,?,?,?,?,?);";
                String insertMed = "INSERT INTO Medicos(Nombre, Apellido, DNI, Matricula, telCel, Mail, FechaNac, Domicilio, TelFijo, EstadoCivil) VALUES(?,?,?,?,?, ?, ?, ?, ?, ?);";
                PreparedStatement psi = conex.prepareStatement(insert);
                PreparedStatement psi1 = conex.prepareStatement(insertMed);

                psi.setString(1, func.getNombre());
                psi.setString(2, func.getApellido());
                psi.setString(3, func.getFecNacimiento());
                psi.setString(4, func.getDomicilio());
                psi.setString(5, func.getDni());
                psi.setString(6, func.getTelFijo());
                psi.setString(7, func.getTelCelular());
                psi.setString(8, func.getEstadoCivil());
                psi.setString(9, func.getCorreoElectronico());

                psi1.setString(1, func.getNombre());
                psi1.setString(2, func.getApellido());
                psi1.setString(3, func.getDni());
                psi1.setString(4, matricula);
                psi1.setString(5, func.getTelCelular());
                psi1.setString(6, func.getCorreoElectronico());
                psi1.setString(7, func.getFecNacimiento());
                psi1.setString(8, func.getDomicilio());
                psi1.setString(9, func.getTelFijo());
                psi1.setString(10, func.getEstadoCivil());

                psi.executeUpdate();
                psi1.executeUpdate();
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

        } catch (SQLException e) {
        }

        return arrayOpciones;
    }
    public void asignarEspecialidades(ArrayList<String> arrayEspecialidades, ArrayList<String> arrayFechas, ArrayList<String> arrayUniversidades, String matricula, int dni) {
        Connection conex = null;

        try {
            conex = Conexion.conectar();
            PreparedStatement psq = conex.prepareStatement("SELECT ID FROM Especialidad WHERE Nombre = ?");
            PreparedStatement insercionEspecialidades = conex.prepareStatement("INSERT INTO AsignacionEspecialidad(DNI, idEspecialidad, Fecha, Universidad, Matricula) VALUES (?,?,?,?,?)");
            int i = 0;
            for (String especialidad : arrayEspecialidades) {
  
                
                psq.setString(1, especialidad);
                ResultSet rs = psq.executeQuery();

                if (rs.next()) {
                   
                    int idEspecialidad = rs.getInt("ID");
                    insercionEspecialidades.setInt(1, dni);
                    insercionEspecialidades.setInt(2, idEspecialidad);
                    insercionEspecialidades.setString(3, arrayFechas.get(i));
                    insercionEspecialidades.setString(4, arrayUniversidades.get(i));
                    insercionEspecialidades.setInt(5, Integer.parseInt(matricula));
                    insercionEspecialidades.executeUpdate();
                    i++;
                    //arrayIDS.add(idRol);
                }
            }
            arrayEspecialidades.clear();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error! Contacte al administrador");
        } finally {
            // Cierra la conexión
            if (conex != null) {
                try {
                    conex.close();
                } catch (SQLException e) {
                    System.err.println("ERROR SQL" + e);
                }
            }
        }

        //return arrayIDS;
    }

}
