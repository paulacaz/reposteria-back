package com.proyecto.reposteria.repository;

import com.proyecto.reposteria.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
