/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedominio_262757_247427_262804.UnidadMedida;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoIngredienteDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.UnidadMedidaDTO;

/**
 *
 * @author BALAMRUSH
 */
public class NuevoIngredienteDTOAIngredienteAdapter {
    
    /**
     * Convierte un NuevoIngredienteDATO un Ingrediente en dominio.
     * @param ingredienteDTO DTo con los datos del ingrediente que se quiere convertir.
     * @return Un nuevo ingrediente con los datos de la DTO ya convertidos.
     */
    public static Ingrediente adaptar(NuevoIngredienteDTO ingredienteDTO){
        UnidadMedida unidadMediaDominio = UnidadMedida.GRAMO;
        
        if(ingredienteDTO.getUnidadMedida()== UnidadMedidaDTO.KILOGRAMO){
            unidadMediaDominio = UnidadMedida.KILOGRAMO;
        }else if(ingredienteDTO.getUnidadMedida() == UnidadMedidaDTO.MILILITRO){
            unidadMediaDominio = UnidadMedida.MILILITRO;
        }else if(ingredienteDTO.getUnidadMedida() == UnidadMedidaDTO.LITROS){
            unidadMediaDominio = UnidadMedida.LITROS;
        }else if(ingredienteDTO.getUnidadMedida()== UnidadMedidaDTO.GRAMO){
            unidadMediaDominio = UnidadMedida.GRAMO;
        }
        
        return new Ingrediente(ingredienteDTO.getNombreIngrediente(), ingredienteDTO.getStockIngrediente(), unidadMediaDominio);     
    }
}
