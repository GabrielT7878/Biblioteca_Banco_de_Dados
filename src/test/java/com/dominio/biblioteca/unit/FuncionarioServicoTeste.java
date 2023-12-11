package com.dominio.biblioteca.unit;

import com.dominio.biblioteca.entidade.Funcionario;
import com.dominio.biblioteca.entidade.Livro;
import com.dominio.biblioteca.repositorio.EditoraRepositorio;
import com.dominio.biblioteca.repositorio.FuncionarioRepositorio;
import com.dominio.biblioteca.servico.EditoraServico;
import com.dominio.biblioteca.servico.FuncionarioServico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServicoTeste {
    @InjectMocks
    private FuncionarioServico servico;
    @Mock
    private FuncionarioRepositorio repositorio;

    @Test
    @DisplayName("#buscarTotalSalario > retorne o total de salarios")
    void buscarTotalSalarioRetorneOTotalDeSalarios() {
        when(repositorio.buscarTotalSalario()).thenReturn(100000.0);

        Double totalSalario = servico.buscarTotalSalario();

        assertEquals(totalSalario,100000.0);
    }

    @Test
    @DisplayName("#buscarFuncionarioSalarioMaiorQueX > Quando é passado valor positivo > Retornar maiores que esse valor")
    void buscarFuncionarioSalarioMaiorQueXValorPosRetornarMaioresQueVal() {
        when(repositorio.buscarFuncionarioSalarioMaiorQueX(50000.00)).thenReturn(List.of(
                Funcionario.builder()
                        .idPessoa(1)
                        .salario(99999.00)
                        .tempoNaEmpresa(1)
                        .build(),

                Funcionario.builder()
                        .idPessoa(2)
                        .salario(50000.01)
                        .tempoNaEmpresa(2)
                        .build())
        );
        List<Funcionario> funcionarios = servico.buscarFuncionarioSalarioMaiorQueX(50000.00);

        Assertions.assertAll(
                () -> assertEquals(1, funcionarios.get(0).getIdPessoa().intValue()),
                () -> assertEquals(99999.00,funcionarios.get(0).getSalario().doubleValue()),
                () -> assertEquals(1,funcionarios.get(0).getTempoNaEmpresa().intValue()),

                () -> assertEquals(2, funcionarios.get(1).getIdPessoa().intValue()),
                () -> assertEquals(50000.01,funcionarios.get(1).getSalario().doubleValue()),
                () -> assertEquals(2,funcionarios.get(1).getTempoNaEmpresa().intValue())
        );
    }

    @Test
    @DisplayName("#buscarFuncionarioSalarioMaiorQueX > Quando é passado valor negativo > Retornar todos")
    void buscarFuncionarioSalarioMaiorQueXValorNegRetornarTodos() {
        when(repositorio.buscarFuncionarioSalarioMaiorQueX(-1.00)).thenReturn(List.of(
                Funcionario.builder()
                        .idPessoa(1)
                        .salario(99999.00)
                        .tempoNaEmpresa(1)
                        .build(),

                Funcionario.builder()
                        .idPessoa(2)
                        .salario(0.01)
                        .tempoNaEmpresa(2)
                        .build())
        );
        List<Funcionario> funcionarios = servico.buscarFuncionarioSalarioMaiorQueX(-1.00);

        Assertions.assertAll(
                () -> assertEquals(1, funcionarios.get(0).getIdPessoa().intValue()),
                () -> assertEquals(99999.00,funcionarios.get(0).getSalario().doubleValue()),
                () -> assertEquals(1,funcionarios.get(0).getTempoNaEmpresa().intValue()),

                () -> assertEquals(2, funcionarios.get(1).getIdPessoa().intValue()),
                () -> assertEquals(0.01,funcionarios.get(1).getSalario().doubleValue()),
                () -> assertEquals(2,funcionarios.get(1).getTempoNaEmpresa().intValue())
        );
    }

    @Test
    @DisplayName("#buscarFuncionarioSalarioMaiorQueX > Quando é passado null > Retornar lista vazia")
    void buscarFuncionarioSalarioMaiorQueXValorNullRetornarListaVazia() {
        when(repositorio.buscarFuncionarioSalarioMaiorQueX(null)).thenReturn(List.of());

        List<Funcionario> funcionarios = servico.buscarFuncionarioSalarioMaiorQueX(null);

        Assertions.assertTrue(funcionarios.isEmpty());
    }

    @Test
    @DisplayName("#buscarFuncionarioTempoMaiorQueX > Quando é passado valor negativo > Retornar todos")
    void buscarFuncionarioTempoMaiorQueXValorPosRetornarMaioresQueVal() {
        when(repositorio.buscarFuncionarioTempoMaiorQueX(-1)).thenReturn(List.of(
                Funcionario.builder()
                        .idPessoa(1)
                        .salario(99999.00)
                        .tempoNaEmpresa(1)
                        .build(),

                Funcionario.builder()
                        .idPessoa(2)
                        .salario(0.01)
                        .tempoNaEmpresa(2)
                        .build())
        );
        List<Funcionario> funcionarios = servico.buscarFuncionarioTempoMaiorQueX(-1);

        Assertions.assertAll(
                () -> assertEquals(1, funcionarios.get(0).getIdPessoa().intValue()),
                () -> assertEquals(99999.00,funcionarios.get(0).getSalario().doubleValue()),
                () -> assertEquals(1,funcionarios.get(0).getTempoNaEmpresa().intValue()),

                () -> assertEquals(2, funcionarios.get(1).getIdPessoa().intValue()),
                () -> assertEquals(0.01,funcionarios.get(1).getSalario().doubleValue()),
                () -> assertEquals(2,funcionarios.get(1).getTempoNaEmpresa().intValue())
        );
    }

    @Test
    @DisplayName("#buscarFuncionarioSalarioMaiorQueAlgumTempoX > Quando é passado tempo negativo > Retornar todos")
    void buscarFuncionarioSalarioMaiorQueAlgumTempoXValorNegRetornarTodos() {
        when(repositorio.buscarFuncionarioSalarioMaiorQueAlgumTempoX(-1)).thenReturn(List.of(
                Funcionario.builder()
                        .idPessoa(1)
                        .salario(0.01)
                        .tempoNaEmpresa(1)
                        .build(),

                Funcionario.builder()
                        .idPessoa(2)
                        .salario(50000.00)
                        .tempoNaEmpresa(2)
                        .build())
        );
        List<Funcionario> funcionarios = servico.buscarFuncionarioSalarioMaiorQueAlgumTempoX(-1);

        Assertions.assertAll(
                () -> assertEquals(1, funcionarios.get(0).getIdPessoa().intValue()),
                () -> assertEquals(0.01,funcionarios.get(0).getSalario().doubleValue()),
                () -> assertEquals(1,funcionarios.get(0).getTempoNaEmpresa().intValue()),

                () -> assertEquals(2, funcionarios.get(1).getIdPessoa().intValue()),
                () -> assertEquals(50000.00,funcionarios.get(1).getSalario().doubleValue()),
                () -> assertEquals(2,funcionarios.get(1).getTempoNaEmpresa().intValue())
        );
    }

}
