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
 * @author joaqu
 */
public class CtrlEntradaMedicoSala {
    
        public ArrayList<Object[]> getTablaTriages(int dniDB, String nomDB) {
        ArrayList<Object[]> listaPacientes = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT NombrePac, DNI, ColorDefinitivo FROM Triages";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                Object ob[] = new Object[3];
                ob[0] = rs.getString("NombrePac");
                ob[1] = rs.getString("DNI");
                ob[2] = rs.getString("ColorDefinitivo");
                System.out.println(ob[0]);
                System.out.println(ob[1]);
                System.out.println(ob[2]);
                listaPacientes.add(ob);
                
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

        return listaPacientes;
    }
        
    
        public ArrayList<Object[]> getTablaBoxes(String numeroDB, Boolean disponibleDB) {
        ArrayList<Object[]> listaBoxes = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Numero, Disponibilidad FROM Boxes";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                Object ob[] = new Object[2];
                ob[0] = rs.getString("Numero");
                ob[1] = rs.getString("Disponibilidad");
                System.out.println(ob[0]);
                System.out.println(ob[1]);
                listaBoxes.add(ob);
                
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

        return listaBoxes;
    }
    
}
