package com.dominio.biblioteca.repositorio;

import com.dominio.biblioteca.controlador.EditoraControlador;
import com.dominio.biblioteca.entidade.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EditoraRepositorio extends JpaRepository<Editora,Integer> {
    @Query("select e from Editora e")
    List<Editora> obterEditoras();
}
