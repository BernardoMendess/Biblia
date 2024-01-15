package com.hb.biblia.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "livros")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Livro {
    @Id
    private long id;
    private long livTesId;
    private long livPosicao;
    private String livNome;
    private String livAbreviado;
    private int livCapitulo;
}
