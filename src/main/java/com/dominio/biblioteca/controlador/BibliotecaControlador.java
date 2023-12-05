package com.dominio.biblioteca.controlador;

import com.dominio.biblioteca.entidade.Livro;
import com.dominio.biblioteca.entidade.Vende;
import com.dominio.biblioteca.servico.BibliotecaServico;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
        return "livros";
    }

    @GetMapping("/vendas")
    public String obterVendas(Model model){
        List<Vende> vendas = servico.obterVendas();
        model.addAttribute("vendas",vendas);
        return "vendas";
    }

    @GetMapping("/livrosQuantidadeMaiorQueX")
    public String buscarLivros(Model model,@RequestParam(name = "valor", required = true) Integer x){
        List<Livro> livros = servico.buscarLivrosQuantidadeMaiorQueX(x);
        model.addAttribute("livros",livros);
        return "livros";
    }

    @GetMapping("/livrosSaldoNegativo")
    public String buscarLivrosSaldoNegativo(Model model){
        List<Livro> livros = servico.buscarLivrosSaldoNegativo();
        model.addAttribute("livros",livros);
        return "livros";
    }

    @GetMapping("/ordenarLivrosPorNome")
    public String ordenarLivrosPorNome(Model model){
        List<Livro> livros = servico.ordenarLivrosPorNome();
        model.addAttribute("livros",livros);
        return "livros";
    }

    @GetMapping("/ordenarLivrosPorAutor")
    public String ordenarLivrosPorAutor(Model model){
        List<Livro> livros = servico.ordenarLivrosPorAutor();
        model.addAttribute("livros",livros);
        return "livros";
    }

    @GetMapping("/ordenarLivrosPorEditora")
    public String ordenarLivrosPorEditora(Model model){
        List<Livro> livros = servico.ordenarLivrosPorEditora();
        model.addAttribute("livros",livros);
        return "livros";
    }

    @GetMapping("/buscarLivrosVendidosNaoComprados")
    public String buscarLivrosVendidosNaoComprados(Model model){
        List<Livro> livros = servico.buscarLivrosVendidosNaoComprados();
        model.addAttribute("livros",livros);
        return "livros";
    }

    @PostMapping("/removerLivro")
    public String removerLivro(Model model,@RequestParam(required = true) Integer id ){
        servico.removerLivro(id);
        return "redirect:livros";
    }


}
