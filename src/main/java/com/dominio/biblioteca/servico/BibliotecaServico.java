package com.dominio.biblioteca.servico;

import com.dominio.biblioteca.entidade.Livro;
import com.dominio.biblioteca.entidade.Vende;
import com.dominio.biblioteca.repositorio.BibliotecaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BibliotecaServico {
    private final BibliotecaRepositorio repositorio;
    public List<Livro> obterTodosLivros(){
        return repositorio.obterLivros();
    }

    public List<Vende> obterVendas(){
        return repositorio.obterVendas();
    }
}
