/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteFrecuenteDTO;

/**
 *
 * @author BALAMRUSH
 */
public interface IClienteFrecuenteDAO {
    public abstract void crearClienteFrecuente(NuevoClienteFrecuenteDTO nuevoClienteFrecuente) throws PersistenciaException;
    public abstract NuevoClienteFrecuenteDTO consultarClienteFrecuentePorNombre(String nombreCompleto) throws PersistenciaException;
    public abstract NuevoClienteFrecuenteDTO consultarClienteFrecuentePorTelefono(String telefono) throws PersistenciaException;
    public abstract NuevoClienteFrecuenteDTO consultarClienteFrecuentePorCorreo(String correoElectronico) throws PersistenciaException;
}
