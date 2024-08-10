package com.proyecto.reposteria.servlet;

import com.proyecto.reposteria.dto.BuscarProductoRequestDto;
import com.proyecto.reposteria.modelo.Producto;
import com.proyecto.reposteria.servicio.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/public/producto")
public class ProductoServlet {

    private final ProductoService productoService;

    @PostMapping("/list")
    public Page<Producto> productos(@RequestBody BuscarProductoRequestDto buscarProductoRequestDto) {
        return productoService.listaProductosPaginados(buscarProductoRequestDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> producto(@PathVariable("id") Long id) {
        return productoService.obtenerProducto(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.crearProducto(producto));
    }
}
