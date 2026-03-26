/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteDTO;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.criteria.Predicate;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author BALAMRUSH
 */
public class ClienteFrecuenteDAO implements IClienteFrecuenteDAO {

    private static final Logger LOGGER = Logger.getLogger(ClienteFrecuenteDAO.class.getName());

    @Override
    public ClienteFrecuente crearClienteFrecuente(NuevoClienteDTO nuevoClienteFrecuente) throws PersistenciaException {
        ClienteFrecuente clienteFrecuente = new ClienteFrecuente();
        clienteFrecuente.setNombreCompleto(nuevoClienteFrecuente.getNombreCompleto());
        clienteFrecuente.setCorreoElectronico(nuevoClienteFrecuente.getCorreoElectronico());
        clienteFrecuente.setTelefono(nuevoClienteFrecuente.getTelefono());
        clienteFrecuente.setFechaRegistro(LocalDate.now());
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(clienteFrecuente);
            entityManager.getTransaction().commit();
            return clienteFrecuente;
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No fue posbile crear el cliente.");
        }
    }
    // TODO: los 3 métodos Juntarlos creando dtoFiltros y juntarlo en 1 metodo
    //con validadores  y agregar el like para que traia coincidencias
    @Override
    public ClienteFrecuente consultarClienteFrecuentePorNombre(String nombreCompleto) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<ClienteFrecuente> cQuery = cBuilder.createQuery(ClienteFrecuente.class);
            Root<ClienteFrecuente> root = cQuery.from(ClienteFrecuente.class);
            Predicate predicado = cBuilder.equal(root.get("nombreCompleto"), nombreCompleto);
            cQuery.select(root).where(predicado);
            return entityManager.createQuery(cQuery).getSingleResult();
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo consultar el cliente frecuente por el nombre");
        }
    }

    @Override
    public ClienteFrecuente consultarClienteFrecuentePorTelefono(String telefono) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<ClienteFrecuente> cQuery = cBuilder.createQuery(ClienteFrecuente.class);
            Root<ClienteFrecuente> root = cQuery.from(ClienteFrecuente.class);
            Predicate predicado = cBuilder.equal(root.get("telefono"), telefono);
            cQuery.select(root).where(predicado);
            return entityManager.createQuery(cQuery).getSingleResult();
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo consultar el cliente frecuente por el nombre");
        }
    }

    @Override
    public ClienteFrecuente consultarClienteFrecuentePorCorreo(String correoElectronico) throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<ClienteFrecuente> cQuery = cBuilder.createQuery(ClienteFrecuente.class);
            Root<ClienteFrecuente> root = cQuery.from(ClienteFrecuente.class);
            Predicate predicado = cBuilder.equal(root.get("correoElectronico"), correoElectronico);
            cQuery.select(root).where(predicado);
            return entityManager.createQuery(cQuery).getSingleResult();
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudo consultar el cliente frecuente por el nombre");
        }
    }

    @Override
    public List<ClienteFrecuente> consultarTodosClientesFrecuentes() throws PersistenciaException {
        try {
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            String queryJPQL = """
                               SELECT cf FROM ClienteFrecuente cf
                               """;
            TypedQuery<ClienteFrecuente> query = entityManager.createQuery(queryJPQL, ClienteFrecuente.class);
            return query.getResultList();
        } catch (PersistenceException ex) {
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No se pudieron obtener los clientes frecuentes");
        }
    }
}
