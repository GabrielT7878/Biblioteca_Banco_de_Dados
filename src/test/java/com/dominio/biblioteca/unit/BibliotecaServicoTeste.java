package com.dominio.biblioteca.unit;


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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BibliotecaServicoTeste {
    @InjectMocks
    private BibliotecaServico servico;

    @Mock
    private BibliotecaRepositorio repositorio;

    @Test
    @DisplayName("removerLivro > Quando um livro não existe > retorne falso")
    void removerLivroQuandoUmLivroNãoExisteRetorneUmaExceção() {
        when(repositorio.findById(1)).thenReturn(Optional.empty());
        assertFalse(
                ()-> servico.removerLivro(1)
        );
    }
}
