package ventanas;

import dbController.CtrlRegistroFuncionarios;
import dbController.CtrlRegistroMedicos;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class RegistroMedicos extends javax.swing.JFrame {

    private DefaultListModel<String> modeloLista;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String dni;
    private String telFijo;
    private String telCelular;
    private String estadoCivil;
    private String correoElectronico;
    private String numMatricula;
    private String especialidad;
    private Date fechaTitulo;
    private Date fechaNacimiento;
    private String universidad;

    public RegistroMedicos() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Registro de Médicos");
        SetImageLabel.setImageLabel(jLabelIconito, "src\\main\\java\\images\\icon.png");
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src\\main\\java\\images\\icon.png");
        SetImageLabel.setImageLabel(jLabel12, "src\\main\\java\\images\\regFunc.png");
        setIconImage(miIcono);
        modeloLista = new DefaultListModel<>();
        lista = new JList<>(modeloLista);
        jScrollPane1.setViewportView(lista);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textEspecialidad = new javax.swing.JTextField();
        textNombre = new javax.swing.JTextField();
        textApellido = new javax.swing.JTextField();
        textDomicilio = new javax.swing.JTextField();
        textDNI = new javax.swing.JTextField();
        textFijo = new javax.swing.JTextField();
        textCel = new javax.swing.JTextField();
        textEstadoCivil = new javax.swing.JTextField();
        jLabelIconito = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dcFechaTitulo = new com.toedter.calendar.JDateChooser();
        botonRegistrar = new javax.swing.JButton();
        textUniversidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        textMail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        dcFechaNac = new com.toedter.calendar.JDateChooser();
        textNumMatricula = new javax.swing.JTextField();

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
        bg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 140, 20));

        textEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEspecialidadActionPerformed(evt);
            }
        });
        bg.add(textEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 460, 170, -1));

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

        jLabelIconito.setText("jLabel1");
        bg.add(jLabelIconito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        jLabel12.setText("jLabel12");
        bg.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 160));
        bg.add(dcFechaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 170, -1));

        botonRegistrar.setBackground(new java.awt.Color(0, 0, 153));
        botonRegistrar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        botonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrar.setText("REGISTRAR");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        bg.add(botonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 700, 130, 30));
        bg.add(textUniversidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, 170, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Universidad");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 90, -1));

        jScrollPane1.setViewportView(lista);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, 170, 140));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("Especialidad");
        bg.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 90, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("Fecha");
        bg.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 50, -1));

        textMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMailActionPerformed(evt);
            }
        });
        bg.add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 170, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 153));
        jLabel14.setText("N° Matricula");
        bg.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 90, -1));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        bg.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, -1, -1));
        bg.add(dcFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 170, -1));
        bg.add(textNumMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEspecialidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEspecialidadActionPerformed

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed

    private void botonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarActionPerformed
        // TODO add your handling code here:
        nombre = textNombre.getText().trim();
        apellido = textApellido.getText().trim();
        fechaNacimiento = dcFechaNac.getDate();
        domicilio = textDomicilio.getText().trim();
        dni = textDNI.getText().trim();
        telFijo = textFijo.getText().trim();
        telCelular = textCel.getText().trim();
        estadoCivil = textEstadoCivil.getText().trim();
        correoElectronico = textMail.getText().trim();
       

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
                && !numMatricula.isEmpty()) {

            if (matcherMail.matches()) {

                if (matcherDNI.matches()) {

                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    String fechaFormateada = formato.format(fechaNacimiento);

                    CtrlRegistroFuncionarios.registrarFuncionario(nombre, apellido, fechaFormateada, domicilio, dni, telFijo, telCelular, estadoCivil, correoElectronico);

                    textNombre.setText("");
                    textApellido.setText("");
                    dcFechaNac.setDate(null);
                    textDomicilio.setText("");
                    textDNI.setText("");
                    textFijo.setText("");
                    textCel.setText("");
                    textEstadoCivil.setText("");
                    textMail.setText("");
                    textNumMatricula.setText("");
                    modeloLista.clear();

                } else {
                    JOptionPane.showMessageDialog(null, "DNI no válido");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Correo electrónico no válido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
        }
    }//GEN-LAST:event_botonRegistrarActionPerformed

    private void textMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        dni = textDNI.getText().trim();
        numMatricula = textNumMatricula.getText().trim();
        especialidad = textEspecialidad.getText().trim();
        fechaTitulo = dcFechaTitulo.getDate();
        universidad = textUniversidad.getText().trim();

        if (!dni.isEmpty()) {
            // to do: controlar campos vacios al agregar una especialidad
            SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada2 = formato2.format(fechaTitulo);

            CtrlRegistroMedicos.registrarMedicos(especialidad, fechaFormateada2, universidad, dni,numMatricula);

            textEspecialidad.setText("");
            dcFechaTitulo.setDate(null);
            textUniversidad.setText("");

            modeloLista.addElement(especialidad);
            lista.updateUI();

        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar el DNI del médico a registrar especialidad.");
        }

        // lista.setSelectedValue(especialidad, true);

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroMedicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroMedicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton botonRegistrar;
    private com.toedter.calendar.JDateChooser dcFechaNac;
    private com.toedter.calendar.JDateChooser dcFechaTitulo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelIconito;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista;
    private javax.swing.JTextField textApellido;
    private javax.swing.JTextField textCel;
    private javax.swing.JTextField textDNI;
    private javax.swing.JTextField textDomicilio;
    private javax.swing.JTextField textEspecialidad;
    private javax.swing.JTextField textEstadoCivil;
    private javax.swing.JTextField textFijo;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNumMatricula;
    private javax.swing.JTextField textUniversidad;
    // End of variables declaration//GEN-END:variables
}