package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import clases.Funcionario;
import java.util.ArrayList;

/**
 * La clase `CtrlRegistroFuncionarios` se encarga de gestionar el registro de funcionarios
 * en la base de datos, así como de proporcionar opciones para cargar datos relacionados con
 * sectores de la organización.
 */

public class CtrlRegistroFuncionarios {
    

    private String matricula;

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Registra un nuevo funcionario en la base de datos.
     *
     * @param nombre El nombre del funcionario.
     * @param apellido El apellido del funcionario.
     * @param fechaFormateada La fecha de nacimiento del funcionario formateada.
     * @param domicilio El domicilio del funcionario.
     * @param dni El número de DNI del funcionario.
     * @param telFijo El número de teléfono fijo del funcionario.
     * @param telCelular El número de teléfono celular del funcionario.
     * @param estadoCivil El estado civil del funcionario.
     * @param correoElectronico El correo electrónico del funcionario.
     * @param sector El sector al que el funcionario pertenece.
     * @throws SQLException Si ocurre un error en la interacción con la base de datos.
     */
    
    public void registrarFuncionario(
           Funcionario func, String sector
    ) {
 

        Connection conex = null;
        try {
            conex = Conexion.conectar();

            String query = "SELECT * FROM Funcionario WHERE DNI = ?";

            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, func.getDni());

            ResultSet rs = psq.executeQuery();

            if (!rs.next()) {

                String insert = "INSERT INTO Funcionario(Nombre, Apellido, FechaNacimiento, Domicilio, DNI, TelFijo, telCel, EstadoCivil, Mail, Sector) VALUES(?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement psi = conex.prepareStatement(insert);

                psi.setString(1, func.getNombre());
                psi.setString(2, func.getApellido());
                psi.setString(3, func.getFecNacimiento());
                psi.setString(4, func.getDomicilio());
                psi.setString(5, func.getDni());
                psi.setString(6, func.getTelFijo());
                psi.setString(7, func.getTelCelular());
                psi.setString(8, func.getDomicilio());
                psi.setString(9, func.getCorreoElectronico());
               
                psi.setString(10, sector);

                psi.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario registrado con éxito - Recuerde que un informático deberá validar el usuario para su posterior ingreso al sistema.");

            } else {
                JOptionPane.showMessageDialog(null, "DNI ya registrado");
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
     * Obtiene una lista de opciones de sectores desde la base de datos.
     *
     * @return Una lista de nombres de sectores.
     */
    
      public ArrayList cargaComboBoxSectores() {
        
        ArrayList<String> arrayOpciones = new ArrayList<>();
        
        Connection conex = null;
        try {
            conex = Conexion.conectar();
            PreparedStatement psq = conex.prepareStatement("SELECT Nombre FROM Sector");
            ResultSet rs = psq.executeQuery();

            while (rs.next()) {
                arrayOpciones.add(rs.getString("Nombre"));

            }

        } catch (Exception e) {
        }

        return arrayOpciones;
    }

}
