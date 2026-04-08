/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.restaurantenegocio_262757_247427_262804;

import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface IProductosBO {
    public abstract Producto validarRegistroProducto(NuevoProductoDTO productoDTO) throws NegocioException;
    
    public abstract List<Producto> validarBarraBusquedaProductos(String nombre) throws NegocioException;
}
