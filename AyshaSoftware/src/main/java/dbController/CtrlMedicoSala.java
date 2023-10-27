
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
 * Clase CtrlMedicoSala que controla la sala médica.
 */
public class CtrlMedicoSala {
    private String dni;

    private String numero;

    /**
     * Constructor por defecto de CtrlMedicoSala.
     */
    public CtrlMedicoSala() {
    }

    /**
     * Constructor de CtrlMedicoSala que toma el DNI del paciente.
     *
     * @param dni El DNI del paciente.
     */
    public CtrlMedicoSala(String dni) {
        this.dni = dni;
    }

    /**
     * Constructor de CtrlMedicoSala que toma el DNI del paciente y el número de la sala.
     *
     * @param dni El DNI del paciente.
     * @param numero El número de la sala.
     */
    public CtrlMedicoSala(String dni, String numero) {
        this.dni = dni;
        this.numero = numero;
    }

    /**
     * Obtiene el DNI del paciente.
     *
     * @return El DNI del paciente.
     */
    public String getDni() {
        return dni;
    }

    /**
     * Obtiene el número de la sala.
     *
     * @return El número de la sala.
     */
    public String getNumero() {
        return numero;
    }


    /**
     * Este método se utiliza para obtener el nombre completo de un paciente de la base de datos.
     *
     * @param dni El DNI del paciente.
     * @return El nombre completo del paciente, que es una combinación del nombre y apellido del paciente.
     */
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
    
    /**
     * Este método se utiliza para obtener una lista de registros de la base de datos.
     * Los registros se ordenan por fecha y hora de manera descendente, es decir, los más recientes aparecen primero.
     *
     * @param dni El DNI del paciente.
     * @return Una lista de arreglos de objetos, donde cada arreglo representa un registro y contiene la fecha, la hora, el lugar y el médico del registro.
     */
    public ArrayList<Object[]> getTablaRegistros(String dni) {
        ArrayList<Object[]> listaRegistros = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Fecha, Hora, Lugar, Medico FROM Registro WHERE DNI = ? AND Estado = 'Finalizado' ORDER BY Fecha DESC, Hora DESC ";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dni);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[4];
                ob[0] = rs.getString("Fecha");
                ob[1] = rs.getString("Hora");
                ob[2] = rs.getString("Lugar");
                ob[3] = rs.getString("Medico");
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


    /**
     * Este método se utiliza para obtener una lista de estudios de la base de datos.
     * Los estudios se ordenan de manera que los más recientes aparecen primero.
     *
     * @param dni El DNI del paciente.
     * @return Una lista de arreglos de objetos, donde cada arreglo representa un estudio y contiene la fecha, la hora y el tipo del estudio.
     */
    public ArrayList<Object[]> getTablaEstudios(String dni) {
        ArrayList<Object[]> listaEstudios = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Fecha, Hora, Tipo, Medico FROM Estudio WHERE DNI = ? ORDER BY Fecha DESC, Hora DESC";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dni);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[4];
                ob[0] = rs.getString("Fecha");
                ob[1] = rs.getString("Hora");
                ob[2] = rs.getString("Tipo");
                ob[3] = rs.getString("Medico");
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

    /**
     * Este método selecciona un registro de la base de datos que coincide con la fecha, hora y lugar proporcionados.
     * 
     * @param fecha La fecha del registro que se va a seleccionar.
     * @param hora La hora del registro que se va a seleccionar.
     * @param lugar El lugar del registro que se va a seleccionar.
     * @return El registro seleccionado, o null si no se encontró ningún registro que coincida.
     */
    public Registro seleccionarRegistroTerminado(String fecha, String hora, String lugar) {
        Registro resultado = null;
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT * FROM Registro WHERE Fecha = ? AND Hora = ? AND Lugar = ? AND Estado='Finalizado'";
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
                        Lugares.valueOf(rs.getString("Lugar")),
                        rs.getInt("Medico"));
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
    
    /**
     * Este método verifica si existe un registro con estado 'No Finalizado' para un DNI y matrícula específicos en la base de datos.
     *
     * @param dni El DNI del paciente del registro que se va a verificar.
     * @param matricula La matrícula del médico del registro que se va a verificar.
     * @return Verdadero si existe al menos un registro con estado 'No Finalizado' para el DNI y la matrícula proporcionados, falso en caso contrario.
     */
    public boolean isRegistroPendiente(String dni, int matricula) {
    boolean resultado = false;
    Connection conex = null;
    try {
        conex = Conexion.conectar();
        String query = "SELECT * FROM Registro WHERE DNI = ? AND Medico = ? AND Estado = 'No Finalizado' ";
        PreparedStatement psq = conex.prepareStatement(query);
        psq.setString(1, dni);
        psq.setInt(2, matricula);
        ResultSet rs = psq.executeQuery();
        if (rs.next()) {
            resultado = true;
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

    
    /**
     * Este método selecciona un registro de la base de datos que coincide con el DNI del paciente y la matrícula del médico proporcionados,
     * y cuyo estado es 'No Finalizado'.
     * 
     * @param dni El DNI del paciente del registro que se va a seleccionar.
     * @param matricula La matrícula del médico del registro que se va a seleccionar.
     * @return El registro seleccionado, o null si no se encontró ningún registro que coincida.
     */
    public Registro seleccionarRegistroNoFinalizado(String dni,int matricula) {
        Registro resultado = null;
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT * FROM Registro WHERE DNI = ? AND Medico = ? AND Estado = 'No Finalizado'";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dni);
            psq.setInt(2, matricula);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                resultado = new Registro(rs.getString("DNI"),
                        LocalDate.parse(rs.getString("Fecha"), FormatosValidos.FORMATO_FECHA),
                        LocalTime.parse(rs.getString("Hora"), FormatosValidos.FORMATO_HORA),
                        rs.getString("Diagnostico"),
                        Lugares.valueOf(rs.getString("Lugar")),
                        rs.getInt("Medico"));
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
    /**
     * Este método selecciona un estudio específico de la base de datos.
     *
     * @param fecha La fecha del estudio.
     * @param hora La hora del estudio.
     * @param tipo El tipo de estudio.
     * @return Un objeto Estudio que contiene los detalles del estudio seleccionado, o null si no se encuentra ningún estudio que coincida con los parámetros proporcionados.
     *
     * El método realiza las siguientes operaciones:
     * Conecta a la base de datos.
     * Prepara y ejecuta una consulta SQL para seleccionar los detalles del estudio que coincide con la fecha, la hora, el tipo y el estado proporcionados.
     * Recupera los resultados de la consulta y crea un nuevo objeto Estudio con estos detalles.
     * Cierra la conexión a la base de datos.
     */
    public Estudio seleccionarEstudio(String fecha, String hora, String tipo) {
        Estudio resultado = null;
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT * FROM Estudio WHERE Fecha = ? AND Hora = ? AND Tipo = ?";
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
                        rs.getString("Resultado"),
                        rs.getInt("Medico"));
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


    /**
     * Este método se utiliza para cargar un registro en la base de datos.
     *
     * @param registro Un objeto Registro que contiene los detalles del registro a cargar.
     */
    public void cargarRegistro(Registro registro) {
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "INSERT INTO Registro(DNI, Fecha, Hora, Diagnostico, Lugar, Medico, Estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, registro.getDni());
            psq.setString(2, registro.getFecha().format(FormatosValidos.FORMATO_FECHA));
            psq.setString(3, registro.getHora().format(FormatosValidos.FORMATO_HORA));
            psq.setString(4, registro.getDiagnostico());
            psq.setString(5, registro.getLugares().toString());
            psq.setInt(6, registro.getMedico());
            psq.setString(7, "No Finalizado");
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
     * Este método se utiliza para cargar un estudio en la base de datos.
     *
     * @param estudio Un objeto Estudio que contiene los detalles del estudio a cargar.
     */
    public void cargarEstudio(Estudio estudio) {
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "INSERT INTO Estudio(DNI, Fecha, Hora, Tipo, Resultado, Medico) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, estudio.getDni());
            psq.setString(2, estudio.getFecha().format(FormatosValidos.FORMATO_FECHA));
            psq.setString(3, estudio.getHora().format(FormatosValidos.FORMATO_HORA));
            psq.setString(4, estudio.getTipo());
            psq.setString(5, estudio.getResultado());
            psq.setString(6, String.valueOf(estudio.getMedico()));
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
     * Este método recupera el nombre completo de un médico de la base de datos usando su matrícula.
     * 
     * @param matricula La matrícula del médico cuyo nombre completo se va a recuperar.
     * @return El nombre completo del médico, o null si no se encontró ningún médico con esa matrícula.
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
    
    /**
     * Este método actualiza un registro en la base de datos.
     *
     * @param registro El objeto Registro que contiene los detalles del registro a actualizar.
     *
     * El método realiza las siguientes operaciones:
     * Conecta a la base de datos.
     * Prepara y ejecuta una consulta SQL para actualizar los detalles del registro en la base de datos.
     * Cierra la conexión a la base de datos.
     */
    public void actualizarRegistro(Registro registro) {
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "UPDATE Registro SET Fecha = ?, Hora = ?, Diagnostico = ? WHERE DNI = ? AND Medico = ? AND Estado = 'No Finalizado'";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, registro.getFecha().format(FormatosValidos.FORMATO_FECHA));
            psq.setString(2, registro.getHora().format(FormatosValidos.FORMATO_HORA));
            psq.setString(3, registro.getDiagnostico());
            psq.setString(4, registro.getDni());
            psq.setInt(5, registro.getMedico());
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
     * Este método guarda los datos de un paciente, un médico y un box en la base de datos.
     *
     * @param datos Un array de objetos que contiene los detalles del paciente, el médico y el box.
     *
     * El método realiza las siguientes operaciones:
     * Conecta a la base de datos.
     * Prepara y ejecuta una consulta SQL para insertar los detalles proporcionados en la tabla PacientesEnSala de la base de datos.
     * Cierra la conexión a la base de datos.
     */
    public void guardarDatosPacienteMedicoBox(Object[] datos) {
                Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "INSERT INTO PacientesEnSala(Box, Nombre, DNI, Color, Motivo, Medico) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, (String) datos[0]);
            psq.setString(2, (String) datos[1]);
            psq.setString(3, (String) datos[2]);
            psq.setString(4, (String) datos[3]);
            psq.setString(5, datos[4].toString());
            psq.setInt(6, (Integer) datos[5]);
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
     * Este método se utiliza para finalizar la carga de un registro en la base de datos.
     * Actualiza el estado del registro a 'Finalizado' donde el DNI y el número de matrícula del médico coinciden, y el estado es 'No Finalizado'.
     *
     * @param registro El objeto Registro que contiene los detalles del registro que se va a actualizar. 
     * Este objeto debe contener el DNI del paciente y la matrícula del médico.
     */
    public void finalizarCargaRegistro(Registro registro) {
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "UPDATE Registro SET Estado = ? WHERE DNI = ? AND Medico = ? AND Estado = 'No Finalizado'";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, "Finalizado");
            psq.setString(2, registro.getDni());
            psq.setInt(3, registro.getMedico());
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
