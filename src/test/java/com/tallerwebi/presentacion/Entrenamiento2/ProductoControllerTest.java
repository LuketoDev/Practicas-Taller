package com.tallerwebi.presentacion.Entrenamiento2;

/*
1. Vista `productos.html`:
- Mostrar una tabla con una lista de productos (nombre, precio).
- Cada fila debe tener un botón o link para ver el detalle del producto.
- Usar Thymeleaf con `th:each` para iterar.

 2. Controlador:
 - Clase `ProductoController`.
 - Método `listarProductos()`:
  - Devuelve una lista quemada en el controlador (ej., 3 productos hardcodeados en una lista).
  - Agrega esa lista al modelo.
  - Devuelve la vista `productos`.
 - Método `verDetalle(@PathVariable Long id)`:
  - Busca el producto en la lista quemada por su `id`.
  - Lo agrega al modelo.
  - Devuelve la vista `detalle.html`.

 3. Vista `detalle.html`:
 - Mostrar el nombre, descripción y precio del producto seleccionado.
 - Botón para volver a la lista (`/productos`)

 Tips:
 - Usar clases POJO para el producto (`id`, `nombre`, `descripcion`, `precio`).
- Usar rutas como `/productos` y `/productos/{id}`.
- Mostrar mensajes si no se encuentra el producto con ese ID (opcional)
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProductoControllerTest {

    private ProductoController controlador;

    @BeforeEach
    public void init() {
        controlador = new ProductoController();
    }

    @Test
    public void dadoQueExisteUnProductoControllerCuandoLePidoListarProductosObtengoLaVistaProductoCon3ProductosEnElModelo(){

        // Preparacion(hecha en el init)

        // Ejecucion

        ModelAndView modelAndViewObtenido = controlador.listarProductos();

        String vistaObtenida = modelAndViewObtenido.getViewName();
        List<ProductoDto> listaDeProductosObtenida = (List<ProductoDto>) modelAndViewObtenido.getModelMap().get("productos");

        // Validacion

        String vistaEsperada = "productos";

        ProductoDto productoAEsperado = new ProductoDto(1L, "NombreA", "DescripcionA", 1000D);
        ProductoDto productoBEsperado = new ProductoDto(2L, "NombreB", "DescripcionB", 2000D);
        ProductoDto productoCEsperado = new ProductoDto(3L, "NombreC", "DescripcionC", 3000D);
        List<ProductoDto> listaDeProductosEsperada = Arrays.asList(productoAEsperado, productoBEsperado, productoCEsperado);

        assertThat(vistaObtenida, equalTo(vistaEsperada));
        assertThat(listaDeProductosObtenida, is(listaDeProductosEsperada));
    }

    @Test
    public void dadoQueExisteUnProductoControllerCuandoLePidoVerDetalleDelProducto2ObtengoLaVistaDetalleConElProductoEnElModelo(){

        // Preparacion(hecha en el init)

        Long idBuscado = 2L;

        // Ejecucion

        ModelAndView modelAndViewObtenido = controlador.verDetalle(idBuscado);

        String vistaObtenida = modelAndViewObtenido.getViewName();
        ProductoDto productoObtenido = (ProductoDto) modelAndViewObtenido.getModelMap().get("producto");

        // Validacion

        String vistaEsperada = "detalle";
        ProductoDto productoEsperado = new ProductoDto(2L, "NombreB", "DescripcionB", 2000D);

        assertThat(vistaObtenida, equalTo(vistaEsperada));
        assertThat(productoObtenido, is(productoEsperado));
    }

    @Test
    public void dadoQueExisteUnProductoControllerCuandoLePidoVerDetalleDeUnProductoNoExistenteObtengoLaVistaDetalleConUnMensajeDeErrorEnElModelo(){

        // Preparacion(hecha en el init)

        Long idBuscado = 4L;

        // Ejecucion

        ModelAndView modelAndViewObtenido = controlador.verDetalle(idBuscado);

        String vistaObtenida = modelAndViewObtenido.getViewName();
        String mensajeDeErrorObtenido = (String) modelAndViewObtenido.getModelMap().get("mensaje");

        // Validacion

        String vistaEsperada = "detalle";
        String mensajeDeErrorEsperado = "No se pudo encontrar el producto del ID ingresado";

        assertThat(vistaObtenida, equalTo(vistaEsperada));
        assertThat(mensajeDeErrorObtenido, equalToIgnoringCase(mensajeDeErrorEsperado));
    }

}
