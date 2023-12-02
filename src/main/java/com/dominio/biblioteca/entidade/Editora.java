package com.dominio.biblioteca.entidade;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import org.springframework.data.annotation.*;


@Entity
@Table(schema = "biblioteca",name = "editora")
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Editora")
    private Integer idEditora;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "Nome_Gerente")
    private String nomeGerente;

}
