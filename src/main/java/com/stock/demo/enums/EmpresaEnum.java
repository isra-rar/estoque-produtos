package com.stock.demo.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Arrays;
import java.util.stream.Collectors;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EmpresaEnum {

    NATURA(0, "NATURA"),
    BOTICARIO(1, "BOTICARIO");

    private final int codigo;
    private final String descricao;

    EmpresaEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EmpresaEnum valueOf(int codigo) {
        return
                Arrays.stream(EmpresaEnum.values()).filter(cod -> cod.getCodigo() == codigo)
                        .collect(Collectors.toList()).get(0);
    }

}
