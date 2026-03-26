/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteFrecuenteDTO;
import com.mycompany.restaurantepersistencia.ClienteFrecuenteDAO;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author MrGam
 */
public class ClientesFrecuentesDAOTEST {

    public ClientesFrecuentesDAOTEST() {
    }

    private ClienteFrecuenteDAO dao;

    @BeforeEach()
    public void init() {
        this.dao = new ClienteFrecuenteDAO();
    }

    @Test
    public void crearClienteFrecuenteSiLoCreaTest() {
        NuevoClienteFrecuenteDTO cliente = new NuevoClienteFrecuenteDTO("diegoNavarro", "6442262864", "diegoPro@gmail.com");

         assertDoesNotThrow(() -> {
            ClienteFrecuente clienteBueno = dao.crearClienteFrecuente(cliente);
            clienteBueno.getId();
        });
        
    }
}
