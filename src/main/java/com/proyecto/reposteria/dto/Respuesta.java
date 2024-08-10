package com.proyecto.reposteria.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Respuesta {
    private String mensaje;
    private Object datos;
    private Object errores;
}
