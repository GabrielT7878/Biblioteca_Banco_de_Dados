package com.dominio.biblioteca.repositorio;

import com.dominio.biblioteca.entidade.Funcionario;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.tree.RowMapper;
import java.util.List;

@Repository
public interface FuncionarioRepositorio extends JpaRepository<Funcionario,Integer> {
    @Query("select l from Funcionario l")
    List<Funcionario> obterFuncionarios();
}
