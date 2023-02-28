package com.adria.esseeujali.service;

import com.adria.esseeujali.dto.LivroSelecionadoParaLeituraDto;
import com.adria.esseeujali.exception.PontuacaoJaGeradaParaEsteLivroException;
import com.adria.esseeujali.exception.usuarioSemLivroNaListaDeLeituraException;
import com.adria.esseeujali.exception.UsuarioNaoEncontradoException;
import com.adria.esseeujali.exception.livroNaoEncontradoException;
import com.adria.esseeujali.model.Livro;
import com.adria.esseeujali.model.LivroSelecionado;
import com.adria.esseeujali.model.LivroSelecionadoParaLeitura;
import com.adria.esseeujali.model.Usuario;
import com.adria.esseeujali.repository.LivroRepository;
import com.adria.esseeujali.repository.LivroSelecionadoParaLeituraRepository;
import com.adria.esseeujali.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    private LivroSelecionadoParaLeituraRepository livroSelecionadoParaLeitura;
    private LivroRepository livroRepository;


    public UsuarioService(UsuarioRepository usuarioRepository, LivroSelecionadoParaLeituraRepository livroSelecionadoRepository, LivroRepository livroRepository) {
        this.usuarioRepository = usuarioRepository;
        this.livroSelecionadoParaLeitura = livroSelecionadoRepository;
        this.livroRepository = livroRepository;
    }

    public Usuario cadastrar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario findBynome(Usuario usuario){
        return usuarioRepository.findBynome(usuario.getNome());
    }

    public Usuario findByemail(Usuario usuario){
        return usuarioRepository.findByemail(usuario.getEmail());
    }

    public Usuario findById(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException());
    }


    public void adicionaLivroNaListaDeLeitura(LivroSelecionadoParaLeituraDto lista) {

        validaCadastroDoUsuarioCom( lista.getIdUsuario());
        validaCadatroDoLivro(lista.getIdLivro());

        LivroSelecionado livroSelecionadoPk = new LivroSelecionado(lista.getIdUsuario(),lista.getIdLivro());
        LivroSelecionadoParaLeitura selecionado = new LivroSelecionadoParaLeitura(livroSelecionadoPk,false);

        livroSelecionadoParaLeitura.save(selecionado);

    }

    private void validaCadatroDoLivro(Integer codigoLivro) {
        livroRepository.findById(codigoLivro).orElseThrow(() -> new livroNaoEncontradoException());
    }

    private void validaCadastroDoUsuarioCom(Integer codigoUsuario) {
        usuarioRepository.findById(codigoUsuario).orElseThrow(() ->  new UsuarioNaoEncontradoException());
    }

    public void gerandoPontuacaoPorLeituraFinalizada(LivroSelecionadoParaLeituraDto lista){


        //verifica se existe o livro na lista de leitura do usuario.
        LivroSelecionado livroSelecionadoPk = new LivroSelecionado(lista.getIdUsuario(),lista.getIdLivro());
        LivroSelecionadoParaLeitura selecionado =
                livroSelecionadoParaLeitura.findById(livroSelecionadoPk).orElseThrow(() -> new usuarioSemLivroNaListaDeLeituraException());

        if(selecionado.getLido() == true){
            throw new PontuacaoJaGeradaParaEsteLivroException();
        }
        //retorna o livro marcado como lido
        Livro livro = livroRepository.findById(lista.getIdLivro());
        double paginasDoLivro = livro.getPaginas();
        double verificaCentena = paginasDoLivro/100;
        DecimalFormat formato = new DecimalFormat("#");
        verificaCentena= Double.valueOf(formato.format(verificaCentena));
         int ponto=1;
         ponto+= verificaCentena;

       //salva pontos na lista de livro de leitura do usuario
        selecionado.setLido(lista.isLido());
        selecionado.setPontuacao(ponto);
        livroSelecionadoParaLeitura.save(selecionado);

    }


}
