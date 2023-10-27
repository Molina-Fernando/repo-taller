package ventanas;

import Utilidades.SetImageLabel;
import dbController.CtrlInfoMedico;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 * La ventana ´InfoMedico´, es la encargada de que el gestor pueda visualizar
 * todos los datos de los médicos registrados en el sistema.
 */
public class InfoMedico extends javax.swing.JFrame {

    DefaultTableModel modelo;
    DefaultTableModel modeloR;
    ArrayList<Object[]> arrayListVectores;
    CtrlInfoMedico ctrlDb = new CtrlInfoMedico();
    ArrayList<Object[]> arrayListEspecialidades;

    /**
     * Constructor que inicializa los componentes de la ventana
     */
    public InfoMedico() {
        initComponents();

        setTitle("Información de Médicos");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src\\main\\java\\images\\icon.png");
        setIconImage(miIcono);
        SetImageLabel.setImageLabel(LabelIconito, "src\\main\\java\\images\\icon.png");
        modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("telCel");
        modelo.addColumn("Mail");
        modelo.addColumn("Matricula");

        modeloR = new DefaultTableModel();
        modeloR.addColumn("Matricula");
        modeloR.addColumn("Especialidades");
        modeloR.addColumn("Universidad");
        modeloR.addColumn("Fecha");

        actualizarTabla();
        actualizarTablaEspecialidades();
    }

    /**
     * Actualiza la tabla donde se muestran los médicos.
     */
    private void actualizarTabla() {
        modelo.setRowCount(0);
        tablaMedicos = new javax.swing.JTable();
        tablaMedicos.setModel(modelo);

        arrayListVectores = ctrlDb.getTablaMedicos();

        tablaMedicos = new JTable(modelo);
        jScrollPane2.setViewportView(tablaMedicos);

        for (Object[] vector : arrayListVectores) {
            modelo.addRow(vector);
            tablaMedicos.setModel(modelo);
        }
    }

    /**
     * Actualiza la tabla donde se visualizan las especialidades de cada médico.
     */
    private void actualizarTablaEspecialidades() {
        modeloR.setRowCount(0);
        tablaEspecialidades = new javax.swing.JTable();
        tablaEspecialidades.setModel(modeloR);

        tablaEspecialidades = new JTable(modeloR);
        jScrollPane1.setViewportView(tablaEspecialidades);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMedicos = new javax.swing.JTable();
        botonMostrarEspecialidades = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEspecialidades = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        LabelIconito = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaMedicos = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tablaMedicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Apellido", "TelCel", "Mail", "Matricula"
            }
        ));
        tablaMedicos.getTableHeader().setResizingAllowed(false);
        tablaMedicos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaMedicos);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 790, 150));

        botonMostrarEspecialidades.setBackground(new java.awt.Color(0, 0, 153));
        botonMostrarEspecialidades.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonMostrarEspecialidades.setForeground(new java.awt.Color(255, 255, 255));
        botonMostrarEspecialidades.setText("Visualizar especialidades");
        botonMostrarEspecialidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarEspecialidadesActionPerformed(evt);
            }
        });
        jPanel1.add(botonMostrarEspecialidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 190, 30));

        tablaEspecialidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Matricula", "Especialidades", "Universidad", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(tablaEspecialidades);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 520, 90));

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Lista de médicos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 130, 30));

        LabelIconito.setText("jLabel8");
        jPanel1.add(LabelIconito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón que carga la tabla de especialidades de un médico que se haya
     * seleccionado.
     *
     * @param evt
     */
    private void botonMostrarEspecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarEspecialidadesActionPerformed
        modeloR.setRowCount(0);
        int numFila = tablaMedicos.getSelectedRow();

        if (numFila != -1) {

            String dnistr = (String) tablaMedicos.getValueAt(numFila, 0);

            arrayListEspecialidades = ctrlDb.getTablaEspecialidades(Integer.parseInt(dnistr));

            for (Object[] vector : arrayListEspecialidades) {
                modeloR.addRow(vector);
                tablaEspecialidades.setModel(modeloR);
            }

        }
    }//GEN-LAST:event_botonMostrarEspecialidadesActionPerformed
    /**
     * Método principal que inicia la ventana Swing.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en
     * este caso).
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
            java.util.logging.Logger.getLogger(InfoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelIconito;
    private javax.swing.JButton botonMostrarEspecialidades;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEspecialidades;
    private javax.swing.JTable tablaMedicos;
    // End of variables declaration//GEN-END:variables
}
