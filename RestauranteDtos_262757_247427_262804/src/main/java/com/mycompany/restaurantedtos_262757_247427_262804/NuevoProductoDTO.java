/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantedtos_262757_247427_262804;

/**
 *
 * @author Diego
 */
public class NuevoProductoDTO {

    private String nombre;
    private String descripcion;
    private Double precio;
    private TipoProductoDTO tipoProducto;
    private EstadoDTO estado;

    public NuevoProductoDTO(String nombre, String descripcion, Double precio, TipoProductoDTO tipoProducto, EstadoDTO estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public TipoProductoDTO getTipoProducto() {
        return tipoProducto;
    }

    public EstadoDTO getEstado() {
        return estado;
    }
}
