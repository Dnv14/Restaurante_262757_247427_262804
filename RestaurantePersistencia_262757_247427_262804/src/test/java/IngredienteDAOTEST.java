/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedtos_262757_247427_262804.FiltrosDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoIngredienteDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.UnidadMedidaDTO;
import com.mycompany.restaurantepersistencia.IngredienteDAO;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author BALAMRUSH
 */
public class IngredienteDAOTEST {
    
    private IngredienteDAO dao;
    
    @BeforeEach()
    public void init() {
        this.dao = new IngredienteDAO();
    }
        
    @Test 
    public void ingresarIngredienteFuncionaOKTest(){
        NuevoIngredienteDTO ingredienteDTO = new NuevoIngredienteDTO("Sal", 3.0, UnidadMedidaDTO.KILOGRAMO);
        assertDoesNotThrow(() -> {
            Ingrediente ingrediente = dao.agregarIngrediente(ingredienteDTO);
        });
    }
    
    @Test
    public void consultarIngredientePorNombreFuncionaOK(){
        assertDoesNotThrow(() -> {
            FiltrosDTO filtroIngrediente = new FiltrosDTO("Sal", null, null, null);
            List<Ingrediente> resultadoEsperado = dao.consultarIngredientesFiltro(filtroIngrediente);
            assertEquals("Sal", resultadoEsperado.get(0).getNombreIngrediente());
        });   
    }
    
    @Test
    public void consultarIngredientePorUnidadMedida(){
        assertDoesNotThrow(() -> {
            FiltrosDTO filtroIngrediente = new FiltrosDTO(null, null, null, "KILOGRAMO");
            List<Ingrediente> resultadoEsperado = dao.consultarIngredientesFiltro(filtroIngrediente);
            assertFalse(resultadoEsperado.isEmpty());
            assertEquals("KILOGRAMO", resultadoEsperado.get(0).getUnidadMedida());
        });   
    }
    
    @Test
    public void actualizarStockIngredienteSumaFuncionaOK(){
        assertDoesNotThrow(() -> {
            FiltrosDTO filtro = new FiltrosDTO("Sal", null, null, null);
            List<Ingrediente> ingredientes = dao.consultarIngredientesFiltro(filtro);
            Double stockAntes = ingredientes.get(0).getStockIngrediente();
            
            dao.acualizarIngrediente(ingredientes.get(0).getIdIngrediente(), 5.0);
            FiltrosDTO filtroActu = new FiltrosDTO("Sal", null, null, null);
            List<Ingrediente> ingredientesActu = dao.consultarIngredientesFiltro(filtroActu);
            assertEquals(stockAntes + 5.0, ingredientesActu.get(0).getStockIngrediente());
        });
    }
    
    @Test
    public void actualizarStockIngredienteRestaFuncionaOK(){
        assertDoesNotThrow(() -> {
            FiltrosDTO filtro = new FiltrosDTO("Sal", null, null, null);
            List<Ingrediente> ingredientes = dao.consultarIngredientesFiltro(filtro);
            Double stockAntes = ingredientes.get(0).getStockIngrediente();
            
            dao.acualizarIngrediente(ingredientes.get(0).getIdIngrediente(), -1.0);
            FiltrosDTO filtroActu = new FiltrosDTO("Sal", null, null, null);
            List<Ingrediente> ingredientesActu = dao.consultarIngredientesFiltro(filtroActu);
            assertEquals(stockAntes - 1.0, ingredientesActu.get(0).getStockIngrediente());
        });
    }
    
    @Test
    public void consultarIngredientePorIDFuncionaOK(){
         assertDoesNotThrow(() -> {
            FiltrosDTO filtro = new FiltrosDTO("Sal", null, null, null);
            List<Ingrediente> ingredientes = dao.consultarIngredientesFiltro(filtro);
            Long idIngrediente = ingredientes.get(0).getIdIngrediente();
            Ingrediente resultado = dao.consultarPorId(idIngrediente);
            assertNotNull(resultado);
            assertEquals("Sal", resultado.getNombreIngrediente());          
         });
    }
    
    @Test
    public void eliminarIngredienteFuncionaOK() {
        assertDoesNotThrow(() -> {
            NuevoIngredienteDTO nuevoIngredientePrueba = new NuevoIngredienteDTO("Ingrediente Prueba", 1.0, UnidadMedidaDTO.GRAMO);
            Ingrediente ingrediente = dao.agregarIngrediente(nuevoIngredientePrueba);
            Long idEliminar = ingrediente.getIdIngrediente();
            dao.eliminarIngrediente(idEliminar);
            FiltrosDTO filtroNombre = new FiltrosDTO("Ingrediente Prueba", null, null, null);
            List<Ingrediente> ingredientes = dao.consultarIngredientesFiltro(filtroNombre);
            assertTrue(ingredientes.isEmpty());
        });
    }
}
