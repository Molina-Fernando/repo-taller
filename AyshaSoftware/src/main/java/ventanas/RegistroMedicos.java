package ventanas;

import Utilidades.SetImageLabel;
import clases.Medico;
import dbController.CtrlRegistroMedicos;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import clases.Funcionario;
import javax.swing.WindowConstants;


/**
 * La ventana ´RegistroMedicos´ se encarga de registrar a los médicos,
 * relacionandose con el controlador ´CtrlResgistroMedicos´.
 */
public class RegistroMedicos extends javax.swing.JFrame {

    private final DefaultListModel<String> modeloLista;
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

    ArrayList<String> arrayEspecialidades = new ArrayList<>();
    ArrayList<String> arrayFechas = new ArrayList<>();
    ArrayList<String> arrayUniversidades = new ArrayList<>();

    CtrlRegistroMedicos ctrlRegistroMedicos = new CtrlRegistroMedicos();

    public RegistroMedicos() {
        
        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Registro de profesionales de la salud");
        SetImageLabel.setImageLabel(jLabelIconito, "src\\main\\java\\images\\icon.png");
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src\\main\\java\\images\\icon.png");
        SetImageLabel.setImageLabel(jLabel12, "src\\main\\java\\images\\regFunc.png");
        setIconImage(miIcono);
        modeloLista = new DefaultListModel<>();
        lista = new JList<>(modeloLista);
        jScrollPane1.setViewportView(lista);
        cargarBoxEspecialidades(ctrlRegistroMedicos.cargaComboBoxEspecialidades());
    }

    /**
     * Carga el comboBox con la lista que le llega por parámetro.
     *
     * @param arrayList : lista con las especialidades.
     */
    private void cargarBoxEspecialidades(ArrayList<String> arrayList) {
        for (String elemento : arrayList) {
            comboBoxEspecialidades.addItem(elemento);
        }
    }

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
        botonAgregar = new javax.swing.JButton();
        dcFechaNac = new com.toedter.calendar.JDateChooser();
        textNumMatricula = new javax.swing.JTextField();
        comboBoxEspecialidades = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Nombre");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 60, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Apellido");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 60, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Fecha de Nacimiento");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setText("Domicilio");
        bg.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 153));
        jLabel6.setText("DNI");
        bg.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 153));
        jLabel7.setText("Telefono Fijo");
        bg.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, -1, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 153));
        jLabel8.setText("Telefono Celular");
        bg.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 120, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("Estado Civil");
        bg.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, 20));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 153));
        jLabel10.setText("Correo Electronico");
        bg.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 140, 20));

        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });
        bg.add(textNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 170, -1));
        bg.add(textApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 170, -1));
        bg.add(textDomicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 170, -1));
        bg.add(textDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 170, -1));
        bg.add(textFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 170, -1));
        bg.add(textCel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 170, -1));
        bg.add(textEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 170, -1));

        jLabelIconito.setText("jLabel1");
        bg.add(jLabelIconito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        jLabel12.setText("jLabel12");
        bg.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 160, 150));
        bg.add(dcFechaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 170, -1));

        botonRegistrar.setBackground(new java.awt.Color(0, 0, 153));
        botonRegistrar.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        botonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        botonRegistrar.setText("REGISTRAR");
        botonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarActionPerformed(evt);
            }
        });
        bg.add(botonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 130, 30));
        bg.add(textUniversidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 170, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Universidad");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 90, -1));

        jScrollPane1.setViewportView(lista);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 170, 120));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 153));
        jLabel11.setText("Especialidad");
        bg.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 90, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("Fecha");
        bg.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 50, -1));

        textMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMailActionPerformed(evt);
            }
        });
        bg.add(textMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 170, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 153));
        jLabel14.setText("N° Matricula");
        bg.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 90, -1));

        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        bg.add(botonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, -1, -1));
        bg.add(dcFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 170, -1));
        bg.add(textNumMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, 170, -1));

        comboBoxEspecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEspecialidadesActionPerformed(evt);
            }
        });
        bg.add(comboBoxEspecialidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed

    /**
     * Registra el médico, pasando por una validación de los datos cargados,
     * llamando al método del controller ´asignarEspecialidades()´, pasandole
     * por parámetros las listas de universidades, especialidades, fechas,
     * matrícula y DNI del médico , para luego llamar a otro método del
     * controller ´registrarMedico()´, pasandole por parámetro un objeto Médico
     * y Funcionario, objetos que ya han sido instanciados con sus respectivos
     * valores.
     *
     * @param evt
     */
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
        numMatricula = textNumMatricula.getText().trim();

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

            ctrlRegistroMedicos.asignarEspecialidades(arrayEspecialidades, arrayFechas, arrayUniversidades, numMatricula, Integer.parseInt(dni));

            if (matcherMail.matches()) {

                if (matcherDNI.matches()) {

                    if (validarMatricula(numMatricula)) {
                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                        String fechaFormateada = formato.format(fechaNacimiento);
                        Medico medico = new Medico(nombre, apellido, fechaFormateada, domicilio, dni, telFijo, telCelular, correoElectronico, Integer.parseInt(numMatricula), estadoCivil);
                        Funcionario funcionario = new Funcionario(nombre, apellido, fechaFormateada, domicilio, dni, telFijo, telCelular, correoElectronico, estadoCivil);
                        ctrlRegistroMedicos.registrarMedico(funcionario, medico);

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
                        JOptionPane.showMessageDialog(null, "Matricula no válida.");
                    }
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

    }//GEN-LAST:event_textMailActionPerformed

    /**
     * Valida la matrícula pasada por parámetro mediante expresiones regulares.
     *
     * @param matricula : número de matrícula del médico.
     * @return booleano.
     */
    public boolean validarMatricula(String matricula) {
        String patronMat = "^[0-9]{2,10}$";
        Pattern pattern = Pattern.compile(patronMat);
        Matcher matcher = pattern.matcher(matricula);

        return matcher.matches();
    }

    /**
     * Botón que valida los datos relacionados con la especialidad, agregando su
     * nombre en la lista y completando las listas de especialidades,
     * universidades donde fueron estudiadas y fechas las cuales obtuvieron ese
     * título.
     *
     * @param evt
     */
    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
        especialidad = (String) comboBoxEspecialidades.getSelectedItem();
        fechaTitulo = dcFechaTitulo.getDate();

        universidad = textUniversidad.getText();

        dni = textDNI.getText().trim();
        numMatricula = textNumMatricula.getText().trim();

        if (!dni.isEmpty()) {
            if (!numMatricula.isEmpty() && !especialidad.isEmpty() && fechaTitulo != null && !universidad.isEmpty()) {

                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String fechaTituloFormat = formato.format(fechaTitulo);

                if (!modeloLista.contains(especialidad)) {

                    modeloLista.addElement(especialidad);
                    lista.updateUI();

                    arrayEspecialidades.add(especialidad);
                    arrayFechas.add(fechaTituloFormat);
                    arrayUniversidades.add(universidad);

                } else {
                    JOptionPane.showMessageDialog(null, "Ya asignó la especialidad " + especialidad);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Faltan datos asociados a la especialidad.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar el DNI del médico a registrar especialidad.");
        }


    }//GEN-LAST:event_botonAgregarActionPerformed

    private void comboBoxEspecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEspecialidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxEspecialidadesActionPerformed

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
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonRegistrar;
    private javax.swing.JComboBox<String> comboBoxEspecialidades;
    private com.toedter.calendar.JDateChooser dcFechaNac;
    private com.toedter.calendar.JDateChooser dcFechaTitulo;
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
    private javax.swing.JTextField textEstadoCivil;
    private javax.swing.JTextField textFijo;
    private javax.swing.JTextField textMail;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNumMatricula;
    private javax.swing.JTextField textUniversidad;
    // End of variables declaration//GEN-END:variables
}
