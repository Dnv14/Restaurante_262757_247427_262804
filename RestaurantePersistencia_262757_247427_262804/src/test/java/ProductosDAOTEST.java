/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedtos_262757_247427_262804.EstadoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.TipoProductoDTO;
import com.mycompany.restaurantepersistencia.ProductosDAO;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Diego
 */
public class ProductosDAOTEST {

    private ProductosDAO dao;

    @BeforeEach()
    public void init() {
        this.dao = new ProductosDAO();
    }

//    @Test
//    public void crearProductoSiLoCrea() {
//        NuevoProductoDTO productoDTO = new NuevoProductoDTO("Papas fritas ", "Papas freidas", 150.00, TipoProductoDTO.PLATILLO, EstadoDTO.ACTIVO);
//        
//        assertDoesNotThrow(() -> {
//            Producto producto = dao.agregarProducto(productoDTO);
//            producto.getId();
//        });
//    }
//    
//    @Test
//    public void conmsultarProductosNombreFunciona() {
//        assertDoesNotThrow(() -> {
//            List<Producto> productos = dao.consultarProductosNombre("papas");
//            
//            for(Producto productosNombre : productos){
//                System.out.println(productosNombre.getNombre());
//            }
//            System.out.println(productos.size());
//        });
//    }
}
