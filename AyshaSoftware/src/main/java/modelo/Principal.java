package modelo;

import java.sql.*;
import vista.MedicoTriage;

public class Principal {

    public static void main(String[] args) {
        Conexion cc = new Conexion();
        Connection conex = cc.conectar();

        MedicoTriage mt = new MedicoTriage();
        mt.setVisible(true);

    }

}
