package com.stock.demo.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.stock.demo.enums.GeneroEnum;
import com.stock.demo.enums.TipoProdutoEnum;
import com.stock.demo.utils.GeneroDeserialize;
import com.stock.demo.utils.TipoProdutoDeserialize;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoDTO  extends AbstractDTO {

    private static final long serialVersionUID = 7864445371548961896L;

    @NotEmpty(message = "{error.nomeproduto.obrigatorio}")
    private String nomeProduto;

    @NotNull(message = "{error.codigoproduto.obrigatorio}")
    private Long codigoProduto;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @JsonDeserialize(using = TipoProdutoDeserialize.class)
    @NotNull(message = "{error.tipoproduto.obrigatorio}")
    private TipoProdutoEnum tipoProduto;

    @NotNull(message = "{error.quantidadeproduto.obrigatorio}")
    private Integer quantidadeProduto;
    @NotNull(message = "{error.valorcompra.obrigatorio}")
    private BigDecimal valorCompra;
    @NotNull(message = "{error.precounitario.obrigatorio}")
    private BigDecimal precoUnitario;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra;

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    @JsonDeserialize(using = GeneroDeserialize.class)
    @NotNull(message = "{error.genero.obrigatorio}")
    private GeneroEnum genero;

    private EmpresaDTO empresa;

    public ProdutoDTO() {
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
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

    public GeneroEnum getGenero() {
        return genero;
    }

    public void setGenero(GeneroEnum genero) {
        this.genero = genero;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }
}
