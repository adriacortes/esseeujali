package com.adria.esseeujali.repository;

import com.adria.esseeujali.model.LivroSelecionadoPK;
import com.adria.esseeujali.model.LivroSelecionadoParaLeitura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroSelecionadoParaLeituraRepository extends JpaRepository<LivroSelecionadoParaLeitura, LivroSelecionadoPK> {

//    @Query(value = "SELECT l.genero,count(*) as total FROM livro_selecionado_para_leitura ll inner join livro l on ll.id_livro = l.id \n" +
//            "where ll.id_usuario=:id" +
//            " group by l.genero having total > 5",nativeQuery = true)

    //    @Query("SELECT l.genero,count(*) as total FROM LivroSelecionadoParaLeitura ll  join Livro l ON ll.livroSelecionadoPk.livroId = l.id" +
//            " where Usuario.id=:id")
    //List<Trofeu> buscarTrofeuDoUsuario(int id);
}
