/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantenegocio_262757_247427_262804;

import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import com.mycompany.restaurantepersistencia.IProductoDAO;
import com.mycompany.restaurantepersistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author Diego
 */
public class ProductosBO implements IProductosBO {

    private final IProductoDAO productosDAO;

    public ProductosBO(IProductoDAO productosDAO) {
        this.productosDAO = productosDAO;
    }

    @Override
    public Producto validarRegistroProducto(NuevoProductoDTO productoDTO) throws NegocioException {
        //TODO validaciones

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
        //TODO validaciones
        try {
            if (nombre == null || nombre.isEmpty()) {
                return productosDAO.consultarTodosLosProductos();
            }else {
                return productosDAO.consultarProductosNombre(nombre);
            }

        } catch (PersistenciaException ex) {
            throw new NegocioException("No se pudo buscar los productos", ex);
        }
    }

}
