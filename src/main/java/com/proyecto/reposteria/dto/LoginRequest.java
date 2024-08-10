package com.proyecto.reposteria.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "{usuario.correo.notblank}")
    private String correo;
    @NotBlank(message = "{usuario.password.notblank}")
    private String password;
}
