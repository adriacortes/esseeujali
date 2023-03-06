package com.adria.esseeujali.repository;

import com.adria.esseeujali.dto.MeusTitulosDto;
import com.adria.esseeujali.dto.RankingPontuacaoDto;
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

    @Query(value = "SELECT sum(pontuacao) FROM livro_selecionado_para_leitura ls WHERE ls.usuario_id= :id", nativeQuery = true)
    Integer buscarPontosUsuario(int id);


    @Query("SELECT new com.adria.esseeujali.dto.RankingPontuacaoDto(us.id,us.nome,ls.pontuacao) FROM  LivroSelecionadoParaLeitura ls INNER JOIN Usuario us\n" +
            " ON ls.livroSelecionadoPk.usuarioId = us.id ")
    List<RankingPontuacaoDto> ranking();

    @Query("SELECT new com.adria.esseeujali.dto.MeusTitulosDto(l.id,l.titulo) FROM LivroSelecionadoParaLeitura ls\n" +
            "            INNER JOIN Usuario us ON ls.livroSelecionadoPk.usuarioId = :id\n" +
            "            INNER JOIN Livro l ON ls.livroSelecionadoPk.livroId= l.id")
    List<MeusTitulosDto> minhaListaDeLeitura(int id);
}
