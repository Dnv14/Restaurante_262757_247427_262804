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
    private UnidadMedidaDTO unidadMedida;
    private byte[] imagen;

    public NuevoIngredienteDTO(String nombreIngrediente, Double stockIngrediente, UnidadMedidaDTO unidadMedida, byte[] imagen) {
        this.nombreIngrediente = nombreIngrediente;
        this.stockIngrediente = stockIngrediente;
        this.unidadMedida = unidadMedida;
        this.imagen = imagen;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public Double getStockIngrediente() {
        return stockIngrediente;
    }

    public UnidadMedidaDTO getUnidadMedida() {
        return unidadMedida;
    }
    
    public byte[] getImagen(){
        return imagen;
    }
    
    public void setImagen(byte[] imagen){
        this.imagen = imagen;
    }
    
    
}
