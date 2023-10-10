/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas.panelesmedicos;

import clases.Estudio;
import clases.Lugares;
import clases.Registro;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaqu
 */
public class Panel2 extends javax.swing.JPanel {
    
    DefaultTableModel modelo= new DefaultTableModel();
    DefaultTableModel modelo2= new DefaultTableModel();
    ArrayList<Registro>lista=new ArrayList<>();
    ArrayList<Estudio>otraLista=new ArrayList<>();
    /**
     * Creates new form Panel2
     */
    public Panel2() {
        initComponents();
        //cargarDatos();
        
    }
//    public void cargarDatos(){
//        
//        //CARGA MANUAL DE REGISTROS Y ESTUDIOS A AMBAS TABLAS SIN LÖGICA DE BASE DE DATOS 
//        //MUCHO DE ESTO SE HACE EN OTRO LADO
//
//        
//        
//        //CARGA DE REGISTROS
//        LocalDate fecha=LocalDate.of(2023, Month.JANUARY, 21);
//        LocalTime hora=LocalTime.of(23, 50);
//        Lugares lugar=Lugares.EMERGENCIA;
//        Registro reg=new Registro(fecha,hora,"Presenta apnea del sueño",lugar,p.getDni());
//
//        LocalDate fecha1=LocalDate.of(2023, Month.APRIL, 15);
//        LocalTime hora1=LocalTime.of(10, 10);
//        Lugares lugar1=Lugares.CONSULTORIO;
//        Registro reg1=new Registro(fecha1,hora1,"Presenta fibromialgia",lugar1,);
//        
//        lista.add(reg);
//        lista.add(reg1);
//        
//        modelo.addColumn("Fecha");
//        modelo.addColumn("Lugar");
//        tablaRegistros.setModel(modelo);
//        
//        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Define el formato deseado
//        
//        
//        for (Registro registro : lista){
//            String fechaFormateada = registro.getFecha().format(formato);
//            String lugarFormateado = String.valueOf(registro.getLugares());
//            String[]cosas={fechaFormateada,lugarFormateado};
//            modelo.addRow(cosas);
//        }
//        
//        tablaRegistros.setModel(modelo);
//        
//        //CARGA DE ESTUDIOS
//        LocalDate fecha3=LocalDate.of(2023, Month.JANUARY, 21);
//        LocalTime hora3=LocalTime.of(23, 50);
//        Estudio es =new Estudio(fecha3,hora3,"Espirometría","Positivo",);
//
//        LocalDate fecha4=LocalDate.of(2023, Month.APRIL, 15);
//        LocalTime hora4=LocalTime.of(10, 10);
//        Estudio es1 =new Estudio(fecha4,hora4,"Espirometría","Positivo");
//
//        otraLista.add(es);
//        otraLista.add(es1);
//        
//        modelo2.addColumn("Fecha");
//        modelo2.addColumn("Tipo");
//        tablaEstudios.setModel(modelo2);
//
//        
//        for (Estudio est : otraLista){
//            String fechaFormateada = est.getFecha().format(formato);
//            String tipo = est.getTipo();
//            String[]cosas2={fechaFormateada,tipo};
//            modelo2.addRow(cosas2);
//        }
//        tablaEstudios.setModel(modelo2);     
//    }
    
    public static Registro registroFechaLugar(ArrayList<Registro> r, String fecha, String lugar) {
        Registro resultado = null;
        for (Registro reg : r) {
            if (String.valueOf(reg.getFecha().format(DateTimeFormatter.ofPattern("dd'/'MM'/'yyyy"))).equals(fecha) && String.valueOf(reg.getLugares()).equals(lugar)) {
                //resultado = new Registro(reg.getFecha(), reg.getHora(), reg.getDiagnostico(), reg.getLugares(),reg.getDni());
                break;
            }
        }
        return resultado;
    }
        public static Estudio estudioFechaLugar(ArrayList<Estudio> r, String fecha, String lugar) {
        Estudio resultado = null;
        for (Estudio est : r) {
            if (String.valueOf(est.getFecha().format(DateTimeFormatter.ofPattern("dd'/'MM'/'yyyy"))).equals(fecha) && String.valueOf(est.getTipo()).equals(lugar)) {
                //resultado = new Estudio(est.getFecha(), est.getHora(), est.getTipo(), est.getResultado(), est.getDni());
                break;
            }
        }
        return resultado;
    }

    
    
    public void showPanelInPanel(JPanel p){
        p.setSize(460,185);
        p.setLocation(0,0);
        
        contentContent.removeAll();
        contentContent.add(p,BorderLayout.CENTER);
        contentContent.revalidate();
        contentContent.repaint();
    }

    public JTable getTablaEstudios() {
        return tablaEstudios;
    }

    public void setTablaEstudios(JTable tablaEstudios) {
        this.tablaEstudios = tablaEstudios;
    }

    public JTable getTablaRegistros() {
        return tablaRegistros;
    }

    public void setTablaRegistros(JTable tablaRegistros) {
        this.tablaRegistros = tablaRegistros;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaRegistros = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEstudios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        contentContent = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(460, 510));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tablaRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Lugar"
            }
        ));
        tablaRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaRegistrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaRegistros);

        tablaEstudios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Fecha", "Tipo"
            }
        ));
        tablaEstudios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEstudiosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaEstudios);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Estudios");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Registros");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Historia Clínica");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Descripción");

        contentContent.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentContentLayout = new javax.swing.GroupLayout(contentContent);
        contentContent.setLayout(contentContentLayout);
        contentContentLayout.setHorizontalGroup(
            contentContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentContentLayout.setVerticalGroup(
            contentContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 185, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(85, 85, 85))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(198, 198, 198))))
            .addComponent(contentContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tablaRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaRegistrosMouseClicked
        int seleccion = tablaRegistros.rowAtPoint(evt.getPoint());
        String fecha=String.valueOf(tablaRegistros.getValueAt(seleccion, 0));
        String lugar=String.valueOf(tablaRegistros.getValueAt(seleccion, 1));
        Registro reg = registroFechaLugar(lista,fecha,lugar);
        showPanelInPanel(new PanelDescripcionRegistro(reg));
    }//GEN-LAST:event_tablaRegistrosMouseClicked

    private void tablaEstudiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEstudiosMouseClicked
        int seleccion = tablaRegistros.rowAtPoint(evt.getPoint());
        String fecha=String.valueOf(tablaEstudios.getValueAt(seleccion, 0));
        String tipo=String.valueOf(tablaEstudios.getValueAt(seleccion, 1));
        Estudio est = estudioFechaLugar(otraLista,fecha,tipo);
        showPanelInPanel(new PanelDescripcionEstudio(est));
    }//GEN-LAST:event_tablaEstudiosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contentContent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaEstudios;
    private javax.swing.JTable tablaRegistros;
    // End of variables declaration//GEN-END:variables
}
