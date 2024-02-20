package com.hb.biblia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VersiculoComDependencias {
    private String livNome;
    private long verCapitulo;
    private long verVersiculo;
    private String verTexto;
}
