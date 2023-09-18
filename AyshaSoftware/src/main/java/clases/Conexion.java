
package clases;

import java.sql.*;

public class Conexion {

    Connection conectar = null;

    public Connection conectar() {

        try {
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection("jdbc:sqlite:aysha.db");

        } catch (Exception e) {
            System.out.println("Error");
        }

        return conectar;
    }
}
