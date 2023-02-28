package com.adria.esseeujali.controller;

import com.adria.esseeujali.dto.LivroDto;
import com.adria.esseeujali.mapper.LivroMapper;
import com.adria.esseeujali.model.Livro;
import com.adria.esseeujali.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("esseeujali")
public class LivroController {

    @Autowired
    private LivroService service;
    @Autowired
    private LivroMapper livroMapper;

    public LivroController() {

    }
    public LivroController(LivroService service, LivroMapper livroMapper) {
        this.service = service;
        this.livroMapper = livroMapper;
    }

    @PostMapping("/livros")
    public ResponseEntity<LivroDto> cadastrar(@RequestBody LivroDto livroDto){
        Livro livro = livroMapper.toEntity(livroDto);
        livro = service.cadastrar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroMapper.toDto(livro));
    }

    @GetMapping("/livros")
    public ResponseEntity<List<Livro>> listarTodosOsLivros(){
        return ResponseEntity.ok(this.service.listarTodosOSLivros().stream().collect(Collectors.toList()));
    }

}
