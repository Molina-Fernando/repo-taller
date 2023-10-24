package ventanas;

import Utilidades.SetImageLabel;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;

/**
 * La clase `AdminInformatico` representa la ventana principal del administrador
 * informático.
 */
public class AdminInformatico extends javax.swing.JFrame {

    /**
     * Constructor de la clase `AdminInformatico`. Inicializa la ventana y
     * configura su apariencia.
     */
    public AdminInformatico() {
        initComponents();

        setLocationRelativeTo(null);
        setResizable(false);
        SetImageLabel.setImageLabel(labelUsuarios, "src\\main\\java\\images\\userAdmin.png");
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src\\main\\java\\images\\icon.png");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(miIcono);
        SetImageLabel.setImageLabel(jLabelIconito, "src\\main\\java\\images\\icon.png");
        setTitle("Administrador");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        bg = new javax.swing.JPanel();
        bg1 = new javax.swing.JPanel();
        jLabelIconito = new javax.swing.JLabel();
        labelUsuarios = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jTextField1.setText("Usuario");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg1.setBackground(new java.awt.Color(255, 255, 255));
        bg1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIconito.setText("jLabel1");
        bg1.add(jLabelIconito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        bg.add(bg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        labelUsuarios.setText("jLabel1");
        bg.add(labelUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 150, 140));

        jButton1.setBackground(new java.awt.Color(0, 0, 153));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Acceder");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        bg.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        new GestionFuncionarios().setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Método principal que inicia la aplicación.
     * @param args Argumentos de la línea de comandos (no se utilizan en este caso).
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
            java.util.logging.Logger.getLogger(AdminInformatico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminInformatico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminInformatico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminInformatico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminInformatico().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel bg1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelIconito;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelUsuarios;
    // End of variables declaration//GEN-END:variables
}
