package com.stock.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.stock.demo.enums.GeneroEnum;
import com.stock.demo.enums.TipoProdutoEnum;
import com.stock.demo.utils.GeneroDeserialize;
import com.stock.demo.utils.TipoProdutoDeserialize;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Where(clause = "deleted = false")
public class Produto extends AbstractEntity {

    private static final long serialVersionUID = 2401571877790414344L;


    private String nomeProduto;

    private Long codigoProduto;

    @Enumerated(EnumType.STRING)
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @JsonDeserialize(using = TipoProdutoDeserialize.class)
    private TipoProdutoEnum tipoProduto;


    private Integer quantidadeProduto;

    private BigDecimal valorCompra;

    private BigDecimal precoUnitario;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;

    @Enumerated(EnumType.STRING)
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @JsonDeserialize(using = GeneroDeserialize.class)
    private GeneroEnum genero;

    @ManyToOne
    private Empresa empresa;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-br", timezone = "America/Recife")
    private LocalDate dataCriacao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-br", timezone = "America/Recife")
    private LocalDate dataAtualizacao;

    public Produto() {
    }

    public Produto(String nomeProduto, Long codigoProduto, TipoProdutoEnum tipoProduto, Integer quantidadeProduto, BigDecimal valorCompra, BigDecimal precoUnitario, LocalDate dataCompra, LocalDate dataCriacao, GeneroEnum genero, Empresa empresa) {
        this.nomeProduto = nomeProduto;
        this.codigoProduto = codigoProduto;
        this.tipoProduto = tipoProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.valorCompra = valorCompra;
        this.precoUnitario = precoUnitario;
        this.dataCompra = dataCompra;
        this.dataCriacao = dataCriacao;
        this.genero = genero;
        this.empresa = empresa;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nome) {
        this.nomeProduto = nome;
    }

    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public TipoProdutoEnum getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProdutoEnum tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDate dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}

