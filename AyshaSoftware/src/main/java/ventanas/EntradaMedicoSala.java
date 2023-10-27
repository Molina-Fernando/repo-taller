
package ventanas;

import clases.Medico;
import dbController.CtrlConsulta;
import dbController.CtrlEntradaMedicoSala;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 * La clase `EntradaMedicoSala` representa la ventana que visualizan los
 * médicos de sala.
 */
public class EntradaMedicoSala extends javax.swing.JFrame {

    String dniUser = Login.user;
    ArrayList<Object[]> listaPacientes = new ArrayList<>();
    ArrayList<Object[]> listaBoxes = new ArrayList<>();
    ArrayList<Object[]> listaRetomados = new ArrayList<>();
    Object[]datosPacienteMedicoBox= new Object[6];
    DefaultTableModel modelo;
    DefaultTableModel modelo2;
    DefaultTableModel modelo3;
    CtrlEntradaMedicoSala ctrlDB = new CtrlEntradaMedicoSala();
    CtrlConsulta ctrlConsulta = new CtrlConsulta();
    public String dniV = null;
    public String disponibleV = null;
    public String numeroV = null;
    private Medico med;

    /**
     * Constructor que inicializa los componentes de la ventana
     */
    public EntradaMedicoSala() {
        initComponents();
        this.setLocationRelativeTo(null);
        setResizable(false);
        med = ctrlDB.recuperarMedico(dniUser);
        Toolkit miPantalla = Toolkit.getDefaultToolkit();
        Image miIcono = miPantalla.getImage("src\\main\\java\\images\\icon.png");
        setIconImage(miIcono);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("DNI");
        modelo.addColumn("Color");
        modelo.addColumn("Fecha");
        modelo.addColumn("Hora");
        modelo.addColumn("Motivo");

        actualizarTablaPacientesEnEspera();

        modelo2 = new DefaultTableModel();
        modelo2.addColumn("Numero");
        modelo2.addColumn("Disponibilidad");
        modelo2.addColumn("Médico");
        modelo2.addColumn("Paciente");
        modelo2.addColumn("Motivo");
        
        actualizarTablaBoxes();
        
        modelo3 = new DefaultTableModel();
        modelo3.addColumn("Box");
        modelo3.addColumn("Nombre");
        modelo3.addColumn("DNI");
        modelo3.addColumn("Color");
        modelo3.addColumn("Motivo");
        
        actualizarTablaPacientesEnSala();


//        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                cambiarDisponibilidad(numeroV);
//                dispose();
//            }
//        });
    }
    
    
    /**
     * Este método devuelve el objeto Medico asociado con la instancia actual.
     *
     * @return El objeto Medico asociado con la instancia actual.
     */
    public Medico getMed(){
        return this.med;
    }

    /**
     * Este método se encarga de actualizar la tabla de pacientes en espera luego del triage.
     * 
     * El método realiza las siguientes operaciones:
     * 1. Reinicia el modelo de la tabla.
     * 2. Crea una nueva tabla y establece su modelo.
     * 3. Recupera la lista de pacientes en espera de la base de datos.
     * 4. Añade cada paciente en la lista al modelo de la tabla.
     */
    private void actualizarTablaPacientesEnEspera() {
        modelo.setRowCount(0);
        tablaPacientes = new javax.swing.JTable();
        tablaPacientes.setModel(modelo);
        listaPacientes = ctrlDB.getTablaTriages();

        tablaPacientes = new JTable(modelo);
        jScrollPane1.setViewportView(tablaPacientes);

        for (Object[] vector : listaPacientes) {

            modelo.addRow(vector);
            tablaPacientes.setModel(modelo);
        }
    }

    /**
     * Este método se encarga de actualizar la tabla de boxes médicos.
     * 
     * El método realiza las siguientes operaciones:
     * 1. Reinicia el modelo de la tabla.
     * 2. Crea una nueva tabla y establece su modelo.
     * 3. Recupera la lista de boxes de la base de datos.
     * 4. Modifica los datos recuperados para incluir el nombre completo del médico.
     * 5. Añade cada box en la lista modificada al modelo de la tabla.
     */
    public void actualizarTablaBoxes() {
        modelo2.setRowCount(0);
        tablaBoxes = new javax.swing.JTable();
        tablaBoxes.setModel(modelo2);
        listaBoxes = ctrlDB.getTablaBoxes();
        // Crear un nuevo ArrayList para almacenar los datos modificados
        ArrayList<Object[]> listaModificada = new ArrayList<>();
        for (Object[] vector : listaBoxes) {
            // Crear una copia del vector para no alterar el original
            Object[] vectorModificado = vector.clone();
            if(!vectorModificado[2].equals(" ")){
                // Obtener el nombre completo del médico y almacenarlo en el vector modificado
                vectorModificado[2] = ctrlDB.nombreCompletoMedico(Integer.parseInt((String) vectorModificado[2]));
            }
            // Añadir el vector modificado a la lista modificada
            listaModificada.add(vectorModificado);
        }
        // Usar la lista modificada para actualizar la tabla
        for (Object[] vector : listaModificada) {
            modelo2.addRow(vector);
            tablaBoxes.setModel(modelo2);
        }
        tablaBoxes = new JTable(modelo2);
        jScrollPane2.setViewportView(tablaBoxes);
    }
    
    
    /**
     * Este método se encarga de actualizar la tabla de pacientes en la sala.
     * 
     * El método realiza las siguientes operaciones:
     * 1. Reinicia el modelo de la tabla.
     * 2. Crea una nueva tabla y establece su modelo.
     * 3. Recupera la lista de pacientes en la sala del médico actual de la base de datos.
     * 4. Añade cada paciente en la lista al modelo de la tabla.
     */
    public void actualizarTablaPacientesEnSala() {
        modelo3.setRowCount(0);
        tablaRetomados = new javax.swing.JTable();
        tablaRetomados.setModel(modelo3);
        listaRetomados = ctrlDB.getTablaPacientesEnSala(med.getNumMatricula());

        tablaRetomados = new JTable(modelo3);
        jScrollPane3.setViewportView(tablaRetomados);
        if(listaRetomados!=null){
            for (Object[] vector : listaRetomados) {
            modelo3.addRow(vector);
            tablaRetomados.setModel(modelo3);
            }
        }
        
    }

    /**
     * Este método se encarga de ocupar un box médico con un paciente.
     *
     * @param numeroV El número del box a ocupar.
     * @param matricula La matrícula del médico que atenderá al paciente.
     * @param nombrePac El nombre del paciente que ocupará el box.
     * @param motivo El motivo de la consulta del paciente.
     *
     * El método realiza las siguientes operaciones:
     * 1. Ocupa el box en la base de datos con los detalles proporcionados.
     * 2. Actualiza la tabla de boxes para reflejar el cambio.
     */
    public void ocuparBox(String numeroV, String matricula, String nombrePac, String motivo) {
        ctrlDB.ocuparBox(numeroV,matricula,nombrePac,motivo);
        actualizarTablaBoxes();
    }
    
    /**
     * Este método se encarga de desocupar un box médico.
     *
     * @param numeroV El número del box a desocupar.
     *
     * El método realiza las siguientes operaciones:
     * 1. Desocupa el box en la base de datos.
     * 2. Actualiza la tabla de boxes para reflejar el cambio.
     */
    public void desocuparBox(String numeroV) {
        ctrlDB.desocuparBox(numeroV);
        actualizarTablaBoxes();
    }
    
    /**
     * Este método se encarga de eliminar una fila de la tabla de triage.
     *
     * @param dniV El DNI del paciente a eliminar.
     *
     * El método realiza las siguientes operaciones:
     * 1. Elimina el paciente con el DNI proporcionado de la base de datos.
     * 2. Actualiza la tabla de pacientes en espera para reflejar el cambio.
     */
    private void eliminarFilaTriage(String dniV) {
        ctrlDB.eliminarPaciente(dniV);
        actualizarTablaPacientesEnEspera();
    }
    
    /**
     * Este método se encarga de eliminar los datos de un paciente que estuviera en espera en un box.
     *
     * @param dniV El DNI del paciente a eliminar.
     *
     * El método realiza las siguientes operaciones:
     * 1. Elimina el paciente con el DNI proporcionado de la base de datos.
     * 2. Actualiza la tabla de pacientes en la sala para reflejar el cambio.
     */
    private void eliminarPacienteEnBox(String dniV) {
        ctrlDB.eliminarPacienteEnBox(dniV);
        actualizarTablaPacientesEnSala();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        SeleccionPaciente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPacientes = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBoxes = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaRetomados = new javax.swing.JTable();
        retomarConsulta = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Elección Pacientes");
        setMaximumSize(new java.awt.Dimension(410, 470));
        setMinimumSize(new java.awt.Dimension(410, 470));
        setSize(410,470);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(410, 470));
        jPanel1.setMinimumSize(new java.awt.Dimension(410, 470));
        jPanel1.setPreferredSize(new java.awt.Dimension(410, 470));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1000, 6));

        SeleccionPaciente.setBackground(new java.awt.Color(0, 0, 153));
        SeleccionPaciente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        SeleccionPaciente.setForeground(new java.awt.Color(255, 255, 255));
        SeleccionPaciente.setText("Asignar box");
        SeleccionPaciente.setBorder(null);
        SeleccionPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionPacienteActionPerformed(evt);
            }
        });
        jPanel1.add(SeleccionPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 310, 30));

        jLabel1.setBackground(new java.awt.Color(0, 0, 153));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Pacientes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        tablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "DNI", "Color", "Fecha", "Hora", "Motivo"
            }
        ));
        tablaPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPacientes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 52, 1000, 147));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 228, 1000, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 153));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("Boxes");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, -1, -1));

        tablaBoxes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero", "Disponibilidad", "Médico", "Paciente", "Motivo"
            }
        ));
        tablaBoxes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBoxesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaBoxes);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 243, 1000, 188));

        tablaRetomados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Box", "Nombre", "DNI", "Color", "Motivo"
            }
        ));
        tablaRetomados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRetomadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaRetomados);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 522, 1000, 110));

        retomarConsulta.setBackground(new java.awt.Color(0, 0, 153));
        retomarConsulta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        retomarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        retomarConsulta.setText("Retomar consulta");
        retomarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retomarConsultaActionPerformed(evt);
            }
        });
        jPanel1.add(retomarConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 640, 310, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 153));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("Pacientes en box");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 490, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Este método se encarga de seleccionar un paciente y un box médico para una consulta.
     *
     * @param evt Evento de acción que desencadena este método.
     *
     * El método realiza las siguientes operaciones:
     * 1. Obtiene los números de fila seleccionados en las tablas de pacientes y boxes.
     * 2. Si no se selecciona ninguna fila en alguna de las tablas, muestra un mensaje de error y termina la ejecución.
     * 3. Recupera los detalles del paciente y del box de las tablas.
     * 4. Si el box seleccionado no está disponible, muestra un mensaje de error y termina la ejecución.
     * 5. Recupera los detalles del médico de la base de datos.
     * 6. Almacena los detalles del paciente, del médico y del box en un array.
     * 7. Ocupa el box con los detalles recuperados.
     * 8. Elimina la fila correspondiente al paciente de la tabla de triage.
     * 9. Crea e inicia una nueva instancia de MedicoSala.
     */
    private void SeleccionPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionPacienteActionPerformed
                        
        int numFila = tablaPacientes.getSelectedRow();
        int numFila2 = tablaBoxes.getSelectedRow();
        if (numFila == -1) {
            JOptionPane.showMessageDialog(null, "¡Error! No se seleccionó ningún paciente.");
            return;
        }
        if (numFila2 == -1) {
            JOptionPane.showMessageDialog(null, "¡Error! No se seleccionó ningún box.");
            return;
        }
        String nombrePaciente =(String) tablaPacientes.getValueAt(numFila, 0);
        String motivoPaciente =(String) tablaPacientes.getValueAt(numFila, 5);
        this.dniV=(String) tablaPacientes.getValueAt(numFila, 1);      
        this.disponibleV = (String) tablaBoxes.getValueAt(numFila2, 1);
        this.numeroV = (String) tablaBoxes.getValueAt(numFila2, 0);
        if (!disponibleV.equals("Disponible")) {
            JOptionPane.showMessageDialog(null, "¡Error! El box seleccionado no está disponible.");
            return;
        }
       
        //Tengo que hacer que esto al menos se guarde en la base de datos de forma optima
        datosPacienteMedicoBox[0]=tablaBoxes.getValueAt(numFila2, 0); //Número del Box
        datosPacienteMedicoBox[1]=tablaPacientes.getValueAt(numFila, 0); //Nombre del Paciente
        datosPacienteMedicoBox[2]=tablaPacientes.getValueAt(numFila, 1); //DNI
        datosPacienteMedicoBox[3]=tablaPacientes.getValueAt(numFila, 2); //Color del triage
        datosPacienteMedicoBox[4]=tablaPacientes.getValueAt(numFila, 5); //Motivo de la consulta
        datosPacienteMedicoBox[5]=med.getNumMatricula(); // Matricula del médico
        ocuparBox(numeroV,String.valueOf(med.getNumMatricula()),nombrePaciente,motivoPaciente);
        eliminarFilaTriage(dniV);
        MedicoSala m = new MedicoSala(this);
        m.setVisible(true);
        ctrlConsulta.terceraCarga(med.getApellido(), med.getNumMatricula(), dniV);
        dniV = null;
    }//GEN-LAST:event_SeleccionPacienteActionPerformed

    private void tablaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPacientesMouseClicked

    }//GEN-LAST:event_tablaPacientesMouseClicked

    private void tablaBoxesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBoxesMouseClicked

    }//GEN-LAST:event_tablaBoxesMouseClicked

    private void tablaRetomadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRetomadosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaRetomadosMouseClicked

    
    /**
     * Este método se encarga de retomar una consulta médica seleccionada por el usuario.
     * 
     * @param evt Evento de acción que desencadena este método.
     * 
     * El método realiza las siguientes operaciones:
     * 1. Obtiene el número de fila seleccionado en la tabla de pacientes.
     * 2. Si no se selecciona ninguna fila, muestra un mensaje de error y termina la ejecución.
     * 3. Recupera los detalles del paciente y la consulta de la tabla.
     * 4. Recupera los detalles del médico de la base de datos.
     * 5. Ocupa un box médico con los detalles recuperados.
     * 6. Elimina la fila correspondiente al paciente de la tabla de triage.
     * 7. Crea e inicia una nueva instancia de MedicoSala.
     */
    private void retomarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retomarConsultaActionPerformed
        int numFila = tablaRetomados.getSelectedRow();
        if (numFila == -1) {
            JOptionPane.showMessageDialog(null, "¡Error! No se seleccionó ningún paciente.");
            return;
        }
        this.numeroV = (String) tablaRetomados.getValueAt(numFila, 0);
        String nombrePaciente =(String) tablaRetomados.getValueAt(numFila, 1);
        this.dniV = (String) tablaRetomados.getValueAt(numFila, 2);
        String motivoPaciente =(String) tablaRetomados.getValueAt(numFila, 4); 
        
        datosPacienteMedicoBox[0]=tablaRetomados.getValueAt(numFila, 0);//Box
        datosPacienteMedicoBox[1]=tablaRetomados.getValueAt(numFila, 1);//Nombre del paciente
        datosPacienteMedicoBox[2]=tablaRetomados.getValueAt(numFila, 2);//DNI
        datosPacienteMedicoBox[3]=tablaRetomados.getValueAt(numFila, 3);//COLOR
        datosPacienteMedicoBox[4]=tablaRetomados.getValueAt(numFila, 4);//Motivo
        datosPacienteMedicoBox[5]=med.getNumMatricula(); // Matricula del médico
        
        ocuparBox(numeroV,String.valueOf(med.getNumMatricula()),nombrePaciente,motivoPaciente);
        eliminarPacienteEnBox(dniV);
        MedicoSala m = new MedicoSala(this);
        m.setVisible(true);
//        ctrlConsulta.terceraCarga(med.getApellido(), med.getNumMatricula(), dniV);

        dniV = null;
    }//GEN-LAST:event_retomarConsultaActionPerformed

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
            java.util.logging.Logger.getLogger(EntradaMedicoSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntradaMedicoSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntradaMedicoSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntradaMedicoSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EntradaMedicoSala().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SeleccionPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton retomarConsulta;
    private javax.swing.JTable tablaBoxes;
    private javax.swing.JTable tablaPacientes;
    private javax.swing.JTable tablaRetomados;
    // End of variables declaration//GEN-END:variables

}
