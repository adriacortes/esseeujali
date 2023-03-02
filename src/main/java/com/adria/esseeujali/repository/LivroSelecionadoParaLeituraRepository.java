package com.adria.esseeujali.repository;

import com.adria.esseeujali.model.LivroSelecionadoPK;
import com.adria.esseeujali.model.LivroSelecionadoParaLeitura;
import com.adria.esseeujali.model.Trofeu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroSelecionadoParaLeituraRepository extends JpaRepository<LivroSelecionadoParaLeitura, LivroSelecionadoPK> {

    @Query("SELECT new com.adria.esseeujali.model.Trofeu(li.genero) FROM LivroSelecionadoParaLeitura l " +
            " INNER JOIN Livro li ON l.livroSelecionadoPk.livroId = li.id" +
            " WHERE l.livroSelecionadoPk.usuarioId = :id" +
            " GROUP BY li.genero HAVING COUNT(li) >= 5 "
    )
    List<Trofeu> buscarTrofeuDoUsuario(int id);

}
