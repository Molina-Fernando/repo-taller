package ventanas;

import Utilidades.SetImageLabel;
import dbController.CtrlInfoFuncionario;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 * La ventana ´InfoFuncionario´, es la encargada de que el gestor pueda
 * visualizar todos los datos de los funcionarios registrados en el sistema.
 */
public class InfoFuncionario extends javax.swing.JFrame {

    DefaultTableModel modelo;
    DefaultTableModel modeloR;

    ArrayList<Object[]> arrayListVectores;
    ArrayList<Object[]> arrayListRoles;
    CtrlInfoFuncionario ctrlDb = new CtrlInfoFuncionario();

    /**
     * Constructor de la ventana de Información de Funcionarios. Inicializa la
     * interfaz de usuario de la ventana, establece el título de la ventana, su
     * ubicación, y propiedades como su capacidad de redimensionamiento y
     * comportamiento de cierre. También carga y establece el ícono de la
     * ventana, así como los modelos de tabla para mostrar información de
     * funcionarios y roles asociados. Llama a los métodos de actualización de
     * tablas para cargar datos iniciales en la ventana.
     */
    public InfoFuncionario() {
        initComponents();
        setTitle("Información de Funcionarios");
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
        modelo.addColumn("Sector");

        modeloR = new DefaultTableModel();
        modeloR.addColumn("DNI");
        modeloR.addColumn("Rol");

        actualizarTabla();
        actualizarTablaRoles();

    }

    /**
     * Actualiza la tabla de funcionarios en la ventana.Obtiene datos de la base
     * de datos a través del controlador de gestión de funcionarios (`dbCtrl`),
     * y llena la tabla con los datos.
     */
    private void actualizarTabla() {
        modelo.setRowCount(0);
        tablaFuncionarios = new javax.swing.JTable();
        tablaFuncionarios.setModel(modelo);

        arrayListVectores = ctrlDb.getTablaFuncionario();

        tablaFuncionarios = new JTable(modelo);
        jScrollPane2.setViewportView(tablaFuncionarios);

        for (Object[] vector : arrayListVectores) {
            modelo.addRow(vector);
            tablaFuncionarios.setModel(modelo);
        }
    }

    /**
     * Actualiza la tabla de roles asociados en la ventana. Borra todos los
     * datos existentes en la tabla de roles y la reconstruye con los nuevos
     * datos de acuerdo al estado actual de `modeloR`.
     */
    private void actualizarTablaRoles() {
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
        tablaFuncionarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        LabelIconito = new javax.swing.JLabel();
        botonMostrarRoles = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEspecialidades = new javax.swing.JTable();

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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Apellido", "TelCel", "Mail", "Matricula"
            }
        ));
        tablaFuncionarios.getTableHeader().setResizingAllowed(false);
        tablaFuncionarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaFuncionarios);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 790, 180));

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Lista de funcionarios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 160, 30));

        LabelIconito.setText("jLabel8");
        jPanel1.add(LabelIconito, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        botonMostrarRoles.setBackground(new java.awt.Color(0, 0, 153));
        botonMostrarRoles.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonMostrarRoles.setForeground(new java.awt.Color(255, 255, 255));
        botonMostrarRoles.setText("Visualizar roles");
        botonMostrarRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarRolesActionPerformed(evt);
            }
        });
        jPanel1.add(botonMostrarRoles, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 190, 30));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 410, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Maneja el evento de clic en el botón "Mostrar Roles" para un funcionario
     * seleccionado. Este método actualiza la tabla de roles, eliminando todas
     * las filas existentes y cargando los roles asociados al funcionario
     * seleccionado. Primero verifica si se ha seleccionado un funcionario en la
     * tabla principal. Luego, obtiene el DNI del funcionario seleccionado y
     * utiliza ese valor para recuperar los roles asociados a ese funcionario
     * desde la base de datos. Luego, agrega estos roles a la tabla de roles y
     * la muestra en la interfaz gráfica.
     *
     * @param evt El evento de acción que desencadena este método (clic en el
     * botón "Mostrar roles").
     */

    private void botonMostrarRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarRolesActionPerformed
        modeloR.setRowCount(0);
        int numFila = tablaFuncionarios.getSelectedRow();

        if (numFila != -1) {

            String dnistr = (String) tablaFuncionarios.getValueAt(numFila, 0);

            arrayListRoles = ctrlDb.getTablaRoles(Integer.parseInt(dnistr));

            for (Object[] vector : arrayListRoles) {
                modeloR.addRow(vector);
                tablaEspecialidades.setModel(modeloR);
            }

        }
    }//GEN-LAST:event_botonMostrarRolesActionPerformed
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
            java.util.logging.Logger.getLogger(InfoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InfoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InfoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InfoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelIconito;
    private javax.swing.JButton botonMostrarRoles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaEspecialidades;
    private javax.swing.JTable tablaFuncionarios;
    // End of variables declaration//GEN-END:variables
}
