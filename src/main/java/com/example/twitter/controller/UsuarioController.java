package com.example.twitter.controller;

import com.example.twitter.entity.Usuario;
import com.example.twitter.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Usuario> listUsuarios() {
        return usuarioRepository.findAll();
    }
}
