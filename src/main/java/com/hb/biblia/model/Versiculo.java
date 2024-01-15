package com.hb.biblia.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "versiculos")
@Getter
@Setter
public class Versiculo {
    @Id
    private long Id;
    private long verLivid;
    private long verCapitulo;
    private long verVersiculo;
    private String verTexto;

}
