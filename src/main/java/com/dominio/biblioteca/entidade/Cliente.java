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
@Table(schema = "biblioteca",name = "cliente")
public class Cliente {
    @Id
    @Column(name = "ID_Pessoa")
    private Integer id;

    @Column(name = "Saldo")
    private Double saldo;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ID_Pessoa")
    private Pessoa pessoa;

}
