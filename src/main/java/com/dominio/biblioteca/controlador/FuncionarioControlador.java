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
    private final FuncionarioRepositorio repositorio;

    @GetMapping("/funcionarios")
    public String obterFuncionarios(Model model){
        List<Funcionario> funcionarios =  repositorio.obterFuncionarios();
        model.addAttribute("funcionarios",funcionarios);
        return "funcionarios";
    }

}
