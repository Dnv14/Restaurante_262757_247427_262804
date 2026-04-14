/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantedominio_262757_247427_262804;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BALAMRUSH
 */
@Entity
@Table(name = "ingredientes")
public class Ingrediente implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente", nullable = false)
    private Long idIngrediente;
    
    @Column(name = "nombre_ingrediente", nullable = false)
    private String nombreIngrediente;
    
    @Column(name = "stock_ingrediente", nullable = false)
    private Double stockIngrediente;
    
    @Column(name = "unidad_medida", nullable = false)
    @Enumerated(EnumType.STRING)
    private UnidadMedida unidadMedida;
    
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    
    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL)
    private List<Receta> receta;

    public Ingrediente() {
    }

    public Ingrediente(Long idIngrediente, String nombreIngrediente, Double stockIngrediente, UnidadMedida unidadMedida) {
        this.idIngrediente = idIngrediente;
        this.nombreIngrediente = nombreIngrediente;
        this.stockIngrediente = stockIngrediente;
        this.unidadMedida = unidadMedida;
    }    
    
    public Ingrediente(String nombreIngrediente, Double stockIngrediente, UnidadMedida unidadMedida) {
        this.nombreIngrediente = nombreIngrediente;
        this.stockIngrediente = stockIngrediente;
        this.unidadMedida = unidadMedida;
    }

    public Ingrediente(String nombreIngrediente, Double stockIngrediente, UnidadMedida unidadMedida, List<Receta> receta) {
        this.nombreIngrediente = nombreIngrediente;
        this.stockIngrediente = stockIngrediente;
        this.unidadMedida = unidadMedida;
        this.receta = receta;
    }

    public Ingrediente(Long idIngrediente, String nombreIngrediente, Double stockIngrediente, UnidadMedida unidadMedida, byte[] imagen, List<Receta> receta) {
        this.idIngrediente = idIngrediente;
        this.nombreIngrediente = nombreIngrediente;
        this.stockIngrediente = stockIngrediente;
        this.unidadMedida = unidadMedida;
        this.imagen = imagen;
        this.receta = receta;
    }   

    public List<Receta> getReceta() {
        return receta;
    }

    public void setReceta(List<Receta> receta) {
        this.receta = receta;
    }
    
    

    public Long getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public Double getStockIngrediente() {
        return stockIngrediente;
    }

    public void setStockIngrediente(Double stockIngrediente) {
        this.stockIngrediente = stockIngrediente;
    }

    public UnidadMedida getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(UnidadMedida unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
    
    

   
}
