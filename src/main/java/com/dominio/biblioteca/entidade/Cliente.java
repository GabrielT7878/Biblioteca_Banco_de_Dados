package com.dominio.biblioteca.entidade;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.*;

import java.util.List;
@Setter
@Getter
@Entity
@Table(schema = "biblioteca",name = "cliente")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @Column(name = "ID_Pessoa")
    private Integer idPessoa;

    @Column(name = "Saldo")
    private Double saldo;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ID_Pessoa")
    private Pessoa pessoa;

}
