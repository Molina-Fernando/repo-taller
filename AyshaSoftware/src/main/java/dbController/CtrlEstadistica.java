package dbController;

import Utilidades.FormatosValidos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
 * La clase `CtrlEstadistica` proporciona métodos para obtener estadísticas
 * relacionadas con médicos y pacientes en la base de datos.
 */
public class CtrlEstadistica {

    /**
     * Este método se utiliza para obtener una lista de médicos de una base de
     * datos.
     *
     * @return ArrayList(Object[]) - Devuelve una lista de objetos, donde cada
     * objeto es un array que contiene el nombre, apellido y matrícula de un
     * médico.
     */
    public ArrayList<Object[]> getTablaMedicos() {
        ArrayList<Object[]> listaMedicos = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Nombre, Apellido, Matricula FROM Medico";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[3];
                ob[0] = rs.getString("Nombre");
                ob[1] = rs.getString("Apellido");
                ob[2] = rs.getString("Matricula");
                listaMedicos.add(ob);
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
        return listaMedicos;
    }

    /**
     * Este método devuelve un vector de dos posiciones, donde la primera
     * posición es la matrícula del médico y la segunda posición es la cantidad
     * de veces que esa matrícula aparece en el ArrayList.
     *
     * @param desdeT La fecha de inicio del rango de tiempo.
     * @param hastaT La fecha de fin del rango de tiempo.
     * @return Un vector de dos posiciones. La primera posición es la matrícula
     * que aparece más veces y la segunda posición es cuántas veces aparece.
     */
    public int[] medicoQueMasAtendioEntre(String desdeT, String hastaT) {
        ArrayList<String> listaMatriculas = new ArrayList<>();
        Connection conex = null;
        int[] vector = new int[2];
        try {
            conex = Conexion.conectar();
            String query = "SELECT Matricula FROM Consulta WHERE Fecha BETWEEN ? AND ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, desdeT);
            psq.setString(2, hastaT);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                listaMatriculas.add(rs.getString("Matricula"));
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

        int maxCount = 0;
        String maxMatricula = null;
        for (String matricula1 : listaMatriculas) {
            int count = 0;
            for (String matricula2 : listaMatriculas) {
                if (matricula1.equals(matricula2)) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                maxMatricula = matricula1;
            }
        }

        if (maxMatricula != null) {
            vector[0] = Integer.parseInt(maxMatricula);
            vector[1] = maxCount;
        }

        return vector;
    }

    /**
     * Obtiene el nombre completo de un médico a partir de su matrícula.
     *
     * @param matricula La matrícula del médico cuyo nombre se desea obtener.
     * @return El nombre completo del médico en formato "Nombre Apellido". Si no
     * se encuentra un médico con la matrícula dada, retorna null.
     */
    public String obtenerNombreCompletoMedico(int matricula) {
        String nombre = null;
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Nombre,Apellido FROM Medico WHERE matricula = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, String.valueOf(matricula));
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                nombre = rs.getString("Nombre") + " " + rs.getString("Apellido");
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
        return nombre;
    }

    /**
     * Obtiene la cantidad de pacientes atendidos por un médico en un rango de
     * fechas dado.
     *
     * @param m Matrícula del médico.
     * @param d Fecha de inicio del rango.
     * @param h Fecha de fin del rango.
     * @return La cantidad de pacientes atendidos por el médico en el rango de
     * fechas.
     */
    public String obtenerCantidadPacientesMedicoFecha(String m, String d, String h) {
        String cantidad;
        Connection conex = null;
        int ac = 0;
        try {
            conex = Conexion.conectar();
            String query = "SELECT * FROM Consulta WHERE Matricula =? AND Fecha BETWEEN ? AND ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, m);
            psq.setString(2, d);
            psq.setString(3, h);
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                ac++;
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
        cantidad = String.valueOf(ac);
        return cantidad;
    }

    /**
     * Obtiene una lista de pacientes que han tenido consultas en un rango de
     * fechas y cumplan con ciertos criterios de edad.
     *
     * @param d Fecha de inicio del rango.
     * @param h Fecha de fin del rango.
     * @param b Edad mínima.
     * @param l Edad máxima.
     * @return Una lista de pacientes que cumplen con los criterios de edad.
     */
    public ArrayList<Object[]> obtenerCantidadPacientesMedicoFechaEdad(String d, String h, String b, String l) {
        ArrayList<Object[]> listaPacientes = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT DNIPaciente FROM Consulta WHERE Fecha BETWEEN ? AND ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, d);
            psq.setString(2, h);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[2];
                ob[0] = rs.getString("DNIPaciente");
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

        busquedaFecNac(listaPacientes, b, l);
        return listaPacientes;
    }

    /**
     * Realiza una búsqueda en la base de datos para obtener la fecha de
     * nacimiento de pacientes basándose en su DNI. Luego, calcula la edad de
     * los pacientes y elimina aquellos que no cumplen con los criterios de edad
     * especificados.
     *
     * @param paciente Un ArrayList de objetos que contienen información de los
     * pacientes, donde cada objeto es un array con al menos dos elementos: el
     * DNI del paciente y un espacio de almacenamiento para la edad.
     * @param b La edad mínima permitida.
     * @param l La edad máxima permitida.
     */
    public void busquedaFecNac(ArrayList<Object[]> paciente, String b, String l) {

        Connection conex = null;
        try {
            conex = Conexion.conectar();

            String query = "SELECT FechaNacimiento FROM Paciente WHERE DNI = ?";

            PreparedStatement psq = conex.prepareStatement(query);
            Iterator<Object[]> iterator = paciente.iterator();

            while (iterator.hasNext()) {
                Object[] dni = iterator.next();
                psq.setString(1, String.valueOf(dni[0]));
                ResultSet rs = psq.executeQuery();

                while (rs.next()) {
                    String fechaNac = rs.getString("FechaNacimiento");
                    dni[1] = calcularEdad(fechaNac);
                    if (Integer.parseInt(dni[1].toString()) > Integer.parseInt(l) || Integer.parseInt(dni[1].toString()) < Integer.parseInt(b)) {
                        iterator.remove(); // Eliminar el elemento del ArrayList
                    }
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
     * Calcula la edad en años a partir de la fecha de nacimiento proporcionada.
     *
     * @param fechaNac La fecha de nacimiento en formato válido (por ejemplo,
     * "yyyy-MM-dd").
     * @return La edad en años.
     */
    private int calcularEdad(String fechaNac) {
        LocalDate fechaNacimiento = LocalDate.parse(fechaNac, FormatosValidos.FORMATO_FECHA);
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();
    }

    private int cantidadDeConsultas = 0;

    public int getCantidadDeConsultas() {
        return cantidadDeConsultas;
    }

    public void setCantidadDeConsultas(int cantidadDeConsultas) {
        this.cantidadDeConsultas = cantidadDeConsultas;
    }

    /**
     * Obtiene una lista de pacientes que han tenido la mayor cantidad de
     * consultas en un rango de fechas especificado.
     *
     * @param d Fecha de inicio del rango.
     * @param h Fecha de fin del rango.
     * @return Una lista de nombres de pacientes que han tenido la mayor
     * cantidad de consultas en el rango de fechas.
     */
    public ArrayList<String> pacienteConMasConsultas(String d, String h) {
        ArrayList<String> pacientesMasConsultados = new ArrayList<>();
        Connection conex = null;
        String dni = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT ApellidoPaciente, DNIPaciente, COUNT(DNIPaciente) AS contador "
                    + "FROM Consulta "
                    + "WHERE Fecha BETWEEN ? AND ? "
                    + "GROUP BY DNIPaciente "
                    + "HAVING contador = (SELECT MAX(subcontador) "
                    + "FROM (SELECT COUNT(DNIPaciente) AS subcontador FROM Consulta WHERE Fecha BETWEEN ? AND ? GROUP BY DNIPaciente))";

            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, d);
            psq.setString(2, h);
            psq.setString(3, d);
            psq.setString(4, h);
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                String apellido = rs.getString("ApellidoPaciente");
                dni = rs.getString("DNIPaciente");
                pacientesMasConsultados.add(apellido + " (" + dni + ")");
                setCantidadDeConsultas(contarConsultas(dni));

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
        return pacientesMasConsultados;
    }

    /**
     * Obtiene la cantidad de consultas realizadas por un paciente con base en
     * su DNI.
     *
     * @param dni El DNI del paciente.
     * @return La cantidad de consultas realizadas por el paciente.
     */
    public int contarConsultas(String dni) {
        int cantidadRepeticiones = 0;
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT COUNT(*) FROM Consulta WHERE DNIPaciente = ?";

            PreparedStatement psq = conex.prepareStatement(query);

            psq.setString(1, dni);

            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                cantidadRepeticiones = rs.getInt(1);
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

        return cantidadRepeticiones;
    }

    /**
     * Busca y devuelve la cantidad de cada color de triaje en un rango de
     * fechas.
     *
     * @param d Fecha de inicio del rango.
     * @param h Fecha de fin del rango.
     * @return El color de triaje que más se repite y la cantidad de veces que
     * se repite.
     */
    public ArrayList<Object[]> triagesPorFecha(String d, String h) {
        ArrayList<Object[]> listaTriages = new ArrayList<>();
        Connection conex = null;
        int cantidadColores;

        try {
            conex = Conexion.conectar();
            String query = "SELECT COUNT(*) as cantidad, ResultadoDefinitivo FROM Consulta WHERE Fecha BETWEEN ? AND ? GROUP BY ResultadoDefinitivo";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, d);
            psq.setString(2, h);

            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                String color = rs.getString("ResultadoDefinitivo");
                cantidadColores = rs.getInt("cantidad");

                Object ob[] = new Object[2];
                ob[0] = color;
                ob[1] = cantidadColores;

                listaTriages.add(ob);
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
        return listaTriages;
    }

    /**
     * Obtiene una lista de triajes que han cambiado de color parcial a color
     * definitivo.
     *
     * @return Una lista de triajes que han cambiado de color.
     */
    public ArrayList<Object[]> triagesCambiados() {

        ArrayList<Object[]> listaTriages = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT * FROM Triage WHERE ColorParcial != ColorDefinitivo";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[5];
                ob[0] = rs.getString("ApellidoMed");
                ob[1] = rs.getString("NroMatricula");
                ob[2] = rs.getString("ColorParcial");
                ob[3] = rs.getString("ColorDefinitivo");
                ob[4] = rs.getString("MotivoCambio");
                listaTriages.add(ob);
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

        return listaTriages;
    }

}
