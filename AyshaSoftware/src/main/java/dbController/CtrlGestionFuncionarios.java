package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.util.ArrayList;
//import clases.AdminSistemas;
//import clases.Administrativo;
//import clases.Medico;
//import clases.Rol;
//import clases.Sector;

public class CtrlGestionFuncionarios {

    /*public void instanciarFuncionario(int dni, String selectedOption, String selectedOption2, String nomDB, int dniDB){
        switch(selectedOption){
            case "MedicoTriage" :
                //Instancia de Medico 
                Medico medicoTriage = new Medico();
                break;
            case "MedicoSala" :
                //Instancia de Medico
                Medico medicoSala = new Medico();
                break;
            case "Administrativo" :
                //Instancia de Administrativo
                Administrativo administrativo = new Administrativo();
                break;
        }
    }*/
    public ArrayList<Object[]> getTablaFuncionarios() {
        ArrayList<Object[]> arrayListDeVectores = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT DNI, Nombre, Apellido, Sector FROM Funcionarios";
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

    public ArrayList<Object[]> getTablaRolesAsociados(int dniDB) {
        ArrayList<Object[]> arrayListDeRoles = new ArrayList<>();
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT Nombre FROM Rol WHERE id IN (SELECT idRol FROM AsignacionRoles WHERE idFuncionario = ?)";
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

    public void asignarRoles(ArrayList<String> arrayList, int dni) {
        Connection conex = null;

        try {
            conex = Conexion.conectar();
            PreparedStatement psq = conex.prepareStatement("SELECT ID FROM Rol WHERE Nombre = ?");
            PreparedStatement insercionRoles = conex.prepareStatement("INSERT INTO AsignacionRoles (idFuncionario, idRol) VALUES (?, ?)");

            for (String rol : arrayList) {
                psq.setString(1, rol);
                ResultSet rs = psq.executeQuery();

                if (rs.next()) {
                    int idRol = rs.getInt("ID");
                    insercionRoles.setInt(1, dni);
                    insercionRoles.setInt(2, idRol);
                    insercionRoles.executeUpdate();

                    //arrayIDS.add(idRol);
                }
            }
            arrayList.clear();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error! Contacte al administrador");
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

        //return arrayIDS;
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

    public void altaFuncionario(String nomDB, int dniDB) {

        generarUsuario(nomDB, dniDB);
    }

    /*public void altaMedico(int dni, String selectedOption, String selectedOption2, String nomDB, int dniDB, Funcionario func){
        
        
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
                   // 
                    Rol rol = new Rol(selectedOption);
                    String rolDB = rol.getNombreRol();
                    psi.setString(1, rolDB);
                    Sector sector = new Sector(selectedOption2);
                    String sectorDB = sector.getSector();
                    psi.setString(2, sectorDB);
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
        
    }*/
 /*public void altaAdministrativo(){
        
    }
    
    public void altaAdminInformatica(){
        
    }*/
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

    private void generarUsuario(String nombre, int dni) {
        String contrasenia = generarContrasenia(nombre, dni);
        String usuario = String.valueOf(dni);

        Connection conex = null;

        try {
            conex = Conexion.conectar();
            String queryInsert = "INSERT INTO Usuarios(Usuario, Contrasenia) VALUES (?, ?);";

            PreparedStatement psq = conex.prepareStatement(queryInsert);

            psq.setString(1, usuario);
            psq.setString(2, contrasenia);
            psq.executeUpdate();

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
