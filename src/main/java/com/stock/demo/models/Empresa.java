package com.stock.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.stock.demo.enums.EmpresaEnum;
import com.stock.demo.utils.EmpresaDeserialize;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Where(clause = "deleted = false")
public class Empresa  extends AbstractEntity{


    private static final long serialVersionUID = 8313373545313752969L;

    @Enumerated(EnumType.STRING)
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @JsonDeserialize(using = EmpresaDeserialize.class)
    private EmpresaEnum nomeFantasia;

    @JsonIgnore
    @OneToMany(mappedBy = "empresa")
    private List<Produto> produtos = new ArrayList<>();

    public Empresa() {
    }

    public Empresa(EmpresaEnum nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public EmpresaEnum getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(EmpresaEnum empresaEnum) {
        this.nomeFantasia = empresaEnum;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }


}
