package com.dominio.biblioteca.repositorio;

import com.dominio.biblioteca.entidade.Livro;
import com.dominio.biblioteca.entidade.Vende;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BibliotecaRepositorio extends JpaRepository<Livro,Integer> {
        @Query("SELECT l FROM Livro l")
        List<Livro> obterLivros();
        @Query("select v from Vende v")
        List<Vende> obterVendas();
}

