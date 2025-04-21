package com.tallerwebi.presentacion.Entrenamiento2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/*
📝
 Requisitos:
 1. Vista `contacto.html`:- Un formulario con los siguientes campos:
  - Nombre (input de texto)
  - Email (input de tipo `email`)
  - Mensaje (textarea)
  - Botón de envío
  - Usar `th:action` y `th:object` para enviar el formulario al backend.
  - El formulario debe enviarse por `POST` al controlador.

2. Controlador:
- Clase `ContactoController`
- Método `mostrarFormulario()` que devuelve la vista `contacto`.
- Método `procesarFormulario()` que recibe el formulario con `@ModelAttribute`.
- Guarda los datos en un objeto `Contacto` (puede ser un POJO con nombre, email, mensaje).
  - Agrega el objeto al modelo.
  - Redirige a una vista de confirmación -> confirmacion.html

 3. Vista `confirmacion.html`:
 - Mostrar un mensaje de agradecimiento personalizado con el nombre del usuario.
 - Mostrar el mensaje enviado y el email.

 Tips:
 - Usar `@GetMapping("/contacto")` para el formulario.
 - Usar `@PostMapping("/contacto")` para procesar el envío.
 - No se necesita persistencia, solo mostrar cómo pasar los datos
 */

public class ContactoControllerTest {

    ContactoController controlador;

    // Preguntar como testear parte de html o binding con html

    @BeforeEach
    public void init() {
        this.controlador = new ContactoController(); // Los controladores se asocian a uno o varios servicios del dominio, pero en este ejercicio no hacen falta, pero casi siempre habra un servicio en el constructor

    }

    @Test
    public void dadoQueExisteUnContactoControllerCuandoLePidoMostrarFormularioObtengoLaVistaDeContactoConElFormularioYUnContactoDto(){
        // Preparacion (hecha en el init)
        // Ejecucion
        ModelAndView modelAndView = this.controlador.mostrarFormulario();

        String vistaObtenida = modelAndView.getViewName();
        ModelMap modeloObtenido = modelAndView.getModelMap();

        // Validacion

        String vistaEsperada = "contacto";

        assertThat(vistaObtenida, equalTo(vistaEsperada));
        assertThat(modeloObtenido.get("contactoDto"), instanceOf(ContactoDto.class));
    }

    @Test
    public void dadoQueExisteUnContactoControllerCuandoProcesoElFormularioConUnContactoDtoObtengoLaVistaDeConfirmacionYElContactoDtoProcesado(){
        // Preparacion

        ContactoDto contacto = new ContactoDto();
        contacto.setNombre("Nombre");
        contacto.setEmail("Email@gmail.com");
        contacto.setMensaje("Mensaje!");

        // Ejecucion

        ModelAndView modelAndView = this.controlador.procesarFormulario(contacto);
        String vistaObtenida = modelAndView.getViewName();
        ModelMap modeloObtenido = modelAndView.getModelMap();

        // Validacion

        String vistaEsperada = "confirmacion";

        assertThat(vistaObtenida, equalTo(vistaEsperada));
        assertThat(modeloObtenido.get("contactoDto"), is(contacto));
    }
}
