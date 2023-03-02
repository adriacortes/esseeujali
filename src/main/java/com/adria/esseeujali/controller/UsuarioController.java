package com.adria.esseeujali.controller;

import com.adria.esseeujali.dto.LivroSelecionadoParaLeituraDto;
import com.adria.esseeujali.dto.UsuarioDto;
import com.adria.esseeujali.exception.PontuacaoJaGeradaParaEsteLivroException;
import com.adria.esseeujali.exception.UsuarioNaoEncontradoException;
import com.adria.esseeujali.exception.UsuarioSemLivroNaListaDeLeituraException;
import com.adria.esseeujali.exception.livroNaoEncontradoException;
import com.adria.esseeujali.mapper.UsuarioMapper;
import com.adria.esseeujali.model.LivroSelecionadoParaLeitura;
import com.adria.esseeujali.model.RankingPontuacao;
import com.adria.esseeujali.model.Trofeu;
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

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@CrossOrigin("*")
@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private UsuarioService service;
    private UsuarioMapper usuarioMapper;
    private CreateRoleUserService createRoleUserService;
    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioService service, UsuarioMapper usuarioMapper, CreateRoleUserService createRoleUserService,
                             UsuarioRepository usuarioRepository) {
        this.service = service;
        this.usuarioMapper = usuarioMapper;
        this.createRoleUserService = createRoleUserService;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping()
    public ResponseEntity<UsuarioDto> cadastrar(@RequestBody UsuarioDto usuarioDto) {

        Usuario usuario = usuarioMapper.toEntity(usuarioDto);

        ResponseEntity<UsuarioDto> CONFLICT = verificaSeJaTemUsuarioRegistradoPeloEmail(usuario);
        if (CONFLICT != null) return CONFLICT;

        usuario = this.service.cadastrar(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioMapper.toDto(usuario));

    }

    private ResponseEntity<UsuarioDto> verificaSeJaTemUsuarioRegistradoPeloEmail(Usuario usuario) {
        Usuario existeUsuario = service.findByemail(usuario);
        if (existeUsuario != null) {
            existeUsuario.setId(0);
            existeUsuario.setEmail("Jà existe um usuario com esse email");
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
    public ResponseEntity<UsuarioDto> loginUsuario(@RequestParam String email) {

        //Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        Usuario verificaUsuarioCadastrado = this.service.findByemail(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(usuarioMapper.toDto(verificaUsuarioCadastrado));

    }

    @PostMapping("/livros")
    public ResponseEntity<String> adicionaLivroNaListaDeLeitura(@RequestBody LivroSelecionadoParaLeitura livroSelecionado) {

        service.adicionaLivroNaListaDeLeitura(livroSelecionado);

        return ResponseEntity.status(HttpStatus.CREATED).body("Dados registrados com sucesso.");

    }

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    private ResponseEntity<Object> usuarioNaoExiste(UsuarioNaoEncontradoException exception) {
        return ResponseEntity.status(NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(livroNaoEncontradoException.class)
    private ResponseEntity<Object> livroNaoEncontrado(livroNaoEncontradoException exception) {
        return ResponseEntity.status(NOT_FOUND).body(exception.getMessage());
    }

    @PutMapping("/{idUsuario}/livrolido/{idLivro}")
    public ResponseEntity<String> alterarLivroDaListaDoUsuarioComoLido(@PathVariable Integer idUsuario,
                                                                       @PathVariable Integer idLivro,
                                                                       @RequestBody LivroSelecionadoParaLeituraDto livroFinalizadoLeitura) {

        service.marcaLivroComoLidoGerandoPontuacao(idUsuario, idLivro, livroFinalizadoLeitura);
        return ResponseEntity.status(HttpStatus.OK).body("Dados registrados com sucesso.");
    }

    @ExceptionHandler(UsuarioSemLivroNaListaDeLeituraException.class)
    private ResponseEntity<Object> livroNaoConstaNaListaDeLeitura(UsuarioSemLivroNaListaDeLeituraException exception) {
        return ResponseEntity.status(NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(PontuacaoJaGeradaParaEsteLivroException.class)
    private ResponseEntity<Object> pontuacaoJaGeradaParaEsteLivro(PontuacaoJaGeradaParaEsteLivroException exception) {
        return ResponseEntity.status(BAD_REQUEST).body(exception.getMessage());
    }

    @GetMapping("/{id}/areadousuario/trofeus")
    public ResponseEntity<List<Trofeu>> adicionaarTrofeuAoUsuario(@PathVariable int id) {
        List<Trofeu> listaTrofeus;
        listaTrofeus = service.retornarTrofeuDeUsuario(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(listaTrofeus);
    }

    @GetMapping("/{id}/areadousuario")
    public ResponseEntity<Integer> pontuacaoDeUmUsuarioEspecifico(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.retornarPontosDoUsuario(id));
    }

    @GetMapping("/{id}/areadousuario/ranking")
    public ResponseEntity<List<RankingPontuacao>> pontuacaoGeralDeTodosOsUsuarios() {
        List<RankingPontuacao> rankingGeral = service.retornarPontoDosUsuarios();
        return ResponseEntity.status(HttpStatus.CREATED).body(rankingGeral);
    }


}
