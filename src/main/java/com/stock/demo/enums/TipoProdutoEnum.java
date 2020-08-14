package com.stock.demo.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.stream.Collectors;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TipoProdutoEnum {

    PERFUME(0, "PERFUME"),
    HIDRATANTE(1, "HIDRATANTE"),
    DESODORANTE(2, "DESODORANTE"),
    SHAMPOO(3, "SHAMPOO"),
    CREME(4, "CREME"),
    MAQUIAGEM(5, "MAQUIAGEM"),
    BARBA(6, "BARBA");


    private final int codigo;
    private final String descricao;

    TipoProdutoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoProdutoEnum valueOf(int codigo) {
        return
                Arrays.stream(TipoProdutoEnum.values()).filter(cod -> cod.getCodigo() == codigo)
                        .collect(Collectors.toList()).get(0);
    }
}
