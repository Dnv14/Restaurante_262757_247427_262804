/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.restaurantepresentacion_262757_262804_247427;

import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import com.mycompany.restaurantenegocio_262757_247427_262804.NegocioException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class EditarProductoFORM extends javax.swing.JDialog {

    private ControlForms control;
    private Long idProducto;

    public EditarProductoFORM(java.awt.Frame parent, boolean modal, ControlForms control, Long idProducto) {
        super(parent, modal);
        this.control = control;
        this.idProducto = idProducto;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Editar Producto");
        initComponents();
        CargarProducto();
        this.setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBuscadorIngredientes = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnVolverAtras = new javax.swing.JButton();
        btnAñadirIngredientes = new javax.swing.JButton();
        btnGuardarCambios = new javax.swing.JButton();
        lblProductoSeleccionado = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtBuscadorIngrediente = new javax.swing.JTextField();
        lbldescp = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblPrecioNuevo1 = new javax.swing.JLabel();
        lblInstruccion2 = new javax.swing.JLabel();
        lblNombre1 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        lblBuscadorIngredientes.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblBuscadorIngredientes.setForeground(new java.awt.Color(0, 0, 0));
        lblBuscadorIngredientes.setText("Buscador Ingredientes:");

        lblTitulo.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblTitulo.setText("Editar Producto");

        btnVolverAtras.setBackground(new java.awt.Color(153, 153, 153));
        btnVolverAtras.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnVolverAtras.setText(">");
        btnVolverAtras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnVolverAtras.addActionListener(this::btnVolverAtrasActionPerformed);

        btnAñadirIngredientes.setBackground(new java.awt.Color(51, 51, 51));
        btnAñadirIngredientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAñadirIngredientes.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadirIngredientes.setText("Añadir Ingredientes");
        btnAñadirIngredientes.addActionListener(this::btnAñadirIngredientesActionPerformed);

        btnGuardarCambios.setBackground(new java.awt.Color(51, 51, 51));
        btnGuardarCambios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardarCambios.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.addActionListener(this::btnGuardarCambiosActionPerformed);

        lblProductoSeleccionado.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblProductoSeleccionado.setForeground(new java.awt.Color(0, 0, 0));
        lblProductoSeleccionado.setText("Producto Seleccionado:");

        txtPrecio.addActionListener(this::txtPrecioActionPerformed);

        txtBuscadorIngrediente.addActionListener(this::txtBuscadorIngredienteActionPerformed);

        lbldescp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbldescp.setForeground(new java.awt.Color(0, 0, 0));
        lbldescp.setText("Descripción:");

        txtDescripcion.addActionListener(this::txtDescripcionActionPerformed);

        lblPrecioNuevo1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPrecioNuevo1.setForeground(new java.awt.Color(0, 0, 0));
        lblPrecioNuevo1.setText("Precio:");

        lblInstruccion2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblInstruccion2.setForeground(new java.awt.Color(0, 0, 0));
        lblInstruccion2.setText("Cambiar/Agregar Ingredientes:");

        lblNombre1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblNombre1.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre1.setText("Producto Seleccionado:");

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar Cambios");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(lbldescp, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProductoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBuscadorIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscadorIngrediente))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(lblInstruccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 133, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAñadirIngredientes)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnVolverAtras)
                .addGap(347, 347, 347)
                .addComponent(lblTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addComponent(lblPrecioNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(562, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(658, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolverAtras)
                    .addComponent(lblTitulo))
                .addGap(24, 24, 24)
                .addComponent(lblProductoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldescp, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(lblInstruccion2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscadorIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscadorIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAñadirIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(193, 193, 193)
                    .addComponent(lblPrecioNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(421, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(lblNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(608, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CargarProducto() {
        try {
            Producto productoID = control.consultaProductoPorID(this.idProducto);
            lblProductoSeleccionado.setText(productoID.getNombre());
            txtDescripcion.setText(productoID.getDescripcion());
            txtPrecio.setText(String.valueOf(productoID.getPrecio()));
        } catch (NegocioException ex) {
        }
    }

    private void btnVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAtrasActionPerformed

        dispose();
    }//GEN-LAST:event_btnVolverAtrasActionPerformed


    private void btnAñadirIngredientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirIngredientesActionPerformed

    }//GEN-LAST:event_btnAñadirIngredientesActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        try {
            String descipcion = txtDescripcion.getText();
            String precio = txtPrecio.getText();

            NuevoProductoDTO productoActualizar = new NuevoProductoDTO();
            productoActualizar.setId(this.idProducto);
            productoActualizar.setDescripcion(descipcion);
            productoActualizar.setPrecio(Double.valueOf(precio));

            control.actualizarProducto(productoActualizar);

            JOptionPane.showMessageDialog(this, "Producto actualizado correctamente");
            dispose();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtBuscadorIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorIngredienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorIngredienteActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirIngredientes;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnVolverAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBuscadorIngredientes;
    private javax.swing.JLabel lblInstruccion2;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblPrecioNuevo1;
    private javax.swing.JLabel lblProductoSeleccionado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lbldescp;
    private javax.swing.JTextField txtBuscadorIngrediente;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
