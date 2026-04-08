/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoIngredienteDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.UnidadMedidaDTO;
import com.mycompany.restaurantepersistencia.IngredienteDAO;
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
        
    }
}
