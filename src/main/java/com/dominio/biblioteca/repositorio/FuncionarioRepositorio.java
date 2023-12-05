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

    // Encontrar funcionarios com salario maior que X
    @Query("select f from Funcionario f where f.salario > :x")
    List<Funcionario> buscarFuncionarioSalarioMaiorQueX(Double x);

    // Encontrar funcionarios com tempo na empresa maior que X
    @Query("select f from Funcionario f where f.tempoNaEmpresa > :x")
    List<Funcionario> buscarFuncionarioTempoMaiorQueX(Integer x);

    // (Exemplo de função agregada) Encontrar media de salario dos funcionarios
    @Query("select avg(f.salario) from Funcionario f")
    Double buscarMediaSalario();

    // (Exemplo de função agregada) Encontrar total de salario dos funcionarios
    @Query("select sum(f.salario) from Funcionario f")
    Double buscarTotalSalario();

    // (Exemplo de ordenação) Ordenar funcionarios por nome
    @Query("select f from Funcionario f order by f.pessoa.nome")
    List<Funcionario> ordenarFuncionariosPorNome();

    // (Exemplo de ordenação) Ordenar funcionarios por salário em ordem descendente
    @Query("select f from Funcionario f order by f.salario desc")
    List<Funcionario> ordenarFuncionariosPorSalarioDesc();

    // (Exemplo de ordenação) Ordenar funcionarios por salário em ordem crescente
    @Query("select f from Funcionario f order by f.salario asc")
    List<Funcionario> ordenarFuncionariosPorSalarioCres();

    // (Exemplo de operação de multiconjunto) Encontrar funcionarios que possuem salario maior que qualquer funcionario
    // com tempo na empresa maior que x
    @Query("select f from Funcionario f where f.salario > any (select f.salario from Funcionario f where f.tempoNaEmpresa > :x)")
    List<Funcionario> buscarFuncionarioSalarioMaiorQueAlgumTempoX(Integer x);

    // (Exemplo de operação de multiconjunto) Encontrar funcionarios que possuem salario maior que todos funcionario
    // com tempo na empresa maior que x
    @Query("select f from Funcionario f where f.salario > all (select f.salario from Funcionario f where f.tempoNaEmpresa > :x)")
    List<Funcionario> buscarFuncionarioSalarioMaiorQueTodosTempoX(Integer x);

    // (Exemplo de função agregada) Encontrar media de salario dos funcionarios
}
