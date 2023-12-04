package com.dominio.biblioteca.repositorio;

import com.dominio.biblioteca.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> {
    @Query("select c from Cliente c")
    List<Cliente> obterClientes();
}
