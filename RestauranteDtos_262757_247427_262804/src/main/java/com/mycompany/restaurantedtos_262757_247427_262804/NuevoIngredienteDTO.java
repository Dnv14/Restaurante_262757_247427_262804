/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantedtos_262757_247427_262804;

/**
 *
 * @author BALAMRUSH
 */
public class NuevoIngredienteDTO {
    private String nombreIngrediente;
    private Double stockIngrediente;
    private String unidadMedida;

    public NuevoIngredienteDTO(String nombreIngrediente, Double stockIngrediente, String unidadMedida) {
        this.nombreIngrediente = nombreIngrediente;
        this.stockIngrediente = stockIngrediente;
        this.unidadMedida = unidadMedida;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public Double getStockIngrediente() {
        return stockIngrediente;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }
    
    
}
