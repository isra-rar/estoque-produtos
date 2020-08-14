package com.stock.demo.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.stream.Collectors;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum GeneroEnum {

    MASCULINO(0, "MASCULINO"),
    FEMININO(1, "FEMININO"),
    UNISEXY(2,  "UNISEXY");

    private final int codigo;
    private final String descricao;

    GeneroEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static GeneroEnum valueOf(int codigo) {
        return
                Arrays.stream(GeneroEnum.values()).filter(cod -> cod.getCodigo() == codigo)
                        .collect(Collectors.toList()).get(0);
    }

}
