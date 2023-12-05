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
@Table(schema = "biblioteca",name = "editora")
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Editora",insertable=false, updatable=false)
    private Integer idEditora;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "Nome_Gerente")
    private String nomeGerente;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ID_Editora")
    private EndEditora endereco;

    @OneToMany(mappedBy = "editora")
    private List<TelefonesE> telefones;

}
