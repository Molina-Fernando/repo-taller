/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbController;

import clases.Medico;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ventanas.Login;



/**
 *
 * @author Jeremías Simian
 */
public class CtrlMedicoTriage {
    
    private final Medico med = new Medico();
    
    public String triagiarPaciente(int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12,int i13){
        String colorParcial = med.realizarTriage(i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13);
        return colorParcial;
    }
    
    public void cambiarTriage(String colorDefinitivo, String motivoCambio){
        med.cambiarTriage(colorDefinitivo, motivoCambio);
    }
    
    public void finalizarTriage(){
        
        String dniMedico = Login.user;
        String dniPac = obtenerUltimoDniPac();
         Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT * FROM Funcionarios WHERE DNI = ?";
            String query1 = "SELECT * FROM Pacientes WHERE DNI = ?";
            
            PreparedStatement psq1 = conex.prepareStatement(query1);
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dniMedico);
            psq1.setString(1, dniPac);
            
            ResultSet rs = psq.executeQuery();
            ResultSet rs1 = psq1.executeQuery();
            
            if(rs.next() && rs1.next()){
                
                    String update = "UPDATE Triages SET ApellidoMed = ?, ColorParcial = ?, ColorDefinitivo = ?, MotivoCambio = ?, NroMatricula = ? WHERE DNI = ?;";
                    PreparedStatement psu = conex.prepareStatement(update);

                    String update1 = "UPDATE ListaEsperaSala SET ColorDefinitivo = ? WHERE DNI = ?;";
                    PreparedStatement psu1 = conex.prepareStatement(update1);

                psu.setString(1, rs.getString("Apellido"));
                psu.setString(2, med.getColorParcial());
                psu.setString(3, med.getColorDefinitivo());
                psu.setString(4, med.getMotivoCambio());
                psu.setString(5, rs.getString("Matricula"));
                psu.setInt(6, Integer.parseInt(dniPac));
                
          
                psu1.setString(1, med.getColorDefinitivo());
                psu1.setInt(2, Integer.parseInt(dniPac));
                
                psu.executeUpdate();
                psu1.executeUpdate();
                
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
    
    public String obtenerUltimoDniPac() {
    String dniPac = null;
    Connection conex = null;
    try {
        conex = Conexion.conectar();
        String query = "SELECT DNI FROM ListaEsperaSala ORDER BY ROWID DESC LIMIT 1;";
        PreparedStatement psq = conex.prepareStatement(query);
        ResultSet rs = psq.executeQuery();

        if (rs.next()) {
            dniPac = rs.getString("DNI");
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
    return dniPac;
}
  
}
