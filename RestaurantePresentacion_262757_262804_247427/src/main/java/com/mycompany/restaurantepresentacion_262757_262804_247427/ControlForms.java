/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.restaurantepresentacion_262757_262804_247427;

import com.mycompany.restaurantedominio_262757_247427_262804.ClienteFrecuente;
import com.mycompany.restaurantedominio_262757_247427_262804.Ingrediente;
import com.mycompany.restaurantedominio_262757_247427_262804.Producto;
import com.mycompany.restaurantedominio_262757_247427_262804.Receta;
import com.mycompany.restaurantedtos_262757_247427_262804.EstadoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevaRecetaDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoClienteFrecuenteDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoIngredienteDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.NuevoProductoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.TipoProductoDTO;
import com.mycompany.restaurantedtos_262757_247427_262804.UnidadMedidaDTO;
import com.mycompany.restaurantenegocio_262757_247427_262804.NegocioException;
import com.mycompany.restaurantenegocio_262757_247427_262804.ObjetosBO;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author MrGam
 */
public class ControlForms {

    private ObjetosBO objetosBO;
    private JFrame frameActual;

    /**
     * Constructor para crear el control el cual genera las bos con objetos bo
     */
    public ControlForms() {
        this.objetosBO = new ObjetosBO();
    }

    /**
     * Se hace este metodo para no repetir codigo haciendo que el frame se ponga
     * en el centro no se pueda editar y que sea visible, haciendo tambien que
     * si tenia un frame anterior lo cierre
     *
     * @param nuevoFrame
     */
    private void mostrarPantalla(JFrame nuevoFrame) {
        if (this.frameActual != null) {
            this.frameActual.dispose();
        }

        this.frameActual = nuevoFrame;
        this.frameActual.setResizable(false);
        this.frameActual.setLocationRelativeTo(null);
        this.frameActual.setVisible(true);

    }

    /**
     * Metodo el cual muestra la pantalla principal
     */
    public void navegarMenuPrincipal() {
        mostrarPantalla(new MenuPrincipalFORM(this));
    }

    /**
     * Metodo el cual muestra la pantalla para agregar un nuevo cliente
     */
    public void navegarAgregarCliente() {
        mostrarPantalla(new AgregarClienteFrecuenteFORM(this));
    }

    /**
     * Este menu muestra las acciones que se le pueden hacer a clientes añadir o
     * consultarlos
     */
    public void navegarMenuClientesFrecuentes() {
        mostrarPantalla(new MenuClientesFrecuentesFORM(this));
    }

    /**
     * Metodo el cual muestra la pantalla para consultar los clientes frecuentes
     * guardados hasta el momento
     */
    public void navegarConsultaClientes() {
        mostrarPantalla(new BusquedaClienteFrecuenteFORM(this));
    }

    /**
     * Metodo el cual muestra la pantalla para mostrar el menu de productos,
     * agregar, consultar
     */
    public void navegarMenuProductos() {
        mostrarPantalla(new MenuProductosFORM(this));
    }

    /**
     * Metodo el cual muestra una tabla para administrar todos los productos
     * guardados hasta el momento
     */
    public void navegarAdministrarProductos() {
        mostrarPantalla(new AdministrarProductosFORM(this));
    }

    /**
     * Metodo el cual muestra la pantalla para navegar por el menu de
     * ingredientes
     */
    public void navegarMenuIngredientes() {
        mostrarPantalla(new MenuIngredientesFORM(this));
    }

    /**
     * metodo el cual muestra el form para agregar un ingrediente a la base de
     * datos
     */
    public void navegarAgregarIngrediente() {
        mostrarPantalla(new AgregarIngredientesFORM(this));
    }

    /**
     * metodo el cual muestra los ingredientes en tabla guardados hasta el
     * momento
     */
    public void navegarBusquedaIngrediente() {
        mostrarPantalla(new BusquedaIngredienteFORM(this));
    }

    /**
     * metodo el cual muestra un menu de acciones al momento de clickear un
     * producto en la tabla
     *
     * @param id
     */
    public void navegarMenuAccionesProducto(Long id) {
        MenuAccionesProducto menuAccionesProducto = new MenuAccionesProducto(frameActual, true, this, id);
        menuAccionesProducto.setLocationRelativeTo(frameActual);
        menuAccionesProducto.setVisible(true);
    }

    /**
     * menu el cual se muestra para poder añadir un producto a la base de datos
     */
    public void navegarAniadirProducto() {
        mostrarPantalla(new AniadirProductoFORM(this));
    }

    /**
     * este metodo sirve para poder editar un producto guardado pasamos las
     * recetas guardadas previamente para poder guardar lo que lleva el usuario
     * y guardar todo hasta que el presione el boton guardar
     *
     * @param id
     */
    public void navegarEditarProducto(Long id) {
        try {
            Producto producto = objetosBO.getProductosBO().validarBusquedaPorId(id);
            EditarProductoFORM editarProducto = new EditarProductoFORM(frameActual, true, this, id);
            List<NuevaRecetaDTO> recetasTemporales = new LinkedList<>();

            for (Receta recetas : producto.getReceta()) {
                recetasTemporales.add(new NuevaRecetaDTO(
                        recetas.getIngrediente().getIdIngrediente(),
                        recetas.getIngrediente().getNombreIngrediente(),
                        recetas.getCantidadIngrediente()
                ));
            }

            editarProducto.setIngredientesReceta(recetasTemporales);
            editarProducto.setLocationRelativeTo(frameActual);
            editarProducto.setVisible(true);
        } catch (NegocioException ex) {
        }

    }

    /**
     * mostramos un boton para poder agregar ingredientes cuando el usuario esta
     * en alñadir producto, asi no se satura el form de añadir y puedo añadir
     * los ingredientes desde otro form
     */
    public void navegarAgregarIngredientesProducto() {
        AgregarIngredientesProductoFORM agregarIngredientesProductoFORM = new AgregarIngredientesProductoFORM(frameActual, true, this);
        agregarIngredientesProductoFORM.setLocationRelativeTo(frameActual);
        agregarIngredientesProductoFORM.setVisible(true);
    }

    /**
     * dialog que muestra los detalles del producto desde su receta hasta la
     * descripcion y el precio, junto con el nombre de este mismo
     *
     * @param id
     */
    public void navegarDetallesProducto(Long id) {
        DetallesProductoFORM detallesProducto = new DetallesProductoFORM(frameActual, true, this, id);
        detallesProducto.setLocationRelativeTo(frameActual);
        detallesProducto.setVisible(true);
    }

    //logica de botones 
    /**
     * Se usa para guardar al cliente como tal trayendo todos los datos
     * necesarios
     *
     * @param nombre
     * @param apellidos
     * @param telefono
     * @param correo
     */
    public void registrarCliente(String nombre, String apellidos, String telefono, String correo) {
        NuevoClienteFrecuenteDTO cliente = new NuevoClienteFrecuenteDTO(nombre, apellidos, telefono, correo);
        try {
            objetosBO.getClientesFrecuentesBO().validarRegistroCliente(cliente);
            JOptionPane.showMessageDialog(frameActual, "Cliente registrado con éxito");
            navegarMenuClientesFrecuentes();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * buscamos a los clientes para ponerlos en tabla
     *
     * @param texto
     * @param tipoFiltro
     */
    public void BuscarClientesFrecuentes(String texto, String tipoFiltro) {
        try {
            List<ClienteFrecuente> lista = objetosBO.getClientesFrecuentesBO().validarBarraBusqueda(texto, tipoFiltro);
            ((BusquedaClienteFrecuenteFORM) frameActual).mostrarResultados(lista);

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Agregamos un producto a la base de datoss, con los ingredientes el cual
     * esta como recetas
     *
     * @param nombre
     * @param precio
     * @param descripcion
     * @param tipoProducto
     * @param recetas
     * @param ruta
     */
    public void agregarProducto(String nombre, Double precio, String descripcion, String tipoProducto, List<NuevaRecetaDTO> recetas, String ruta) {
        try {
            TipoProductoDTO tipoDTO = TipoProductoDTO.valueOf(tipoProducto.toUpperCase());
            EstadoDTO estado = EstadoDTO.ACTIVO;
            NuevoProductoDTO productoDTO = new NuevoProductoDTO(nombre, descripcion, precio, tipoDTO, estado, recetas);
            productoDTO.setRutaImagen(ruta);

            objetosBO.getProductosBO().validarRegistroProducto(productoDTO);
            JOptionPane.showMessageDialog(frameActual, "Producto registrado con éxito");
            navegarMenuProductos();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * buscamos los productos para ponerlos en la tabla del form
     *
     * @param nombre
     */
    public void buscarProductos(String nombre) {
        try {
            List<Producto> lista = objetosBO.getProductosBO().validarBarraBusquedaProductos(nombre);
            ((AdministrarProductosFORM) frameActual).mostrarResultados(lista);

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * actualizamos el producto, seteandole la descripcion el precio y las
     * recetas lo cual es lo unico seteable o cambiable
     *
     * @param productoActualizar
     * @throws NegocioException
     */
    public void actualizarProducto(NuevoProductoDTO productoActualizar) throws NegocioException {
        try {
            objetosBO.getProductosBO().validacionProductoActualizado(productoActualizar);
            this.reiniciarTablaProductos();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * elinimaos el producto requerido, al momento de usarlo mandamos a llamar
     * un metodo que buscamos por id para luego borrarlo
     *
     * @param id
     */
    public void eliminarProducto(Long id) {
        try {
            objetosBO.getProductosBO().validarEliminarProducto(id);
            this.reiniciarTablaProductos();

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * cambiamos el estado del producto seleccionado por el usuario cambiando el
     * enumerado de ACTIVO a INACTIVO
     *
     * @param id
     * @param estadoDTO
     */
    public void cambiarEstadoProducto(Long id, EstadoDTO estadoDTO) {
        try {
            objetosBO.getProductosBO().validarCambiarEstado(id, estadoDTO);
            this.reiniciarTablaProductos();

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Registramos un ingrediente trayendo datos necesarios para poder
     * registrarlo en la base de datos
     *
     * @param nombre
     * @param stock
     * @param unidadMedida
     */
    public void registrarIngrediente(String nombre, String stockTexto, String unidadMedida, byte[] imagen) {
        if (stockTexto == null || stockTexto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frameActual,"Debes ingresar un número de stock.","Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Double stock;
        try {
            stock = Double.parseDouble(stockTexto.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frameActual,"Ingrese un núemro de stock válido.","Formato inválido", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            UnidadMedidaDTO unidadDTO = UnidadMedidaDTO.valueOf(unidadMedida.toUpperCase());
            NuevoIngredienteDTO ingredienteDTO = new NuevoIngredienteDTO(nombre, stock, unidadDTO, imagen);
            objetosBO.getIngredientesBO().validarRegistroIngrediente(ingredienteDTO);
            JOptionPane.showMessageDialog(frameActual, "El ingrediente ha sido registrado con éxito.");
            navegarMenuIngredientes();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * usamos el id del ingrediente para buscarlo en la base de datos y luego
     * eliminarlo
     *
     * @param idIngrediente
     */
    public void eliminarIngrediente(Long idIngrediente) {
        try {
            objetosBO.getIngredientesBO().eliminarIngrediente(idIngrediente);
            JOptionPane.showMessageDialog(null, "Ingrediente eliminado correctamente.");
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * buscamos los ingredientes para poder mostrarlos en la tabla con el texto
     * y tipo filtro manejados por un comboBox y un txt para buscar lo que
     * indica el tipo filtro
     *
     * @param texto
     * @param tipoFiltro
     */
    public void buscarIngredientes(String texto, String tipoFiltro) {
        try {
            List<Ingrediente> lista = objetosBO.getIngredientesBO().validarBarraBusqueda(texto, tipoFiltro);
            ((BusquedaIngredienteFORM) frameActual).mostrarResultados(lista);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * actualizamos el stock de un ingrediente escogido previamente por el
     * usuario con el id y seteamos la nueva cantidad
     *
     * @param idIngrediente
     * @param cantidad
     */
    public void actualizarStockIngrediente(Long idIngrediente, String cantidad) {
        try {
            objetosBO.getIngredientesBO().actualizarStockIngrediente(idIngrediente, cantidad);
            JOptionPane.showMessageDialog(frameActual, "El stock ha sido actualizado correctamente");
            buscarIngredientes("", "");
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Buscamos el ingrediente para el producto, usando texto y el tipo filtro
     * aunque por default ponemos que sea por nombre, y asi traer los
     * ingredientes para poder agregarlos al producto usando el buscador de
     * ingrediente
     *
     * @param texto
     * @param tipoFiltro
     * @param dialog
     */
    public void buscarIngredientesParaProducto(String texto, String tipoFiltro, AgregarIngredientesProductoFORM dialog) {
        try {
            List<Ingrediente> lista = objetosBO.getIngredientesBO().validarBarraBusqueda(texto, tipoFiltro);
            dialog.mostrarResultados(lista);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * hacemos lo mismo que el metodo de arriba solo que este dialogo es para
     * editar producto trayendo todos los ingredientes solo por nombre el tipo
     * filtro para que el usuario pueda buscar ingredientes para añadirlos a su
     * producto
     *
     * @param texto
     * @param tipoFiltro
     * @param dialog
     */
    public void buscarIngredientesParaProductoEditar(String texto, String tipoFiltro, EditarProductoFORM dialog) {
        try {
            List<Ingrediente> lista = objetosBO.getIngredientesBO().validarBarraBusqueda(texto, tipoFiltro);
            dialog.mostrarResultados(lista);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * en este metodo se manda a llamar desde agregar ingrdientes para producto
     * Form haciendo que todo los ingredientes que agregue el usuario se
     * guarden, mandamos a llamar este metodo lo que hace es que en el form de
     * añadir producto tiene una lista la cual guarda recetas =ingrediente,
     * entonces todo lo que puso el usuario de ingredientes en el form anterior
     * con este metodo lo pasamos para añadir ingredients guardando el producto
     * con todo y sus ingredientes
     *
     * @param receta
     */
    public void enviarIngredienteAniadirProducto(NuevaRecetaDTO receta) {
        ((AniadirProductoFORM) frameActual).agregarIngredienteLista(receta);
    }

    /**
     * Mostramos la descripcion de los ingredientes agregados previamente para
     * cuando el usuario se quiera salir para añadir al producto con los
     * ingredientes que escogio previamente le aparezca cuales selecciono, por
     * si quiere cancelar la operacion o si todo bien
     *
     * @return
     */
    public String ResumenRecetasProducto() {
        String ingredientesMostar = "";
        List<NuevaRecetaDTO> lista = ((AniadirProductoFORM) frameActual).getIngredientesReceta();

        for (NuevaRecetaDTO ingrediente : lista) {
            ingredientesMostar += ingrediente.getNombre() + "\n";
        }
        return ingredientesMostar;
    }

    /**
     * usado en el frame para mostrar la descripcion del producto
     *
     * @param id
     * @return
     */
    public String mostrarDescripcion(Long id) {
        try {
            Producto producto = objetosBO.getProductosBO().validarBusquedaPorId(id);
            return producto.getDescripcion();

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * obtenemos la receta del producto seleccionado para mostrarlo en el mismo
     * frame el cual esta la deescripcion
     *
     * @param id
     * @return
     */
    public String obtenerReceta(Long id) {
        try {
            Producto producto = objetosBO.getProductosBO().validarBusquedaPorId(id);
            String texto = "";
            for (Receta receta : producto.getReceta()) {

                texto += "- " + receta.getCantidadIngrediente() + " " + receta.getIngrediente().getUnidadMedida() + " de " + receta.getIngrediente().getNombreIngrediente() + "\n";
            }
            return texto;
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    //utileria
    /**
     * Usado en varios metodos para poder consultar al producto por su id y
     * hacer operaciones con el
     *
     * @param id
     * @return
     * @throws NegocioException
     */
    public Producto consultaProductoPorID(Long id) throws NegocioException {
        try {
            return objetosBO.getProductosBO().validarBusquedaPorId(id);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frameActual, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * usamos este metodo porque se queda abierta la pantalla mientras el
     * usuario hace operaciones como eliminar editar o cambiar el estado a un
     * producto que se muestra atras, asi que volvemos a llamar al metodo el
     * cual carga los productos para que reinice la tabla
     */
    public void reiniciarTablaProductos() {
        if (frameActual instanceof AdministrarProductosFORM administrarProductosFrom) {
            administrarProductosFrom.cargarProductos();
        }
    }

    /**
     * Mandamos a llamar a el form de añadir producto donde tenemos las recetas
     * para saber si el ingrediente ya existe o no, y no se puedan añadir mas de
     * 1
     *
     * @param id
     * @return
     */
    public boolean ValidarIngredienteRepetido(Long id) {
        AniadirProductoFORM frame = (AniadirProductoFORM) frameActual;
        for (NuevaRecetaDTO receta : frame.getIngredientesReceta()) {
            if (receta.getIdIngrediente().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
