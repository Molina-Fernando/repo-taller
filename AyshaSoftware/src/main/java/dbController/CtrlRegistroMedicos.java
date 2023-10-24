package dbController;

import clases.Funcionario;
import clases.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * La clase ´CtrRegistroMedicos´ se encarga de cargar los datos de cada médico a
 * la base de datos, que dicha información se recupera mediante la ventana
 * llamada ´RegistroMedicos´.
 */
public class CtrlRegistroMedicos {

    /**
     * Carga los datos del médico en la base de datos, tanto en la tabla de
     * Medico como en la de Funcionario.
     *
     * @param func : objeto Funcionario.
     * @param med : objeto Medico.
     * @throws SQLExeption Si ocurre un error en la interacción con la base de
     * datos.
     */
    public void registrarMedico(Funcionario func, Medico med) {

        Connection conex = null;
        try {
            conex = Conexion.conectar();

            String query = "SELECT * FROM Funcionario WHERE DNI = ?";

            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, func.getDni());

            ResultSet rs = psq.executeQuery();

            if (!rs.next()) {

                String insert = "INSERT INTO Funcionario(Nombre, Apellido, FechaNacimiento, Domicilio, DNI, TelFijo, telCel, EstadoCivil, Mail) VALUES(?,?,?,?,?,?,?,?,?);";
                String insertMed = "INSERT INTO Medico(Nombre, Apellido, DNI, Matricula, telCel, Mail, FechaNacimiento, Domicilio, TelFijo, EstadoCivil) VALUES(?,?,?,?,?, ?, ?, ?, ?, ?);";
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

                psi1.setString(1, med.getNombre());
                psi1.setString(2, med.getApellido());
                psi1.setString(3, med.getDni());
                psi1.setInt(4, med.getNumMatricula());
                psi1.setString(5, med.getTelCelular());
                psi1.setString(6, med.getCorreoElectronico());
                psi1.setString(7, med.getFecNacimiento());
                psi1.setString(8, med.getDomicilio());
                psi1.setString(9, med.getTelFijo());
                psi1.setString(10, med.getEstadoCivil());

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

    /**
     * Carga la lista mediante los datos cargados en la base de datos en la
     * tabla Especialidad.
     *
     * @return : lista de nombres de especialidades.
     */
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

    /**
     * LLena la tabla AsignacionEspecialidad de la base de datos, tomando los
     * datos de las listas y de la tabla Especialidad.
     *
     * @param arrayEspecialidades : lista con los nombres de las especialidades
     * que tiene el médico.
     * @param arrayFechas : lista con las fechas en las que obtuvo el o los
     * títulos cada médico.
     * @param arrayUniversidades : lista con los nombres de las universidades en
     * las que obtuvo cada título.
     * @param matricula : numero de matrícula del médico.
     * @param dni : DNI del médico.
     */
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

    }

}
