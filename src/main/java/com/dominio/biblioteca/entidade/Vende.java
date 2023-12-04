package com.dominio.biblioteca.entidade;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import org.springframework.data.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Setter
@Getter
@Entity
@Table(schema = "biblioteca",name = "vende")
public class Vende {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Venda")
    private Long id;

    @Column(name = "ID_Pessoa", nullable = false)
    private Long pessoaId;

    @Column(name = "ID_Livro", nullable = false)
    private Long livroId;

    @Column(name = "Data_Compra")
    private Date dataCompra;

    @Column(name = "Quantidade", nullable = false)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "ID_Pessoa", referencedColumnName = "ID_Pessoa", insertable = false, updatable = false)
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "ID_Livro", referencedColumnName = "ID_Livro", insertable = false, updatable = false)
    private Livro livro;

    // Getters and setters
}
