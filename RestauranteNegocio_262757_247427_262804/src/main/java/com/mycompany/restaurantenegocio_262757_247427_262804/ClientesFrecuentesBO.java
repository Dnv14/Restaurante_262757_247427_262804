/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantenegocio_262757_247427_262804;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteFrecuenteDTO;
import com.mycompany.restaurantepersistencia.IClienteFrecuenteDAO;
import com.mycompany.restaurantepersistencia.PersistenciaException;
import java.util.ArrayList;
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
        if (clienteFrecuente.getNombreCompleto() == null || clienteFrecuente.getNombreCompleto().isEmpty()) {
            throw new NegocioException("El nombre completo es obligatorio");
        }

        if (!clienteFrecuente.getCorreoElectronico().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new NegocioException("Correo no válido, use este formato: {diegoPro@gmail.com}.");
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
        }
    }

    @Override
    public List<ClienteFrecuente> validarBarraBusqueda(String textoBusqueda, String tipoFiltro) throws NegocioException {
        try {

            if (textoBusqueda == null) {
                return clientesFrecuentesDAO.consultarTodosClientesFrecuentes();
            }
            List<ClienteFrecuente> listaResultado = new ArrayList<>();

            switch (tipoFiltro) {
                case "Nombre":

                    if (textoBusqueda == null || textoBusqueda.trim().isEmpty()) {
                        return clientesFrecuentesDAO.consultarTodosClientesFrecuentes();
                    }
                    if (textoBusqueda.equals("")) {
                        throw new NegocioException("Campo de busqueda vacío");
                    }
                    ClienteFrecuente clienteNombre = clientesFrecuentesDAO.consultarClienteFrecuentePorNombre(textoBusqueda);
                    listaResultado.add(clienteNombre);
                    break;

                case "Teléfono":
                    if (textoBusqueda.equals("")) {
                        throw new NegocioException("Campo de busqueda vacío");
                    }
                    if (!textoBusqueda.matches("\\d{10}")) {
                        throw new NegocioException("El teléfono debe ser contener 10 dígitos");
                    }
                    ClienteFrecuente clienteTelefono = clientesFrecuentesDAO.consultarClienteFrecuentePorTelefono(textoBusqueda);
                    listaResultado.add(clienteTelefono);
                    break;

                case "Correo Electrónico":
                    if (textoBusqueda.equals("")) {
                        throw new NegocioException("Campo de busqueda vacío");
                    }

                    if (!textoBusqueda.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                        throw new NegocioException("El formato del correo ingresado no es válido.");
                    }
                    ClienteFrecuente clienteCorreo = clientesFrecuentesDAO.consultarClienteFrecuentePorCorreo(textoBusqueda);
                    listaResultado.add(clienteCorreo);
                    break;
            }
            return listaResultado;

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al buscar: " + ex.getMessage());
        }
    }
}
