/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.restaurantedominio_262757_247427_262804;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Diego
 */
public class pruebitarapida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_RestauranteDominio_262757_247427_262804_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        
       
        
        String datosFacturacion = "NAVD990101H87";
        List<String> direcciones = new ArrayList<>();
        direcciones.add("valle del rey");

        ClienteFrecuente cliente1 = new ClienteFrecuente(
                datosFacturacion,
                direcciones,
                "Diego Navarro",
                "6642262864",
                LocalDate.now(),
                "navarro@itson.edu.mx"
        );
        
        em.persist(cliente1);

        em.getTransaction().commit();
        System.out.println(" Cliente Frecuente y General creados");

    }

}
