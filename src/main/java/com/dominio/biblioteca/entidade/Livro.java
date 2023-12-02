package com.dominio.biblioteca.entidade;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Table(schema = "biblioteca", name = "livro")
@Getter
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Livro")
    private Integer id;
    @Column(name = "Nome")
    private String nome;
    @Column(name = "Autor")
    private String autor;
    @Column(name = "Categoria")
    private String categoria;
    @Column(name = "Quantidade")
    private Integer quantidade;
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "ID_Editora")
    private Integer idEditora;
}
