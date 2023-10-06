package main;

import dbController.Conexion;
import java.sql.*;
import ventanas.Login;

public class Principal {

    public static void main(String[] args) {
        Conexion cc = new Conexion();
        Connection conex = cc.conectar();
        Login ventanaLogin = new Login();
        
        ventanaLogin.setVisible(true);
    }

}
