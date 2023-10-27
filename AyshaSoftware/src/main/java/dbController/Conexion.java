package dbController;


import java.sql.*;

/**
 * La clase `Conexion` se encarga de establecer una conexión con una base de datos SQLite.
 * Utiliza la biblioteca JDBC para conectar y administrar la base de datos.
 */

public class Conexion {

    static Connection conectar = null;

    /**
     * Conecta a la base de datos SQLite especificada.
     *
     * @return Un objeto `Connection` que representa la conexión a la base de datos.
     */
    
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
