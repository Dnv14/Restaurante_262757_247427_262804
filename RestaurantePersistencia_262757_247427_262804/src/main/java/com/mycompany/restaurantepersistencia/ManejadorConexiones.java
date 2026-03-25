/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepersistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego
 */
public class ManejadorConexiones {

    public static EntityManager crearEntityManager() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.mycompany_RestauranteDominio_262757_247427_262804_jar_1.0-SNAPSHOTPU");
        EntityManager em = emFactory.createEntityManager();
        
        return em;
    }

}
