package com.dominio.biblioteca.entidade;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.util.List;
@Setter
@Getter
@Entity
@Table(schema = "biblioteca",name = "pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Pessoa")
    private Integer idPessoa;

    @Column(name = "P_Nome", nullable = false)
    private String nome;

    @Column(name = "Ult_Nome")
    private String ultimoNome;

    @Column(name = "CPF", unique = true, nullable = false)
    private String cpf;

    @OneToMany(mappedBy = "pessoa")
    private List<TelefonesP> telefones;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ID_Pessoa")
    private EndPessoa endPessoa;
}
