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
@Table(schema = "biblioteca",name = "telefones_p")
public class TelefonesP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ID_Pessoa", nullable = false)
    private Integer pessoaId;

    @Column(name = "Telefone")
    private String telefone;

}
