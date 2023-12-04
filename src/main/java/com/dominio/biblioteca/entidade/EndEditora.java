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
@Table(name = "end_editora")
public class EndEditora {
    @Id
    @Column(name = "ID_Editora",insertable=false, updatable=false)
    private Integer editoraId;

    @Column(name = "Rua", nullable = false, length = 50)
    private String rua;

    @Column(name = "Numero", nullable = false)
    private Integer numero;

    @Column(name = "Cidade", nullable = false, length = 50)
    private String cidade;

}
