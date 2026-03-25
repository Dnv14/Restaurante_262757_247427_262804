/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantedominio_262757_247427_262804;

import java.time.LocalDate;
import java.util.List;
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

    @Column(name = "datos_facturacion", length = 100)
    private String datosFacturacion;

    @Column(name = "direcciones", length = 100, nullable = true)
    private List<String> direcciones;

    @Column(name = "conteo_visitas", nullable = false)
    private Integer conteoVisitas;

    @Column(name = "puntos_acumulables", nullable = false)
    private double puntosAcumulables;

    @Column(name = "gasto_total", nullable = false)
    private double gastoTotal;

    public ClienteFrecuente() {
    }
    
    public ClienteFrecuente(String datosFacturacion, List<String> direcciones, Integer conteoVisitas, double puntosAcumulables, double gastoTotal, String nombreCompleto, String telefono, LocalDate fechaRegistro, String correoElectronico) {
        super(nombreCompleto, telefono, fechaRegistro, correoElectronico);
        this.datosFacturacion = datosFacturacion;
        this.direcciones = direcciones;
        this.conteoVisitas = conteoVisitas;
        this.puntosAcumulables = puntosAcumulables;
        this.gastoTotal = gastoTotal;
    }

    public String getDatosFacturacion() {
        return datosFacturacion;
    }

    public void setDatosFacturacion(String datosFacturacion) {
        this.datosFacturacion = datosFacturacion;
    }

    public List<String> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<String> direcciones) {
        this.direcciones = direcciones;
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
