package com.dominio.biblioteca.servico;


import com.dominio.biblioteca.entidade.Cliente;
import com.dominio.biblioteca.repositorio.ClienteRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteServico {
    private final ClienteRepositorio repositorio;
    public List<Cliente> obterClientes(){
        return repositorio.obterClientes();
    }

    public List<Cliente> buscarCliente(String nome){
        return repositorio.buscarCliente(nome);
    }
}
