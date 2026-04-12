/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantenegocio_262757_247427_262804;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.FiltrosDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteFrecuenteDTO;
import com.mycompany.restaurantepersistencia.IClienteFrecuenteDAO;
import com.mycompany.restaurantepersistencia.PersistenciaException;
import java.util.List;

/**
 *
 * @author MrGam
 */
public class ClientesFrecuentesBO implements IClientesFrecuentesBO {

    private final IClienteFrecuenteDAO clientesFrecuentesDAO;

    public ClientesFrecuentesBO(IClienteFrecuenteDAO clientesFrecuentesDAO) {
        this.clientesFrecuentesDAO = clientesFrecuentesDAO;
    }

    @Override
    public ClienteFrecuente validarRegistroCliente(NuevoClienteFrecuenteDTO clienteFrecuente) throws NegocioException {
        if (clienteFrecuente.getNombres() == null || clienteFrecuente.getNombres().isEmpty()) {
            throw new NegocioException("El nombre completo es obligatorio");
        }

        if (clienteFrecuente.getApellidos() == null || clienteFrecuente.getNombres().isEmpty()) {
            throw new NegocioException("El apellido es obligatorio");
        }

        String correo = clienteFrecuente.getCorreoElectronico();
        if (correo != null && !correo.isEmpty()) {
            if (!correo.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                throw new NegocioException("Correo no válido, use este formato: {diegoPro@gmail.com}.");
            }
        }
        
        if (!clienteFrecuente.getTelefono().matches("[0-9]+")){
            throw new NegocioException("El teléfono solamente debe contener números");
        }
        
        if (clienteFrecuente.getTelefono() == null || !clienteFrecuente.getTelefono().matches("\\d{10}")) {
            throw new NegocioException("El teléfono debe tener 10 dígitos.");
        }
        
        
        try {
            ClienteFrecuente cliente = clientesFrecuentesDAO.crearClienteFrecuente(clienteFrecuente);
            if (cliente == null) {
                throw new NegocioException("Cliente no encontrado.", null);
            }
            return cliente;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al intentar validar el usuario.", ex);
        } catch (Exception ex){
            throw new NegocioException("Error al querer encriptar el teléfono.", ex);
        }
    }

    @Override
    public List<ClienteFrecuente> validarBarraBusqueda(String texto, String tipoFiltro) throws NegocioException {
        try {
            if (texto == null || texto.isEmpty()) {
                return clientesFrecuentesDAO.consultarTodosClientesFrecuentes();
            }
            
            FiltrosDTO filtros = new FiltrosDTO(null, null, null,null);
            switch (tipoFiltro) {
                case "Nombre":
                    filtros.setNombre(texto);
                    break;

                case "Teléfono":
                    filtros.setTelefono(texto);
                    break;

                case "Correo Electrónico":
                    filtros.setCorreo(texto);
                    break;
            }

            return clientesFrecuentesDAO.consultarClientesFiltros(filtros);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar: " + ex.getMessage());
        }
    }
}
