package com.example.twitter.config;

import com.example.twitter.entity.Usuario;
import com.example.twitter.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            criarUsuario("Galdino", "dgstihler@gmail.com", "123456");
        }
    }

    private void criarUsuario(String name, String email, String password) {
        usuarioRepository.save(new Usuario(name, email, password));
    }

}
