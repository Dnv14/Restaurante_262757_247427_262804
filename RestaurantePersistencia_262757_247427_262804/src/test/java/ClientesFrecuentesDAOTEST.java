/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteFrecuenteDTO;
import com.mycompany.restaurantepersistencia.ClienteFrecuenteDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
        
        
    }
}
