package com.adria.esseeujali.service;

import com.adria.esseeujali.dto.UsuarioDto;
import com.adria.esseeujali.model.Usuario;
import com.adria.esseeujali.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario cadastrar(Usuario usuario){
        return repository.save(usuario);
    }
}
