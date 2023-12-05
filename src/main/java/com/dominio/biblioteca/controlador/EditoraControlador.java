package com.dominio.biblioteca.controlador;

import com.dominio.biblioteca.entidade.TelefonesE;
import org.springframework.ui.Model;
import com.dominio.biblioteca.entidade.Editora;
import com.dominio.biblioteca.servico.EditoraServico;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class EditoraControlador {
    private final EditoraServico servico;
    @GetMapping("/editoras")
    public String obterEditoras(Model model){
        List<Editora> editoras = servico.obterEditoras();
        model.addAttribute("editoras",editoras);
        return "editoras";
    }

    @PostMapping("/editoras/adicionarTelefone")
    public String adicionarTelefone(@RequestParam Integer idEditora, @RequestParam String numero){
        servico.adicionarTelefone(idEditora,numero);
        return "redirect:/editoras";
    }

    @GetMapping("/editoras/buscarPorGerente")
    public String buscarEditoraPorGerente(Model model,@RequestParam(name = "nome", required = false) String nome){
        List<Editora> editoras = servico.buscarEditoraPorGerente(nome);
        model.addAttribute("editoras",editoras);
        return "editoras";
    }

    @GetMapping("/editoras/ordenarPorNome")
    public String ordenarEditorasPorNome(Model model){
        List<Editora> editoras = servico.ordenarEditorasPorNome();
        model.addAttribute("editoras",editoras);
        return "editoras";
    }

    @GetMapping("/editoras/ordenarPorCidade")
    public String ordenarEditorasPorCidade(Model model){
        List<Editora> editoras = servico.ordenarEditorasPorCidade();
        model.addAttribute("editoras",editoras);
        return "editoras";
    }

    @GetMapping("/editoras/ordenarPorCNPJ")
    public String ordenarEditorasPorCNPJ(Model model){
        List<Editora> editoras = servico.ordenarEditorasPorCNPJ();
        model.addAttribute("editoras",editoras);
        return "editoras";
    }
}
