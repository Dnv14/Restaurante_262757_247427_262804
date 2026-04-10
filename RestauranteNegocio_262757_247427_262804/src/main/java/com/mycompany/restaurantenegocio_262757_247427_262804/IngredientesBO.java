/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantenegocio_262757_247427_262804;

import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedtos_262757_247427_262804.FiltrosDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoIngredienteDTO;
import com.mycompany.restaurantepersistencia.IIngredienteDAO;
import com.mycompany.restaurantepersistencia.PersistenciaException;
import java.util.List;


/**
 *
 * @author BALAMRUSH
 */
public class IngredientesBO implements IIngredientesBO{
    
    private final IIngredienteDAO ingredientesDAO;
    
    public IngredientesBO(IIngredienteDAO ingredientesDAO){
        this.ingredientesDAO = ingredientesDAO;
    }

    /**
     * 
     * @param nuevoIngrediente
     * @return
     * @throws NegocioException 
     */
    @Override
    public Ingrediente validarRegistroIngrediente(NuevoIngredienteDTO nuevoIngrediente) throws NegocioException {
        if(nuevoIngrediente.getNombreIngrediente() == null || nuevoIngrediente.getNombreIngrediente().isEmpty()){
            throw new NegocioException("El ingrediente debe de tener un nombre.");
        }
        
        if(nuevoIngrediente.getNombreIngrediente().length() > 100){
            throw new NegocioException("El ingrediente no puede tener más de 100 letras.");
        }
        
        if(!nuevoIngrediente.getNombreIngrediente().matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ ]+")){
            throw new NegocioException("El ingrediente solamente puede tener letras.");
        }
        
        if(nuevoIngrediente.getStockIngrediente()< 0){
            throw new NegocioException("El stock del ingrediente no puede ser menor a 0.");
        }       
        
              
        if(nuevoIngrediente.getUnidadMedida() == null){
            throw new NegocioException("La unidad de medida no puede ser nula ");
        }
        
        try{
            Ingrediente ingredienteExistente = ingredientesDAO.consultarPorNombreyUnidad(nuevoIngrediente.getNombreIngrediente(), nuevoIngrediente.getUnidadMedida());
            if(ingredienteExistente != null){
                throw new NegocioException("Un ingrediente ya se encuentra registrado con ese nombre y unidad");
            }
            
            return ingredientesDAO.agregarIngrediente(nuevoIngrediente);
        }catch(PersistenciaException ex){
            throw new NegocioException(ex.getMessage());
        }
    }

    /**
     * 
     * @param texto
     * @param tipoFiltro
     * @return
     * @throws NegocioException 
     */
    @Override
    public List<Ingrediente> validarBarraBusqueda(String texto, String tipoFiltro) throws NegocioException {
        try {
            if (texto == null || texto.isEmpty()) {
                return ingredientesDAO.consultarTodosIngredientes();
            }
            
            FiltrosDTO filtros = new FiltrosDTO(null, null, null,null);
            switch (tipoFiltro) {
                case "Nombre":
                    filtros.setNombre(texto);
                    break;

                case "Unidad de Medida":
                    filtros.setUnidadMedida(texto);
                    break;
            }

            return ingredientesDAO.consultarIngredientesFiltro(filtros);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar: " + ex.getMessage());
        }
    }

    /**
     * 
     * @param idIngrediente
     * @param cantidadTexto
     * @throws NegocioException 
     */
    @Override
    public void actualizarStockIngrediente(Long idIngrediente, String cantidadTexto) throws NegocioException {
       double cantidadStock;
       try{
           cantidadStock = Double.parseDouble(cantidadTexto);
       }catch(NumberFormatException ex){
           throw new NegocioException("La ccantidad que se ha ingresado no es válida");
       }
       if(cantidadStock == 0){
           throw new NegocioException("La cantidad ingresada no puede ser igual a 0");
       }
       try{
           Ingrediente ingrediente = ingredientesDAO.consultarPorId(idIngrediente);
           if(ingrediente.getStockIngrediente() + cantidadStock < 0){
               throw new NegocioException("El stock no puede ser negativo.");        
           }
           ingredientesDAO.acualizarIngrediente(idIngrediente, cantidadStock);
       }catch(PersistenciaException ex){
           throw new NegocioException(ex.getMessage());
       }
        
        
    }
    
    
    
}
