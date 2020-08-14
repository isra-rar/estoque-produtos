package com.stock.demo.services;

import com.stock.demo.models.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService extends GenericService{


    ProdutoDTO getProdutoById(Long id);

    List<ProdutoDTO> getAllProdutos();

    ProdutoDTO insertProduto(ProdutoDTO objDto);

    void updateProduto(ProdutoDTO objDto, Long id);

    void deleteProduto(Long id);

}
