/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantedtos_262757_247427_262804;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author BALAMRUSH
 */
public class NuevoClienteFrecuenteDTO extends NuevoClienteDTO{
    
    private Long id;
    private LocalDate fechaRegistro;
    private String datosFacturacion; 
    private List<String> direcciones;
    private Integer conteoVisitas;
    private double puntosAcumulables;
    private double gastoTotal;

    public NuevoClienteFrecuenteDTO(Long id, LocalDate fechaRegistro, String datosFacturacion, List<String> direcciones, Integer conteoVisitas, double puntosAcumulables, double gastoTotal, String nombreCompleto, String telefono, String correoElectronico) {
        super(nombreCompleto, telefono, correoElectronico);
        this.id = id;
        this.fechaRegistro = fechaRegistro;
        this.datosFacturacion = datosFacturacion;
        this.direcciones = direcciones;
        this.conteoVisitas = conteoVisitas;
        this.puntosAcumulables = puntosAcumulables;
        this.gastoTotal = gastoTotal;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public String getDatosFacturacion() {
        return datosFacturacion;
    }

    public List<String> getDirecciones() {
        return direcciones;
    }

    public Integer getConteoVisitas() {
        return conteoVisitas;
    }

    public double getPuntosAcumulables() {
        return puntosAcumulables;
    }

    public double getGastoTotal() {
        return gastoTotal;
    }
      
}
