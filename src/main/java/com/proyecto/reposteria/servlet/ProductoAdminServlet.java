package com.proyecto.reposteria.servlet;

import com.proyecto.reposteria.modelo.Producto;
import com.proyecto.reposteria.servicio.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/producto")
public class ProductoAdminServlet {

    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.crearProducto(producto));
    }
}
