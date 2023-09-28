/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas.panelesmedicos;

import clases.Box;
import clases.Estudio;
import clases.Lugares;
import clases.Paciente;
import clases.Registro;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaqu
 */
public class Panel1 extends javax.swing.JPanel {
        
    ArrayList<Paciente> listaPacientes = new ArrayList<>();
    Box[] boxes = new Box[10];
    DefaultTableModel modelo= new DefaultTableModel();
    DefaultTableModel modelo2= new DefaultTableModel();
    Paciente elegido=null;
    Box boxElegido=null;

    /**
     * Creates new form Panel1
     */
    public Panel1() {
        initComponents();
        cargaDatos();
    }
    
    public void cargaDatos(){
        
        //aca creo que deberia llamarse a la base de datos pero por ahora la carga va a ser manual con muchos atributos
        //PRIMER PACIENTE
        Paciente p1 = new Paciente("Sebastian","Romero",LocalDate.of(2001, Month.SEPTEMBER, 19),"Chile 2150","43382385","4213544","3454234594","sebas2001@gmail.com","3454803293","SOLTERO");
        //Primer estudio
        LocalDate fecha3=LocalDate.of(2021, Month.JANUARY, 20);
        LocalTime hora3=LocalTime.of(23, 50,15);
        Estudio es =new Estudio(fecha3,hora3,"Espirometría","Positivo");
        //carga del primer estudio 
        p1.setEstudios(es);
        //Segundo estudio
        LocalDate fecha4=LocalDate.of(2019, Month.JANUARY, 14);
        LocalTime hora4=LocalTime.of(8, 45,15);
        Estudio es1 =new Estudio(fecha4,hora4,"Tomografía","negativo");
        //carga del segundo estudio
        p1.setEstudios(es1);
        //Primer registro
        LocalDate fecha=LocalDate.of(2023, Month.JANUARY, 25);
        LocalTime hora=LocalTime.of(23, 50,38);
        Registro reg=new Registro(fecha,hora,"Presenta apnea del sueño",Lugares.CONSULTORIO);
        p1.setRegistros(reg);
        //Segundo registro
        LocalDate fecha1=LocalDate.of(2022, Month.AUGUST, 12);
        LocalTime hora1=LocalTime.of(12, 30,18);
        Registro reg1=new Registro(fecha1,hora1,"Presenta lesiones debido a un accidente",Lugares.EMERGENCIA);
        p1.setRegistros(reg);  
        //Carga del paciente completo en la lista de pacientes
        listaPacientes.add(p1);
        
        

        //SEGUNDO PACIENTE
        Paciente p2 = new Paciente("Santiago","Nuñez",LocalDate.of(2001, Month.APRIL, 11),"Gregoria Perez","42570987","4233324","3454857219","santicarp@gmail.com","3454803293","CASADO");
        
        //Primer estudio
        LocalDate fecha9=LocalDate.of(2018, Month.DECEMBER, 3);
        LocalTime hora9=LocalTime.of(06, 05,15);
        Estudio es9 =new Estudio(fecha9,hora9,"Encefálograma","Positivo");
        //carga del primer estudio 
        p1.setEstudios(es9);
        //Segundo estudio
        LocalDate fecha8=LocalDate.of(2015, Month.JANUARY, 13);
        LocalTime hora8=LocalTime.of(8, 45,15);
        Estudio es8 =new Estudio(fecha8,hora8,"Hemograma","negativo");
        //carga del segundo estudio
        p1.setEstudios(es8);
        //Primer registro
        LocalDate fecha7=LocalDate.of(2023, Month.SEPTEMBER, 21);
        LocalTime hora7=LocalTime.of(21, 30,00);
        Registro reg7=new Registro(fecha7,hora7,"Presenta apnea del sueño",Lugares.INTERNACION);
        p1.setRegistros(reg7);
        //Segundo registro
        LocalDate fecha6=LocalDate.of(2022, Month.MARCH, 30);
        LocalTime hora6=LocalTime.of(11, 35,13);
        Registro reg6=new Registro(fecha6,hora6,"Presenta lesiones debido a un accidente",Lugares.EMERGENCIA);
        p1.setRegistros(reg6);
        //CARGA SEGUNDO PACIENTE
        listaPacientes.add(p2);
        
        //
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Color");
        tablaPacientes.setModel(modelo);
        for (Paciente pac : listaPacientes){
            String nombre = pac.getNombre();
            String apellido = pac.getApellido();
            String color = "AMARILLO";
            String[]cosasPacientes={nombre,apellido,color};
            modelo.addRow(cosasPacientes);
        }
        
        //CARGA DE DATOS DE LOS BOXES POR DEFECTO
        int numeracion = 1;
        for (int i =0;i<10;i++) {
            boxes[i]=new Box(true, numeracion);
            numeracion++;
        }
        
        modelo2.addColumn("Número");
        modelo2.addColumn("Disponibilidad");
        tablaBoxes.setModel(modelo2);
        for (Box box : boxes){
            String disponibilidad = String.valueOf(box.isDisponible());
            String numero = String.valueOf(box.getNumero());
            String[]cosasBox={numero,disponibilidad};
            modelo2.addRow(cosasBox);
        }
        
    }
    
    public Paciente pacienteNombreApellido(ArrayList<Paciente>list,String nombre,String apellido){
        Paciente pac = null;
        for (Paciente p : list){
            if (p.getNombre().equals(nombre) && p.getApellido().equals(apellido)){
                pac= new Paciente(p.getNombre(),p.getApellido(),p.getFecNacimiento(),p.getDomicilio(),p.getDni(),p.getTelFijo(),p.getTelCelular(),p.getCorreoElectronico(),p.getPersonaContacto(),p.getEstadoCivil());
            }
        }
        return pac;
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPacientes = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBoxes = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        SeleccionPaciente = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(460, 510));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Pacientes");

        tablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Color"
            }
        ));
        tablaPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPacientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaPacientes);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Boxes");

        tablaBoxes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Número", "Disponibilidad "
            }
        ));
        tablaBoxes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaBoxesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaBoxes);

        jButton1.setText("Asignar box");
        jButton1.setBorder(null);

        SeleccionPaciente.setText("Seleccionar");
        SeleccionPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionPacienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(SeleccionPaciente)
                        .addGap(176, 176, 176))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(187, 187, 187))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(SeleccionPaciente)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SeleccionPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionPacienteActionPerformed
        try{
            boxes[boxElegido.getNumero()].setDisponible(false);
            //elegido tal cosa como que se pase a los paneles correspondientes.
            
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "No fue posible asignar box, falto seleccionar paciente o box", "Error", JOptionPane.ERROR_MESSAGE);
       
        }
    }//GEN-LAST:event_SeleccionPacienteActionPerformed

    private void tablaPacientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPacientesMouseClicked
        int seleccion = tablaPacientes.rowAtPoint(evt.getPoint());
        String nombre=String.valueOf(tablaPacientes.getValueAt(seleccion, 0));
        String apellido=String.valueOf(tablaPacientes.getValueAt(seleccion, 1));
        String color =String.valueOf(tablaPacientes.getValueAt(seleccion, 2));
        Paciente elegido=pacienteNombreApellido(listaPacientes,nombre,apellido);
    }//GEN-LAST:event_tablaPacientesMouseClicked

    private void tablaBoxesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaBoxesMouseClicked
        int seleccion = tablaBoxes.rowAtPoint(evt.getPoint());
        int numero=Integer.parseInt((String) tablaBoxes.getValueAt(seleccion, 0));
        boolean disponibilidad=Boolean.parseBoolean((String) tablaBoxes.getValueAt(seleccion, 1));
        boxElegido=new Box(disponibilidad,numero);
    }//GEN-LAST:event_tablaBoxesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SeleccionPaciente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tablaBoxes;
    private javax.swing.JTable tablaPacientes;
    // End of variables declaration//GEN-END:variables
}
