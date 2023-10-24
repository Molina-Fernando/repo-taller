
package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import clases.Medico;


public class CtrlEntradaMedicoSala {

    public ArrayList<Object[]> getTablaTriages(String dniDB, String nomDB) {
        ArrayList<Object[]> listaPacientes = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT NombrePac, DNI, ColorDefinitivo FROM ListaEsperaSala";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[3];
                ob[0] = rs.getString("NombrePac");
                ob[1] = rs.getString("DNI");
                ob[2] = rs.getString("ColorDefinitivo");
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

    public ArrayList<Object[]> getTablaBoxes(String numeroDB, String disponibleDB) {
        ArrayList<Object[]> listaBoxes = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Numero, Disponibilidad FROM Box";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[2];
                ob[0] = rs.getString("Numero");
                ob[1] = rs.getString("Disponibilidad");
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

    /**
     *
     * @param numero
     */
    public void alternarDisponibilidad(String numero) {
        Connection conex = null;
        try {

            conex = Conexion.conectar();

            // Consultar el valor actual de Disponibilidad
            String query = "SELECT Disponibilidad FROM Box WHERE Numero = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, numero);
            ResultSet rs = psq.executeQuery();

            if (rs.next()) {
                String disponibilidadActual = rs.getString("Disponibilidad");
                String nuevaDisponibilidad = "Disponible".equals(disponibilidadActual) ? "No Disponible" : "Disponible";

                // Actualizar el valor de Disponibilidad en la base de datos
                String update = "UPDATE Box SET Disponibilidad = ? WHERE Numero = ?;";
                PreparedStatement psi = conex.prepareStatement(update);
                psi.setString(1, nuevaDisponibilidad);
                psi.setString(2, numero);
                psi.executeUpdate();
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

    public void eliminarPaciente(String dni) {
        Connection conex = null;
        try {

            conex = Conexion.conectar();
            String deleteQuery = "DELETE FROM ListaEsperaSala WHERE DNI = ?";
            PreparedStatement psq = conex.prepareStatement(deleteQuery);
            psq.setString(1, dni);
            psq.executeUpdate();
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
    
    public Medico recuperarMedico(String dni) {
        Medico medico = null;
        Connection conex = null;
        try {

            conex = Conexion.conectar();

            String query = "SELECT * FROM Medico WHERE DNI = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dni);
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                medico = new Medico(
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("FechaNacimiento"),
                        rs.getString("Domicilio"),
                        rs.getString("DNI"),
                        rs.getString("TelFijo"),
                        rs.getString("TelCel"),
                        rs.getString("Mail"),
                        rs.getInt("Matricula"),
                        rs.getString("EstadoCivil")
                );
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

        return medico;
    }

}
