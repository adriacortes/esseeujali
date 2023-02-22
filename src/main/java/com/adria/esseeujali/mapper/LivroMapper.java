package com.adria.esseeujali.mapper;

import com.adria.esseeujali.dto.LivroDto;
import com.adria.esseeujali.model.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface LivroMapper {

    LivroDto toDto(Livro livro);
    @Mapping(target = "id", ignore = true)
    Livro toEntity(LivroDto livroDto);
}
