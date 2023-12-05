package com.dominio.biblioteca.repositorio;

import com.dominio.biblioteca.entidade.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepositorio extends JpaRepository<Pessoa,Integer> {
}
