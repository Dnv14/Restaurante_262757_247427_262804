/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.restaurantepresentacion_262757_262804_247427;

import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevaRecetaDTO;
import java.util.List;

/**
 *
 * @author Diego
 */
public class AgregarIngredientesProductoFORM extends javax.swing.JDialog {

    private ControlForms control;

    public AgregarIngredientesProductoFORM(java.awt.Frame parent, boolean modal, ControlForms control) {
        super(parent, modal);
        this.control = control;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Añadir Ingredientes al Producto");
        initComponents();
        java.awt.EventQueue.invokeLater(() -> {
            cargarTodosLosIngredientes();
        });
        this.setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        botonAtras = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCantidadIngrediente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setMaximumSize(new java.awt.Dimension(595, 552));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Agregar Ingrediente");

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setLabel("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaIngredientes.getTableHeader().setResizingAllowed(false);
        tablaIngredientes.getTableHeader().setReorderingAllowed(false);
        tablaIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaIngredientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaIngredientes);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre del Ingrediente:");

        botonAtras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonAtras.setForeground(new java.awt.Color(153, 153, 153));
        botonAtras.setText(">");
        botonAtras.addActionListener(this::botonAtrasActionPerformed);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cantidad de Ingrediente Seleccionado:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonAtras)
                                .addGap(146, 146, 146)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidadIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidadIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

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

    public void mostrarResultados(List<Ingrediente> ingrediente) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tablaIngredientes.getModel();
        modelo.setRowCount(0);

        for (Ingrediente i : ingrediente) {
            modelo.addRow(new Object[]{
                i.getIdIngrediente(),
                i.getNombreIngrediente(),});
        }
    }

    private void cargarTodosLosIngredientes() {
        control.buscarIngredientesParaProducto("", "", this);
    }


    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String texto = txtBusqueda.getText().trim();
        control.buscarIngredientesParaProducto(texto, "Nombre", this);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void botonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAtrasActionPerformed
        
        
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(this,
                "Ingredientes Seleccionados" + "\n"+control.ResumenRecetasProducto() +"\nSalir?",
                "Resumen",
                javax.swing.JOptionPane.YES_NO_OPTION);

        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            dispose();
        }
        
    }//GEN-LAST:event_botonAtrasActionPerformed

    private void tablaIngredientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaIngredientesMouseClicked
        int fila = tablaIngredientes.getSelectedRow();

        if (evt.getClickCount() == 1) {
            Long id = (Long) tablaIngredientes.getValueAt(fila, 0);
            String nombre = (String) tablaIngredientes.getValueAt(fila, 1);

            int respuesta = javax.swing.JOptionPane.showConfirmDialog(this,
                    "¿Seleccionar: " + nombre + "\n"
                    + "Con cantidad: " + txtCantidadIngrediente.getText() + "?", "Confirmar ingrediente",
                    javax.swing.JOptionPane.YES_NO_OPTION);

            if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
                NuevaRecetaDTO receta = new NuevaRecetaDTO(id, nombre, Double.parseDouble(txtCantidadIngrediente.getText()));
                control.enviarIngredienteAniadirProducto(receta);
                txtCantidadIngrediente.setText("");
            }
        }
    }//GEN-LAST:event_tablaIngredientesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAtras;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCantidadIngrediente;
    // End of variables declaration//GEN-END:variables
}
