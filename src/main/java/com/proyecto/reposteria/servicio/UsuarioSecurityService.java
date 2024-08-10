package com.proyecto.reposteria.servicio;

import com.proyecto.reposteria.exception.ServiceException;
import com.proyecto.reposteria.modelo.Usuario;
import com.proyecto.reposteria.repository.UsuarioRepository;
import com.proyecto.reposteria.util.MessagesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Locale;

@RequiredArgsConstructor
@Service
public class UsuarioSecurityService {

    private final UsuarioRepository usuarioRepository;
    private final MessagesUtil messagesUtil;

    public Usuario findByCorreoForSecurity(String correo) {
        return this.usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new ServiceException(this.messagesUtil.getMessage("usuario.correo.nonexisting", Locale.getDefault())
                        .replace("#correo", correo)));
    }
}
