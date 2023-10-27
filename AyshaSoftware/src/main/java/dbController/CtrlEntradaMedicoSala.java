
package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import clases.Medico;

/**
 * La clase CtrlEntradaMedicoSala se utiliza para controlar la entrada de los médicos a la sala.
 */
public class CtrlEntradaMedicoSala {

    /**
     * Este método se utiliza para obtener una lista de pacientes de la base de datos.
     * Los pacientes se ordenan primero por color (Rojo, Naranja, Amarillo, Verde, Azul) y luego por fecha y hora de manera ascendente.
     *
     * @return Una lista de arreglos de objetos, donde cada arreglo representa un paciente y contiene el nombre del paciente, DNI, color definitivo, fecha, hora y motivo.
     */
    public ArrayList<Object[]> getTablaTriages() {
        ArrayList<Object[]> listaPacientes = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT * FROM ListaEsperaSala ORDER BY CASE ColorDefinitivo WHEN 'Rojo' THEN 1 WHEN 'Naranja' THEN 2 WHEN 'Amarillo' THEN 3 WHEN 'Verde' THEN 4 WHEN 'Azul' THEN 5 END, Fecha ASC, Hora ASC";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[6];
                ob[0] = rs.getString("NombrePac");
                ob[1] = rs.getString("DNI");
                ob[2] = rs.getString("ColorDefinitivo");
                ob[3] = rs.getString("Fecha");
                ob[4] = rs.getString("Hora");
                ob[5] = rs.getString("Motivo");
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
    
    /**
     * Este método recupera una lista de pacientes en la sala que están siendo atendidos por un médico específico.
     *
     * @param matricula La matrícula del médico.
     * @return Una lista de arrays de objetos, donde cada array contiene los detalles de un paciente en la sala.
     *
     * El método realiza las siguientes operaciones:
     * Conecta a la base de datos.
     * Prepara y ejecuta una consulta SQL para seleccionar los detalles de los pacientes en la sala que están siendo atendidos por el médico con la matrícula proporcionada, ordenados por el color del triage.
     * Recupera los resultados de la consulta y los añade a la lista.
     * Cierra la conexión a la base de datos.
     * Devuelve la lista de pacientes en la sala.
     */   
    public ArrayList<Object[]> getTablaPacientesEnSala(int matricula) {
        ArrayList<Object[]> listaPacientesEnBox = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Box, Nombre, DNI, Color, Motivo, Medico FROM PacientesEnSala WHERE Medico = ? ";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setInt(1,matricula);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[5];
                ob[0] = rs.getString("Box");
                ob[1] = rs.getString("Nombre");
                ob[2] = rs.getString("DNI");
                ob[3] = rs.getString("Color");
                ob[4] = rs.getString("Motivo");
                listaPacientesEnBox.add(ob);
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
        return listaPacientesEnBox;
    }

    /**
     * Este método recupera una lista de todos los boxes médicos de la base de datos.
     *
     * @return Una lista de arrays de objetos, donde cada array contiene los detalles de un box médico.
     *
     * El método realiza las siguientes operaciones:
     * Conecta a la base de datos.
     * Prepara y ejecuta una consulta SQL para seleccionar todos los detalles de los boxes.
     * Recupera los resultados de la consulta y los añade a la lista.
     * Cierra la conexión a la base de datos.
     */
    public ArrayList<Object[]> getTablaBoxes() {
        ArrayList<Object[]> listaBoxes = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT * FROM Box";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[5];
                ob[0] = rs.getString("Numero");
                ob[1] = rs.getString("Disponibilidad");
                if (rs.getString("Medico") == null) {
                    ob[2] = " ";
                    ob[3] = " ";
                    ob[4] = " ";
                } else {
                    ob[2] = rs.getString("Medico");
                    ob[3] = rs.getString("Paciente");
                    ob[4] = rs.getString("Motivo");
                }
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
     * Este método se utiliza para ocupar un box en la base de datos.
     * Cambia la disponibilidad a "No Disponible" y actualiza los campos "Medico", "Paciente" y "Motivo" con los valores proporcionados.
     *
     * @param numero El número del box que se va a ocupar.
     * @param matricula La matrícula del médico para actualizar el campo "Medico".
     * @param nombrePac El nombre del paciente para actualizar el campo "Paciente".
     * @param motivo El motivo para actualizar el campo "Motivo".
     */
    public void ocuparBox(String numero,String matricula,String nombrePac,String motivo) {
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Disponibilidad FROM Box WHERE Numero = ?";
            PreparedStatement psq = conex.prepareStatement(query); 
            psq.setString(1, numero);
            ResultSet rs = psq.executeQuery();

            if (rs.next()) {
                String disponibilidadActual = rs.getString("Disponibilidad");
                if ("Disponible".equals(disponibilidadActual)){
                    String update = "UPDATE Box SET Disponibilidad = 'No Disponible', Medico = ?, Paciente = ?, Motivo= ? WHERE Numero = ?;";
                    PreparedStatement psi = conex.prepareStatement(update);
                    psi.setString(1, matricula);
                    psi.setString(2, nombrePac);
                    psi.setString(3, motivo);
                    psi.setString(4, numero);
                    psi.executeUpdate();
                }
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
     * Este método se utiliza para desocupar un box en la base de datos.
     * Cambia la disponibilidad a "Disponible" y borra los datos de los campos "Medico", "Paciente" y "Motivo".
     *
     * @param numero El número del box que se va a desocupar.
     */
    public void desocuparBox(String numero) {
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Disponibilidad FROM Box WHERE Numero = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, numero);
            ResultSet rs = psq.executeQuery();
            if (rs.next()) {
                String disponibilidadActual = rs.getString("Disponibilidad");
                if ("No Disponible".equals(disponibilidadActual)){
                    String update = "UPDATE Box SET Disponibilidad = 'Disponible', Medico = NULL, Paciente = NULL, Motivo= NULL WHERE Numero = ?;";
                    PreparedStatement psi = conex.prepareStatement(update);
                    psi.setString(1, numero);
                    psi.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.err.println("Error SQL en desocuparBox: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "¡Error al desocupar el box! Por favor, revisa los logs para más detalles.");
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
     * Este método elimina un paciente de la lista de espera en la sala.
     *
     * @param dni El DNI del paciente a eliminar.
     *
     * El método realiza las siguientes operaciones:
     * Conecta a la base de datos.
     * Prepara y ejecuta una consulta SQL para eliminar al paciente con el DNI proporcionado de la tabla ListaEsperaSala de la base de datos.
     * Cierra la conexión a la base de datos.
     */
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
    /**
     * Este método elimina un paciente de la sala de pacientes en un box.
     *
     * @param dni El DNI del paciente a eliminar.
     *
     * El método realiza las siguientes operaciones:
     * Conecta a la base de datos.
     * Prepara y ejecuta una consulta SQL para eliminar al paciente con el DNI proporcionado de la tabla PacientesEnSala de la base de datos.
     * Cierra la conexión a la base de datos.
     */    
    public void eliminarPacienteEnBox(String dni) {
        Connection conex = null;
        try {

            conex = Conexion.conectar();
            String deleteQuery = "DELETE FROM PacientesEnSala WHERE DNI = ?";
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
    
    /**
     * Este método recupera un objeto Medico de la base de datos.
     *
     * @param dni El DNI del médico a recuperar.
     * @return Un objeto Medico que contiene los detalles del médico recuperado, o null si no se encuentra ningún médico con el DNI proporcionado.
     *
     * El método realiza las siguientes operaciones:
     * Conecta a la base de datos.
     * Prepara y ejecuta una consulta SQL para seleccionar los detalles del médico con el DNI proporcionado.
     * Recupera los resultados de la consulta y crea un nuevo objeto Medico con estos detalles.
     * Cierra la conexión a la base de datos.
     */    
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
    
    /**
     * Este método recupera el nombre completo de un médico de la base de datos.
     *
     * @param matricula La matrícula del médico.
     * @return El nombre completo del médico, o null si no se encuentra ningún médico con la matrícula proporcionada.
     *
     * El método realiza las siguientes operaciones:
     * Conecta a la base de datos.
     * Prepara y ejecuta una consulta SQL para seleccionar el nombre y apellido del médico con la matrícula proporcionada.
     * Recupera los resultados de la consulta y concatena el nombre y apellido para formar el nombre completo del médico.
     * Cierra la conexión a la base de datos.
     */
    public Object nombreCompletoMedico(int matricula) {
        String nombreCompleto = null;
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Nombre, Apellido FROM Medico WHERE Matricula = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setInt(1, matricula);
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                nombreCompleto = rs.getString("Nombre") + " " + rs.getString("Apellido");
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

        return nombreCompleto;
    }


}
