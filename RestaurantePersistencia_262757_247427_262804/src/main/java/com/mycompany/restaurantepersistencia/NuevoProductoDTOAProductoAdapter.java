/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.Estado;
import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedominio_262757_247427_262804.Receta;
import com.mycompany.restaurantedominio_262757_247427_262804.TipoProducto;
import com.mycompany.restaurantedtos_262757_247427_262804.EstadoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevaRecetaDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.TipoProductoDTO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Diego
 */
public class NuevoProductoDTOAProductoAdapter {

    /**
     * Convierte un NuevoProductoDTO a un producto del dominio.
     *
     * @param productoDTO DTO con los datos del producto a transformar.
     * @return Un nuevo Producto con los datos DTO adaptados.
     */
    public static Producto adaptar(NuevoProductoDTO productoDTO) {
        TipoProducto tipoProductoDominio = TipoProducto.PLATILLO;
        Estado estadoDominio = Estado.ACTIVO;

        if (productoDTO.getTipoProducto() == TipoProductoDTO.BEBIDA) {
            tipoProductoDominio = TipoProducto.BEBIDA;
        } else if (productoDTO.getTipoProducto() == TipoProductoDTO.POSTRE) {
            tipoProductoDominio = TipoProducto.POSTRE;
        }

        if (productoDTO.getEstado() == EstadoDTO.INACTIVO) {
            estadoDominio = Estado.INACTIVO;
        }

        Producto productoNuevo = new Producto(productoDTO.getNombre(),
                productoDTO.getDescripcion(), productoDTO.getPrecio(),
                tipoProductoDominio,
                estadoDominio);

        productoNuevo.setRutaImagen(productoDTO.getRutaImagen());

        if (productoDTO.getRecetas() != null || !productoDTO.getRecetas().isEmpty()) {
            List<Receta> listaRecetas = new LinkedList<>();

            for (NuevaRecetaDTO recetaDTO : productoDTO.getRecetas()) {
                Receta recetaDominio = new Receta();
                recetaDominio.setCantidadIngrediente(recetaDTO.getCantidad());
                recetaDominio.setProducto(productoNuevo);

                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setIdIngrediente(recetaDTO.getIdIngrediente());
                recetaDominio.setIngrediente(ingrediente);

                listaRecetas.add(recetaDominio);
            }
            productoNuevo.setReceta(listaRecetas);
        }

        return productoNuevo;
    }

    /**
     * Actualiza el estado de un Producto existente de un EstadoDTO.
     *
     * @param productoExistente Producto al cual se le actualizará el estado.
     * @param nuevoEstadoDTO Estado nuevo que se asignará al producto.
     * @return Producto con el estado actualizado.
     */
    public static Producto actualizarEstado(Producto productoExistente, EstadoDTO nuevoEstadoDTO) {
        Estado estadoDominio = Estado.ACTIVO;

        if (nuevoEstadoDTO == EstadoDTO.INACTIVO) {
            estadoDominio = Estado.INACTIVO;
        }

        productoExistente.setEstado(estadoDominio);

        return productoExistente;
    }
}
