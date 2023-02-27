package com.adria.esseeujali.repository;

import com.adria.esseeujali.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
   // Usuario findByUsuarionome(String nome);
    Usuario findBynome(String nome);
    Usuario findByemail(String email);
}
