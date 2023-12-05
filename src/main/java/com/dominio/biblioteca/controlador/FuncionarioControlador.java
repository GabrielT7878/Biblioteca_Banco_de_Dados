package com.dominio.biblioteca.controlador;

import com.dominio.biblioteca.entidade.Funcionario;
import com.dominio.biblioteca.repositorio.FuncionarioRepositorio;
import org.springframework.boot.actuate.web.exchanges.HttpExchange;
import org.springframework.stereotype.Controller;
import com.dominio.biblioteca.servico.*;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
@AllArgsConstructor
@Log4j2
@Controller
public class FuncionarioControlador {
    private final FuncionarioServico servico;

    @GetMapping("/funcionarios")
    public String obterFuncionarios(Model model){
        List<Funcionario> funcionarios =  servico.obterFuncionarios();
        Double totalSalario = servico.buscarTotalSalario();
        Double mediaSalario = servico.buscarMediaSalario();
        model.addAttribute("totalSalario",totalSalario);
        model.addAttribute("mediaSalario",mediaSalario);
        model.addAttribute("funcionarios",funcionarios);
        return "funcionarios";
    }

    @GetMapping("/funcionarios/buscarSalarioMaiorQueX")
    public String buscarFuncionarioSalarioMaiorQueX(Model model,@RequestParam(name = "valor", required = true) Double x){
        List<Funcionario> funcionarios =  servico.buscarFuncionarioSalarioMaiorQueX(x);
        model.addAttribute("funcionarios",funcionarios);
        return "funcionarios";
    }

    @GetMapping("/funcionarios/buscarTempoMaiorQueX")
    public String buscarFuncionarioTempoMaiorQueX(Model model,@RequestParam(name = "tempo", required = true) Integer x){
        List<Funcionario> funcionarios =  servico.buscarFuncionarioTempoMaiorQueX(x);
        model.addAttribute("funcionarios",funcionarios);
        return "funcionarios";
    }

    @GetMapping("/funcionarios/ordernarPorNome")
    public String ordenarFuncionarioPorNome(Model model){
        List<Funcionario> funcionarios =  servico.ordenarFuncionarioPorNome();
        model.addAttribute("funcionarios",funcionarios);
        return "funcionarios";
    }

    @GetMapping("/funcionarios/ordernarPorSalarioDesc")
    public String ordenarFuncionarioPorSalarioDesc(Model model){
        List<Funcionario> funcionarios =  servico.ordenarFuncionarioPorSalarioDesc();
        model.addAttribute("funcionarios",funcionarios);
        return "funcionarios";
    }

    @GetMapping("/funcionarios/ordernarPorSalarioCres")
    public String ordenarFuncionarioPorSalarioCres(Model model){
        List<Funcionario> funcionarios =  servico.ordenarFuncionarioPorSalarioCres();
        model.addAttribute("funcionarios",funcionarios);
        return "funcionarios";
    }

    @GetMapping("/funcionarios/buscarSalarioMaiorQueAlgumTempoX")
    public String buscarFuncionarioSalarioMaiorQueAlgumTempoX(Model model,@RequestParam(name = "tempo", required = true) Integer x){
        List<Funcionario> funcionarios =  servico.buscarFuncionarioSalarioMaiorQueAlgumTempoX(x);
        model.addAttribute("funcionarios",funcionarios);
        return "funcionarios";
    }

    @GetMapping("/funcionarios/buscarSalarioMaiorQueTodosTempoX")
    public String buscarFuncionarioSalarioMaiorQueTodosTempoX(Model model,@RequestParam(name = "tempo", required = true) Integer x){
        List<Funcionario> funcionarios =  servico.buscarFuncionarioSalarioMaiorQueTodosTempoX(x);
        model.addAttribute("funcionarios",funcionarios);
        return "funcionarios";
    }



}
