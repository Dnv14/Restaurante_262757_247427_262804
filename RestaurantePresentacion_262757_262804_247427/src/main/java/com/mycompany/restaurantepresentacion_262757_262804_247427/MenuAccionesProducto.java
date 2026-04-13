/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.restaurantepresentacion_262757_262804_247427;

import com.mycompany.restaurantedominio_262757_247427_262804.Estado;
import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedtos_262757_247427_262804.EstadoDTO;
import com.mycompany.restaurantenegocio_262757_247427_262804.NegocioException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class MenuAccionesProducto extends javax.swing.JDialog {

    private ControlForms control;
    private Long idProducto;
    public MenuAccionesProducto(java.awt.Frame parent, boolean modal, ControlForms control, Long idProducto) {
        super(parent, modal);
        this.control = control;
        this.idProducto = idProducto;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Menú Acciones Producto");
        initComponents();
        lblCargarNombreProducto();
        this.setLocationRelativeTo(parent);
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
        btnDetallesProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        lblProductoSeleccionado = new javax.swing.JLabel();

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

        btnDetallesProducto.setBackground(new java.awt.Color(51, 51, 51));
        btnDetallesProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnDetallesProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnDetallesProducto.setText("Detalles del Producto");
        btnDetallesProducto.addActionListener(this::btnDetallesProductoActionPerformed);

        btnEliminarProducto.setBackground(new java.awt.Color(51, 51, 51));
        btnEliminarProducto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarProducto.setText("Eliminar Producto");
        btnEliminarProducto.addActionListener(this::btnEliminarProductoActionPerformed);

        lblProductoSeleccionado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblProductoSeleccionado.setForeground(new java.awt.Color(0, 0, 0));
        lblProductoSeleccionado.setText("*************************");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnVolverAtras)
                .addGap(177, 177, 177)
                .addComponent(lblTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDetallesProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCambiarEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(91, 91, 91))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(lblInstruccion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(lblProductoSeleccionado)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolverAtras)
                    .addComponent(lblTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInstruccion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProductoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCambiarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDetallesProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
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
    
    /**
     * consultamos el producto actual con el id que dio adminsitrar productos
     * al clickear la tabla para manejarlo en el dialog
     * @return
     * @throws NegocioException 
     */
    private Producto productoActual() throws NegocioException {
        return control.consultaProductoPorID(idProducto);
    }


    private void btnVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAtrasActionPerformed
        dispose();
    }//GEN-LAST:event_btnVolverAtrasActionPerformed

    
    /**
     * manda a llamar el dialog de editar producto
     * @param evt 
     */
    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        control.navegarEditarProducto(idProducto);
    }//GEN-LAST:event_btnEditarProductoActionPerformed
    
    /**
     * cambia el estado del producto
     * con mensajes de confirmaciones por si el usuario decide cancelar 
     * la operacion
     * @param evt 
     */
    private void btnCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstadoActionPerformed
        try {
            Estado estadoActual = productoActual().getEstado();
            EstadoDTO nuevoEstado;
            
            if (estadoActual == Estado.ACTIVO) {
                nuevoEstado = EstadoDTO.INACTIVO;
            } else {
                nuevoEstado = EstadoDTO.ACTIVO;
            }

            int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    "Estado Actual: " + productoActual().getEstado() + "\n" + " Deseas Cambiarlo?",
                    "Gestión de Estado",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                control.cambiarEstadoProducto(idProducto, nuevoEstado);
                JOptionPane.showMessageDialog(this, "Cambio Exitoso");
                this.dispose();
            }
        } catch (NegocioException ex) {
        }
    }//GEN-LAST:event_btnCambiarEstadoActionPerformed

    /**
     * manda a llamar el dialog de los detalles del producto
     * @param evt 
     */
    private void btnDetallesProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesProductoActionPerformed
        control.navegarDetallesProducto(idProducto);
    }//GEN-LAST:event_btnDetallesProductoActionPerformed
    
    /**
     * Elimina el producto, con mensaje de confirmacion por si el usuario decide
     * cancelar la operacion
     * @param evt 
     */
    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed

        try {
            int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    "Deseas Eliminar el Producto: " + productoActual().getNombre(),
                    "Confirmar Eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                control.eliminarProducto(idProducto);
                JOptionPane.showMessageDialog(this, "Eliminación Exitosa");
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Eliminación Cancelada");

            }
        } catch (NegocioException ex) {
        }

    }//GEN-LAST:event_btnEliminarProductoActionPerformed
    
    /**
     * carga el nombre del producto para sobreescribirlo en la pantalla
     * para que el usuario sepa que producto esta manejando
     */
    private void lblCargarNombreProducto() {
        try {
//            Producto productoID = control.consultaProductoPorID(this.idProducto);
            Producto productoID = productoActual();
            lblProductoSeleccionado.setText(productoID.getNombre());

        } catch (NegocioException ex) {
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnDetallesProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnVolverAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblInstruccion;
    private javax.swing.JLabel lblProductoSeleccionado;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
