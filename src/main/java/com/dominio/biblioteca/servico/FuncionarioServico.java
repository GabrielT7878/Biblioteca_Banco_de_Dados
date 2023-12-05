package com.dominio.biblioteca.servico;

import com.dominio.biblioteca.entidade.Funcionario;
import com.dominio.biblioteca.repositorio.FuncionarioRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioServico {
    private final FuncionarioRepositorio repositorio;

    public  List<Funcionario> obterFuncionarios(){return repositorio.obterFuncionarios();}
    public List<Funcionario> buscarFuncionarioSalarioMaiorQueX(Double x){return repositorio.buscarFuncionarioSalarioMaiorQueX(x);}

    public List<Funcionario> buscarFuncionarioTempoMaiorQueX(Integer x){return repositorio.buscarFuncionarioTempoMaiorQueX(x);}

    public List<Funcionario> ordenarFuncionarioPorNome(){return repositorio.ordenarFuncionariosPorNome();}

    public List<Funcionario> ordenarFuncionarioPorSalarioDesc(){return repositorio.ordenarFuncionariosPorSalarioDesc();}

    public List<Funcionario> ordenarFuncionarioPorSalarioCres(){return repositorio.ordenarFuncionariosPorSalarioCres();}

    public List<Funcionario> buscarFuncionarioSalarioMaiorQueAlgumTempoX(Integer x){return repositorio.buscarFuncionarioSalarioMaiorQueAlgumTempoX(x);}

    public List<Funcionario> buscarFuncionarioSalarioMaiorQueTodosTempoX(Integer x){return repositorio.buscarFuncionarioSalarioMaiorQueTodosTempoX(x);}
}
