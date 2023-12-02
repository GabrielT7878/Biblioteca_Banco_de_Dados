package com.dominio.biblioteca.repositorio;

import com.dominio.biblioteca.entidade.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepositorio extends JpaRepository<Livro,Integer> {

}

