/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.FiltrosDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteDTO;
import java.util.List;

/**
 *
 * @author BALAMRUSH
 */
public interface IClienteFrecuenteDAO {

    public abstract ClienteFrecuente crearClienteFrecuente(NuevoClienteDTO nuevoClienteFrecuente) throws PersistenciaException, Exception;
    
    public abstract List<ClienteFrecuente> consultarClientesFiltros(FiltrosDTO Tipofiltro) throws PersistenciaException;

    public abstract List<ClienteFrecuente> consultarTodosClientesFrecuentes() throws PersistenciaException;
}
