/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantedominio_262757_247427_262804;

import java.time.LocalDate;

/**
 *
 * @author MrGam
 */
public class ClienteGeneral extends Cliente {

    private static ClienteGeneral instance;

    private ClienteGeneral() {
        super("Cliente General", "0000000000", LocalDate.now(), "clienteGeneral@gmail.com");
        this.setId(1L);
    }

    public static ClienteGeneral getInstancia() {
        if (instance == null) {
            instance = new ClienteGeneral();
        }
        return instance;
    }
}
