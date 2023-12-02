package com.dominio.biblioteca.servico;

import com.dominio.biblioteca.entidade.Livro;
import com.dominio.biblioteca.repositorio.LivroRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BibliotecaServico {
    private final LivroRepositorio repositorio;
    public List<Livro> obterTodosLivros(){
        return repositorio.findAll();
    }
}
