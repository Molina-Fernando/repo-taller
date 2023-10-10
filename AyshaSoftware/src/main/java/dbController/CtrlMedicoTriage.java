/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbController;

import clases.Medico;
import clases.Triage;
import java.awt.Color;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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
       /* System.out.println(med.getColorParcial());
        System.out.println(med.getColorDefinitivo());
        System.out.println(med.getMotivoCambio());*/
        String dniMedico = Login.user;
         Connection conex = null;
        try {
            conex = Conexion.conectar();
            String query = "SELECT * FROM Funcionarios WHERE DNI = ?";
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dniMedico);
            
            ResultSet rs = psq.executeQuery();
            
            if(rs.next()){
                String insertTriages = "INSERT INTO Triages(ApellidoMed, NombrePac, ApellidoPac, DNI, ColorParcial, ColorDefinitivo, MotivoCambio, NroMatricula) VALUES(?,?,?,?,?,?,?,?);";
                PreparedStatement psi = conex.prepareStatement(insertTriages);
                
                String insertListaEspera = "INSERT INTO ListaEsperaSala(NombrePac, DNI, ColorDefinitivo) VALUES(?,?,?);";
                PreparedStatement psi1 = conex.prepareStatement(insertListaEspera);
                
                //psi1.setString(1, med.getColorDefinitivo());NOMBRE PACIENTE
                //psi1.setString(2, med.getColorDefinitivo()); DNI PACIENTE
                psi1.setString(3, med.getColorDefinitivo());
                
                psi1.executeUpdate();
                
                psi.setString(1, rs.getString("Apellido"));
                //psi.setString(2, rs.getString("Apellido")); NOMBRE PACIENTE
                //psi.setString(3, rs.getString("Apellido")); APELLIDO PACIENTE
                //psi.setString(4, rs.getString("Apellido")); DNI PACIENTE (RECUPERARLOS)
                psi.setString(5, med.getColorParcial());
                psi.setString(6, med.getColorDefinitivo());
                psi.setString(7, med.getMotivoCambio());
                psi.setString(8, rs.getString("Matricula"));
                
                psi.executeUpdate();
            } else{
                System.out.println("No tiene sentido que no exista");
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
  
}
