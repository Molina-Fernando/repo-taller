package dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Controlador para operaciones relacionadas con ventanas genéricas y roles.
 * Esta clase proporciona métodos para obtener información sobre roles asignados a un funcionario.
 */

public class CtrlVentanaGenerica {
    
    /**
     * Completa una lista con todos los Ids de Rol de cada funcionario.
     * 
     * @param dni : DNI del funcionario.
     * @return lista de Ids.
     */
    public ArrayList<Integer> rolesParametrizados(String dni) {

        ArrayList<Integer> arrayIds = new ArrayList<>();

        Connection conex = null;
        try {
            conex = Conexion.conectar();
            String insert = "SELECT * FROM AsignacionRol idRol WHERE idFuncionario = ?";
            PreparedStatement psi = conex.prepareStatement(insert);
            psi.setString(1, dni);
            ResultSet rs = psi.executeQuery();

            while (rs.next()) {
                arrayIds.add(Integer.valueOf(rs.getString("idRol")));
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
        return arrayIds;

    }
}
