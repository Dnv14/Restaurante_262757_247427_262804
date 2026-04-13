/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.FiltrosDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteDTO;
import enriquemadridalvarez.utilidades_262757_247427_262804.Encriptador;
import java.time.LocalDate;
import java.util.LinkedList;
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

    /**
     * Crea  y agrega un nuevo cliente frecuente a la base de datos.
     * @param nuevoClienteFrecuente DTO con los datos del cliente que se quiere registrar.
     * @return Retorna el cliente frecuente que se creo.
     * @throws PersistenciaException Si ocurre un error al querer agregar cliente frecuente a la base de datos.
     * @throws Exception Si ocurre algún error durante el proceso.
     */
    @Override
    public ClienteFrecuente crearClienteFrecuente(NuevoClienteDTO nuevoClienteFrecuente) throws PersistenciaException, Exception {
        ClienteFrecuente clienteFrecuente = new ClienteFrecuente();
        clienteFrecuente.setNombres(nuevoClienteFrecuente.getNombres());
        clienteFrecuente.setApellidos(nuevoClienteFrecuente.getApellidos());
        clienteFrecuente.setCorreoElectronico(nuevoClienteFrecuente.getCorreoElectronico());
        clienteFrecuente.setTelefono(Encriptador.encriptar(nuevoClienteFrecuente.getTelefono()));
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
        } catch (Exception ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("Existió un error al enciptar el teléfono");
        }
    }

    /**
     * Consulta una lista de clientes frecuentes dependiendo del filtro que se le asigne.
     * @param Tipofiltro Filtro con el cual se podrán hacer las búsquedas personalizadas.
     * @return Retorna el cliente frecuente dependiendo del filtro utilizado.
     * @throws PersistenciaException Si ocurre un error al acceder a la base de datos.
     */
    @Override
    public List<ClienteFrecuente> consultarClientesFiltros(FiltrosDTO Tipofiltro) throws PersistenciaException {
        EntityManager entityManager = ManejadorConexiones.crearEntityManager();
        CriteriaBuilder cBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClienteFrecuente> cQuery = cBuilder.createQuery(ClienteFrecuente.class);
        Root<ClienteFrecuente> root = cQuery.from(ClienteFrecuente.class);

        List<Predicate> predicados = new LinkedList<>();

        if (Tipofiltro.getNombre() != null && !Tipofiltro.getNombre().isEmpty()) {
            String filtro = "%" + Tipofiltro.getNombre() + "%";
            Predicate pNombre = cBuilder.like(root.get("nombres"), filtro);
            Predicate pApellido = cBuilder.like(root.get("apellidos"), filtro);
            predicados.add(cBuilder.or(pNombre, pApellido)); 
        }

        if (Tipofiltro.getTelefono() != null && !Tipofiltro.getTelefono().isEmpty()) {
            predicados.add(cBuilder.like(root.get("telefono"), "%" + Tipofiltro.getTelefono() + "%"));
        }

        if (Tipofiltro.getCorreo() != null && !Tipofiltro.getCorreo().isEmpty()) {
            predicados.add(cBuilder.like(root.get("correoElectronico"), "%" + Tipofiltro.getCorreo() + "%"));
        }

        if (!predicados.isEmpty()) {
            Predicate[] filtrosFinales = predicados.toArray(new Predicate[predicados.size()]);
            cQuery.where(cBuilder.and(filtrosFinales));
        }
        return entityManager.createQuery(cQuery).getResultList();
    }

    

    /**
     * Consulta una lista con todos los clientes frecuentes.
     * @return Retorna una lista con todos los clientes frecuentes.
     * @throws PersistenciaException Si ocurre un error al acceder a la base de datos.
     */
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
