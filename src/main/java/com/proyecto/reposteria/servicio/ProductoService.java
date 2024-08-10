package com.proyecto.reposteria.servicio;

import com.proyecto.reposteria.dto.BuscarProductoRequestDto;
import com.proyecto.reposteria.modelo.Producto;
import com.proyecto.reposteria.repository.ProductoRepository;
import com.proyecto.reposteria.repository.ProductoSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> listaProductos() {
        return productoRepository.findAll();
    }

    public Page<Producto> listaProductosPaginados(BuscarProductoRequestDto buscarProductoRequestDto) {

        Pageable pageable = PageRequest.of(Optional.ofNullable(buscarProductoRequestDto.getPagina())
                .orElse(0), Optional.ofNullable(buscarProductoRequestDto.getItemsPorPagina()).orElse(10));

        Specification<Producto> specs = Specification.where(null);

        if (Optional.ofNullable(buscarProductoRequestDto.getNombre()).isPresent()) {
            specs = specs.and(ProductoSpecification.conNombre(buscarProductoRequestDto.getNombre()));
        }

        if (Optional.ofNullable(buscarProductoRequestDto.getIdsCategoria()).isPresent() && !buscarProductoRequestDto.getIdsCategoria().isEmpty()) {
            specs = specs.and(ProductoSpecification.conCategoria(buscarProductoRequestDto.getIdsCategoria()));
        }

        if (Optional.ofNullable(buscarProductoRequestDto.getPrecioMin()).isPresent() && Optional.ofNullable(buscarProductoRequestDto.getPrecioMax()).isPresent()) {
            specs = specs.and(ProductoSpecification.conPrecioEntre(buscarProductoRequestDto.getPrecioMin(), buscarProductoRequestDto.getPrecioMax()));
        } else if (Optional.ofNullable(buscarProductoRequestDto.getPrecioMin()).isPresent()) {
            specs = specs.and(ProductoSpecification.conPrecioMenorA(buscarProductoRequestDto.getPrecioMin()));
        }

        if (Optional.ofNullable(buscarProductoRequestDto.getOrdenarPor()).isPresent()) {
            if (buscarProductoRequestDto.getOrdenarPor().equals("precioAsc")) {
                specs = specs.and(ProductoSpecification.orderByPrecioAsc());
            } else if (buscarProductoRequestDto.getOrdenarPor().equals("precioDesc")) {
                specs = specs.and(ProductoSpecification.orderByPrecioDesc());
            }
        }

        return productoRepository.findAll(specs, pageable);
    }

    public Optional<Producto> obtenerProducto(Long id) {
        return productoRepository.findById(id);
    }

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
