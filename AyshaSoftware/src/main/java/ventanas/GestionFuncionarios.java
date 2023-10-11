package ventanas;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.WindowConstants;

import dbController.CtrlGestionFuncionarios;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class GestionFuncionarios extends javax.swing.JFrame {

    DefaultTableModel modelo;
    ArrayList<Object[]> arrayListVectores;
    CtrlGestionFuncionarios dbCtrl = new CtrlGestionFuncionarios();
    private DefaultListModel<String> modeloLista;
    private String rol;

    public GestionFuncionarios() {
        initComponents();
        setTitle("Gestión de Funcionarios");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        arrayListVectores = new ArrayList<>();

        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src\\main\\java\\images\\icon.png");
        setIconImage(miIcono);

        modeloLista = new DefaultListModel<>();
        lista = new JList<>(modeloLista);
        jScrollPane2.setViewportView(lista);
        modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        //modelo.addColumn("Rol");
        modelo.addColumn("Sector");
        actualizarTabla();
        cargarBoxRoles(dbCtrl.cargaComboBoxRoles());
    }

    private void cargarBoxRoles(ArrayList<String> arrayList) {
        for (String elemento : arrayList) {
            comboBoxRoles.addItem(elemento);
        }
    }

    String nomDB;
    int dniDB;

    private void actualizarTabla() {
        modelo.setRowCount(0);
        tablaFuncionarios = new javax.swing.JTable();
        tablaFuncionarios.setModel(modelo);

        arrayListVectores = dbCtrl.getTablaFuncionarios(dniDB, nomDB);

        tablaFuncionarios = new JTable(modelo);
        jScrollPane1.setViewportView(tablaFuncionarios);

        for (Object[] vector : arrayListVectores) {

            String dniParcialString = vector[0].toString();
            dniDB = Integer.parseInt(dniParcialString);
            nomDB = vector[1].toString();

            modelo.addRow(vector);
            tablaFuncionarios.setModel(modelo);
        }
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFuncionarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonEliminar = new javax.swing.JButton();
        botonAlta = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        botonAlta1 = new javax.swing.JButton();
        comboBoxRoles = new javax.swing.JComboBox<>();
        botonAlta2 = new javax.swing.JButton();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 730, 190));

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Roles a asignar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 120, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Rol(es)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 50, 20));

        botonEliminar.setBackground(new java.awt.Color(0, 0, 153));
        botonEliminar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminar.setText("ELIMINAR");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 380, 110, 30));

        botonAlta.setBackground(new java.awt.Color(0, 0, 153));
        botonAlta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAlta.setForeground(new java.awt.Color(255, 255, 255));
        botonAlta.setText("ALTA");
        botonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaActionPerformed(evt);
            }
        });
        jPanel1.add(botonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, 110, 30));

        jScrollPane2.setViewportView(lista);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 220, 120));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 740, 160));

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("  PENDIENTES DE ALTA (quienes no tienen rol y sector)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 390, 40));

        botonActualizar.setBackground(new java.awt.Color(0, 0, 153));
        botonActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonActualizar.setForeground(new java.awt.Color(255, 255, 255));
        botonActualizar.setText("ACTUALIZAR");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, 110, 30));

        jLabel4.setBackground(new java.awt.Color(0, 0, 153));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Roles asociados");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 490, 120, 40));

        botonAlta1.setBackground(new java.awt.Color(0, 0, 153));
        botonAlta1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAlta1.setForeground(new java.awt.Color(255, 255, 255));
        botonAlta1.setText("Agregar a la Lista");
        botonAlta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlta1ActionPerformed(evt);
            }
        });
        jPanel1.add(botonAlta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 140, 30));

        jPanel1.add(comboBoxRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, -1, -1));

        botonAlta2.setBackground(new java.awt.Color(0, 0, 153));
        botonAlta2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonAlta2.setForeground(new java.awt.Color(255, 255, 255));
        botonAlta2.setText("Asignar Roles");
        botonAlta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAlta2ActionPerformed(evt);
            }
        });
        jPanel1.add(botonAlta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 420, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 910, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonAlta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlta1ActionPerformed
        // TODO add your handling code here:
        //modeloLista.clear();
        rol = (String) comboBoxRoles.getSelectedItem();
        System.out.println(rol);
        if(!modeloLista.contains(rol)){
        modeloLista.addElement(rol);
        lista.updateUI();
        int numFila = tablaFuncionarios.getSelectedRow();
        if (numFila != -1) {
            String dnistr = (String) tablaFuncionarios.getValueAt(numFila, 0);
            int dniDB = Integer.parseInt(dnistr);
            
        dbCtrl.agregarRoles(rol,dniDB);
            System.out.println(dniDB);
        }
        }else{
            JOptionPane.showMessageDialog(null, "Ya asignó el rol " + rol);
        
        }
        //modeloLista.clear();
    }//GEN-LAST:event_botonAlta1ActionPerformed

    private void botonAlta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAlta2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAlta2ActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonEliminarActionPerformed

        int numFila = tablaFuncionarios.getSelectedRow();
        if (numFila != -1) {
            String dnistr = (String) tablaFuncionarios.getValueAt(numFila, 0);
            int dni = Integer.parseInt(dnistr);

            dbCtrl.eliminarFuncionario(dni);
            DefaultTableModel model = (DefaultTableModel) tablaFuncionarios.getModel();
            model.removeRow(numFila);

        }
    }

    private String selectedOption;
    private String selectedOption2;

    private void botonAltaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonAltaActionPerformed
        // TODO add your handling code here:
        int numFila = tablaFuncionarios.getSelectedRow();
        if (numFila != -1) {

            String dnistr = (String) tablaFuncionarios.getValueAt(numFila, 0);
            int dni = Integer.parseInt(dnistr);
            dbCtrl.altaFuncionario(dni, selectedOption, selectedOption2, nomDB, dniDB);
            actualizarTabla();
        }
    }

    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonAlta;
    private javax.swing.JButton botonAlta1;
    private javax.swing.JButton botonAlta2;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JComboBox<String> comboBoxRoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<String> lista;
    private javax.swing.JTable tablaFuncionarios;
    // End of variables declaration//GEN-END:variables
}
