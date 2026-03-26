/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantedtos_262757_247427_262804;

import java.time.LocalDate;

/**
 *
 * @author BALAMRUSH
 */
public class NuevoClienteDTO {
    private String nombreCompleto;
    private String telefono;
    private String correoElectronico;

    public NuevoClienteDTO(String nombreCompleto, String telefono, String correoElectronico) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    
}
