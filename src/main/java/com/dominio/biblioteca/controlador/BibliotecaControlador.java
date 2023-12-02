package com.dominio.biblioteca.controlador;

import com.dominio.biblioteca.entidade.Livro;
import com.dominio.biblioteca.servico.BibliotecaServico;
import com.mysql.cj.log.Log;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@Log4j2
public class BibliotecaControlador {
    private final BibliotecaServico servico;
    @GetMapping("/")
    public String paginaInicial(){
        return "home";
    }

    @GetMapping("/livros")
    public String obterLivros(Model model){
        List<Livro> livros = servico.obterTodosLivros();
        model.addAttribute("livros",livros);
        return "todos_livros";
    }

}
