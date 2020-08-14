package com.stock.demo.mappers;

import com.stock.demo.models.Empresa;
import com.stock.demo.models.Produto;
import com.stock.demo.models.dto.EmpresaDTO;
import com.stock.demo.models.dto.ProdutoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-13T00:19:37-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_265 (Private Build)"
)
@Component
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public ProdutoDTO produtoToProdutoDTO(Produto produto) {
        if ( produto == null ) {
            return null;
        }

        ProdutoDTO produtoDTO = new ProdutoDTO();

        produtoDTO.setId( produto.getId() );
        produtoDTO.setNomeProduto( produto.getNomeProduto() );
        produtoDTO.setCodigoProduto( produto.getCodigoProduto() );
        produtoDTO.setTipoProduto( produto.getTipoProduto() );
        produtoDTO.setQuantidadeProduto( produto.getQuantidadeProduto() );
        produtoDTO.setValorCompra( produto.getValorCompra() );
        produtoDTO.setPrecoUnitario( produto.getPrecoUnitario() );
        produtoDTO.setGenero( produto.getGenero() );
        produtoDTO.setEmpresa( empresaToEmpresaDTO( produto.getEmpresa() ) );
        produtoDTO.setDataCompra( produto.getDataCompra() );

        return produtoDTO;
    }

    @Override
    public Produto produtoDTOToProduto(ProdutoDTO produtoDTO) {
        if ( produtoDTO == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setId( produtoDTO.getId() );
        produto.setNomeProduto( produtoDTO.getNomeProduto() );
        produto.setCodigoProduto( produtoDTO.getCodigoProduto() );
        produto.setTipoProduto( produtoDTO.getTipoProduto() );
        produto.setQuantidadeProduto( produtoDTO.getQuantidadeProduto() );
        produto.setValorCompra( produtoDTO.getValorCompra() );
        produto.setPrecoUnitario( produtoDTO.getPrecoUnitario() );
        produto.setDataCompra( produtoDTO.getDataCompra() );
        produto.setGenero( produtoDTO.getGenero() );
        produto.setEmpresa( empresaDTOToEmpresa( produtoDTO.getEmpresa() ) );

        return produto;
    }

    @Override
    public List<ProdutoDTO> listProdutoToListProdutoDTO(List<Produto> produtos) {
        if ( produtos == null ) {
            return null;
        }

        List<ProdutoDTO> list = new ArrayList<ProdutoDTO>( produtos.size() );
        for ( Produto produto : produtos ) {
            list.add( produtoToProdutoDTO( produto ) );
        }

        return list;
    }

    protected EmpresaDTO empresaToEmpresaDTO(Empresa empresa) {
        if ( empresa == null ) {
            return null;
        }

        EmpresaDTO empresaDTO = new EmpresaDTO();

        empresaDTO.setId( empresa.getId() );
        empresaDTO.setNomeFantasia( empresa.getNomeFantasia() );

        return empresaDTO;
    }

    protected Empresa empresaDTOToEmpresa(EmpresaDTO empresaDTO) {
        if ( empresaDTO == null ) {
            return null;
        }

        Empresa empresa = new Empresa();

        empresa.setId( empresaDTO.getId() );
        empresa.setNomeFantasia( empresaDTO.getNomeFantasia() );

        return empresa;
    }
}
