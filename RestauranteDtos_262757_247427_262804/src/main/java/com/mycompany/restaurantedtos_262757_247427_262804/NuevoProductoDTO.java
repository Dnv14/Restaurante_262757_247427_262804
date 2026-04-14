/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantedtos_262757_247427_262804;

import java.util.List;

/**
 *
 * @author Diego
 */
public class NuevoProductoDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private TipoProductoDTO tipoProducto;
    private EstadoDTO estado;
    private List<NuevaRecetaDTO> recetas;
    private String rutaImagen;

    public NuevoProductoDTO() {
    }

    public NuevoProductoDTO(String nombre, String descripcion, Double precio, TipoProductoDTO tipoProducto, EstadoDTO estado, List<NuevaRecetaDTO> recetas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.estado = estado;
        this.recetas = recetas;
    }

    public NuevoProductoDTO(String nombre, String descripcion, Double precio, TipoProductoDTO tipoProducto, EstadoDTO estado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.estado = estado;
    }

    public NuevoProductoDTO(Long id, String nombre, String descripcion, Double precio, TipoProductoDTO tipoProducto, EstadoDTO estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.estado = estado;
    }

    public NuevoProductoDTO(String nombre, String descripcion, Double precio, TipoProductoDTO tipoProducto, EstadoDTO estado, List<NuevaRecetaDTO> recetas, String rutaImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tipoProducto = tipoProducto;
        this.estado = estado;
        this.recetas = recetas;
        this.rutaImagen = rutaImagen;
    }
    
    

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setTipoProducto(TipoProductoDTO tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setEstado(EstadoDTO estado) {
        this.estado = estado;
    }

    public List<NuevaRecetaDTO> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<NuevaRecetaDTO> recetas) {
        this.recetas = recetas;
    }
    
    
}
