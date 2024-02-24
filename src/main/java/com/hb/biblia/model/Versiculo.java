package com.hb.biblia.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "versiculos")
public record Versiculo (
    @Id long Id,
    long verLivId,
    long verCapitulo,
    long verVersiculo,
    String verTexto) {}
