package com.dominio.biblioteca.repositorio;

import com.dominio.biblioteca.controlador.EditoraControlador;
import com.dominio.biblioteca.entidade.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EditoraRepositorio extends JpaRepository<Editora,Integer> {
    @Query("select e from Editora e")
    List<Editora> obterEditoras();

    @Query("select e from Editora e where e.idEditora = :id")
    Editora adicionarTelefone(Integer id);

    // encontrar editoras com gerente chamado [nome]
    @Query("select e from Editora e where e.nomeGerente = :nome")
    List<Editora> encontrarEditoraPorGerente(String nome);

    // (exemplo de ordenação) ordenar editoras por nome
    @Query("select e from Editora e order by e.nome")
    List<Editora> ordenarEditorasPorNome();

    // (exemplo de ordenação) ordenar editoras por cidade
    @Query("select e from Editora e order by e.endereco.cidade")
    List<Editora> ordenarEditorasPorCidade();

    // (exemplo de ordenação) ordenar editoras por cnpj
    @Query("select e from Editora e order by e.cnpj")
    List<Editora> ordenarEditorasPorCNPJ();

}
