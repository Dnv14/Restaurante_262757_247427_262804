/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantenegocio_262757_247427_262804;

import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedtos_262757_247427_262804.EstadoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import com.mycompany.restaurantepersistencia.IProductoDAO;
import com.mycompany.restaurantepersistencia.PersistenciaException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Diego
 */
public class ProductosBO implements IProductosBO {

    private final IProductoDAO productosDAO;

    public ProductosBO(IProductoDAO productosDAO) {
        this.productosDAO = productosDAO;
    }

    private boolean soloLetras(String texto) {
        Pattern pattern = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    @Override
    public Producto validarRegistroProducto(NuevoProductoDTO productoDTO) throws NegocioException {
        if (productoDTO == null) {
            throw new NegocioException("La información del producto está vacía.");
        }

        if (productoDTO.getNombre() == null || productoDTO.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre del producto es obligatorio.");
        }

        if (!soloLetras(productoDTO.getNombre())) {
            throw new NegocioException("El nombre solo debe contener letras.");
        }

        if (productoDTO.getDescripcion().length() > 50) {
            throw new NegocioException("La descripción es muy larga (máximo 50 caracteres)");
        }
        
        if (productoDTO.getPrecio() == null) {
            throw new NegocioException("El precio es obligatorio.");
        }
        
        if (productoDTO.getPrecio() < 0) {
            throw new NegocioException("El precio debe ser un número positivo.");
        }

        if (productoDTO.getRecetas() == null || productoDTO.getRecetas().isEmpty()) {
            throw new NegocioException("Un producto debe tener al menos un ingrediente.");
        }

        try {
            Producto producto = productosDAO.agregarProducto(productoDTO);

            if (producto == null) {
                throw new NegocioException("Producto no encontrado.", null);
            }
            return producto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar validar el Producto.", ex);
        }
    }

    @Override
    public List<Producto> validarBarraBusquedaProductos(String nombre) throws NegocioException {
        if (nombre != null && !nombre.isEmpty()) {
            if (!soloLetras(nombre)) {
                throw new NegocioException("La búsqueda solo debe contener letras");
            }

        }
        try {
            if (nombre == null || nombre.isEmpty()) {
                return productosDAO.consultarTodosLosProductos();
            } else {
                return productosDAO.consultarProductosNombre(nombre);
            }

        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo buscar los productos", ex);
        }
    }

    @Override
    public Producto validarBusquedaPorId(Long id) throws NegocioException {
        if (id == null) {
            throw new NegocioException("El ID del producto es nulo");
        }
        try {
            return productosDAO.consultarProductoPorId(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo consultar el Producto por su ID");
        }
    }

    @Override
    public Producto validacionProductoActualizado(NuevoProductoDTO productoActualizar) throws NegocioException {
        if (productoActualizar.getId() == null) {
            throw new NegocioException("El ID del producto es nulo");
        }

        if (!soloLetras((productoActualizar.getNombre()))) {
            throw new NegocioException("El nombre actualizado no es válido.");
        }

        if (productoActualizar.getPrecio() < 0) {
            throw new NegocioException("El precio debe ser un número positivo.");
        }
        try {
            return productosDAO.actualizarProducto(productoActualizar);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo actualizar el producto solicitado");
        }
    }

    @Override
    public void validarEliminarProducto(Long id) throws NegocioException {
        if (id == null) {
            throw new NegocioException("El ID del producto es nulo");
        }
        try {
            productosDAO.eliminarProducto(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo eliminar el producto solicitado");
        }
    }

    @Override
    public void validarCambiarEstado(Long id, EstadoDTO estadoDTO) throws NegocioException {
        if (id == null) {
            throw new NegocioException("El ID del producto es nulo");
        }

        if (estadoDTO == null) {
            throw new NegocioException("El nuevo estado es obligatorio.");
        }

        try {
            productosDAO.actualizarEstadoProducto(id, estadoDTO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo cambiar el estado del producto solicitado");
        }
    }

}
