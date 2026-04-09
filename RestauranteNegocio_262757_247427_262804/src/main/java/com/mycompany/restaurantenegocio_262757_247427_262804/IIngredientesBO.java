/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.restaurantenegocio_262757_247427_262804;

import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoIngredienteDTO;
import java.util.List;

/**
 *
 * @author BALAMRUSH
 */
public interface IIngredientesBO {
    
    public abstract Ingrediente validarRegistroIngrediente(NuevoIngredienteDTO nuevoIngrediente)throws NegocioException;
    
    public List<Ingrediente> validarBarraBusqueda(String texto, String tipoFiltro) throws NegocioException;
    
    public void actualizarStockIngrediente(Long idIngrediente, String cantidadTexto) throws NegocioException;
    
}
