package com.dominio.biblioteca.servico;

import com.dominio.biblioteca.entidade.Livro;
import com.dominio.biblioteca.entidade.MediaEditora;
import com.dominio.biblioteca.entidade.Vende;
import com.dominio.biblioteca.repositorio.BibliotecaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BibliotecaServico {
    private final BibliotecaRepositorio repositorio;
    public List<Livro> obterTodosLivros(){
        return repositorio.obterLivros();
    }

    public Integer buscarQuantidadeTotalLivros(){
        return repositorio.buscarTotalLivros();
    }

    public List<Vende> obterVendas(){
        return repositorio.obterVendas();
    }
    public List<Livro> buscarLivrosQuantidadeMaiorQueX(Integer x){return repositorio.buscarLivrosQuantidadeMaiorQueX(x);}

    public List<Livro> buscarLivrosSaldoNegativo(){
        return repositorio.buscarLivrosSaldoNegativo();
    }

    public List<Livro> ordenarLivrosPorNome(){return repositorio.ordernarLivrosPorNome();}

    public List<Livro> ordenarLivrosPorAutor(){return repositorio.ordernarLivrosPorAutor();}

    public List<Livro> ordenarLivrosPorEditora(){return repositorio.ordernarLivrosPorEditora();}

    public List<Livro> buscarLivrosVendidosNaoComprados(){return repositorio.buscarLivrosVendidosNaoComprados();}

    public boolean removerLivro(Integer id){
        Optional<Livro> livro = repositorio.findById(id);
        if(livro.isPresent()) {
            repositorio.delete(livro.get());
        }else{
            return false;
        }
        return true;
    }

    public Integer buscarTotalLivros(){return repositorio.buscarTotalLivros();}

    public Integer buscarMediaLivros(){return repositorio.buscarMediaLivros();}

    public List<MediaEditora> buscarMediaLivrosPorEditora(){return repositorio.buscarMediaLivrosPorEditora();}

    public List<MediaEditora> buscarMediaLivrosPorEditoraApenasX(Integer x){return repositorio.buscarMediaLivrosPorEditoraApenasMaisQueX(x);}

}
