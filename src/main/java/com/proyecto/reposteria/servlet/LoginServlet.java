package com.proyecto.reposteria.servlet;

import com.proyecto.reposteria.dto.LoginRequest;
import com.proyecto.reposteria.dto.Respuesta;
import com.proyecto.reposteria.servicio.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginServlet {

    private final LoginService authenticationService;

    @PostMapping
    public Respuesta login(@Valid @RequestBody LoginRequest loginRequest, Locale locale) {
        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje("Login exitoso");
        respuesta.setDatos(authenticationService.login(loginRequest, locale));
        return respuesta;
    }

}
