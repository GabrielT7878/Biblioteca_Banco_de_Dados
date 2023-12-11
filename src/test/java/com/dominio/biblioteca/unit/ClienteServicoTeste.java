package com.dominio.biblioteca.unit;

import com.dominio.biblioteca.entidade.Cliente;
import com.dominio.biblioteca.entidade.Livro;
import com.dominio.biblioteca.entidade.TelefonesE;
import com.dominio.biblioteca.entidade.TelefonesP;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;
import static org.springframework.test.util.AssertionErrors.assertTrue;

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
    @DisplayName("#buscarClienteSaldoMaiorQueX > quando o valor é 50 > retornar clientes com saldo maior que 50 ")
    void buscarClienteSaldoMaiorQueXQuandoOValorÉ50RetornarClientesComSaldoMaiorQue50() {
        when(repositorio.buscarClientesSaldoMaiorQueX(50.0)).thenReturn(
                List.of(
                        Cliente.builder().
                        saldo(60.0).
                        build(),
                        Cliente.builder().
                        saldo(500.0).
                        build()
                )
        );

        List<Cliente> clientes = servico.buscarClienteSaldoMaiorQueX(50.0);

        assertAll(
                ()->assertEquals(clientes.size(),2),
                ()->assertEquals(clientes.get(0).getSaldo().doubleValue(),60.0),
                ()->assertEquals(clientes.get(1).getSaldo().doubleValue(),500.0)
        );
    }
    
    
    @Test
    @DisplayName("#ordenarPorSaldo > retornar os clientes ordenados por saldo")
    void ordenarPorSaldoRetornarOsClientesOrdenadosPorSaldo() {
        when(repositorio.ordenarPorSaldo()).thenReturn(
                List.of(
                        Cliente.builder().
                                saldo(60.0).
                                build(),
                        Cliente.builder().
                                saldo(500.0).
                                build()
                )
        );

        List<Cliente> clientes = servico.ordenarPorSaldo();

        assertAll(
                () -> assertEquals(clientes.size(), 2),
                () -> assertEquals(clientes.get(0).getSaldo().doubleValue(), 60.0),
                () -> assertEquals(clientes.get(1).getSaldo().doubleValue(), 500.0)
        );

    }
    
//      public Integer buscarTotalClientes(){return repositorio.buscarTotalClientes();}
    
    @Test
    @DisplayName("#buscarTotalClientes > retorne a quantidade total de clientes")
    void buscarTotalClientesRetorneAQuantidadeTotalDeClientes() {
        when(repositorio.buscarTotalClientes()).thenReturn(10);

        assertEquals(servico.buscarTotalClientes(),10);
    }
}

