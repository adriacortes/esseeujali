package com.adria.esseeujali.service;

import com.adria.esseeujali.exception.livroNaoEncontradoException;
import com.adria.esseeujali.model.Livro;
import com.adria.esseeujali.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public Livro cadastrar(Livro livro) {
        return repository.save(livro);
    }

    public List<Livro> listarTodosOSLivros() {
        return repository.findAll();
    }

    public Livro findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new livroNaoEncontradoException());
    }
}
