package com.adria.esseeujali.mapper;

import com.adria.esseeujali.dto.LivroSelecionadoParaLeituraDto;
import com.adria.esseeujali.model.LivroSelecionadoParaLeitura;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface LivroSelecionadoParaLeitoraMapper {

    LivroSelecionadoParaLeituraDto toDto (LivroSelecionadoParaLeitura livroSelecionadoParaLeitura);

    LivroSelecionadoParaLeitura toEntity( LivroSelecionadoParaLeituraDto  LivroSelecionadoParaLeituraDto);
}
