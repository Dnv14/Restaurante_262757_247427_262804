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

    /**
     * Agregar un nuevo ingrediente a la base de datos 
     * @param nuevoIngrediente DTO que contiene los datos del ingrediente que se quiere agregar.
     * @return El ingrediente ya creado y agregado en la base de datos.
     * @throws PersistenciaException Si ocurre un error al agregar el ingrediente u otro error.
     */
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

    /**
     * Consulta una lista de ingredientes dependiendo del filtro que se le asigne.
     * @param tipoFiltro Filtro con el cual se podrán realizar las búsquedas personalizadas.
     * @return Lista de ingredientes que coinciden con el filtro seleccionado.
     * @throws PersistenciaException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public List<Ingrediente> consultarIngredientesFiltro(FiltrosDTO tipoFiltro) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.crearEntityManager();
        CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> cQuery = cBuilder.createQuery(Ingrediente.class);
        Root<Ingrediente> root = cQuery.from(Ingrediente.class);
        List<Predicate> predicados = new LinkedList<>();

        if (tipoFiltro.getNombre() != null && !tipoFiltro.getNombre().isEmpty()) {
            predicados.add(cBuilder.like(root.get("nombreIngrediente"), "%" + tipoFiltro.getNombre() + "%"));
        }

        if (tipoFiltro.getUnidadMedida() != null && !tipoFiltro.getUnidadMedida().isEmpty()) {
            try{
                UnidadMedida unidad = UnidadMedida.valueOf(tipoFiltro.getUnidadMedida().toUpperCase());
                predicados.add(cBuilder.equal(root.get("unidadMedida"), unidad));
            }catch(IllegalArgumentException ex){
                
            }
        }
        if (!predicados.isEmpty()) {
            cQuery.where(predicados.toArray(new Predicate[predicados.size()]));
        }
        return entityManager.createQuery(cQuery).getResultList();

    }

    /**
     * Consulta una lista de todos los ingredientes existentes.
     * @return La la lista de los ingredientes encontrados. 
     * @throws PersistenciaException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public List<Ingrediente> consultarTodosIngredientes() throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            String queryJPQL = """
                               SELECT i FROM Ingrediente i
                               """;
            TypedQuery<Ingrediente> query = entityManager.createQuery(queryJPQL, Ingrediente.class);
            return query.getResultList();
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron obtener los ingredientes");
        }
    }

    /**
     * Consulta un ingrediente por su nombre y unidad medida.
     * @param nombre Nombre del ingrediente que se quiere buscar.
     * @param unidadMedida Unidad de medida del ingrediente que se quiere buscar.
     * @return Retorna el ingrediente que coincide con los datos puestos.
     * @throws PersistenciaException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public Ingrediente consultarPorNombreyUnidad(String nombre, UnidadMedidaDTO unidadMedida) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.crearEntityManager();
        CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ingrediente> cQuery = cBuilder.createQuery(Ingrediente.class);
        Root<Ingrediente> root = cQuery.from(Ingrediente.class);
        
        cQuery.where(
            cBuilder.and(
                cBuilder.equal(root.get("nombreIngrediente"), nombre),
                cBuilder.equal(root.get("unidadMedida"), unidadMedida)));
        
        List<Ingrediente> resultado = entityManager.createQuery(cQuery).getResultList();
        if(resultado.isEmpty()){
            return null;
        }
        return resultado.get(0);
    }

    /**
     * Actializa el stock de un ingrediente dependiendo de la cantidad que se quiera sumar.
     * @param idIngrediente El identificador único del ingrediente a modificar el stock.
     * @param cantidad La cantidad de stock que se desea modificar .
     * @throws PersistenciaException Si ocurre algún error al acceder a la base de datos.
     */
    @Override
    public void acualizarIngrediente(Long idIngrediente, Double cantidad) throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            
            Ingrediente ingrediente = entityManager.find(Ingrediente.class, idIngrediente);
            if(ingrediente == null){
                throw new PersistenciaException("El ingrediente que se está buscando no existe.");
            }
            Double stockNuevo = ingrediente.getStockIngrediente() + cantidad;
            ingrediente.setStockIngrediente(stockNuevo);
            
            entityManager.merge(ingrediente);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo actualizar el stock de ingredientes");
        }
    }

    /**
     * Consulta un ingrediente de la base de datos mediante su ID.
     * @param idIngrediente El identificador único del ingrediente a consultar.
     * @return El ingrediente encontrado con su ID.
     * @throws PersistenciaException El ingrediente no se encuentre o exista otro error.
     */
    @Override
    public Ingrediente consultarPorId(Long idIngrediente) throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            Ingrediente ingrediente = entityManager.find(Ingrediente.class, idIngrediente);
            if(ingrediente == null){
                throw new PersistenciaException("No se encontró el ingrediente");
            }
            return ingrediente;
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo consultar el ingrediente.");
        }
    }

    /**
     * Eliminar un ingrediente encontrado en la base de datos mediante su ID.
     * @param ideIngrediente El identificador único del ingrediente a eliminar
     * @throws PersistenciaException El ingrediente no se pueda eliminar o exista otro error.
     */
    @Override
    public void eliminarIngrediente(Long ideIngrediente) throws PersistenciaException {
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            Ingrediente ingrediente = entityManager.find(Ingrediente.class, ideIngrediente);
            entityManager.remove(ingrediente);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch(PersistenceException ex){
            throw new PersistenciaException("No se pudo eliminar el ingrediente");
        }
    }
}
