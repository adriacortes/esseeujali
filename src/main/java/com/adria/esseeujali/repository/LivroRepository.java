package com.adria.esseeujali.repository;

import com.adria.esseeujali.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    Livro findBytitulo(String titulo);
    Livro findById(int id);
}
