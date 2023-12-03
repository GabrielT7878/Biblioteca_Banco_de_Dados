package com.dominio.biblioteca.repositorio;

import com.dominio.biblioteca.entidade.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivroRepositorio extends JpaRepository<Livro,Integer> {
        @Query("SELECT l FROM Livro l")
        List<Livro> obterLivros();
}

