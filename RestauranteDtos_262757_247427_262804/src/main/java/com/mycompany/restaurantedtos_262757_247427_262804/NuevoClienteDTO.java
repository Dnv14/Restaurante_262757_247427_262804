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
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correoElectronico;

    public NuevoClienteDTO(String nombres, String apellidos ,String telefono, String correoElectronico) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }
    
    
}
