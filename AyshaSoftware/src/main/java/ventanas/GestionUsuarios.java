package ventanas;

import clases.Conexion;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import static ventanas.Login.user;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GestionUsuarios extends javax.swing.JFrame {

    DefaultTableModel modelo;
    Conexion cn = new Conexion();

    public GestionUsuarios() {
        initComponents();
        setTitle("Gestión de Usuarios");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src\\main\\java\\images\\icon.png");
        setIconImage(miIcono);

        modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Rol");
        modelo.addColumn("Sector");
        actualizarTabla();
    }

    private void actualizarTabla() {
        modelo.setRowCount(0);
        tablaFuncionarios = new javax.swing.JTable();

        tablaFuncionarios.setModel(modelo);
        Connection conex = null;
        try {
            conex = cn.conectar();

            String query = "SELECT DNI, Nombre, Apellido, Rol, Sector FROM Funcionarios";

            PreparedStatement psq = conex.prepareStatement(query);

            ResultSet rs = psq.executeQuery();

            tablaFuncionarios = new JTable(modelo);

            jScrollPane1.setViewportView(tablaFuncionarios);

            while (rs.next()) {
                Object ob[] = new Object[5];
                ob[0] = rs.getString("DNI");
                ob[1] = rs.getString("Nombre");
                ob[2] = rs.getString("Apellido");
                ob[3] = rs.getString("Rol");
                ob[4] = rs.getString("Sector");

                modelo.addRow(ob);
                tablaFuncionarios.setModel(modelo);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFuncionarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JButton();
        botonAlta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaFuncionarios = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tablaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaFuncionarios.getTableHeader().setResizingAllowed(false);
        tablaFuncionarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaFuncionarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 730, 190));

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("  PENDIENTES DE ALTA (quienes no tienen rol y sector)");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 390, 40));

        jComboBox1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MedicoTriage", "MedicoSala", "AdminInformatico", "Administrativo" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        jComboBox2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admision", "RRHH", "Compras", "Auditoria", "Gestion", "RegistrosMedicos" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Sector");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, -1, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Rol");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 30, 20));

        botonEliminar.setBackground(new java.awt.Color(0, 0, 153));
        botonEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminar.setText("ELIMINAR");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, 90, 30));

        botonAlta.setBackground(new java.awt.Color(0, 0, 153));
        botonAlta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAlta.setForeground(new java.awt.Color(255, 255, 255));
        botonAlta.setText("ALTA");
        botonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaActionPerformed(evt);
            }
        });
        jPanel1.add(botonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed

        int numFila = tablaFuncionarios.getSelectedRow();
        if (numFila != -1) {
            String dnistr = (String) tablaFuncionarios.getValueAt(numFila, 0);
            int dni = Integer.parseInt(dnistr);
            Connection conex = null;
            try {

                conex = cn.conectar();

                String deleteQuery = "DELETE FROM FUNCIONARIOS WHERE DNI = ?";
                PreparedStatement psq = conex.prepareStatement(deleteQuery);

                psq.setInt(1, dni);
                int filaModificada = psq.executeUpdate();

                if (filaModificada > 0) {

                    DefaultTableModel model = (DefaultTableModel) tablaFuncionarios.getModel();
                    model.removeRow(numFila);
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
    }//GEN-LAST:event_botonEliminarActionPerformed
    private String selectedOption;
    private String selectedOption2;
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        selectedOption = (String) jComboBox1.getSelectedItem();


    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void botonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaActionPerformed
        // TODO add your handling code here:
        int numFila = tablaFuncionarios.getSelectedRow();
        if (numFila != -1) {

            String dnistr = (String) tablaFuncionarios.getValueAt(numFila, 0);
            int dni = Integer.parseInt(dnistr);

            Connection conex = null;
            try {
                conex = cn.conectar();

                String query = "SELECT * FROM Funcionarios WHERE DNI = ?";

                PreparedStatement psq = conex.prepareStatement(query);
                psq.setInt(1, dni);

                ResultSet rs = psq.executeQuery();

                if (rs.next()) {
                    String update = "UPDATE Funcionarios SET Rol = ?, Sector = ? WHERE DNI = ?;";
                    PreparedStatement psi = conex.prepareStatement(update);
                    psi.setString(1, selectedOption);
                    psi.setString(2, selectedOption2);
                    psi.setInt(3, dni);

                    psi.executeUpdate();

                    actualizarTabla();

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
    }//GEN-LAST:event_botonAltaActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        selectedOption2 = (String) jComboBox2.getSelectedItem();
    }//GEN-LAST:event_jComboBox2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAlta;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFuncionarios;
    // End of variables declaration//GEN-END:variables
}
