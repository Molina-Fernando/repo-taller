package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CtrlRegistroMedicos {

    public static void registrarMedicos(String especialidad, String fecha, String universidad, String dni, String matricula) {
        Connection conex = null;
        try {
            conex = Conexion.conectar();

            String insert = "INSERT INTO Especialidades(DNI, Especialidad, Fecha, Universidad, Matricula) VALUES (?,?,?,?,?)";
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

}
