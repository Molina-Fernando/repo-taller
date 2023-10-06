package dbController;


import java.sql.*;

public class Conexion {

    static Connection conectar = null;

    public static Connection conectar() {

        try {
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection("jdbc:sqlite:aysha.db");

        } catch (Exception e) {
            System.out.println("Error");
        }

        return conectar;
    }
}
