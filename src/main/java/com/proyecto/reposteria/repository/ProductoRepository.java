package com.proyecto.reposteria.repository;

import com.proyecto.reposteria.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN 1 ELSE 0 END FROM producto p WHERE p.categoria.id = :categoriaId")
    int existsProductoByCategoriaId(@Param("categoriaId") Long categoriaId);

}
