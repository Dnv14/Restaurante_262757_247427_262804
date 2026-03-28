/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteFrecuenteDTO;
import com.mycompany.restaurantepersistencia.ClienteFrecuenteDAO;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

//    @Test
//    public void crearClienteFrecuenteSiLoCreaTest() {
//        NuevoClienteFrecuenteDTO cliente = new NuevoClienteFrecuenteDTO("enrique", "Madrid" ,"6442262865", "enriquePro@gmail.com");
//
//        assertDoesNotThrow(() -> {
//            ClienteFrecuente clienteBueno = dao.crearClienteFrecuente(cliente);
//            clienteBueno.getId();
//        });
//
//    }
//
//    @Test
//    public void consultarClienteFrecuentePorNombreFuncionaOKTest() {
//        assertDoesNotThrow(() -> {
//            String nombre = "enrique";           
//            ClienteFrecuente cliente1 = dao.consultarClienteFrecuentePorNombre(nombre);
//            assertEquals(cliente1.getId(), 2);
//            assertEquals(nombre, cliente1.getNombreCompleto());
//            System.out.println(cliente1);
//        });
//    }
//    
//    @Test
//    public void consultarClienteFrecuentePorTelefonoFuncionaOKTest() {
//        assertDoesNotThrow(() -> {
//            String telefono = "6442262865";           
//            ClienteFrecuente cliente1 = dao.consultarClienteFrecuentePorTelefono(telefono);
//            assertEquals(cliente1.getId(), 2);
//            assertEquals(telefono, cliente1.getTelefono());
//            System.out.println(cliente1);
//        });
//    }
//    
//    @Test
//    public void consultarClienteFrecuentePorCorreoFuncionaOKTest() {
//        assertDoesNotThrow(() -> {
//            String correo = "enriquePro@gmail.com";           
//            ClienteFrecuente cliente1 = dao.consultarClienteFrecuentePorCorreo(correo);
//            assertEquals(cliente1.getId(), 2);
//            assertEquals(correo, cliente1.getCorreoElectronico());
//            System.out.println(cliente1);
//        });
//    }
//    
//    @Test
//    public void consultarTodosClienteFrecuenteFuncionaOKTest() {
//        assertDoesNotThrow(() -> {
//           List<ClienteFrecuente> listaClientes = dao.consultarTodosClientesFrecuentes();
//           assertEquals(listaClientes.size(), 2);
//        });       
//    }
    

}
