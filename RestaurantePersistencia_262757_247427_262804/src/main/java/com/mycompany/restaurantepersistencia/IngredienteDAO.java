/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedominio_262757_247427_262804.UnidadMedida;
import com.mycompany.restaurantedtos_262757_247427_262804.FiltrosDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoIngredienteDTO;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
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
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombreIngrediente(nuevoIngrediente.getNombreIngrediente());
        ingrediente.setStockIngrediente(nuevoIngrediente.getStockIngrediente());
        UnidadMedida unidadMedida = UnidadMedida.valueOf(nuevoIngrediente.getUnidadMedida().name());
        ingrediente.setUnidadMedida(unidadMedida);
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
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
        CriteriaQuery<ClienteFrecuente> cQuery = cBuilder.createQuery(ClienteFrecuente.class);
        Root<ClienteFrecuente> root = cQuery.from(ClienteFrecuente.class);
        List<Predicate> predicados = new LinkedList<>();
        
       return null;
    }

    @Override
    public List<Ingrediente> consultarTodosIngredientes() throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
