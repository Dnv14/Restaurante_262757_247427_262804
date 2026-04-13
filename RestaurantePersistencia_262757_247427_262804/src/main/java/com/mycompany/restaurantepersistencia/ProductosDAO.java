/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedominio_262757_247427_262804.Receta;
import com.mycompany.restaurantedtos_262757_247427_262804.EstadoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevaRecetaDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Diego
 */
public class ProductosDAO implements IProductoDAO {

    private static final Logger LOGGER = Logger.getLogger(ProductosDAO.class.getName());

    /**
     * Crea y agrega un nuevo producto a la base de datos.
     * @param productoDTO DTO con los datos del producto que se quiere agregar.
     * @return El producto agregado.
     * @throws PersistenciaException Si ocurre un error al agregar el producto a la base de datos.
     */
    @Override
    public Producto agregarProducto(NuevoProductoDTO productoDTO) throws PersistenciaException {
        try {
            Producto productoNuevo = NuevoProductoDTOAProductoAdapter.adaptar(productoDTO);
            EntityManager em = ManejadorConexiones.crearEntityManager();
            em.getTransaction().begin();
            em.persist(productoNuevo);
            em.getTransaction().commit();
            return productoNuevo;

        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo crear el producto");
        }
    }

    /**
     * Consulta una lista de productos mediante su nombre.
     * @param nombre Nombre exacto del ingrediente que se está buscando.
     * @return Retorna el producto que coincide con el nombre colocado.
     * @throws PersistenciaException Si ocurre un error al momento de consultar en la base de datos.
     */
    @Override
    public List<Producto> consultarProductosNombre(String nombre) throws PersistenciaException {
        try {
            EntityManager em = ManejadorConexiones.crearEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery criteria = cb.createQuery(Producto.class);
            Root<Producto> root = criteria.from(Producto.class);

            Predicate where = cb.like(root.get("nombre"), "%" + nombre + "%");
            criteria.select(root).where(where);

            TypedQuery<Producto> query = em.createQuery(criteria);

            List<Producto> productosConsultados = query.getResultList();
            return productosConsultados;
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se puedo consultar los productos");
        }
    }

    /**
     * Consulta una lista de productos con todos los productos que se encuentran en ella.
     * @return Retorna todos los productos.
     * @throws PersistenciaException Si ocurre un error al consultar lso productos en la base de datos.
     */
    @Override
    public List<Producto> consultarTodosLosProductos() throws PersistenciaException {
        try {
            EntityManager em = ManejadorConexiones.crearEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery criteria = cb.createQuery(Producto.class);
            Root<Producto> root = criteria.from(Producto.class);

            criteria.select(root);
            TypedQuery<Producto> query = em.createQuery(criteria);
            List<Producto> productosConsultados = query.getResultList();
            return productosConsultados;
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo consultar los productos");
        }
    }

    /**
     * Consulta un producto mediante su identificador único.
     * @param id Identificador único del producto a consultar.
     * @return Retorna el prducto que coincide con el ID especificado.
     * @throws PersistenciaException Si ocurre un error al consultar el producto en la Baase de datos.
     */
    @Override
    public Producto consultarProductoPorId(Long id) throws PersistenciaException {
        try {
            EntityManager em = ManejadorConexiones.crearEntityManager();
            Producto productoId = em.find(Producto.class, id);
            return productoId;
        } catch (PersistenceException ex) {
            throw new PersistenciaException("No se encontró el producto con ID: " + id);
        }
    }

    /**
     * Actualiza los datos de un producto existente en la base de datos.
     * @param productoActualizado DTO con los nuevos datos del producto que se quiere actualizar.
     * @return El producto ya actualizado.
     * @throws PersistenciaException Si ocurre un error al actualizar el producto en la base de datos.
     */
    @Override
    public Producto actualizarProducto(NuevoProductoDTO productoActualizado) throws PersistenciaException {
        try {
            EntityManager em = ManejadorConexiones.crearEntityManager();
            em.getTransaction().begin();
            Producto productoGuardado = em.find(Producto.class, productoActualizado.getId());

            productoGuardado.setDescripcion(productoActualizado.getDescripcion());
            productoGuardado.setPrecio(productoActualizado.getPrecio());
            
            productoGuardado.getReceta().clear();
            for (NuevaRecetaDTO recetaDTO : productoActualizado.getRecetas()) {
                Receta nuevaReceta = new Receta();

                Ingrediente ingrediente = em.find(Ingrediente.class, recetaDTO.getIdIngrediente());

                nuevaReceta.setIngrediente(ingrediente);
                nuevaReceta.setProducto(productoGuardado);
                nuevaReceta.setCantidadIngrediente(recetaDTO.getCantidad());
                productoGuardado.getReceta().add(nuevaReceta);
            }
            
            em.getTransaction().commit();
            return productoGuardado;
        } catch (PersistenceException ex) {
            throw new PersistenciaException("No se pudo actualizar el producto");
        }
    }

    /**
     * Elimina un producto de la base de datos mediante su ID.
     * @param id ID del producto que se quiere eliminar.
     * @throws PersistenciaException Si ocurre un error al momento de eliminar el producto en la base de datos.
     */
    @Override
    public void eliminarProducto(Long id) throws PersistenciaException {
        try {
            EntityManager em = ManejadorConexiones.crearEntityManager();
            em.getTransaction().begin();
            Producto productoEliminar = em.find(Producto.class, id);
            em.remove(productoEliminar);
            em.getTransaction().commit();

        } catch (PersistenceException ex) {
            throw new PersistenciaException("No se pudo eliminar el producto");
        }
    }

    /**
     * Actualiza el estado de un producto en la base de datos.
     * @param id ID del producto que se quiere actualizar.
     * @param nuevoEstado Nuevo estado que se le asignará al producto.
     * @throws PersistenciaException Si ocurre un error al actualizar el producto en la base de datos.
     */
    @Override
    public void actualizarEstadoProducto(Long id, EstadoDTO nuevoEstado) throws PersistenciaException {
        try {
            EntityManager em = ManejadorConexiones.crearEntityManager();
            em.getTransaction().begin();
            Producto productoEstado = em.find(Producto.class, id);

            NuevoProductoDTOAProductoAdapter.actualizarEstado(productoEstado, nuevoEstado);

            em.getTransaction().commit();

        } catch (PersistenceException ex) {
            throw new PersistenciaException("No se pudo actualizar el estado del producto");
        }
    }
}
