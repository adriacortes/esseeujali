package com.adria.esseeujali.repository;

import com.adria.esseeujali.model.LivroSelecionadoPK;
import com.adria.esseeujali.model.LivroSelecionadoParaLeitura;
import com.adria.esseeujali.model.RankingPontuacao;
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

    @Query(value = "SELECT sum(pontuacao) FROM livro_selecionado_para_leitura ls WHERE ls.usuario_id= :id", nativeQuery = true)
    Integer buscarPontosUsuario(int id);

    @Query("SELECT new com.adria.esseeujali.model.RankingPontuacao(us.nome) FROM LivroSelecionadoParaLeitura ls INNER JOIN Usuario us ON ls.livroSelecionadoPk.usuarioId = us.id" +
            " GROUP BY us.nome")
    List<RankingPontuacao> buscarPontosTodosUsuarios();
}
