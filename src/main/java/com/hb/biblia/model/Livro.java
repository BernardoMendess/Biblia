package com.hb.biblia.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "livros")
public record Livro (
    @Id long id,
    long livTesId,
    long livPosicao,
    String livNome,
    String livAbreviado,
    int livCapitulo) {}

