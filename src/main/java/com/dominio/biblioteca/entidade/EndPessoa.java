package com.dominio.biblioteca.entidade;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import org.springframework.data.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.io.Serializable;
import java.util.List;
@Setter
@Getter
@Entity
@Table(schema = "biblioteca",name = "end_pessoa")
public class EndPessoa {
    @Id
    @Column(name = "ID_Pessoa")
    private Long pessoaId;

    @Column(name = "Rua", nullable = false, length = 50)
    private String rua;

    @Column(name = "Numero", nullable = false)
    private Integer numero;

    @Column(name = "Cidade", nullable = false, length = 50)
    private String cidade;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ID_Pessoa")
    private Pessoa pessoa;

    // Getters and setters
}
