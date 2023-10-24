package ventanas;

import java.awt.Image;
import java.awt.Toolkit;
import dbController.CtrlLogin;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Login extends javax.swing.JFrame {

    public static String user = "";
    String pass = "";
    CtrlLogin ctrlLogin = new CtrlLogin();

    public Login() {
        initComponents();
        this.setLocationRelativeTo(this);
        SetImageLabel.setImageLabel(labelImagen, "src\\main\\java\\images\\LogoAysha.png");
        SetImageLabel.setImageLabel(labelUser, "src\\main\\java\\images\\user.png");
        SetImageLabel.setImageLabel(labelPass, "src\\main\\java\\images\\pass.png");
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Acceso al sistema");
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src\\main\\java\\images\\icon.png");
        setIconImage(miIcono);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }


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
        bg.add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 290, 20));
        bg.add(labelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 330));

        textUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUsuarioActionPerformed(evt);
            }
        });
        bg.add(textUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 340, 40));

        labelContrasenia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelContrasenia.setForeground(new java.awt.Color(0, 0, 153));
        labelContrasenia.setText("CONTRASEÑA");
        bg.add(labelContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 100, 20));

        textContrasenia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        textContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textContraseniaActionPerformed(evt);
            }
        });
        bg.add(textContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 340, 40));
        bg.add(labelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, 25, 25));
        bg.add(labelPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 25, 25));

        botonAcceso.setBackground(new java.awt.Color(0, 0, 153));
        botonAcceso.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        botonAcceso.setForeground(new java.awt.Color(255, 255, 255));
        botonAcceso.setText("INGRESAR");
        botonAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAccesoActionPerformed(evt);
            }
        });
        bg.add(botonAcceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 160, 40));

        labelUsuario1.setBackground(new java.awt.Color(102, 102, 102));
        labelUsuario1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelUsuario1.setForeground(new java.awt.Color(0, 0, 153));
        labelUsuario1.setText("USUARIO");
        bg.add(labelUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
        if(ctrlLogin.validarAcceso(user, pass)){
            
            new VentanaGenerica().setVisible(true);
            
        } else {
        JOptionPane.showMessageDialog(null, "Datos de acceso incorrectos");
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
