package com.adria.esseeujali.service;

import com.adria.esseeujali.dto.CreateUserRoleDTO;
import com.adria.esseeujali.model.Role;
import com.adria.esseeujali.model.Usuario;
import com.adria.esseeujali.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CreateRoleUserService {

    @Autowired
    UsuarioRepository repository;

//    public Usuario execute(CreateUserRoleDTO createUserRoleDTO){
//
//        Optional<Usuario> userExists = repository.findById(createUserRoleDTO.getIdUser());
//        List<Role> roles = new ArrayList<>();
//
//        if (userExists.isEmpty()){
//            throw new Error("Usuario não existe.");
//        }
//
//        roles = createUserRoleDTO.getIdsRoles().stream().map(role ->{
//            return new Role(role);
//        }).collect(Collectors.toList());
//
//        Usuario usuario = userExists.get();
//        usuario.setRoles(roles);
//
//        repository.save(usuario);
//
//        return usuario;
//    }
}
