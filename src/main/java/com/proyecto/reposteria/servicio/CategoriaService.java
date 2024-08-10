package com.proyecto.reposteria.servicio;

import com.proyecto.reposteria.exception.ServiceException;
import com.proyecto.reposteria.modelo.Categoria;
import com.proyecto.reposteria.repository.CategoriaRepository;
import com.proyecto.reposteria.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    private final ProductoRepository productoRepository;

    public List<Categoria> listarCategorias(){
        return this.categoriaRepository.findAll();
    }

    public Categoria agregarCategoria(Categoria categoria){
        return this.categoriaRepository.save(categoria);
    }

    public Categoria actualizarCategoria(Categoria categoria){
        return this.categoriaRepository.save(categoria);
    }

    public void eliminarCategoria(Long id){
        int existenProductos = this.productoRepository.existsProductoByCategoriaId(id);
        if(existenProductos > 0){
            throw new ServiceException("No se puede eliminar la categoria porque tiene productos asociados");
        }
        this.categoriaRepository.deleteById(id);
    }
}
