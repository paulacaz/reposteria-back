package com.proyecto.reposteria.repository;

import com.proyecto.reposteria.modelo.Producto;
import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;

public class ProductoSpecification {

    public static Specification<Producto> conNombre(String nombre) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nombre"), "%" + nombre + "%");
    }

    public static Specification<Producto> conCategoria(Collection<Long> idsCategoria) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.in(root.get("categoria").get("id")).value(idsCategoria);
    }

    public static Specification<Producto> conPrecioMenorA(double precio) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("precio"), precio);
    }

    public static Specification<Producto> conPrecioEntre(double precioMin, double precioMax) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("precio"), precioMin, precioMax);
    }

    public static Specification<Producto> orderByPrecioAsc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.asc(root.get("precio")));
            return query.getRestriction();
        };
    }

    public static Specification<Producto> orderByPrecioDesc() {
        return (root, query, criteriaBuilder) -> {
            query.orderBy(criteriaBuilder.desc(root.get("precio")));
            return query.getRestriction();
        };
    }
}
