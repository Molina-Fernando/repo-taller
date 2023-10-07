package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import clases.AdminSistemas;
import clases.Administrativo;
import clases.Medico;



public class CtrlGestionFuncionarios {
    
    public void instanciarFuncionario(int dni, String selectedOption, String selectedOption2, String nomDB, int dniDB){
        switch(selectedOption){
            case "MedicoTriage" :
                Medico medicoTriage = new Medico();
                //Instancia de Medico altaFuncionario
                break;
            case "MedicoSala" :
                //Instancia de Medico
                Medico medicoSala = new Medico();
                break;
            case "AdminInformatico":
                //Instancia de AdminSistemas
                AdminSistemas adminInformatica = new AdminSistemas();
                break;
            case "Administrativo" :
                //Instancia de Administrativo
                Administrativo administrativo = new Administrativo();
                break;
        }
    }

    public ArrayList<Object[]> getTablaFuncionarios(int dniDB, String nomDB) {
        ArrayList<Object[]> arrayListDeVectores = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT DNI, Nombre, Apellido, Rol, Sector FROM Funcionarios";
            PreparedStatement psq = conex.prepareStatement(query);
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                Object ob[] = new Object[5];
                ob[0] = rs.getString("DNI");
                ob[1] = rs.getString("Nombre");
                ob[2] = rs.getString("Apellido");
                ob[3] = rs.getString("Rol");
                ob[4] = rs.getString("Sector");

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

    public void eliminarFuncionario(int dni) {
        Connection conex = null;
        try {

            conex = Conexion.conectar();
            String deleteQuery = "DELETE FROM FUNCIONARIOS WHERE DNI = ?";
            PreparedStatement psq = conex.prepareStatement(deleteQuery);
            psq.setInt(1, dni);
            
            psq.executeUpdate();

            //se elimina el usuario cuando se elimina un Funcionario
            String deleteUserQuery = "DELETE FROM Usuarios WHERE Usuario = ?";
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
    
    public void altaFuncionario(int dni, String selectedOption, String selectedOption2, String nomDB, int dniDB){
        Connection conex = null;
            try {
                conex = Conexion.conectar();
                String query = "SELECT * FROM Funcionarios WHERE DNI = ?";
                PreparedStatement psq = conex.prepareStatement(query);
                psq.setInt(1, dni);
                ResultSet rs = psq.executeQuery();

                if (rs.next()) {
                    String update = "UPDATE Funcionarios SET Rol = ?, Sector = ? WHERE DNI = ?;";
                    PreparedStatement psi = conex.prepareStatement(update);
                    psi.setString(1, selectedOption);
                    psi.setString(2, selectedOption2);
                    psi.setInt(3, dni);
                    psi.executeUpdate();
                    //actualizarTabla();
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
            
            generarUsuario(selectedOption, selectedOption2, nomDB, dniDB);
    }
    
    public void altaMedico(int dni, String selectedOption, String selectedOption2, String nomDB, int dniDB, Medico medico){
        Connection conex = null;
            try {
                conex = Conexion.conectar();
                String query = "SELECT * FROM Funcionarios WHERE DNI = ?";
                PreparedStatement psq = conex.prepareStatement(query);
                psq.setInt(1, dni);
                ResultSet rs = psq.executeQuery();

                if (rs.next()) {
                    String update = "UPDATE Funcionarios SET Rol = ?, Sector = ? WHERE DNI = ?;";
                    PreparedStatement psi = conex.prepareStatement(update);
                   // psi.setString(1, medico.setRol(selectedOption));
                    psi.setString(2, selectedOption2);
                    psi.setInt(3, dni);
                    psi.executeUpdate();
                    //actualizarTabla();
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
            
            generarUsuario(selectedOption, selectedOption2, nomDB, dniDB);
        
    }
    
    public void altaAdministrativo(){
        
    }
    
    public void altaAdminInformatica(){
        
    }
    
    private String generarContrasenia(String nombre, int dni) {

        int tresUltimosDigitosDni = dni % 1000;
        String tresPrimerasLetrasNombre = obtenerTresPrimerasLetras(nombre);
        String contrasenia = tresPrimerasLetrasNombre + String.valueOf(tresUltimosDigitosDni);
        //System.out.println(contrasenia);
        return contrasenia;
    }

    private String obtenerTresPrimerasLetras(String nombre) {
        if (nombre.length() < 3) {
            return nombre;
        } else {
            return nombre.substring(0, 3);
        }
    }

    private void generarUsuario(String opcion1, String opcion2, String nombre, int dni) {
        String contrasenia = generarContrasenia(nombre, dni);
        String usuario = String.valueOf(dni);

        Connection conex = null;

        try {
            conex = Conexion.conectar();
            String queryInsert1 = "INSERT INTO Usuarios(Usuario, Contrasenia, Rol, Sector) VALUES (?,?,?,?);";
            String queryInsert2 = "UPDATE Usuarios SET Rol = ?, Sector = ? WHERE Usuario = ?";
            String queryMatch = "SELECT * FROM Usuarios WHERE Usuario = ?";

            PreparedStatement psq = conex.prepareStatement(queryMatch);
            psq.setString(1, usuario);

            ResultSet rs = psq.executeQuery();

            if (rs.next()) {
                psq = conex.prepareStatement(queryInsert2);
                psq.setString(1, opcion1);
                psq.setString(2, opcion2);
                psq.setString(3, usuario);
                psq.executeUpdate();
            } else {
                psq = conex.prepareStatement(queryInsert1);
                psq.setString(1, usuario);
                psq.setString(2, contrasenia);
                psq.setString(3, opcion1);
                psq.setString(4, opcion2);
                psq.executeUpdate();
            }

            System.out.println("acá ando");

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
    
    
    /* switch(SelectOpt1){
            case "MedicoTriage" :
                //Instancia de Medico
                break;
            case "MedicoSala" :
                //Instancia de Medico
                break;
            case "AdminInformatico":
                //Instancia de AdminSistemas
                break;
            case "Administrativo" :
                //Instancia de Administrativo
                break;
        }*/

}
