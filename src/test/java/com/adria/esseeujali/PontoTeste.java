package com.adria.esseeujali;

import com.adria.esseeujali.dto.LivroDto;
import com.adria.esseeujali.dto.UsuarioDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PontoTeste {

    @Test
    void retonar1PontoParaOUsuario(){
        UsuarioDto usuarioDto = new UsuarioDto(1,"Adria Aline","adria.aline@gmail.com","123");
        LivroDto livroDto = new LivroDto(1,"Jhon Lenon",200,"Amanhecer");

        boolean livroLido;


        //assertEquals(true,livroLido);

    }
}
