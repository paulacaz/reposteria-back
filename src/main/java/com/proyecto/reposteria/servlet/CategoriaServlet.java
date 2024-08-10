package com.proyecto.reposteria.servlet;

import com.proyecto.reposteria.modelo.Categoria;
import com.proyecto.reposteria.servicio.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/public/categoria")
public class CategoriaServlet {

    private final CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> productos() {
        return categoriaService.listarCategorias();
    }

}
