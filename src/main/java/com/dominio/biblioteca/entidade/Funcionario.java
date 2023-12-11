package com.dominio.biblioteca.entidade;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.annotation.*;

import java.io.Serializable;
import java.util.List;
@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "biblioteca",name = "funcionario")
public class Funcionario implements Serializable {
    @Id
    @Column(name = "ID_Pessoa")
    private Integer idPessoa;

    @Column(name = "Salario", nullable = false)
    private Double salario;

    @Column(name = "Tempo_na_Empresa", nullable = false)
    private Integer tempoNaEmpresa;

    @OneToOne
    @MapsId
    @JoinColumn(name = "ID_Pessoa")
    private Pessoa pessoa;

}
