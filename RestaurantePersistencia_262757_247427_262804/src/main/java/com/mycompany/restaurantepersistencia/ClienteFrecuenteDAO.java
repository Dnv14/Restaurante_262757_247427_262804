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
            //aqui usamos el arreglo pq con las listas tira error :p
            Predicate[] filtrosFinales = predicados.toArray(new Predicate[predicados.size()]);
            cQuery.where(cBuilder.and(filtrosFinales));
        }
        return entityManager.createQuery(cQuery).getResultList();
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
