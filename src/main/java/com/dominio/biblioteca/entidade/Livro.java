package com.dominio.biblioteca.entidade;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.util.List;
@Setter
@Getter
@Entity
@Builder
@Table(schema = "biblioteca",name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Livro")
    private Integer id;

    @Column(name = "Nome", nullable = false)
    private String nome;

    @Column(name = "Autor", nullable = false)
    private String autor;

    @Column(name = "Categoria")
    private String categoria;

    @Column(name = "Quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "ISBN", nullable = false)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "ID_Editora")
    private Editora editora;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.REMOVE)
    private List<Compra> compras;

    @OneToMany(mappedBy = "livro", cascade = CascadeType.REMOVE)
    private List<Vende> vendas;

}
