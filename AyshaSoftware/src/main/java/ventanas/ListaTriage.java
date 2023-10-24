
package ventanas;

import javax.swing.table.DefaultTableModel;
import dbController.CtrlListaTriage;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class ListaTriage extends javax.swing.JFrame {

    public static String nombreUpdate = "";
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Object[]> arrayListEspera;
    CtrlListaTriage dbCtrl = new CtrlListaTriage();

    public ListaTriage() {

        initComponents();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src\\main\\java\\images\\icon.png");
        setIconImage(miIcono);
        SetImageLabel.setImageLabel(LabelIconito, "src\\main\\java\\images\\icon.png");
        setTitle("Lista para Triage");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("DNI");
        tablaUsuarios = new javax.swing.JTable();
        arrayListEspera = new ArrayList<>();
        actualizarTabla();
    }
 

    private void actualizarTabla() {
        modelo.setRowCount(0);

        tablaUsuarios.setModel(modelo);
        arrayListEspera = dbCtrl.tablaLista();

        tablaUsuarios = new JTable(modelo);
        jScrollPane1.setViewportView(tablaUsuarios);

        for (Object[] vector : arrayListEspera) {


            modelo.addRow(vector);
            tablaUsuarios.setModel(modelo);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        botonTriage = new javax.swing.JButton();
        LabelIconito = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 550, 180));

        botonTriage.setBackground(new java.awt.Color(0, 0, 153));
        botonTriage.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonTriage.setForeground(new java.awt.Color(255, 255, 255));
        botonTriage.setText("Realizar Triage");
        botonTriage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTriageActionPerformed(evt);
            }
        });
        jPanel1.add(botonTriage, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, -1, 30));

        LabelIconito.setText("Label1");
        LabelIconito.setPreferredSize(new java.awt.Dimension(39, 16));
        jPanel1.add(LabelIconito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void botonTriageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTriageActionPerformed

        int numFila = tablaUsuarios.getSelectedRow();

        if (numFila != -1) {
            String dnistr = (String) tablaUsuarios.getValueAt(numFila, 2);
            int dni = Integer.parseInt(dnistr);

            dbCtrl.eliminarPacienteEsperaTriage(dni);
            DefaultTableModel model = (DefaultTableModel) tablaUsuarios.getModel();
            model.removeRow(numFila);
            new MedicoTriage().setVisible(true);
            
        }
    }//GEN-LAST:event_botonTriageActionPerformed

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
            java.util.logging.Logger.getLogger(ListaTriage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaTriage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaTriage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaTriage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaTriage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelIconito;
    private javax.swing.JButton botonTriage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
