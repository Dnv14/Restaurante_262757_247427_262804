/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.FiltrosDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteFrecuenteDTO;
import com.mycompany.restaurantepersistencia.ClienteFrecuenteDAO;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void crearClienteFrecuenteFuncionaOKTest() {
        assertDoesNotThrow(() -> {
            NuevoClienteDTO nuevoCliente = new NuevoClienteDTO("Harry", "Styles", "6442567826", "harry@gmail.com");
            ClienteFrecuente clienteFrecuente = dao.crearClienteFrecuente(nuevoCliente);
            assertNotNull(clienteFrecuente);
            assertEquals("Harry", clienteFrecuente.getNombres());
            assertEquals("Styles", clienteFrecuente.getApellidos());
            assertEquals("6442567876", clienteFrecuente.getTelefono());
            assertEquals("harry@gmail.com", clienteFrecuente.getCorreoElectronico());
            assertNotNull(clienteFrecuente.getFechaRegistro());
        });
    }
    
    @Test
    public void consultarClientePorNombreFuncionaOKTest() {
        assertDoesNotThrow(() -> {
            FiltrosDTO filtros = new FiltrosDTO("Harry", null, null, null);
            List<ClienteFrecuente> resultado = dao.consultarClientesFiltros(filtros);
            assertFalse(resultado.isEmpty());
            assertTrue(resultado.get(0).getNombres().contains("Harry"));
        });
    }
    
    @Test
    public void consultarClientePorApellidoFuncionaOKTest() {
        assertDoesNotThrow(() -> {
            FiltrosDTO filtros = new FiltrosDTO("Styles", null , null, null);
            List<ClienteFrecuente> resultado = dao.consultarClientesFiltros(filtros);
            assertFalse(resultado.isEmpty());
            assertTrue(resultado.get(0).getApellidos().contains("Styles"));
        });
    }
    
    @Test
    public void consultarTodosClientesFrecuentesFuncionaOKTest() {
        assertDoesNotThrow(() -> {
            List<ClienteFrecuente> resultado = dao.consultarTodosClientesFrecuentes();
            assertNotNull(resultado);
            assertFalse(resultado.isEmpty());
        });
    }
    
     @Test
    public void consultarClientePorCorreoFuncionaOKTest() {
        assertDoesNotThrow(() -> {
            FiltrosDTO filtros = new FiltrosDTO(null, null, "harry@gmail.com", null);
            List<ClienteFrecuente> resultado = dao.consultarClientesFiltros(filtros);
            assertFalse(resultado.isEmpty());
            assertEquals("harry@gmail.com", resultado.get(0).getCorreoElectronico());
        });
    }
    
    



}
