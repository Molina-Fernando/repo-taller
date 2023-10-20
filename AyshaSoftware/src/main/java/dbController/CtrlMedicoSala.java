/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbController;

import clases.Estudio;
import Utilidades.FormatosValidos;
import clases.Lugares;
import clases.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author joaqu
 */
public class CtrlMedicoSala {

    private final String dni;
    private String numero;

    public CtrlMedicoSala(String dni) {
        this.dni = dni;
    }

    public CtrlMedicoSala(String dni, String numero) {
        this.dni = dni;
        this.numero = numero;
    }

    public String getDni() {
        return dni;
    }

    public String getNumero() {
        return numero;
    }

    public String nombreCompleto(String dni) {
        String nombreC = "";
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Nombre, Apellido FROM Paciente WHERE DNI = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dni);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[2];
                ob[0] = rs.getString("Nombre");
                ob[1] = rs.getString("Apellido");
                nombreC = ob[0] + " " + ob[1];
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
        return nombreC;
    }

    public ArrayList<Object[]> getTablaRegistros(String fecha, String hora, String tipo) {
        ArrayList<Object[]> listaRegistros = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Fecha, Hora, Lugar FROM Registro WHERE DNI = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dni);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[3];
                ob[0] = rs.getString("Fecha");
                ob[1] = rs.getString("Hora");
                ob[2] = rs.getString("Lugar");
                listaRegistros.add(ob);
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
        return listaRegistros;
    }

    public ArrayList<Object[]> getTablaEstudios(String fecha, String hora, String lugar) {
        ArrayList<Object[]> listaEstudios = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Fecha, Hora, Tipo FROM Estudio WHERE DNI = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dni);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[3];
                ob[0] = rs.getString("Fecha");
                ob[1] = rs.getString("Hora");
                ob[2] = rs.getString("Tipo");
                listaEstudios.add(ob);
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
        return listaEstudios;
    }

    public Registro seleccionarRegistro(String fecha, String hora, String lugar) {
        Registro resultado = null;
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT DNI, Fecha, Hora, Diagnostico, Lugar FROM Registro WHERE Fecha = ? AND Hora = ? AND Lugar = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, fecha);
            psq.setString(2, hora);
            psq.setString(3, lugar);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                resultado = new Registro(rs.getString("DNI"),
                        LocalDate.parse(rs.getString("Fecha"), FormatosValidos.FORMATO_FECHA),
                        LocalTime.parse(rs.getString("Hora"), FormatosValidos.FORMATO_HORA),
                        rs.getString("Diagnostico"),
                        Lugares.valueOf(rs.getString("Lugar")));
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
        return resultado;
    }

    public Estudio seleccionarEstudio(String fecha, String hora, String tipo) {
        Estudio resultado = null;
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT DNI, Fecha, Hora, Tipo, Resultado FROM Estudio WHERE Fecha = ? AND Hora = ? AND Tipo = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, fecha);
            psq.setString(2, hora);
            psq.setString(3, tipo);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                resultado = new Estudio(rs.getString("DNI"),
                        LocalDate.parse(rs.getString("Fecha"), FormatosValidos.FORMATO_FECHA),
                        LocalTime.parse(rs.getString("Hora"), FormatosValidos.FORMATO_HORA),
                        rs.getString("Tipo"),
                        rs.getString("Resultado"));
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
        return resultado;
    }

    public void cargarRegistro(Registro registro) {
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "INSERT INTO Registro(DNI, Fecha, Hora, Diagnostico, Lugar) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, registro.getDni());
            psq.setString(2, registro.getFecha().format(FormatosValidos.FORMATO_FECHA));
            psq.setString(3, registro.getHora().format(FormatosValidos.FORMATO_HORA));
            psq.setString(4, registro.getDiagnostico());
            psq.setString(5, registro.getLugares().toString());
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

    public void cargarEstudio(Estudio estudio) {
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "INSERT INTO Estudio(DNI, Fecha, Hora, Tipo, Resultado) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, estudio.getDni());
            psq.setString(2, estudio.getFecha().format(FormatosValidos.FORMATO_FECHA));
            psq.setString(3, estudio.getHora().format(FormatosValidos.FORMATO_HORA));
            psq.setString(4, estudio.getTipo());
            psq.setString(5, estudio.getResultado());
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

}
