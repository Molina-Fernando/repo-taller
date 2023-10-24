package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * La clase `CtrlGestionFuncionarios` se encarga de gestionar la información de funcionarios,
 * interactuando con la base de datos, dar de alta funcionarios generando usuario y contraseña para el acceso al sistema,
 * asignación de roles en la base de datos y ver roles asociados.
 */


public class CtrlGestionFuncionarios {
    
    /**
     * Obtiene una tabla de funcionarios desde la base de datos.
     * @param dniDB DNI de la base de datos.
     * @param nomDB Nombre de la base de datos.
     * @return Una lista de arrays de objetos con información de funcionarios.
     * Cada array contiene [DNI, Nombre, Apellido, Sector].
     * @throws SQLException Si ocurre un error en la interacción con la base de datos.
     */

    public ArrayList<Object[]> getTablaFuncionarios(int dniDB, String nomDB) {
        ArrayList<Object[]> arrayListDeVectores = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT DNI, Nombre, Apellido, Sector FROM Funcionario";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                Object ob[] = new Object[4];
                ob[0] = rs.getString("DNI");
                ob[1] = rs.getString("Nombre");
                ob[2] = rs.getString("Apellido");
                ob[3] = rs.getString("Sector");

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
    
     /**
     * Obtiene una tabla de roles asociados a un funcionario desde la base de datos.
     *
     * @param dniDB DNI de la base de datos.
     * @return Una lista de arrays de objetos con información de roles asociados.
     * Cada array contiene [DNI, Nombre].
     * @throws SQLException Si ocurre un error en la interacción con la base de datos.
     */

    public ArrayList<Object[]> getTablaRolesAsociados(int dniDB) {
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

    /**
     * Carga una lista de opciones de roles desde la base de datos.
     *
     * @return Una lista de nombres de roles.
     */
    public ArrayList cargaComboBoxRoles() {

        ArrayList<String> arrayOpciones = new ArrayList<>();

        Connection conex = null;
        try {
            conex = Conexion.conectar();
            PreparedStatement psq = conex.prepareStatement("SELECT Nombre FROM Rol");
            ResultSet rs = psq.executeQuery();
            while (rs.next()) {
                arrayOpciones.add(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error! Contacte al administrador");
        }
        return arrayOpciones;
    }

    /**
     * Asigna roles a un funcionario en la base de datos.
     *
     * @param arrayList Una lista de nombres de roles a asignar.
     * @param dni El DNI del funcionario al que se asignan los roles.
     * @throws SQLException Si ocurre un error en la interacción con la base de datos.
     */
    
    public void asignarRoles(ArrayList<String> arrayList, int dni) {
        Connection conex = null;

        try {
            conex = Conexion.conectar();
            PreparedStatement psq = conex.prepareStatement("SELECT ID FROM Rol WHERE Nombre = ?");
            PreparedStatement insercionRoles = conex.prepareStatement("INSERT INTO AsignacionRol (idFuncionario, idRol) VALUES (?, ?)");

            for (String rol : arrayList) {
                psq.setString(1, rol);
                ResultSet rs = psq.executeQuery();

                if (rs.next()) {
                    int idRol = rs.getInt("ID");
                    insercionRoles.setInt(1, dni);
                    insercionRoles.setInt(2, idRol);
                    insercionRoles.executeUpdate();
                }
            }
            arrayList.clear();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error! Contacte al administrador");
            System.out.println(e);
        } finally {
            // Cierra la conexión
            if (conex != null) {
                try {
                    conex.close();
                } catch (SQLException e) {
                    System.err.println("ERROR SQL" + e);
                }
            }
        }
    }

    /**
     * Elimina un funcionario de la base de datos y su correspondiente usuario.
     *
     * @param dni El DNI del funcionario a eliminar.
     */
    public void eliminarFuncionario(int dni) {
        Connection conex = null;
        try {

            conex = Conexion.conectar();
            String deleteQuery = "DELETE FROM FUNCIONARIO WHERE DNI = ?";
            PreparedStatement psq = conex.prepareStatement(deleteQuery);
            psq.setInt(1, dni);

            psq.executeUpdate();

            //se elimina el usuario cuando se elimina un Funcionario
            String deleteUserQuery = "DELETE FROM Usuario WHERE Usuario = ?";
            psq = conex.prepareStatement(deleteUserQuery);
            psq.setInt(1, dni);
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

    public void altaFuncionario(String nomDB, int dniDB) {
        generarUsuario(nomDB, dniDB);
    }

    private String generarContrasenia(String nombre, int dni) {

        int tresUltimosDigitosDni = dni % 1000;
        String tresPrimerasLetrasNombre = obtenerTresPrimerasLetras(nombre);
        String contrasenia = tresPrimerasLetrasNombre + String.valueOf(tresUltimosDigitosDni);
        return contrasenia;
    }

    private String obtenerTresPrimerasLetras(String nombre) {
        if (nombre.length() < 3) {
            return nombre;
        } else {
            return nombre.substring(0, 3);
        }
    }

    private void generarUsuario(String nombre, int dni) {
        String contrasenia = generarContrasenia(nombre, dni);
        String usuario = String.valueOf(dni);

        Connection conex = null;

        try {
            conex = Conexion.conectar();
            String queryInsert = "INSERT INTO Usuario(Usuario, Contrasenia) VALUES (?, ?);";

            PreparedStatement psq = conex.prepareStatement(queryInsert);

            psq.setString(1, usuario);
            psq.setString(2, contrasenia);
            psq.executeUpdate();

        } catch (SQLException e) {
            System.out.println("EXCEP SQL" + e);
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
