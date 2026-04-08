/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedominio_262757_247427_262804.UnidadMedida;
import com.mycompany.restaurantedtos_262757_247427_262804.FiltrosDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoIngredienteDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.UnidadMedidaDTO;
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
 * @author BALAMRUSH
 */
public class IngredienteDAO implements IIngredienteDAO {

    private static final Logger LOGGER = Logger.getLogger(IngredienteDAO.class.getName());

    @Override
    public Ingrediente agregarIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            Ingrediente ingrediente = NuevoIngredienteDTOAIngredienteAdapter.adaptar(nuevoIngrediente);
            entityManager.getTransaction().begin();
            entityManager.persist(ingrediente);
            entityManager.getTransaction().commit();
            return ingrediente;
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo agregar un nuevo Ingrediente.");
        }
    }

    @Override
    public List<Ingrediente> consultarIngredientesFiltro(FiltrosDTO tipoFiltro) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.crearEntityManager();
        CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> cQuery = cBuilder.createQuery(Ingrediente.class);
        Root<Ingrediente> root = cQuery.from(Ingrediente.class);
        List<Predicate> predicados = new LinkedList<>();

        if (tipoFiltro.getNombre() != null && !tipoFiltro.getNombre().isEmpty()) {
            predicados.add(cBuilder.like(root.get("nombre_ingrediente"), "%" + tipoFiltro.getTelefono() + "%"));
        }

        if (tipoFiltro.getUnidadMedida() != null && !tipoFiltro.getUnidadMedida().isEmpty()) {
            predicados.add(cBuilder.like(root.get("unidad_medida"), "%" + tipoFiltro.getTelefono() + "%"));
        }
        if (!predicados.isEmpty()) {
            cQuery.where(predicados.toArray(new Predicate[predicados.size()]));
        }
        return entityManager.createQuery(cQuery).getResultList();

    }

    @Override
    public List<Ingrediente> consultarTodosIngredientes() throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            String queryJPQL = """
                               SELECT i FROM ingredientes i
                               """;
            TypedQuery<Ingrediente> query = entityManager.createQuery(queryJPQL, Ingrediente.class);
            return query.getResultList();
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron obtener los ingredientes");
        }
    }

    @Override
    public Ingrediente consultarPorNombreyUnidad(String nombre, UnidadMedidaDTO unidadMedida) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.crearEntityManager();
        CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> cQuery = cBuilder.createQuery(Ingrediente.class);
        Root<Ingrediente> root = cQuery.from(Ingrediente.class);
        
        cQuery.where(
            cBuilder.and(
                cBuilder.equal(root.get("nombre_ingrediente"), nombre),
                cBuilder.equal(root.get("unidad_Medida"), unidadMedida)));
        
        List<Ingrediente> resultado = entityManager.createQuery(cQuery).getResultList();
        if(resultado.isEmpty()){
            return null;
        }
        return resultado.get(0);
    }
    
    

}
