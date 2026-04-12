/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.restaurantepresentacion_262757_262804_247427;

import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevaRecetaDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import com.mycompany.restaurantenegocio_262757_247427_262804.NegocioException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class EditarProductoFORM extends javax.swing.JDialog {

    private ControlForms control;
    private Long idProducto;
    private List<NuevaRecetaDTO> ingredientesReceta = new LinkedList<>();

    public EditarProductoFORM(java.awt.Frame parent, boolean modal, ControlForms control, Long idProducto) {
        super(parent, modal);
        this.control = control;
        this.idProducto = idProducto;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Editar Producto");
        initComponents();
        CargarProducto();
        java.awt.EventQueue.invokeLater(() -> {
            cargarTodosLosIngredientes();
        });
        this.setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBuscadorIngredientes = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        btnVolverAtras = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnGuardarCambios = new javax.swing.JButton();
        lblProductoSeleccionado = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        txtCantidadProducto = new javax.swing.JTextField();
        lbldescp = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        lblPrecioNuevo1 = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblInstruccionProducto = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        txtBuscadorIngrediente = new javax.swing.JTextField();
        lblInstruccion3 = new javax.swing.JLabel();

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

        btnBuscar.setBackground(new java.awt.Color(51, 51, 51));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        btnGuardarCambios.setBackground(new java.awt.Color(51, 51, 51));
        btnGuardarCambios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnGuardarCambios.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.addActionListener(this::btnGuardarCambiosActionPerformed);

        lblProductoSeleccionado.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblProductoSeleccionado.setForeground(new java.awt.Color(0, 0, 0));
        lblProductoSeleccionado.setText("Producto Seleccionado:");

        txtPrecio.addActionListener(this::txtPrecioActionPerformed);

        txtCantidadProducto.addActionListener(this::txtCantidadProductoActionPerformed);

        lbldescp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbldescp.setForeground(new java.awt.Color(0, 0, 0));
        lbldescp.setText("Descripción:");

        txtDescripcion.addActionListener(this::txtDescripcionActionPerformed);

        lblPrecioNuevo1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPrecioNuevo1.setForeground(new java.awt.Color(0, 0, 0));
        lblPrecioNuevo1.setText("Precio:");

        lblCantidad.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(0, 0, 0));
        lblCantidad.setText("Cantidad Del Producto Nueva:");

        lblInstruccionProducto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblInstruccionProducto.setForeground(new java.awt.Color(0, 0, 0));
        lblInstruccionProducto.setText("Producto Seleccionado:");

        btnCancelar.setBackground(new java.awt.Color(51, 51, 51));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar Cambios");
        btnCancelar.addActionListener(this::btnCancelarActionPerformed);

        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Unidad de Medida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaIngredientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaIngredientes);

        txtBuscadorIngrediente.addActionListener(this::txtBuscadorIngredienteActionPerformed);

        lblInstruccion3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblInstruccion3.setForeground(new java.awt.Color(0, 0, 0));
        lblInstruccion3.setText("Cambiar/Agregar Ingredientes:");

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
                        .addGap(164, 164, 164)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBuscadorIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscadorIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnVolverAtras)
                .addGap(347, 347, 347)
                .addComponent(lblTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(106, 106, 106)
                    .addComponent(lblPrecioNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(562, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(41, 41, 41)
                    .addComponent(lblInstruccionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(658, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(317, Short.MAX_VALUE)
                    .addComponent(lblInstruccion3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(291, 291, 291)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolverAtras)
                    .addComponent(lblTitulo))
                .addGap(30, 30, 30)
                .addComponent(lblProductoSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldescp, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuscadorIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscadorIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(193, 193, 193)
                    .addComponent(lblPrecioNuevo1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(604, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(lblInstruccionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(735, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(284, 284, 284)
                    .addComponent(lblInstruccion3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(489, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    public void setIngredientesReceta(List<NuevaRecetaDTO> lista) {
        this.ingredientesReceta = lista;
    }

    public List<NuevaRecetaDTO> getIngredientesReceta() {
        return ingredientesReceta;
    }

    public void mostrarResultados(List<Ingrediente> ingrediente) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) tablaIngredientes.getModel();
        modelo.setRowCount(0);

        for (Ingrediente i : ingrediente) {
            modelo.addRow(new Object[]{
                i.getIdIngrediente(),
                i.getNombreIngrediente(),
                i.getUnidadMedida()
            });
        }
    }

    private void cargarTodosLosIngredientes() {
        control.buscarIngredientesParaProductoEditar("", "", this);
    }


    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        try {
            String descipcion = txtDescripcion.getText();
            String precio = txtPrecio.getText();

            NuevoProductoDTO productoActualizar = new NuevoProductoDTO();
            productoActualizar.setId(this.idProducto);
            productoActualizar.setNombre(lblProductoSeleccionado.getText());
            productoActualizar.setDescripcion(descipcion);
            productoActualizar.setPrecio(Double.valueOf(precio));
            productoActualizar.setRecetas(this.ingredientesReceta);

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

    private void txtCantidadProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadProductoActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String texto = txtBuscadorIngrediente.getText().trim();
        control.buscarIngredientesParaProductoEditar(texto, "Nombre", this);

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscadorIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorIngredienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorIngredienteActionPerformed

    private void tablaIngredientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaIngredientesMouseClicked
        int fila = tablaIngredientes.getSelectedRow();
        Long idSeleccionado = (Long) tablaIngredientes.getValueAt(fila, 0);
        String nombre = (String) tablaIngredientes.getValueAt(fila, 1);
        List<NuevaRecetaDTO> lista = this.ingredientesReceta;

        Double cantidadNueva = null;
        try {
            String texto = txtCantidadProducto.getText().trim();
            if (!texto.isEmpty()) {
                cantidadNueva = Double.valueOf(texto);
            }
        } catch (NumberFormatException e) {
            
        }
        NuevaRecetaDTO RecetaEncontrada = null;
        for (NuevaRecetaDTO receta : lista) {
            if (receta.getIdIngrediente().equals(idSeleccionado)) {
                RecetaEncontrada = receta;
                break;
            }

        }
        if (RecetaEncontrada != null) {
            int resp = JOptionPane.showConfirmDialog(this, "¿Quitar " + nombre + "?", "Editar Receta", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                lista.remove(RecetaEncontrada);
            }
        } else {
            if (cantidadNueva == null) {
                JOptionPane.showMessageDialog(this, "Escribe la cantidad antes de agregar el ingrediente.");
                return;
            }
            int respuesta = JOptionPane.showConfirmDialog(this, "¿Agregar " + nombre + "?", "Editar Receta", JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                lista.add(new NuevaRecetaDTO(idSeleccionado, nombre, cantidadNueva));
                txtCantidadProducto.setText("");
            }

        }
    }//GEN-LAST:event_tablaIngredientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnVolverAtras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscadorIngredientes;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblInstruccion3;
    private javax.swing.JLabel lblInstruccionProducto;
    private javax.swing.JLabel lblPrecioNuevo1;
    private javax.swing.JLabel lblProductoSeleccionado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lbldescp;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JTextField txtBuscadorIngrediente;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
