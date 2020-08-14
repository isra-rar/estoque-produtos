package com.stock.demo.mappers;

import com.stock.demo.models.Produto;
import com.stock.demo.models.dto.ProdutoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    ProdutoDTO produtoToProdutoDTO(Produto produto);

    Produto produtoDTOToProduto(ProdutoDTO produtoDTO);

    List<ProdutoDTO> listProdutoToListProdutoDTO(List<Produto> produtos);

}
