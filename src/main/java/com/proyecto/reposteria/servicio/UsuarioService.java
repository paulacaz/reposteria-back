package com.proyecto.reposteria.servicio;

import com.proyecto.reposteria.dto.Respuesta;
import com.proyecto.reposteria.exception.ServiceException;
import com.proyecto.reposteria.modelo.Role;
import com.proyecto.reposteria.modelo.Usuario;
import com.proyecto.reposteria.repository.UsuarioRepository;
import com.proyecto.reposteria.util.MessagesUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final MessagesUtil messagesUtil;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${admin.secret.key}")
    private String llaveSecreta;

    public Respuesta registrarUsuario(Usuario usuario, Locale locale) {

        if (usuario.getRole().equals(Role.ADMIN)) {
            if (!usuario.getLlaveSecreta().equals(llaveSecreta)) {
                throw new ServiceException(messagesUtil.getMessage("usuario.registro.noadmin", locale));
            }
        }

        if (!usuario.getPassword().equals(usuario.getConfirmPassword())) {
            throw new ServiceException(messagesUtil.getMessage("usuario.confirmpassword.none", locale));
        }

        Optional<Usuario> usuarioExistente = usuarioRepository.findByCorreo(usuario.getCorreo());

        if(usuarioExistente.isPresent()){
            throw new ServiceException(this.messagesUtil.getMessage("usuario.existente.correo", locale));
        }


        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        Usuario usuarioRegistrado = usuarioRepository.save(usuario);
        usuarioRegistrado.setPassword(null);
        usuarioRegistrado.setLlaveSecreta(null);

        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje(messagesUtil.getMessage("usuario.register.successful", locale));
        respuesta.setDatos(usuarioRegistrado);

        return respuesta;
    }

    public Respuesta listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll().stream().map(u -> {
            u.setPassword(null);
            return u;
        }).collect(Collectors.toList());

        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje("Lista de usuarios");
        respuesta.setDatos(usuarios);

        return respuesta;
    }

    public Usuario findByCorreo(String correo, Locale locale) {
        return usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new ServiceException(this.messagesUtil.getMessage("usuario.correo.nonexisting", locale)));
    }


}
