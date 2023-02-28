package com.adria.esseeujali.controller;

import com.adria.esseeujali.dto.LivroSelecionadoParaLeituraDto;
import com.adria.esseeujali.dto.UsuarioDto;
import com.adria.esseeujali.exception.livroNaoEncontradoException;
import com.adria.esseeujali.exception.usuarioSemLivroNaListaDeLeituraException;
import com.adria.esseeujali.exception.UsuarioNaoEncontradoException;
import com.adria.esseeujali.mapper.UsuarioMapper;
import com.adria.esseeujali.model.Usuario;
import com.adria.esseeujali.repository.UsuarioRepository;
import com.adria.esseeujali.service.CreateRoleUserService;
import com.adria.esseeujali.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@CrossOrigin("*")
@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private UsuarioService service;
    private UsuarioMapper usuarioMapper;
    private CreateRoleUserService createRoleUserService;
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioService service, UsuarioMapper usuarioMapper,CreateRoleUserService createRoleUserService,
                             UsuarioRepository usuarioRepository) {
        this.service = service;
        this.usuarioMapper = usuarioMapper;
        this.createRoleUserService = createRoleUserService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping()
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioDto usuarioDto){

        Usuario usuario = usuarioMapper.toEntity(usuarioDto);

        ResponseEntity<UsuarioDto> CONFLICT = verificaSeJaTemUsuarioRegistradoPeloEmail(usuario);
        if (CONFLICT != null) return CONFLICT;

        usuario = this.service.cadastrar(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioMapper.toDto(usuario));

    }

    private ResponseEntity<UsuarioDto> verificaSeJaTemUsuarioRegistradoPeloEmail(Usuario usuario) {
        Usuario existeUsuario = service.findByemail(usuario);
        if (existeUsuario != null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(usuarioMapper.toDto(existeUsuario));
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> findById(@PathVariable Integer id) {
        Usuario usuario = this.service.findById(id);
        UsuarioDto usuarioDto = usuarioMapper.toDto(usuario);
        return ResponseEntity.ok(usuarioDto);
    }

    @GetMapping("/autenticacao")
    public  ResponseEntity<UsuarioDto> loginUsuario(@RequestParam String email){

        //Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        Usuario verificaUsuarioCadastrado = this.service.findByemail(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioMapper.toDto(verificaUsuarioCadastrado));

    }

    @PostMapping("/livros")
    public ResponseEntity<String> adicionaLivroNaListaDeLeitura(@RequestBody LivroSelecionadoParaLeituraDto livroSelecionado) {

        service.adicionaLivroNaListaDeLeitura(livroSelecionado);

        return ResponseEntity.status(HttpStatus.CREATED).body("Dados registrados com sucesso.");

    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    private ResponseEntity<Object> usuarioNaoExiste(UsuarioNaoEncontradoException exception){
        return ResponseEntity.status(NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(livroNaoEncontradoException.class)
    private ResponseEntity<Object> livroNaoEncontrado(livroNaoEncontradoException exception){
     return ResponseEntity.status(NOT_FOUND).body(exception.getMessage());
    }

    @PutMapping("/livrolido")
    public ResponseEntity<String> adicionaPontuacaoPorLivroLIdo(@RequestBody LivroSelecionadoParaLeituraDto livroFinalizadoLeitura){

        service.gerandoPontuacaoPorLeituraFinalizada(livroFinalizadoLeitura);
        return ResponseEntity.status(HttpStatus.CREATED).body("Dados registrados com sucesso.");
    }

    @ExceptionHandler(usuarioSemLivroNaListaDeLeituraException.class)
    private ResponseEntity<Object> livroNaoConstaNaListaDeLeitura(usuarioSemLivroNaListaDeLeituraException exception){
        return ResponseEntity.status(NOT_FOUND).body(exception.getMessage());
    }





}
