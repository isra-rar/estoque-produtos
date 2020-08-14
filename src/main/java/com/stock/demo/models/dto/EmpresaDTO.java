package com.stock.demo.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.stock.demo.enums.EmpresaEnum;
import com.stock.demo.utils.EmpresaDeserialize;

public class EmpresaDTO extends AbstractDTO {

    private static final long serialVersionUID = 7864445371548961896L;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = EmpresaDeserialize.class)
    private EmpresaEnum nomeFantasia;

    public EmpresaDTO() {
    }

    public EmpresaEnum getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(EmpresaEnum nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
