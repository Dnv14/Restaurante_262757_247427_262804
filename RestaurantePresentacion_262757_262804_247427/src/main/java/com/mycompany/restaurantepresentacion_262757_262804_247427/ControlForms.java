/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepresentacion_262757_262804_247427;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedominio_262757_247427_262804.Receta;
import com.mycompany.restaurantedtos_262757_247427_262804.EstadoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevaRecetaDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteFrecuenteDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoIngredienteDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.TipoProductoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.UnidadMedidaDTO;
import com.mycompany.restaurantenegocio_262757_247427_262804.NegocioException;
import com.mycompany.restaurantenegocio_262757_247427_262804.ObjetosBO;
import java.util.LinkedList;
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

    public void navegarMenuIngredientes() {
        mostrarPantalla(new MenuIngredientesFORM(this));
    }

    public void navegarAgregarIngrediente() {
        mostrarPantalla(new AgregarIngredientesFORM(this));
    }

    public void navegarBusquedaIngrediente() {
        mostrarPantalla(new BusquedaIngredienteFORM(this));
    }

    public void navegarMenuAccionesProducto(Long id) {
        MenuAccionesProducto menuAccionesProducto = new MenuAccionesProducto(frameActual, true, this, id);
        menuAccionesProducto.setLocationRelativeTo(frameActual);
        menuAccionesProducto.setVisible(true);
    }

    public void navegarAniadirProducto() {
        mostrarPantalla(new AniadirProductoFORM(this));
    }

    public void navegarEditarProducto(Long id) {
        try {
            Producto producto = objetosBO.getProductosBO().validarBusquedaPorId(id);
            EditarProductoFORM editarProducto = new EditarProductoFORM(frameActual, true, this, id);
            List<NuevaRecetaDTO> recetasTemporales = new LinkedList<>();

            for (Receta recetas : producto.getReceta()) {
                recetasTemporales.add(new NuevaRecetaDTO(
                        recetas.getIngrediente().getIdIngrediente(),
                        recetas.getIngrediente().getNombreIngrediente(),
                        recetas.getCantidadIngrediente()
                ));
            }

            editarProducto.setIngredientesReceta(recetasTemporales);
            editarProducto.setLocationRelativeTo(frameActual);
            editarProducto.setVisible(true);
        } catch (NegocioException ex) {
        }

    }

    public void agregarIngredientesProducto() {
        AgregarIngredientesProductoFORM agregarIngredientesProductoFORM = new AgregarIngredientesProductoFORM(frameActual, true, this);
        agregarIngredientesProductoFORM.setLocationRelativeTo(frameActual);
        agregarIngredientesProductoFORM.setVisible(true);
    }

    public void navegarDetallesProducto(Long id) {
        DetallesProductoFORM detallesProducto = new DetallesProductoFORM(frameActual, true, this, id);
        detallesProducto.setLocationRelativeTo(frameActual);
        detallesProducto.setVisible(true);
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

    public void agregarProducto(String nombre, Double precio, String descripcion, String tipoProducto, List<NuevaRecetaDTO> recetas) {
        try {
            TipoProductoDTO tipoDTO = TipoProductoDTO.valueOf(tipoProducto.toUpperCase());
            EstadoDTO estado = EstadoDTO.ACTIVO;
            NuevoProductoDTO productoDTO = new NuevoProductoDTO(nombre, descripcion, precio, tipoDTO, estado, recetas);

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

    public void actualizarProducto(NuevoProductoDTO productoActualizar) throws NegocioException {
        try {
            objetosBO.getProductosBO().validacionProductoActualizado(productoActualizar);
            this.reiniciarTablaProductos();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarProducto(Long id) {
        try {
            objetosBO.getProductosBO().validarEliminarProducto(id);
            this.reiniciarTablaProductos();

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cambiarEstadoProducto(Long id, EstadoDTO estadoDTO) {
        try {
            objetosBO.getProductosBO().validarCambiarEstado(id, estadoDTO);
            this.reiniciarTablaProductos();

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void registrarIngrediente(String nombre, Double stock, String unidadMedida) {
        try {
            UnidadMedidaDTO unidadDTO = UnidadMedidaDTO.valueOf(unidadMedida.toUpperCase());
            NuevoIngredienteDTO ingredienteDTO = new NuevoIngredienteDTO(nombre, stock, unidadDTO);
            objetosBO.getIngredientesBO().validarRegistroIngrediente(ingredienteDTO);
            JOptionPane.showMessageDialog(frameActual, "El ingrediente ha sido registrado con éxito.");
            navegarMenuIngredientes();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarIngredientes(String texto, String tipoFiltro) {
        try {
            List<Ingrediente> lista = objetosBO.getIngredientesBO().validarBarraBusqueda(texto, tipoFiltro);
            ((BusquedaIngredienteFORM) frameActual).mostrarResultados(lista);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarStockIngrediente(Long idIngrediente, String cantidad) {
        try {
            objetosBO.getIngredientesBO().actualizarStockIngrediente(idIngrediente, cantidad);
            JOptionPane.showMessageDialog(frameActual, "El stock ha sido actualizado correctamente");
            buscarIngredientes("", "");
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarIngredientesParaProducto(String texto, String tipoFiltro, AgregarIngredientesProductoFORM dialog) {
        try {
            List<Ingrediente> lista = objetosBO.getIngredientesBO().validarBarraBusqueda(texto, tipoFiltro);
            dialog.mostrarResultados(lista);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void buscarIngredientesParaProductoEditar(String texto, String tipoFiltro, EditarProductoFORM dialog) {
        try {
            List<Ingrediente> lista = objetosBO.getIngredientesBO().validarBarraBusqueda(texto, tipoFiltro);
            dialog.mostrarResultados(lista);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void enviarIngredienteAniadirProducto(NuevaRecetaDTO receta) {
        ((AniadirProductoFORM) frameActual).agregarIngredienteLista(receta);
    }

    public String ResumenRecetasProducto() {
        String ingredientesMostar = "";
        List<NuevaRecetaDTO> lista = ((AniadirProductoFORM) frameActual).getIngredientesReceta();

        for (NuevaRecetaDTO ingrediente : lista) {
            ingredientesMostar += ingrediente.getNombre() + "\n";
        }
        return ingredientesMostar;
    }

    public String mostrarDescripcion(Long id) {
        try {
            Producto producto = objetosBO.getProductosBO().validarBusquedaPorId(id);
            return producto.getDescripcion();

        } catch (NegocioException ex) {
        }
        return null;
    }

    public String obtenerReceta(Long id) {
        try {
            Producto producto = objetosBO.getProductosBO().validarBusquedaPorId(id);
            String texto = "";
            for (Receta receta : producto.getReceta()) {

                texto += "- " + receta.getCantidadIngrediente() + "x " + receta.getIngrediente().getNombreIngrediente() + "\n";
            }
            return texto;
        } catch (NegocioException ex) {
        }
        return null;
    }

//    public List<NuevaRecetaDTO> obtenerListaTemporalParaAniadir() {
//        return ((AniadirProductoFORM) frameActual).getIngredientesReceta();
//    }
//    
//    public List<NuevaRecetaDTO> obtenerListaTemporalParaEditar(EditarProductoFORM dialog) {
//        return dialog.getIngredientesReceta();
//    }
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
