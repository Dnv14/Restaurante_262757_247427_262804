/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.restaurantepresentacion_262757_262804_247427;

/**
 *
 * @author Diego
 */
public class MenuAccionesProducto extends javax.swing.JDialog {
    
    private ControlForms control;

   
    public MenuAccionesProducto(java.awt.Frame parent, boolean modal, ControlForms control) {
        super(parent, modal);
        this.control = control;
        this.setTitle("Menú Acciones Producto");
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblInstruccion = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnVolverAtras = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnCambiarEstado = new javax.swing.JButton();
        btnDescripcionProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        lblInstruccion.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblInstruccion.setForeground(new java.awt.Color(0, 0, 0));
        lblInstruccion.setText("¿Qué quiere hacer con el Producto?");

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblTitulo.setText("Acciones Producto");

        btnVolverAtras.setBackground(new java.awt.Color(153, 153, 153));
        btnVolverAtras.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnVolverAtras.setText(">");
        btnVolverAtras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnVolverAtras.addActionListener(this::btnVolverAtrasActionPerformed);

        btnEditarProducto.setBackground(new java.awt.Color(51, 51, 51));
        btnEditarProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEditarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarProducto.setText("Editar Producto");
        btnEditarProducto.addActionListener(this::btnEditarProductoActionPerformed);

        btnCambiarEstado.setBackground(new java.awt.Color(51, 51, 51));
        btnCambiarEstado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCambiarEstado.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarEstado.setText("Cambiar Estado");
        btnCambiarEstado.addActionListener(this::btnCambiarEstadoActionPerformed);

        btnDescripcionProducto.setBackground(new java.awt.Color(51, 51, 51));
        btnDescripcionProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDescripcionProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnDescripcionProducto.setText("Descripción del Producto");
        btnDescripcionProducto.addActionListener(this::btnDescripcionProductoActionPerformed);

        btnEliminarProducto.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminarProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setText("Eliminar Producto");
        btnEliminarProducto.addActionListener(this::btnEliminarProductoActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnVolverAtras)
                .addGap(167, 167, 167)
                .addComponent(lblTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(lblInstruccion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDescripcionProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCambiarEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(91, 91, 91))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolverAtras)
                    .addComponent(lblTitulo))
                .addGap(38, 38, 38)
                .addComponent(lblInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
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

    private void btnVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAtrasActionPerformed
        volverAtras();
    }//GEN-LAST:event_btnVolverAtrasActionPerformed
    
    private void volverAtras(){
        control.navegarAdministrarProductos();
    }
    
    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
    
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void btnCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstadoActionPerformed

    }//GEN-LAST:event_btnCambiarEstadoActionPerformed

    private void btnDescripcionProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescripcionProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDescripcionProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnDescripcionProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnVolverAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInstruccion;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
