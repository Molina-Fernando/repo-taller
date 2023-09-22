package vista;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.sql.*;
import modelo.Conexion;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    public static String user = "";
    String pass = "";

    public Login() {
        initComponents();
        this.setLocationRelativeTo(this);
        SetImageLabel(labelImagen, "src\\main\\java\\images\\LogoAysha.png");
        SetImageLabel(labelUser, "src\\main\\java\\images\\user.png");
        SetImageLabel(labelPass, "src\\main\\java\\images\\pass.png");
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Acceso al sistema");
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src\\main\\java\\images\\icon.png");
        setIconImage(miIcono);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        labelImagen = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        labelContrasenia = new javax.swing.JLabel();
        textContrasenia = new javax.swing.JPasswordField();
        labelUser = new javax.swing.JLabel();
        labelPass = new javax.swing.JLabel();
        botonAcceso = new javax.swing.JButton();
        labelUsuario1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setForeground(new java.awt.Color(204, 204, 204));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUsuario.setBackground(new java.awt.Color(102, 102, 102));
        labelUsuario.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(0, 0, 153));
        labelUsuario.setText("Sistema de Gestión Hospitalaria");
        bg.add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 320, 20));
        bg.add(labelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 370));

        textUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUsuarioActionPerformed(evt);
            }
        });
        bg.add(textUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 340, 40));

        labelContrasenia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelContrasenia.setForeground(new java.awt.Color(0, 0, 153));
        labelContrasenia.setText("CONTRASEÑA");
        bg.add(labelContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 100, 20));

        textContrasenia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textContraseniaActionPerformed(evt);
            }
        });
        bg.add(textContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 340, 40));
        bg.add(labelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 40, 40));
        bg.add(labelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 40, 40));

        botonAcceso.setBackground(new java.awt.Color(0, 0, 153));
        botonAcceso.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        botonAcceso.setForeground(new java.awt.Color(255, 255, 255));
        botonAcceso.setText("INGRESAR");
        botonAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAccesoActionPerformed(evt);
            }
        });
        bg.add(botonAcceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 580, 160, 40));

        labelUsuario1.setBackground(new java.awt.Color(102, 102, 102));
        labelUsuario1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelUsuario1.setForeground(new java.awt.Color(0, 0, 153));
        labelUsuario1.setText("USUARIO");
        bg.add(labelUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUsuarioActionPerformed

    private void textContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textContraseniaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textContraseniaActionPerformed

    private void botonAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAccesoActionPerformed
        // TODO add your handling code here:
        user = textUsuario.getText().trim();
        pass = textContrasenia.getText().trim();
        Conexion cn = new Conexion();
        //boolean credencialValida = false;

        if (!user.isEmpty() && !pass.isEmpty()) {
            Connection conex = null;
            try {
                conex = cn.conectar();
                //Statement statement = conex.createStatement();
                String query = "SELECT * FROM Usuarios WHERE Usuario = ? AND Contrasenia = ?";
                //define una consulta que busca en la base de datos una fila en la tabla Usuarios, donde el campo Usuario sea igual al valor que se proporcionará más adelante marcado como ?
                //evitamos inyección SQL, mediante consulta parametrizada

                PreparedStatement preparedStatement = conex.prepareStatement(query);
                preparedStatement.setString(1, user);
                preparedStatement.setString(2, pass);

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    String nivelAcceso = rs.getString("NivelAcceso");

                    // Verificamos el nivel de acceso y abrimos la interfaz correspondiente
                    if ("AdminInformatico".equals(nivelAcceso)) {
                        dispose();
                        new AdminInformatico().setVisible(true);
                    } else if ("Medico".equals(nivelAcceso)) { //Medico no va, seria MedicoSala, MedicoTriage
                        dispose();
                        new MedicoTriage().setVisible(true);
                    } else if ("Funcionario".equals(nivelAcceso)) {
                        dispose();
                        new Funcionario().setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
                    textUsuario.setText("");
                    textContrasenia.setText("");
                }

            } catch (SQLException e) {
                System.err.println("Error en el botón acceder: " + e);
                JOptionPane.showMessageDialog(null, "Error al iniciar sesión. Contacte al administrador.");
            } finally {
                try {

                    if (conex != null) {
                        conex.close();
                    }

                } catch (SQLException excSql) {
                    System.err.println("ERROR SQL" + excSql);
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        }
    }//GEN-LAST:event_botonAccesoActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private void SetImageLabel(JLabel jLabel1, String root) {
        ImageIcon image = new ImageIcon(root);
        Icon icon = new ImageIcon(
                image.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
        jLabel1.setIcon(icon);
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton botonAcceso;
    private javax.swing.JLabel labelContrasenia;
    private javax.swing.JLabel labelImagen;
    private javax.swing.JLabel labelPass;
    private javax.swing.JLabel labelUser;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JLabel labelUsuario1;
    private javax.swing.JPasswordField textContrasenia;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables
}