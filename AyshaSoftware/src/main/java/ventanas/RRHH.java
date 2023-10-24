
package ventanas;

import Utilidades.SetImageLabel;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;



public class RRHH extends javax.swing.JFrame {

    
    public RRHH() {
        initComponents();
        this.setLocationRelativeTo(this);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Recursos Humanos");
        SetImageLabel.setImageLabel(labelFuncMen, "src\\main\\java\\images\\menAdmin.png");
        SetImageLabel.setImageLabel(labelFuncWomen, "src\\main\\java\\images\\womenAdmin.png");
        SetImageLabel.setImageLabel(labelDocMen, "src\\main\\java\\images\\regMedicos.png");
        SetImageLabel.setImageLabel(labelDocWomen, "src\\main\\java\\images\\femDoc.png");
        
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src\\main\\java\\images\\icon.png");
        setIconImage(miIcono);
        SetImageLabel.setImageLabel(jLabelIconito, "src\\main\\java\\images\\icon.png");
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        bg = new javax.swing.JPanel();
        jButtonRegistrar = new javax.swing.JButton();
        labelFuncMen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelIconito = new javax.swing.JLabel();
        labelFuncWomen = new javax.swing.JLabel();
        labelDocWomen = new javax.swing.JLabel();
        labelDocMen = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jButtonRegistrar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("REGISTRO DE FUNCIONARIOS");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistrar.setBackground(new java.awt.Color(0, 0, 153));
        jButtonRegistrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        bg.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 190, 40));

        labelFuncMen.setText("jLabel1");
        bg.add(labelFuncMen, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 110, 100));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("PERSONAL DE SALUD");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 270, 30));

        jLabelIconito.setText("jLabel1");
        bg.add(jLabelIconito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        labelFuncWomen.setText("jLabel1");
        bg.add(labelFuncWomen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 110, 100));

        labelDocWomen.setText("jLabel1");
        bg.add(labelDocWomen, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 110, 100));

        labelDocMen.setText("jLabel1");
        bg.add(labelDocMen, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 110, 100));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 20, 370));
        bg.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 660, 20));

        jButtonRegistrar1.setBackground(new java.awt.Color(0, 0, 153));
        jButtonRegistrar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonRegistrar1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar1.setText("Registrar");
        jButtonRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrar1ActionPerformed(evt);
            }
        });
        bg.add(jButtonRegistrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 450, 190, 40));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("REGISTRO DE FUNCIONARIOS");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 270, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("ADMINISTRATIVOS");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 270, 30));
        bg.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 140, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        // TODO add your handling code here:
        //dispose();
        new RegistroFuncionarios().setVisible(true);
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrar1ActionPerformed
        // TODO add your handling code here:
        new RegistroMedicos().setVisible(true);
    }//GEN-LAST:event_jButtonRegistrar1ActionPerformed

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
            java.util.logging.Logger.getLogger(RRHH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RRHH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RRHH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RRHH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RRHH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonRegistrar1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelIconito;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelDocMen;
    private javax.swing.JLabel labelDocWomen;
    private javax.swing.JLabel labelFuncMen;
    private javax.swing.JLabel labelFuncWomen;
    // End of variables declaration//GEN-END:variables
}
