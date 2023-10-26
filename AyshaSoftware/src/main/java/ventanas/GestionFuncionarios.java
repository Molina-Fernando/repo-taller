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

/**
 * La clase `GestionFuncionarios` representa la ventana de gestión de
 * funcionarios.
 */
public class GestionFuncionarios extends javax.swing.JFrame {

    DefaultTableModel modelo;
    DefaultTableModel modeloR;
    ArrayList<Object[]> arrayListVectores;
    ArrayList<Object[]> arrayListRoles;
    CtrlGestionFuncionarios dbCtrl = new CtrlGestionFuncionarios();
    private DefaultListModel<String> modeloLista;
    private String rol;

    /**
     * Constructor de la clase `GestionFuncionarios`. Inicializa la ventana y
     * configura su apariencia, así como los modelos de tabla y listas.
     */
    public GestionFuncionarios() {
        initComponents();
        setTitle("Gestión de Funcionarios");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        arrayListVectores = new ArrayList<>();
        arrayListRoles = new ArrayList<>();

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
        modelo.addColumn("Sector");

        modeloR = new DefaultTableModel();
        modeloR.addColumn("DNI");
        modeloR.addColumn("Rol");

        actualizarTabla();
        actualizarTablaRoles();

        cargarBoxRoles(dbCtrl.cargaComboBoxRoles());
    }

    /**
     * Método que carga el comboBox con los nombres de roles obtenidos de la
     * base de datos
     *
     * @param arrayList lista de nombre de roles
     */
    private void cargarBoxRoles(ArrayList<String> arrayList) {
        for (String elemento : arrayList) {
            comboBoxRoles.addItem(elemento);
        }
    }

    String nomDB;
    int dniDB;

    /**
     * Actualiza la tabla de funcionarios en la ventana. Elimina todos los datos
     * existentes en la tabla de funcionarios, obtiene nuevos datos de la base
     * de datos a través del controlador de gestión de funcionarios (`dbCtrl`),
     * y llena la tabla con los nuevos datos.
     */
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

    /**
     * Actualiza la tabla de roles en la ventana. Borra todos los datos
     * existentes en la tabla de roles y la reconstruye con los nuevos datos de
     * acuerdo al estado actual de `modeloR`.
     */
    private void actualizarTablaRoles() {
        modeloR.setRowCount(0);
        tablaRoles = new javax.swing.JTable();
        tablaRoles.setModel(modeloR);

        tablaRoles = new JTable(modeloR);
        jScrollPane3.setViewportView(tablaRoles);
    }

    @SuppressWarnings("unchecked")

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
        tablaRoles = new javax.swing.JTable();
        botonActualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        botonAgrearLista = new javax.swing.JButton();
        comboBoxRoles = new javax.swing.JComboBox<>();
        botonAsignarRoles = new javax.swing.JButton();

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 730, 190));

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Roles a asignar");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 120, 40));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Seleccione Rol(es)");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 140, 20));

        botonEliminar.setBackground(new java.awt.Color(0, 0, 153));
        botonEliminar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        botonEliminar.setText("ELIMINAR");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, 120, 30));

        botonAlta.setBackground(new java.awt.Color(0, 0, 153));
        botonAlta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botonAlta.setForeground(new java.awt.Color(255, 255, 255));
        botonAlta.setText("ALTA");
        botonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaActionPerformed(evt);
            }
        });
        jPanel1.add(botonAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 250, 120, 30));

        jScrollPane2.setViewportView(lista);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 210, 100));

        tablaRoles.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaRoles);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 470, 160));

        botonActualizar.setBackground(new java.awt.Color(0, 0, 153));
        botonActualizar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botonActualizar.setForeground(new java.awt.Color(255, 255, 255));
        botonActualizar.setText("VER ROLES");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 120, 30));

        jLabel4.setBackground(new java.awt.Color(0, 0, 153));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setText("Roles asociados");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 120, 40));

        botonAgrearLista.setBackground(new java.awt.Color(0, 0, 153));
        botonAgrearLista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botonAgrearLista.setForeground(new java.awt.Color(255, 255, 255));
        botonAgrearLista.setText("Agregar rol a la Lista");
        botonAgrearLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgrearListaActionPerformed(evt);
            }
        });
        jPanel1.add(botonAgrearLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 240, 30));

        comboBoxRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRolesActionPerformed(evt);
            }
        });
        jPanel1.add(comboBoxRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 170, -1));

        botonAsignarRoles.setBackground(new java.awt.Color(0, 0, 153));
        botonAsignarRoles.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botonAsignarRoles.setForeground(new java.awt.Color(255, 255, 255));
        botonAsignarRoles.setText("Asignar Roles");
        botonAsignarRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAsignarRolesActionPerformed(evt);
            }
        });
        jPanel1.add(botonAsignarRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 250, 140, 30));

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de actualización de la tabla de roles asociados. Borra
     * todos los datos existentes en la tabla de roles y obtiene nuevos datos de
     * roles asociados a un funcionario seleccionado en la tabla de
     * funcionarios. Luego llena la tabla de roles con los nuevos datos.
     *
     * @param evt El evento de acción que desencadena la actualización.
     */

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        // TODO add your handling code here:
        modeloR.setRowCount(0);
        int numFila = tablaFuncionarios.getSelectedRow();
        if (numFila != -1) {

            String dnistr = (String) tablaFuncionarios.getValueAt(numFila, 0);

            arrayListRoles = dbCtrl.getTablaRolesAsociados(Integer.parseInt(dnistr));

            for (Object[] vector : arrayListRoles) {
                modeloR.addRow(vector);
                tablaRoles.setModel(modeloR);
            }

        }

    }//GEN-LAST:event_botonActualizarActionPerformed

    ArrayList<String> arrayRolesInputDB = new ArrayList<>();

    /**
     * Maneja el evento de agregar un rol a la lista de roles seleccionados.
     * Obtiene el rol seleccionado en el ComboBox de roles, verifica si ya se
     * encuentra en la lista de roles seleccionados (`modeloLista`), y lo agrega
     * a la lista si no está presente. Si el rol ya está en la lista, muestra un
     * mensaje de advertencia.
     *
     * @param evt El evento de acción que desencadena la acción de agregar un
     * rol a la lista.
     */

    private void botonAgrearListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgrearListaActionPerformed

        rol = (String) comboBoxRoles.getSelectedItem();
        System.out.println(rol);
        if (!modeloLista.contains(rol)) {

            modeloLista.addElement(rol);
            lista.updateUI();

            arrayRolesInputDB.add(rol);

        } else {
            JOptionPane.showMessageDialog(null, "Ya asignó el rol " + rol);

        }

    }//GEN-LAST:event_botonAgrearListaActionPerformed

    /**
     * Maneja el evento de asignar roles a un funcionario seleccionado. Obtiene
     * la fila seleccionada en la tabla de funcionarios, recupera el DNI del
     * funcionario seleccionado, y asigna los roles de la lista
     * `arrayRolesInputDB` al funcionario a través del controlador de gestión de
     * funcionarios (`dbCtrl`). Finalmente, limpia la lista de roles
     * seleccionados en la interfaz de usuario. Muestra una advertencia si no se
     * selecciona ningún funcionario.
     *
     * @param evt El evento de acción que desencadena la acción de asignar
     * roles.
     */

    private void botonAsignarRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAsignarRolesActionPerformed

        int numFila = tablaFuncionarios.getSelectedRow();
        if (numFila != -1) {
            String dnistr = (String) tablaFuncionarios.getValueAt(numFila, 0);
            int dniDBA = Integer.parseInt(dnistr);
            System.out.println(dniDBA);
            dbCtrl.asignarRoles(arrayRolesInputDB, dniDBA);
            modeloLista.clear();

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un funcionario de la tabla");
        }

    }//GEN-LAST:event_botonAsignarRolesActionPerformed


    private void comboBoxRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRolesActionPerformed

    }//GEN-LAST:event_comboBoxRolesActionPerformed

    /**
     * Maneja el evento de eliminar un funcionario seleccionado de la tabla.
     * Obtiene la fila seleccionada en la tabla de funcionarios, recupera el DNI
     * del funcionario seleccionado y utiliza el controlador de gestión de
     * funcionarios (`dbCtrl`) para eliminar el funcionario de la base de datos.
     * Luego, elimina la fila correspondiente de la tabla de funcionarios en la
     * interfaz de usuario. Muestra una advertencia si no se selecciona ningún
     * funcionario.
     *
     * @param evt El evento de acción que desencadena la acción de eliminar un
     * funcionario.
     */
    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {

        int numFila = tablaFuncionarios.getSelectedRow();
        if (numFila != -1) {
            String dnistr = (String) tablaFuncionarios.getValueAt(numFila, 0);
            int dni = Integer.parseInt(dnistr);

            dbCtrl.eliminarFuncionario(dni);
            DefaultTableModel model = (DefaultTableModel) tablaFuncionarios.getModel();
            model.removeRow(numFila);

        }
    }

    /**
     * Maneja el evento de dar de alta a un nuevo funcionario. Obtiene la fila
     * seleccionada en la tabla de funcionarios, recupera el DNI y el nombre del
     * funcionario seleccionado, y utiliza el controlador de gestión de
     * funcionarios (`dbCtrl`) para agregar un nuevo funcionario a la base de
     * datos con los datos proporcionados. Luego, actualiza la tabla de
     * funcionarios en la interfaz de usuario con los cambios. Muestra una
     * advertencia si no se selecciona ningún funcionario.
     *
     * @param evt El evento de acción que desencadena la acción de dar de alta a
     * un funcionario.
     */
    private void botonAltaActionPerformed(java.awt.event.ActionEvent evt) {

        int numFila = tablaFuncionarios.getSelectedRow();
        if (numFila != -1) {

            String dnistr = (String) tablaFuncionarios.getValueAt(numFila, 0);
            String nomstr = (String) tablaFuncionarios.getValueAt(numFila, 1);
            int dni = Integer.parseInt(dnistr);
            System.out.println(dni);
            dbCtrl.altaFuncionario(nomstr, dni);
            actualizarTabla();
        }
    }

    /**
     * Método principal que inicia la ventana Swing.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en
     * este caso).
     */
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
    private javax.swing.JButton botonAgrearLista;
    private javax.swing.JButton botonAlta;
    private javax.swing.JButton botonAsignarRoles;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JComboBox<String> comboBoxRoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lista;
    private javax.swing.JTable tablaFuncionarios;
    private javax.swing.JTable tablaRoles;
    // End of variables declaration//GEN-END:variables
}
