package com.adria.esseeujali.service;

import com.adria.esseeujali.dto.LivroSelecionadoParaLeituraDto;
import com.adria.esseeujali.exception.LivroNaoEncontradoException;
import com.adria.esseeujali.exception.UsuarioNaoEncontradoException;
import com.adria.esseeujali.model.LivroSelecionado;
import com.adria.esseeujali.model.LivroSelecionadoParaLeitura;
import com.adria.esseeujali.model.Usuario;
import com.adria.esseeujali.repository.LivroRepository;
import com.adria.esseeujali.repository.LivroSelecionadoParaLeituraRepository;
import com.adria.esseeujali.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    private LivroSelecionadoParaLeituraRepository livroSelecionadoRepository;
    private LivroRepository livroRepository;

    public UsuarioService(UsuarioRepository usuarioRepository, LivroSelecionadoParaLeituraRepository livroSelecionadoRepository, LivroRepository livroRepository) {
        this.usuarioRepository = usuarioRepository;
        this.livroSelecionadoRepository = livroSelecionadoRepository;
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

        LivroSelecionado livroSelecionado = new LivroSelecionado(lista.getIdUsuario(),lista.getIdLivro());
        LivroSelecionadoParaLeitura selecionado = new LivroSelecionadoParaLeitura(livroSelecionado,false);

        livroSelecionadoRepository.save(selecionado);

    }

    private void validaCadatroDoLivro(Integer codigoLivro) {
        livroRepository.findById(codigoLivro).orElseThrow(() -> new LivroNaoEncontradoException());
    }

    private void validaCadastroDoUsuarioCom(Integer codigoUsuario) {
        usuarioRepository.findById(codigoUsuario).orElseThrow(() ->  new UsuarioNaoEncontradoException());
    }
}
