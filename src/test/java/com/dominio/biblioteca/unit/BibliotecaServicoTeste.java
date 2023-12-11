package com.dominio.biblioteca.unit;


import com.dominio.biblioteca.entidade.Editora;
import com.dominio.biblioteca.entidade.Livro;
import com.dominio.biblioteca.repositorio.BibliotecaRepositorio;
import com.dominio.biblioteca.servico.BibliotecaServico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BibliotecaServicoTeste {
    @InjectMocks
    private BibliotecaServico servico;

    @Mock
    private BibliotecaRepositorio repositorio;

    @Test
    @DisplayName("#buscarLivroQuantidadeMaiorQueX > Quando é passado valor 50 > Retornar maiores que 50")
    void buscarLivroQuantidadeMaiorQueXValor50RetornarMaioresQue50() {
        when(repositorio.buscarLivrosQuantidadeMaiorQueX(50)).thenReturn(List.of(
                Livro.builder()
                        .id(1)
                        .nome("Teste")
                        .autor("Fulano")
                        .categoria("XXX")
                        .quantidade(51)
                        .isbn("1234567")
                        .build(),

                Livro.builder()
                        .id(2)
                        .nome("Teste2")
                        .autor("Ciclano")
                        .categoria("YYY")
                        .quantidade(100)
                        .isbn("7654321")
                        .build())
        );
        List<Livro> livros = servico.buscarLivrosQuantidadeMaiorQueX(50);

        Assertions.assertAll(
                () -> assertEquals(1, livros.get(0).getId().intValue()),
                () -> assertEquals("Teste",livros.get(0).getNome()),
                () -> assertEquals("Fulano",livros.get(0).getAutor()),
                () -> assertEquals("XXX",livros.get(0).getCategoria()),
                () -> assertEquals(51,livros.get(0).getQuantidade().intValue()),
                () -> assertEquals("1234567",livros.get(0).getIsbn()),

                () -> assertEquals(2, livros.get(1).getId().intValue()),
                () -> assertEquals("Teste2",livros.get(1).getNome()),
                () -> assertEquals("Ciclano",livros.get(1).getAutor()),
                () -> assertEquals("YYY",livros.get(1).getCategoria()),
                () -> assertEquals(100,livros.get(1).getQuantidade().intValue()),
                () -> assertEquals("7654321",livros.get(1).getIsbn())
        );
    }

    @Test
    @DisplayName("#buscarLivroQuantidadeMaiorQueX > Quando é passado valor negativo > Retornar todos")
    void buscarLivroQuantidadeMaiorQueXTemQuantidadeRetornarTodos() {
        when(repositorio.buscarLivrosQuantidadeMaiorQueX(-10)).thenReturn(List.of(
                Livro.builder()
                        .id(1)
                        .nome("Teste")
                        .autor("Fulano")
                        .categoria("XXX")
                        .quantidade(30)
                        .isbn("1234567")
                        .build(),

                Livro.builder()
                        .id(2)
                        .nome("Teste2")
                        .autor("Ciclano")
                        .categoria("YYY")
                        .quantidade(80)
                        .isbn("7654321")
                        .build())
        );
        List<Livro> livros = servico.buscarLivrosQuantidadeMaiorQueX(-10);

        Assertions.assertAll(
                () -> assertEquals(1, livros.get(0).getId().intValue()),
                () -> assertEquals("Teste",livros.get(0).getNome()),
                () -> assertEquals("Fulano",livros.get(0).getAutor()),
                () -> assertEquals("XXX",livros.get(0).getCategoria()),
                () -> assertEquals(30,livros.get(0).getQuantidade().intValue()),
                () -> assertEquals("1234567",livros.get(0).getIsbn()),

                () -> assertEquals(2, livros.get(1).getId().intValue()),
                () -> assertEquals("Teste2",livros.get(1).getNome()),
                () -> assertEquals("Ciclano",livros.get(1).getAutor()),
                () -> assertEquals("YYY",livros.get(1).getCategoria()),
                () -> assertEquals(80,livros.get(1).getQuantidade().intValue()),
                () -> assertEquals("7654321",livros.get(1).getIsbn())
        );
    }

    @Test
    @DisplayName("#buscarLivroQuantidadeMaiorQueX > Quando é passado null > Retornar lista vazia")
    void buscarLivroQuantidadeMaiorQueXPassadoLetraRetornarListaVazia() {
        when(repositorio.buscarLivrosQuantidadeMaiorQueX(null)).thenReturn(List.of());

        List<Livro> livros = servico.buscarLivrosQuantidadeMaiorQueX(null);

        Assertions.assertTrue(livros.isEmpty());
    }

}
