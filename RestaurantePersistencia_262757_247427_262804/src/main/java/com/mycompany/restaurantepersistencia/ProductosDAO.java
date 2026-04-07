/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import java.util.LinkedList;
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

}
