package com.dominio.biblioteca.entidade;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import org.springframework.data.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.util.List;
@Setter
@Getter


@Entity
@Table(schema = "biblioteca", name = "fornece")
public class Fornece {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Numero_Carregamento")
    private Integer numeroCarregamento;

    @Column(name = "Quantidade")
    private Integer quantidade;

    @Column(name = "Nome_Livro")
    private String nomeLivro;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "ID_Editora")
    private Integer editora;

}
