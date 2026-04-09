/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedominio_262757_247427_262804.UnidadMedida;
import com.mycompany.restaurantedtos_262757_247427_262804.FiltrosDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoIngredienteDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.UnidadMedidaDTO;
import java.util.List;

/**
 *
 * @author BALAMRUSH
 */
public interface IIngredienteDAO {
    
    public abstract Ingrediente agregarIngrediente(NuevoIngredienteDTO nuevoIngrediente)throws PersistenciaException;
    
    public abstract void acualizarIngrediente(Long idIngrediente, Double cantidad) throws PersistenciaException;
    
    public abstract List<Ingrediente> consultarIngredientesFiltro (FiltrosDTO tipoFiltro)throws PersistenciaException;
    
    public abstract List<Ingrediente> consultarTodosIngredientes()throws PersistenciaException;
    
    public abstract Ingrediente consultarPorNombreyUnidad(String nombre, UnidadMedidaDTO unidadMedida) throws PersistenciaException;
    
    public abstract Ingrediente consultarPorId(Long idIngrediente) throws PersistenciaException;
}
