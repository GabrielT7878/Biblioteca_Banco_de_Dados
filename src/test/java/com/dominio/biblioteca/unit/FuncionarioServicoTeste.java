package com.dominio.biblioteca.unit;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServicoTeste {
    @InjectMocks
    private FuncionarioServico servico;
    @Mock
    private FuncionarioRepositorio repositorio;

    @Test
    @DisplayName("buscarTotalSalario > retorne o total de salarios")
    void buscarTotalSalarioRetorneOTotalDeSalarios() {
        when(repositorio.buscarTotalSalario()).thenReturn(100000.0);

        Double totalSalario = servico.buscarTotalSalario();

        assertEquals(totalSalario,100000.0);
    }

}
