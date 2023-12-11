package com.dominio.biblioteca.unit;

import com.dominio.biblioteca.entidade.Editora;
import com.dominio.biblioteca.repositorio.ClienteRepositorio;
import com.dominio.biblioteca.repositorio.EditoraRepositorio;
import com.dominio.biblioteca.servico.ClienteServico;
import com.dominio.biblioteca.servico.EditoraServico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AbstractSoftAssertions.assertAll;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EditoraServicoTeste {
    @InjectMocks
    private EditoraServico servico;
    @Mock
    private EditoraRepositorio repositorio;

    @Test
    @DisplayName("#ordenarEditorasPorNome > retorne lista de editoras ordenadas por nome")
    void ordenarEditorasPorNomeRetorneListaDeEditorasOrdenadasPorNome() {
        when(repositorio.ordenarEditorasPorNome()).thenReturn(List.of(
                Editora.builder()
                .idEditora(1)
                .nome("Atlas")
                .nomeGerente("James Rodrigues")
                .cnpj("123456874")
                .build(),

                Editora.builder()
                .idEditora(2)
                .nome("Baiser")
                .nomeGerente("Hamilton Tadeu")
                .cnpj("213456789")
                .build()));

        List<Editora> editoras = servico.ordenarEditorasPorNome();

        Assertions.assertAll(
                () -> assertEquals(1, editoras.get(0).getIdEditora().intValue()),
                () -> assertEquals("Atlas",editoras.get(0).getNome()),
                () -> assertEquals("James Rodrigues",editoras.get(0).getNomeGerente()),
                () -> assertEquals("123456874",editoras.get(0).getCnpj()),

                () -> assertEquals(2, editoras.get(1).getIdEditora().intValue()),
                () -> assertEquals("Baiser",editoras.get(1).getNome()),
                () -> assertEquals("Hamilton Tadeu",editoras.get(1).getNomeGerente()),
                () -> assertEquals("213456789",editoras.get(1).getCnpj())

        );
    }

    @Test
    @DisplayName("#encontrarEditoraPorGerente > quando o nome for vazio > retorne lista vazia")
    void encontrarEditoraPorGerenteQuandoONomeForVazioRetorneListaVazia() {
        List editoras = new ArrayList<Editora>();
        when(repositorio.encontrarEditoraPorGerente("")).thenReturn(editoras);

        List<Editora> editora = servico.encontrarEditoraPorGerente("");

        Assertions.assertTrue(editora.isEmpty());

    }

    @Test
    @DisplayName("#ordenarEditorasPorCNPJ > retorne as editoras ordenadas por cnpj")
    void ordenarEditorasPorCnpjRetorneAsEditorasOrdenadasPorCnpj() {
        when(repositorio.ordenarEditorasPorCNPJ()).thenReturn(List.of(
                Editora.builder()
                        .idEditora(1)
                        .nome("Atlas")
                        .nomeGerente("Ricardo Fonseca")
                        .cnpj("0231548941")
                        .build(),

                Editora.builder()
                        .idEditora(2)
                        .nome("Erase")
                        .nomeGerente("Laeu Osmar")
                        .cnpj("798846512510")
                        .build()));

        List<Editora> editoras = servico.ordenarEditorasPorCNPJ();

        Assertions.assertAll(
                ()-> assertEquals(editoras.get(0).getCnpj(),"0231548941"),
                ()-> assertEquals(editoras.get(1).getCnpj(),"798846512510")
        );


    }




}
