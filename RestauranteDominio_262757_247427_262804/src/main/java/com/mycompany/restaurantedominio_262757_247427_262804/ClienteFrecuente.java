/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantedominio_262757_247427_262804;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Diego
 */
@Entity
@Table(name = "clientes_frecuentes")
@PrimaryKeyJoinColumn(name = "id_cliente")
public class ClienteFrecuente extends Cliente {

    @Column(name = "conteo_visitas", nullable = false)
    private Integer conteoVisitas = 0;

    @Column(name = "puntos_acumulables", nullable = false)
    private double puntosAcumulables = 0.0;

    @Column(name = "gasto_total", nullable = false)
    private double gastoTotal = 0.0;

    public ClienteFrecuente() {
    }

    public ClienteFrecuente(String nombre, String telefono, String correo) {
        super(nombre, telefono, LocalDate.now(), correo);
        this.conteoVisitas = 0;
        this.puntosAcumulables = 0.0;
        this.gastoTotal = 0.0; 
    }

    @Override
    public void registrarPuntos(double monto) {
        this.gastoTotal += monto;
        this.conteoVisitas++;
        this.puntosAcumulables += (monto / 20);
        
    }
    
    
    public Integer getConteoVisitas() {
        return conteoVisitas;
    }

    public void setConteoVisitas(Integer conteoVisitas) {
        this.conteoVisitas = conteoVisitas;
    }

    public double getPuntosAcumulables() {
        return puntosAcumulables;
    }

    public void setPuntosAcumulables(double puntosAcumulables) {
        this.puntosAcumulables = puntosAcumulables;
    }

    public double getGastoTotal() {
        return gastoTotal;
    }

    public void setGastoTotal(double gastoTotal) {
        this.gastoTotal = gastoTotal;
    }

}
