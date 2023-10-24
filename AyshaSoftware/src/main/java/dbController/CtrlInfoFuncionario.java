
package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlInfoFuncionario {

    public ArrayList<Object[]> getTablaFuncionario() {
        ArrayList<Object[]> arrayListDeVectores = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT DNI, Nombre, Apellido, telCel, Mail, Sector FROM Funcionario";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                Object ob[] = new Object[6];
                ob[0] = rs.getString("DNI");
                ob[1] = rs.getString("Nombre");
                ob[2] = rs.getString("Apellido");
                ob[3] = rs.getString("telCel");
                ob[4] = rs.getString("Mail");
                ob[5] = rs.getString("Sector");

                arrayListDeVectores.add(ob);
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

        return arrayListDeVectores;
    }
    
    public ArrayList<Object[]> getTablaRoles(int dniDB) {
        ArrayList<Object[]> arrayListDeRoles = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Nombre FROM Rol WHERE id IN (SELECT idRol FROM AsignacionRol WHERE idFuncionario = ?)";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setInt(1, dniDB);

            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                Object ob[] = new Object[2];
                ob[1] = rs.getString("Nombre");
                ob[0] = dniDB;
                arrayListDeRoles.add(ob);
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
        return arrayListDeRoles;
    }

}