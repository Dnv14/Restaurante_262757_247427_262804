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
public class NuevoClienteFrecuenteDTO extends NuevoClienteDTO {

    private Long id;
    private LocalDate fechaRegistro;
    private Integer conteoVisitas;
    private double puntosAcumulables;
    private double gastoTotal;

    public NuevoClienteFrecuenteDTO(String nombre, String telefono, String correo) {
        super(nombre, telefono, correo);
        this.fechaRegistro = LocalDate.now();
        this.conteoVisitas = 0;
        this.puntosAcumulables = 0.0;
        this.gastoTotal = 0.0;
    }

    public NuevoClienteFrecuenteDTO(Long id, String nombre, String telefono, String correo) {
        super(nombre, telefono, correo);
        this.id = id;
        this.fechaRegistro = LocalDate.now();
        this.conteoVisitas = 0;
        this.puntosAcumulables = 0.0;
        this.gastoTotal = 0.0;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
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
