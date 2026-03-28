/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.restaurantenegocio_262757_247427_262804;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.FiltrosDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteFrecuenteDTO;
import java.util.List;

/**
 *
 * @author MrGam
 */
public interface IClientesFrecuentesBO {
    public abstract ClienteFrecuente validarRegistroCliente(NuevoClienteFrecuenteDTO clienteFrecuente) throws NegocioException;
    public List<ClienteFrecuente> validarBarraBusqueda(String texto, String tipoFiltro) throws NegocioException;
}
