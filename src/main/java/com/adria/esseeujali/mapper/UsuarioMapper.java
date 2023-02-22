package com.adria.esseeujali.mapper;

import com.adria.esseeujali.dto.UsuarioDto;
import com.adria.esseeujali.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Component
@Mapper(componentModel = "spring")
public interface UsuarioMapper {

     UsuarioDto toDto(Usuario usuario);

     @Mapping(target = "id", ignore = true)
     Usuario toEntity(UsuarioDto usuarioDto);
}
