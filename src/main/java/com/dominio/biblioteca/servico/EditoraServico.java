package com.dominio.biblioteca.servico;

import com.dominio.biblioteca.controlador.EditoraControlador;
import com.dominio.biblioteca.entidade.Editora;
import com.dominio.biblioteca.repositorio.EditoraRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EditoraServico {
    private final EditoraRepositorio repositorio;

    public List<Editora> obterEditoras(){
        return repositorio.obterEditoras();
    }
}
