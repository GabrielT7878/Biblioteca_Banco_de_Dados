package com.dominio.biblioteca.unit;

import com.dominio.biblioteca.repositorio.EditoraRepositorio;
import com.dominio.biblioteca.servico.EditoraServico;
import com.dominio.biblioteca.servico.FuncionarioServico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FuncionarioServicoTeste {
    @InjectMocks
    private FuncionarioServico servico;
    @Mock
    private FuncionarioServico repositorio;

    @Test
    @DisplayName("buscarTotalSalario > retorne o total de salarios")
    void buscarTotalSalarioRetorneOTotalDeSalarios() {

    }

}
