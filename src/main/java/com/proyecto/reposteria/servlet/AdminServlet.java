package com.proyecto.reposteria.servlet;

import com.proyecto.reposteria.dto.BuscarProductoRequestDto;
import com.proyecto.reposteria.dto.Respuesta;
import com.proyecto.reposteria.modelo.Categoria;
import com.proyecto.reposteria.modelo.Producto;
import com.proyecto.reposteria.servicio.CategoriaService;
import com.proyecto.reposteria.servicio.ProductoService;
import com.proyecto.reposteria.servicio.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminServlet {

    private final UsuarioService usuarioService;

    private final CategoriaService categoriaService;

    private final ProductoService productoService;

    @GetMapping("/usuarios")
    public Respuesta listarUsuarios(){
        Respuesta respuesta = usuarioService.listarUsuarios();
        return respuesta;
    }

    @GetMapping("/categorias")
    public Respuesta listarCategorias(){
        Respuesta respuesta = Respuesta.builder()
                .datos(categoriaService.listarCategorias())
                .build();
        return respuesta;
    }

    @PostMapping("/categorias")
    public ResponseEntity<Void> agregarCategoria(@RequestBody Categoria categoria){
        categoriaService.agregarCategoria(categoria);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/categorias")
    public ResponseEntity<Void> actualizarCategoria(@RequestBody Categoria categoria){
        categoriaService.actualizarCategoria(categoria);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id){
        categoriaService.eliminarCategoria(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/productos/list")
    public Page<Producto> productos(@RequestBody BuscarProductoRequestDto buscarProductoRequestDto) {
        return productoService.listaProductosPaginados(buscarProductoRequestDto);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> producto(@PathVariable("id") Long id) {
        return productoService.obtenerProducto(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/productos")
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.crearProducto(producto));
    }

    @PutMapping("/productos")
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.actualizarProducto(producto));
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.ok().build();
    }
}
