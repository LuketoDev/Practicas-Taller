package com.tallerwebi.presentacion.Entrenamiento2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductoController {

    private List<ProductoDto> productos;

    public ProductoController() {
        this.productos = Arrays.asList(
                new ProductoDto(1L, "NombreA", "DescripcionA", 1000D),
                new ProductoDto(2L, "NombreB", "DescripcionB", 2000D),
                new ProductoDto(3L, "NombreC", "DescripcionC", 3000D));
    }

    @GetMapping("/productos")
    public ModelAndView listarProductos() {
        ModelMap model = new ModelMap();
        model.put("productos", this.productos);
        return new ModelAndView("productos", model);
    }

    @GetMapping("/productos/{id}")
    public ModelAndView verDetalle(@PathVariable Long id) {
        ModelMap model = new ModelMap();

        ProductoDto productoBuscado = this.productos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst() // devolvelo si lo encontras
                .orElse(null); // caso contrario devolveme un null (si no aclaro esto lanza excepcion)

        if (productoBuscado != null) model.put("producto", productoBuscado);
        else model.put("mensaje", "No se pudo encontrar el producto del ID ingresado");

        return new ModelAndView("detalle", model);
    }
}
