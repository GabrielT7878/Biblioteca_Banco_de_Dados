package com.dominio.biblioteca.controlador;

import org.springframework.ui.Model;
import com.dominio.biblioteca.entidade.Editora;
import com.dominio.biblioteca.servico.EditoraServico;
import lombok.AllArgsConstructor;
import org.springframework.boot.actuate.endpoint.web.annotation.ControllerEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
