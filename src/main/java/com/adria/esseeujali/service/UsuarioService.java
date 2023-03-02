package com.adria.esseeujali.service;

import com.adria.esseeujali.dto.LivroSelecionadoParaLeituraDto;
import com.adria.esseeujali.exception.PontuacaoJaGeradaParaEsteLivroException;
import com.adria.esseeujali.exception.UsuarioNaoEncontradoException;
import com.adria.esseeujali.exception.UsuarioSemLivroNaListaDeLeituraException;
import com.adria.esseeujali.exception.livroNaoEncontradoException;
import com.adria.esseeujali.model.Livro;
import com.adria.esseeujali.model.LivroSelecionadoPK;
import com.adria.esseeujali.model.LivroSelecionadoParaLeitura;
import com.adria.esseeujali.model.Trofeu;
import com.adria.esseeujali.model.Usuario;
import com.adria.esseeujali.repository.LivroRepository;
import com.adria.esseeujali.repository.LivroSelecionadoParaLeituraRepository;
import com.adria.esseeujali.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    private LivroSelecionadoParaLeituraRepository livroSelecionadoParaLeituraRepository;
    private LivroRepository livroRepository;

    private LivroService livroService;


    public UsuarioService(UsuarioRepository usuarioRepository, LivroSelecionadoParaLeituraRepository livroSelecionadoRepository, LivroRepository livroRepository,
                          LivroService livroService) {
        this.usuarioRepository = usuarioRepository;
        this.livroSelecionadoParaLeituraRepository = livroSelecionadoRepository;
        this.livroRepository = livroRepository;
        this.livroService = livroService;

    }

    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario findBynome(Usuario usuario) {
        return usuarioRepository.findBynome(usuario.getNome());
    }

    public Usuario findByemail(Usuario usuario) {
        return usuarioRepository.findByemail(usuario.getEmail());
    }

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException());
    }


    public void adicionaLivroNaListaDeLeitura(LivroSelecionadoParaLeitura lista) {

        validaCadastroDoUsuarioCom(lista.livroSelecionadoPk.getUsuarioId());
        validaCadatroDoLivro(lista.livroSelecionadoPk.getLivroId());

        Usuario usuario = findById(lista.livroSelecionadoPk.getUsuarioId());
        Livro livro = livroService.findById(lista.livroSelecionadoPk.getLivroId());

        lista.setUsuario(usuario);
        lista.setLivro(livro);

        livroSelecionadoParaLeituraRepository.save(lista);

    }

    private void validaCadatroDoLivro(Integer codigoLivro) {
        livroRepository.findById(codigoLivro).orElseThrow(() -> new livroNaoEncontradoException());
    }

    private void validaCadastroDoUsuarioCom(Integer codigoUsuario) {
        usuarioRepository.findById(codigoUsuario).orElseThrow(() -> new UsuarioNaoEncontradoException());
    }

    public void marcaLivroComoLidoGerandoPontuacao(Integer idUsuario, Integer idLivro, LivroSelecionadoParaLeituraDto lista) {

        LivroSelecionadoParaLeitura livroSelecionadoParaLeitura =
                livroSelecionadoParaLeituraRepository.findById
                                (new LivroSelecionadoPK(idUsuario, idLivro))
                        .orElseThrow(UsuarioSemLivroNaListaDeLeituraException::new);

        verificaSeLivroJaFoiLido(livroSelecionadoParaLeitura);


        int ponto = geraPontuacao(idLivro);

        livroSelecionadoParaLeitura.setLido(lista.isLido());
        livroSelecionadoParaLeitura.setPontuacao(ponto);
        livroSelecionadoParaLeituraRepository.save(livroSelecionadoParaLeitura);
    }

    private int geraPontuacao(Integer idLivro) {
        Livro livro = livroService.findById(idLivro);
        int paginasDoLivro = livro.getPaginas();
        int verificaCentena = paginasDoLivro / 100;
        int ponto = 1;
        ponto += verificaCentena;
        return ponto;
    }

    private static void verificaSeLivroJaFoiLido(LivroSelecionadoParaLeitura livroSelecionadoParaLeitura) {
        if (livroSelecionadoParaLeitura.jaLido()) {
            throw new PontuacaoJaGeradaParaEsteLivroException();
        }
    }

    public List<Trofeu> retornarTrofeuDeUsuario(int id) {
        List<Trofeu> listaTrofeus;
        listaTrofeus = livroSelecionadoParaLeituraRepository.buscarTrofeuDoUsuario(id);

        return listaTrofeus;
    }

    public Integer retornarPontosDoUsuario(int id) {
        return livroSelecionadoParaLeituraRepository.buscarPontosUsuario(id);
    }
}
