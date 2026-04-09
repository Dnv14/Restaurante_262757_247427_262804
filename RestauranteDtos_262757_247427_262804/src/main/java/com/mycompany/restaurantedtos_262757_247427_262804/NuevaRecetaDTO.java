/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantedtos_262757_247427_262804;

/**
 *
 * @author Diego
 */

public class NuevaRecetaDTO {
    private Long idIngrediente;
    private String nombre;
    private Double cantidad;

    public NuevaRecetaDTO() {
    }

    public NuevaRecetaDTO(Long idIngrediente, String nombre, Double cantidad) {
        this.idIngrediente = idIngrediente;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public Long getId() {
        return idIngrediente;
    }

    public void setId(Long id) {
        this.idIngrediente = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    
    
}

