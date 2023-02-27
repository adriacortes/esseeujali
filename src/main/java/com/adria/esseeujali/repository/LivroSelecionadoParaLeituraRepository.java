package com.adria.esseeujali.repository;

import com.adria.esseeujali.model.LivroSelecionado;
import com.adria.esseeujali.model.LivroSelecionadoParaLeitura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroSelecionadoParaLeituraRepository extends JpaRepository<LivroSelecionadoParaLeitura,LivroSelecionado> {
}
