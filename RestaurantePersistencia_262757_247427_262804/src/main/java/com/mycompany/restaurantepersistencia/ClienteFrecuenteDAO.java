/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteDTO;
import java.time.LocalDate;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author BALAMRUSH
 */
public class ClienteFrecuenteDAO implements IClienteFrecuenteDAO{

    private static final Logger LOGGER = Logger.getLogger(ClienteFrecuenteDAO.class.getName());
    

    @Override
    public ClienteFrecuente crearClienteFrecuente(NuevoClienteDTO nuevoClienteFrecuente) throws PersistenciaException {
        ClienteFrecuente clienteFrecuente = new ClienteFrecuente();
        clienteFrecuente.setNombreCompleto(nuevoClienteFrecuente.getNombreCompleto());
        clienteFrecuente.setCorreoElectronico(nuevoClienteFrecuente.getCorreoElectronico());
        clienteFrecuente.setTelefono(nuevoClienteFrecuente.getTelefono());
        clienteFrecuente.setFechaRegistro(LocalDate.now());
        try{
            EntityManager entityManager = ManejadorConexiones.crearEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(clienteFrecuente);
            entityManager.getTransaction().commit();
            return clienteFrecuente;
        }catch(PersistenceException ex){
            LOGGER.severe(ex.getMessage());
            throw new PersistenciaException("No fue posbile crear el cliente");
        }
    }

    @Override
    public ClienteFrecuente consultarClienteFrecuentePorNombre(String nombreCompleto) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteFrecuente consultarClienteFrecuentePorTelefono(String telefono) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ClienteFrecuente consultarClienteFrecuentePorCorreo(String correoElectronico) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
