/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteDTO;

/**
 *
 * @author BALAMRUSH
 */
public interface IClienteFrecuenteDAO {
    public abstract ClienteFrecuente crearClienteFrecuente(NuevoClienteDTO nuevoClienteFrecuente) throws PersistenciaException;
    public abstract ClienteFrecuente consultarClienteFrecuentePorNombre(String nombreCompleto) throws PersistenciaException;
    public abstract ClienteFrecuente consultarClienteFrecuentePorTelefono(String telefono) throws PersistenciaException;
    public abstract ClienteFrecuente consultarClienteFrecuentePorCorreo(String correoElectronico) throws PersistenciaException;
}
