package com.adria.esseeujali.controller;

import com.adria.esseeujali.dto.UsuarioDto;
import com.adria.esseeujali.mapper.UsuarioMapper;
import com.adria.esseeujali.model.Usuario;
import com.adria.esseeujali.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("esseeujali")
public class UsuarioController {


    private UsuarioService service;

    private UsuarioMapper usuarioMapper;

    public UsuarioController(UsuarioService service, UsuarioMapper usuarioMapper) {
        this.service = service;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping()
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioDto usuarioDto){
           Usuario usuario = usuarioMapper.toEntity(usuarioDto);
           usuario = this.service.cadastrar(usuario);

           return ResponseEntity.status(HttpStatus.CREATED).body(usuarioMapper.toDto(usuario));

    }
}
