/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepresentacion_262757_262804_247427;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedtos_262757_247427_262804.EstadoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteFrecuenteDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.TipoProductoDTO;
import com.mycompany.restaurantenegocio_262757_247427_262804.NegocioException;
import com.mycompany.restaurantenegocio_262757_247427_262804.ObjetosBO;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MrGam
 */
public class ControlForms {

    private ObjetosBO objetosBO;
    private JFrame frameActual;
    

    public ControlForms() {
        this.objetosBO = new ObjetosBO();
    }

    //metodo q ahorra codigo
    private void mostrarPantalla(JFrame nuevoFrame) {
        if (this.frameActual != null) {
            this.frameActual.dispose();
        }

        this.frameActual = nuevoFrame;
        this.frameActual.setResizable(false);
        this.frameActual.setLocationRelativeTo(null);
        this.frameActual.setVisible(true);

    }

    //cambiar de pantallas
    public void navegarMenuPrincipal() {
        mostrarPantalla(new MenuPrincipalFORM(this));
    }

    public void navegarAgregarCliente() {
        mostrarPantalla(new AgregarClienteFrecuenteFORM(this));
    }

    public void navegarMenuClientesFrecuentes() {
        mostrarPantalla(new MenuClientesFrecuentesFORM(this));
    }

    public void navegarConsultaClientes() {
        mostrarPantalla(new BusquedaClienteFrecuenteFORM(this));
    }

    public void navegarMenuProductos() {
        mostrarPantalla(new MenuProductosFORM(this));
    }

    public void navegarAdministrarProductos() {
        mostrarPantalla(new AdministrarProductosFORM(this));
    }

    public void navegarMenuAccionesProducto(Long id) {
        MenuAccionesProducto menuAccionesProducto = new MenuAccionesProducto(frameActual, true, this,id);
        menuAccionesProducto.setLocationRelativeTo(frameActual);
        menuAccionesProducto.setVisible(true);
    }

    public void navegarAniadirProducto() {
        mostrarPantalla(new AniadirProductoFORM(this));
    }
    
    public void navegarEditarProducto(Long id) {
        EditarProductoFORM editarProducto = new EditarProductoFORM(frameActual, true, this, id);
        editarProducto.setLocationRelativeTo(frameActual);
        editarProducto.setVisible(true);
    }

    //logica de botones 
    public void registrarCliente(String nombre, String apellidos, String telefono, String correo) {
        NuevoClienteFrecuenteDTO cliente = new NuevoClienteFrecuenteDTO(nombre, apellidos, telefono, correo);
        try {
            objetosBO.getClientesFrecuentesBO().validarRegistroCliente(cliente);
            JOptionPane.showMessageDialog(frameActual, "Cliente registrado con éxito");
            navegarMenuClientesFrecuentes();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void BuscarClientesFrecuentes(String texto, String tipoFiltro) {
        try {
            List<ClienteFrecuente> lista = objetosBO.getClientesFrecuentesBO().validarBarraBusqueda(texto, tipoFiltro);
            ((BusquedaClienteFrecuenteFORM) frameActual).mostrarResultados(lista);

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void agregarProducto(String nombre, Double precio, String descripcion, String tipoProducto) {
        try {
            TipoProductoDTO tipoDTO = TipoProductoDTO.valueOf(tipoProducto.toUpperCase());
            EstadoDTO estado = EstadoDTO.ACTIVO;
            NuevoProductoDTO productoDTO = new NuevoProductoDTO(nombre, descripcion, precio, tipoDTO, estado);

            objetosBO.getProductosBO().validarRegistroProducto(productoDTO);
            JOptionPane.showMessageDialog(frameActual, "Producto registrado con éxito");
            navegarMenuProductos();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarProductos(String nombre) {
        try {
            List<Producto> lista = objetosBO.getProductosBO().validarBarraBusquedaProductos(nombre);
            ((AdministrarProductosFORM) frameActual).mostrarResultados(lista);

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarProducto(NuevoProductoDTO productoActualizar)throws NegocioException{
        try {
            objetosBO.getProductosBO().validacionProductoActualizado(productoActualizar);
            this.reiniciarTablaProductos();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarProducto(Long id){
        try {
            objetosBO.getProductosBO().validarEliminarProducto(id);
            this.reiniciarTablaProductos();
            
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    //utileria
    public Producto consultaProductoPorID(Long id) throws NegocioException {
        try {
            return objetosBO.getProductosBO().validarBusquedaPorId(id);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public void reiniciarTablaProductos() {
    if (frameActual instanceof AdministrarProductosFORM administrarProductosFrom) {
        administrarProductosFrom.cargarProductos(); 
    }
}

    
}
