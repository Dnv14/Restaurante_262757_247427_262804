/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepresentacion_262757_262804_247427;

import com.mycompany.restaurantenegocio_262757_247427_262804.ObjetosBO;
import javax.swing.JFrame;

/**
 *
 * @author MrGam
 */
public class ControlForms {

    private ObjetosBO objetosBO;
    private JFrame frameActual;
    private MenuReportes menuReportes;
    private FiltroReportesClientes filtroReportesClientes;
    private FiltroReportesComandas filtroReporteComandas;
    

    public ControlForms() {
        this.objetosBO = new ObjetosBO();
    }

    //cambiar de pantallas 
    public void navegarMenuPrincipal() {
        if (this.frameActual != null) {
            this.frameActual.dispose();
        }
        frameActual = new MenuPrincipalFORM(this);
        frameActual.setVisible(true);
        frameActual.setLocationRelativeTo(null);
    }

    public void navegarAgregarCliente() {
        if (this.frameActual != null) {
            this.frameActual.dispose();
        }
        frameActual = new AgregarClienteFrecuenteFORM(this);
        frameActual.setVisible(true);
        frameActual.setLocationRelativeTo(null);
    }

    public void navegarMenuClientesFrecuentes() {
        if (this.frameActual != null) {
            this.frameActual.dispose();
        }
        frameActual = new MenuClientesFrecuentesFORM(this);
        frameActual.setVisible(true);
        frameActual.setLocationRelativeTo(null);
    }
    
    public void MenuReportes(){
    menuReportes.setVisible(true);
    }
    
    public void friltroComandas(){
    filtroReporteComandas.setVisible(true);
    }
    
    public void filtroClientes(){
    filtroReportesClientes.setVisible(true);
    }
}
