package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * La clase `CtrlLogin` se encarga de validar el acceso de un usuario
 * en la aplicación mediante la interacción con la base de datos y la
 * ventana de inicio de sesión.
 */
public class CtrlLogin {
    
    /**
     * Valida el acceso de un usuario comparando las credenciales proporcionadas con
     * los registros de la base de datos.
     *
     * @param user El nombre de usuario proporcionado por el usuario.
     * @param pass La contraseña proporcionada por el usuario.
     * @return `true` si las credenciales son válidas y el acceso es exitoso, de lo contrario, `false`.
     */

    public boolean validarAcceso(String user, String pass) {

        boolean retorno = false;

        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String insert = "SELECT * FROM Usuario WHERE Usuario = ? AND Contrasenia = ?";
            PreparedStatement psi = conex.prepareStatement(insert);
            psi.setString(1, user);
            psi.setString(2, pass);
            ResultSet rs = psi.executeQuery();

            if (rs.next()) {
                retorno = true;
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
        return retorno;
    }
}
