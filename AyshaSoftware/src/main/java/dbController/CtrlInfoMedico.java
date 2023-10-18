/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeremías Simian
 */
public class CtrlInfoMedico {

    public ArrayList<Object[]> getTablaMedicos() {
        ArrayList<Object[]> arrayListDeVectores = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT DNI, Nombre, Apellido, Matricula, TelCel, Mail FROM Medico";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                Object ob[] = new Object[6];
                ob[0] = rs.getString("DNI");
                ob[1] = rs.getString("Nombre");
                ob[2] = rs.getString("Apellido");
                ob[3] = rs.getString("TelCel");
                ob[4] = rs.getString("Mail");
                ob[5] = rs.getString("Matricula");

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

    public ArrayList<Object[]> getTablaEspecialidades(int dniDB) {
        ArrayList<Object[]> arrayListDeRoles = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT * FROM AsignacionEspecialidad WHERE DNI = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setInt(1, dniDB);
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {

                String consulta = "SELECT Nombre FROM Especialidad WHERE ID = ?";
                PreparedStatement psc = conex.prepareStatement(consulta);
                psc.setInt(1, rs.getInt(2));
                ResultSet rsc = psc.executeQuery();

                Object ob[] = new Object[4];
                ob[0] = rs.getString(5);
                ob[1] = rsc.getString("Nombre");
                ob[2] = rs.getString(4);
                ob[3] = rs.getString(3);
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
