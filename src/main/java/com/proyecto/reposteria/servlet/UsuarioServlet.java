package com.proyecto.reposteria.servlet;


import com.proyecto.reposteria.dto.Respuesta;
import com.proyecto.reposteria.modelo.Usuario;
import com.proyecto.reposteria.servicio.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioServlet {

    private final UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<Respuesta> registro(@Valid @RequestBody Usuario usuario, Locale locale) {

        Respuesta respuesta = usuarioService.registrarUsuario(usuario, locale);
        return ResponseEntity.ok(respuesta);
    }

    @Secured("ADMIN")
    @GetMapping()
    public Respuesta listUsuarios(){
        return usuarioService.listarUsuarios();
    }
}
