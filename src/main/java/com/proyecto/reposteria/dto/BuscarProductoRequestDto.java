package com.proyecto.reposteria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BuscarProductoRequestDto {

    private Integer pagina;
    private Integer itemsPorPagina;
    private String nombre;
    private Collection<Long> idsCategoria;
    private Double precioMin;
    private Double precioMax;
    private String ordenarPor;

}
