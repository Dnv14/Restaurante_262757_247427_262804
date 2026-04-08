/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import java.util.List;

/**
 *
 * @author Diego
 */
public interface IProductoDAO {
    public abstract Producto agregarProducto(NuevoProductoDTO producto)throws PersistenciaException;
    
    public abstract List<Producto> consultarProductosNombre(String nombre)throws PersistenciaException;
    
    public abstract List<Producto> consultarTodosLosProductos()throws PersistenciaException;
}
