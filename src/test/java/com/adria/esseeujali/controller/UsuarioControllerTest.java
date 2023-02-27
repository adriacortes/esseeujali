package com.adria.esseeujali.controller;

import com.adria.esseeujali.mapper.UsuarioMapper;
import com.adria.esseeujali.model.Usuario;
import com.adria.esseeujali.repository.UsuarioRepository;
import com.adria.esseeujali.service.CreateRoleUserService;
import com.adria.esseeujali.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import java.time.LocalDate;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UsuarioControllerTest {

    public static final String EMAIL = "teste@email.com";
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UsuarioService usuarioService;

    private UsuarioMapper usuarioMapper;
    @MockBean
    private CreateRoleUserService createRoleUserService;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void deve_retornar_200_quando_usuario_for_autenticado() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setEmail(EMAIL);
        Usuario usuarioRetornado = new Usuario();
        usuarioRetornado.setNome("Fulano da Silva");
        usuarioRetornado.setEmail(EMAIL);
        usuarioRetornado.setId(1);
        usuarioRetornado.setDataCadastro(LocalDate.now());

        when(usuarioService.findByemail(usuario)).thenReturn(usuarioRetornado);

        ResultActions result = mockMvc.perform(get("/usuarios/autenticacao").param("email", EMAIL));

        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is("teste@email.com")));
        verify(usuarioService).findByemail(usuario);
    }

    @Test
    public void deve_retornar_201_quando_cadastrar_com_sucesso_um_livro_na_lista_do_usuario() throws Exception {
        when(usuarioRepository.findById(77)).thenReturn(Optional.of(new Usuario()));
        ResultActions result = mockMvc.perform(post("/usuarios/livros").content("{idUsuario:77,idLivro:55}"));

        //ListaLivrosUsuario listaLivrosUsuario = new ListaLivrosUsuario(77,55,false);

        result.andExpect(status().isCreated());
        //verify(usuarioService).adicionaLivroNaListaDeLeitura(listaLivrosUsuario);
        verify(usuarioRepository).findById(77);
    }



}