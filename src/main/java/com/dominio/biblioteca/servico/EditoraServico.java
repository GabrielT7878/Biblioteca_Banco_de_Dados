package com.dominio.biblioteca.servico;

import com.dominio.biblioteca.controlador.EditoraControlador;
import com.dominio.biblioteca.entidade.Editora;
import com.dominio.biblioteca.entidade.TelefonesE;
import com.dominio.biblioteca.repositorio.EditoraRepositorio;
import com.dominio.biblioteca.repositorio.TelefoneERpositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EditoraServico {
    private final EditoraRepositorio repositorio;
    private final TelefoneERpositorio repositorioTele;

    public List<Editora> obterEditoras(){
        return repositorio.obterEditoras();
    }

    public void adicionarTelefone(Integer id, String numero) {
            Editora editora = repositorio.adicionarTelefone(id);

            TelefonesE telefonesE = new TelefonesE();
            telefonesE.setTelefone(numero);
            telefonesE.setIdEditora(editora.getIdEditora());

            repositorioTele.save(telefonesE);

    }

    public List<Editora> buscarEditoraPorGerente(String nome){return repositorio.encontrarEditoraPorGerente(nome);}

    public List<Editora> ordenarEditorasPorNome(){return repositorio.ordenarEditorasPorNome();}

    public List<Editora> ordenarEditorasPorCidade(){return repositorio.ordenarEditorasPorCidade();}

    public List<Editora> ordenarEditorasPorCNPJ(){return repositorio.ordenarEditorasPorCNPJ();}

    public List<Editora> encontrarEditoraPorGerente(String nome){return repositorio.encontrarEditoraPorGerente(nome);}
}
