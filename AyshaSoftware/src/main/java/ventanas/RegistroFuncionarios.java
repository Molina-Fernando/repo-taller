package ventanas;

import dbController.CtrlRegistroFuncionarios;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class RegistroFuncionarios extends javax.swing.JFrame {
    
    CtrlRegistroFuncionarios ctrlRegistroFuncionarios = new CtrlRegistroFuncionarios();
    private String[] elementosBox = new String[5];
    
    public RegistroFuncionarios() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Registro de Funcionarios");
        SetImageLabel.setImageLabel(jLabelIconito, "src\\main\\java\\images\\icon.png");
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src\\main\\java\\images\\icon.png");
        SetImageLabel.setImageLabel(jLabel12, "src\\main\\java\\images\\regFunc.png");
        setIconImage(miIcono);
        
        cargarBoxSectores(ctrlRegistroFuncionarios.cargaComboBoxSectores());
    }
    
   private void cargarBoxSectores(ArrayList<String> arrayList){
        for(String elemento : arrayList){
            boxSector.addItem(elemento);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAgregar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textApellido = new javax.swing.JTextField();
        textDomicilio = new javax.swing.JTextField();
        textDNI = new javax.swing.JTextField();
        textFijo = new javax.swing.JTextField();
        textCel = new javax.swing.JTextField();
        textEstadoCivil = new javax.swing.JTextField();
        botonAgregar1 = new javax.swing.JButton();
        jLabelIconito = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dcFechaNac = new com.toedter.calendar.JDateChooser();
        boxSector = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

        botonAgregar.setText("Alta");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonEditar.setText("Eliminar");
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
            }
        });

        botonBuscar.setText("Buscar");

        botonEliminar.setText("Editar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Nombre");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 60, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Apellido");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 60, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Fecha de Nacimiento");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Domicilio");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("DNI");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, -1, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Telefono Fijo");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Telefono Celular");
        bg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 120, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Estado Civil");
        bg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, -1, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("Correo Electronico");
        bg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 140, 20));

        textMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMailActionPerformed(evt);
            }
        });
        bg.add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 170, -1));

        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });
        bg.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 170, -1));
        bg.add(textApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 170, -1));
        bg.add(textDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 170, -1));
        bg.add(textDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 170, -1));
        bg.add(textFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 170, -1));
        bg.add(textCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 170, -1));
        bg.add(textEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 170, -1));

        botonAgregar1.setBackground(new java.awt.Color(0, 0, 153));
        botonAgregar1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        botonAgregar1.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregar1.setText("REGISTRAR");
        botonAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregar1ActionPerformed(evt);
            }
        });
        bg.add(botonAgregar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 130, 30));

        jLabelIconito.setText("jLabel1");
        bg.add(jLabelIconito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        jLabel12.setText("jLabel12");
        bg.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 160));
        bg.add(dcFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 170, -1));

        bg.add(boxSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 170, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("Sector(es)");
        bg.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 80, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEditarActionPerformed

    private void botonAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregar1ActionPerformed
        String nombre = textNombre.getText().trim();
        String apellido = textApellido.getText().trim();
        Date fechaNacimiento = dcFechaNac.getDate();
        String domicilio = textDomicilio.getText().trim();
        String dni = textDNI.getText().trim();
        String telFijo = textFijo.getText().trim();
        String telCelular = textCel.getText().trim();
        String estadoCivil = textEstadoCivil.getText().trim();
        String correoElectronico = textMail.getText().trim();
        String sector = (String) boxSector.getSelectedItem();

        String patronMail = "^[A-Za-z0-9+_.-]+@(.+)$";
        String patronDNI = "^[0-9]{7,10}$";

        Pattern patternMail = Pattern.compile(patronMail);
        Matcher matcherMail = patternMail.matcher(correoElectronico);

        Pattern patternDNI = Pattern.compile(patronDNI);
        Matcher matcherDNI = patternDNI.matcher(dni);

        if (!nombre.isEmpty()
                && !apellido.isEmpty()
                && fechaNacimiento != null
                && !domicilio.isEmpty()
                && !dni.isEmpty()
                && !telFijo.isEmpty()
                && !telCelular.isEmpty()
                && !estadoCivil.isEmpty()
                && !correoElectronico.isEmpty()
                && !sector.isEmpty()) {
            

            if (matcherMail.matches()) {

                if (matcherDNI.matches()) {

                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaFormateada = formato.format(fechaNacimiento);

                    ctrlRegistroFuncionarios.registrarFuncionario(nombre, apellido, fechaFormateada, domicilio, dni, telFijo, telCelular, estadoCivil, correoElectronico, sector);
                    

                    textNombre.setText("");
                    textApellido.setText("");
                    dcFechaNac.setDate(null);
                    textDomicilio.setText("");
                    textDNI.setText("");
                    textFijo.setText("");
                    textCel.setText("");
                    textEstadoCivil.setText("");
                    textMail.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "DNI no válido");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Correo electrónico no válido");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        }
    }//GEN-LAST:event_botonAgregar1ActionPerformed

    private void textMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMailActionPerformed

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed
    /*   private void buscarFuncionario(String dni) {
        String query = "SELECT * FROM Funcionarios WHERE DNI = ?";
        Connection conex = null;
        try {
            conex = cn.conectar();
            PreparedStatement psq = conex.prepareStatement(query);
            psq.setString(1, dni);
            ResultSet rs = psq.executeQuery();

        } catch (Exception e) {

        }
    }*/

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
            java.util.logging.Logger.getLogger(RegistroFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonAgregar1;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JComboBox<String> boxSector;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser dcFechaNac;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelIconito;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textCel;
    private javax.swing.JTextField textDNI;
    private javax.swing.JTextField textDomicilio;
    private javax.swing.JTextField textEstadoCivil;
    private javax.swing.JTextField textFijo;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textNombre;
    // End of variables declaration//GEN-END:variables
}
