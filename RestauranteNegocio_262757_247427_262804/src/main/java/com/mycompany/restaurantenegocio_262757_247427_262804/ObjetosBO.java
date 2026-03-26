/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantenegocio_262757_247427_262804;

import com.mycompany.restaurantepersistencia.ClienteFrecuenteDAO;

/**
 *
 * @author MrGam
 */
public class ObjetosBO {

    private IClientesFrecuentesBO clientesFrecuentesBO;
    
    public ObjetosBO() {
        
        this.clientesFrecuentesBO = new ClientesFrecuentesBO(new ClienteFrecuenteDAO());
    }

    public IClientesFrecuentesBO getClientesFrecuentesBO() {
        return clientesFrecuentesBO;
    }

}
