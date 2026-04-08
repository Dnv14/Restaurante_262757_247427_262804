/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantenegocio_262757_247427_262804;

import com.mycompany.restaurantepersistencia.ClienteFrecuenteDAO;
import com.mycompany.restaurantepersistencia.ProductosDAO;

/**
 *
 * @author MrGam
 */
public class ObjetosBO {

    private IClientesFrecuentesBO clientesFrecuentesBO;
    private IProductosBO productosBO;

    public ObjetosBO() {
        this.clientesFrecuentesBO = new ClientesFrecuentesBO(new ClienteFrecuenteDAO());
        this.productosBO = new ProductosBO(new ProductosDAO());
    }

    public IClientesFrecuentesBO getClientesFrecuentesBO() {
        return clientesFrecuentesBO;
    }

    public IProductosBO getProductosBO() {
        return productosBO;
    }

}
