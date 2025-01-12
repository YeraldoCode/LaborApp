package com.alexander.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/categorias")
public class CategoriasController {
    // Metodo para mostrar la lista de categorías
    @GetMapping("/index")
    public String mostrarIndex(Model model) {
        return "categorias/listCategorias";
    }

    // Metodo para mostrar el formulario de creación de categoría
    @GetMapping("/create")
    public String crear() {
        return "categorias/formCategoria";
    }

    // Metodo para guardar una nueva categoría
    @PostMapping("/save")
    public String guardar(@RequestParam("nombre") String nombre,@RequestParam("descripcion") String descripcion) {
        System.out.println("Categoria: "+nombre);
        System.out.println("Descripcion: "+descripcion);
        return "categorias/listCategorias";
    }
}
