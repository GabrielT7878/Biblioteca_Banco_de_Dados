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
@Table(schema = "biblioteca",name = "telefones_e")
public class TelefonesE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Telefone", length = 20)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "ID_Editora", referencedColumnName = "ID_Editora", insertable = false, updatable = false)
    private Editora editora;

}
