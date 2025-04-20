package com.tallerwebi.presentacion.Entrenamiento2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactoController {

    // o usar @RequestMapping(path = /contacto, method = RequestMethod.GET)
    @GetMapping("/contacto")
    public ModelAndView mostrarFormulario() {
        ModelMap model = new ModelMap();
        model.put("contactoDto", new ContactoDto());
        return new ModelAndView("contacto", model);
    }

    // o usar @RequestMapping(path = /contacto, method = RequestMethod.POST)
    @PostMapping("/contacto")
    public ModelAndView procesarFormulario(@ModelAttribute("contactoDto") ContactoDto contacto) {
        ModelMap model = new ModelMap();
        model.put("contactoDto", contacto);
        return new ModelAndView("confirmacion", model);
    }
}
