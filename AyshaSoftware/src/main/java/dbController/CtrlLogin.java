package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CtrlLogin {

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
