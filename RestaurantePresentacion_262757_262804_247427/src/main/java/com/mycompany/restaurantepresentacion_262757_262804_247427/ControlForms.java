/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepresentacion_262757_262804_247427;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.FiltrosDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteFrecuenteDTO;
import com.mycompany.restaurantenegocio_262757_247427_262804.NegocioException;
import com.mycompany.restaurantenegocio_262757_247427_262804.ObjetosBO;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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

    //metodo q ahorra codigo
    private void mostrarPantalla(JFrame nuevoFrame) {
        if (this.frameActual != null) {
            this.frameActual.dispose();
        }

        this.frameActual = nuevoFrame;
        this.frameActual.setResizable(false);
        this.frameActual.setLocationRelativeTo(null);
        this.frameActual.setVisible(true);

    }

    //cambiar de pantallas
    public void navegarMenuPrincipal() {
        mostrarPantalla(new MenuPrincipalFORM(this));
    }

    public void navegarAgregarCliente() {
        mostrarPantalla(new AgregarClienteFrecuenteFORM(this));
    }

    public void navegarMenuClientesFrecuentes() {
        mostrarPantalla(new MenuClientesFrecuentesFORM(this));
    }

    public void navegarConsultaClientes() {
        mostrarPantalla(new BusquedaClienteFrecuenteFORM(this));
    }
    
    public void navegarMenuProductos(){
        mostrarPantalla(new MenuProductosFORM(this));
    }
    
    public void navegarAdministrarProductos(){
        mostrarPantalla(new AdministrarProductosFORM(this));
    }

    //logica de botones 
    public void registrarCliente(String nombre, String apellidos, String telefono, String correo) {
        NuevoClienteFrecuenteDTO cliente = new NuevoClienteFrecuenteDTO(nombre, apellidos, telefono, correo);
        try {
            objetosBO.getClientesFrecuentesBO().validarRegistroCliente(cliente);
            JOptionPane.showMessageDialog(frameActual, "Cliente registrado con éxito");
            navegarMenuClientesFrecuentes();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void BuscarClientesFrecuentes(String texto, String tipoFiltro) {
        try {
            List<ClienteFrecuente> lista = objetosBO.getClientesFrecuentesBO().validarBarraBusqueda(texto, tipoFiltro);
            ((BusquedaClienteFrecuenteFORM) frameActual).mostrarResultados(lista);

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void MenuReportes() {
        menuReportes.setVisible(true);
    }

    public void friltroComandas() {
        filtroReporteComandas.setVisible(true);
    }

    public void filtroClientes() {
        filtroReportesClientes.setVisible(true);
    }
}
