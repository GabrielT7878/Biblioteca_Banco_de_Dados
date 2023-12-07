package com.dominio.biblioteca.unit;

import com.dominio.biblioteca.repositorio.BibliotecaRepositorio;
import com.dominio.biblioteca.repositorio.ClienteRepositorio;
import com.dominio.biblioteca.repositorio.PessoaRepositorio;
import com.dominio.biblioteca.repositorio.TelefonePRepositorio;
import com.dominio.biblioteca.servico.BibliotecaServico;
import com.dominio.biblioteca.servico.ClienteServico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServicoTeste {
    @InjectMocks
    private ClienteServico servico;
    @Mock
    private ClienteRepositorio repositorio;
    @Mock
    private PessoaRepositorio pessoaRepositorio;
    @Mock
    private TelefonePRepositorio telefonePRepositorio;

    @Test
    @DisplayName("cadastrarCliente > Quando o nome é nulo > retorne falso")
    void cadastrarClienteQuandoONomeÉNuloRetorneFalso() {
        assertFalse(servico.cadastrarCliente(null,"rodrigues","123456789","33265664"));
    }

}
