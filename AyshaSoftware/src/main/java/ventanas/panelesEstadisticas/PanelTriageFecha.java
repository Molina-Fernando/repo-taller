/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ventanas.panelesEstadisticas;

import Utilidades.FormatosValidos;
import dbController.CtrlEstadistica;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joaqu
 */
public class PanelTriageFecha extends javax.swing.JPanel {
    String desdeT;
    String hastaT;
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Object[]> lista = new ArrayList<>();
    CtrlEstadistica ctrlEst = new CtrlEstadistica();

    /**
     * Creates new form PanelTriageFecha
     */
    public PanelTriageFecha() {
        initComponents();
        modelo.addColumn("Color");
        modelo.addColumn("Cantidad");
    }
    
        public boolean esFechaValida(String fecha) {
        try {
            LocalDate localDate = LocalDate.parse(fecha, FormatosValidos.FORMATO_FECHA);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean esFechaEnRango(String fechaStr) {
        try {
            LocalDate fecha = LocalDate.parse(fechaStr, FormatosValidos.FORMATO_FECHA);

            LocalDate hoy = LocalDate.now();
            LocalDate fechaMinima = LocalDate.of(2000, 1, 1);

            return !fecha.isAfter(hoy) && !fecha.isBefore(fechaMinima);
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    
    private void actualizarTablaTriages(String desdeT, String hastaT) {
        modelo.setRowCount(0);
        tablaTriages = new javax.swing.JTable();
        tablaTriages.setModel(modelo);
        tablaTriages = new JTable(modelo);
        lista = ctrlEst.triagesPorFecha(desdeT, hastaT);
        jScrollPane1.setViewportView(tablaTriages);

        for (Object[] vector : lista) {
            modelo.addRow(vector);
            tablaTriages.setModel(modelo);
        }
    
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        hasta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        desde = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botonCargaMedicoFecha = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTriages = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 204, 255));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Triages realizado en un rango de fechas por color");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(166, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(163, 163, 163))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(23, 23, 23))
        );

        hasta.setText("dd-mm-aaaa");

        jLabel4.setText("Rango de fechas");

        jLabel1.setText("Desde:");

        desde.setText("dd-mm-aaaa");
        desde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desdeActionPerformed(evt);
            }
        });

        jLabel2.setText("Hasta:");

        botonCargaMedicoFecha.setBackground(new java.awt.Color(0, 0, 153));
        botonCargaMedicoFecha.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonCargaMedicoFecha.setForeground(new java.awt.Color(255, 255, 255));
        botonCargaMedicoFecha.setText("Buscar");
        botonCargaMedicoFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargaMedicoFechaActionPerformed(evt);
            }
        });

        tablaTriages.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Color", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tablaTriages);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(botonCargaMedicoFecha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4))
                    .addComponent(jLabel1))
                .addGap(197, 197, 197))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(desde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(botonCargaMedicoFecha))
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel1)))
                .addGap(0, 227, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 330, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void desdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_desdeActionPerformed

    private void botonCargaMedicoFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargaMedicoFechaActionPerformed

            desdeT = desde.getText().trim();
            hastaT = hasta.getText().trim();
            if (desdeT.isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Error! El campo 'desde' está vacío");
            } else if (!esFechaValida(desdeT)) {
                JOptionPane.showMessageDialog(null, "¡Error! La fecha en el campo 'desde' no es válida");
            } else if (!esFechaEnRango(desdeT)) {
                JOptionPane.showMessageDialog(null, "¡Error! La fecha en el campo 'desde' no está en el rango permitido");
            }

            if (hastaT.isEmpty()) {
                JOptionPane.showMessageDialog(null, "¡Error! El campo 'hasta' está vacío");
            } else if (!esFechaValida(hastaT)) {
                JOptionPane.showMessageDialog(null, "¡Error! La fecha en el campo 'hasta' no es válida");
            } else if (!esFechaEnRango(hastaT)) {
                JOptionPane.showMessageDialog(null, "¡Error! La fecha en el campo 'hasta' no está en el rango permitido");
            }

            if (!desdeT.isEmpty() && !hastaT.isEmpty() && esFechaValida(desdeT) && esFechaValida(hastaT) && esFechaEnRango(desdeT) && esFechaEnRango(hastaT)) {
                LocalDate desdeFecha = LocalDate.parse(desdeT, FormatosValidos.FORMATO_FECHA);
                LocalDate hastaFecha = LocalDate.parse(hastaT, FormatosValidos.FORMATO_FECHA);
                if (desdeFecha.isAfter(hastaFecha)) {
                    JOptionPane.showMessageDialog(null, "¡Error! La fecha 'desde' es posterior a la fecha 'hasta'");
                }
                actualizarTablaTriages(desdeT,hastaT);
                
                
            }

    }//GEN-LAST:event_botonCargaMedicoFechaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCargaMedicoFecha;
    private javax.swing.JTextField desde;
    private javax.swing.JTextField hasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTriages;
    // End of variables declaration//GEN-END:variables


}
