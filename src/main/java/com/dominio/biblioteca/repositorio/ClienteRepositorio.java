package com.dominio.biblioteca.repositorio;

import com.dominio.biblioteca.entidade.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository<Cliente,Integer> {

}
