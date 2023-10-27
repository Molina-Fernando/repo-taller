
package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


/**
 * La clase ´CtrlListaTriage´ se encarga de pasar datos de pacientes,
 * eliminarlos de su respectiva tabla de la base de datos y a su vez cargarlo en
 * otra tabla.
 */
public class CtrlListaTriage {

    /**
     * LLena una lista de pacientes con los datos que hay en la base de datos.
     *
     * @return ArrayList con vectores de tipo Object.
     */
    public ArrayList<Object[]> tablaLista() {
        ArrayList<Object[]> arrayListEspera = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();

            String query = "SELECT Nombre, Apellido, DNI FROM ListaTriage";

            PreparedStatement psq = conex.prepareStatement(query);

            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                Object ob[] = new Object[3];
                ob[0] = rs.getString("Nombre");
                ob[1] = rs.getString("Apellido");
                ob[2] = rs.getString("DNI");

                arrayListEspera.add(ob);

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
        return arrayListEspera;
    }

    /**
     * Elimina el paciente de la lista del triage y completa con sus datos la
     * lista de espera de sala mediante la base de datos.
     *
     * @param dni se pasa el DNI del paciente, para poder odentrificarlo en la
     * tabla de la base de datos.
     */
    public void eliminarPacienteEsperaTriage(int dni) {

        String dniInsert = Integer.toString(dni);
        Connection conex = null;

        try {

            conex = Conexion.conectar();

            String query = "SELECT * FROM Paciente WHERE DNI = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dniInsert);
            ResultSet rs = psq.executeQuery();

            if (rs.next()) {

                String insertListaEspera = "INSERT INTO ListaEsperaSala(NombrePac, DNI) VALUES(?,?);";
                PreparedStatement psi1 = conex.prepareStatement(insertListaEspera);
                psi1.setString(1, rs.getString("Nombre"));
                psi1.setString(2, dniInsert);

                psi1.executeUpdate();
            }

            String deleteQuery = "DELETE FROM LISTATRIAGE WHERE DNI = ?";
            PreparedStatement psdq = conex.prepareStatement(deleteQuery);
            psdq.setInt(1, dni);
            psdq.executeUpdate();

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
