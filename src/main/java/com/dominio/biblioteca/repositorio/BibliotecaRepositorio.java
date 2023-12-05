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


        // encontrar livros com quantidade maior que x
        @Query("select l from Livro as l where l.quantidade > :x")
        List<Livro> buscarLivrosQuantidadeMaiorQueX(Integer x);

        // (Exemplo de Renomeação) encontrar livros que foram vendidos por clientes com saldo negativo
        @Query("select l from Livro as l, Vende as v, Cliente as c where l.id = v.livroId and v.pessoaId = c.idPessoa and c.saldo < 0")
        List<Livro> buscarLivrosSaldoNegativo();

        // (Exemplo de Funções Agregadas) encontrar quantidade total de livros
        @Query("select sum(l.quantidade) from Livro l")
        Integer buscarQuantidadeTotalLivros();

        // (Exemplo de Ordenação) Ordenar livros por nome
        @Query("select l from Livro l order by l.nome")
        List<Livro> ordernarLivrosPorNome();

        // (Exemplo de Ordenação) Ordenar livros por editora
        @Query("select l from Livro l order by l.editora.nome")
        List<Livro> ordernarLivrosPorEditora();

        // (Exemplo de Ordenação) Ordenar livros por autor
        @Query("select l from Livro l order by l.autor")
        List<Livro> ordernarLivrosPorAutor();

        // (Exemplo de operação de Conjunto) Encontrar o nome de livros que foram vendidos e não foram comprados
        @Query("select distinct l from Livro l, Vende v where l.id = v.livroId except select distinct l from Livro l, Compra c where l.id = c.livroId order by l.nome")
        List<Livro> buscarLivrosVendidosNaoComprados();
}

