package com.stock.demo.services.impl;

import com.stock.demo.mappers.ProdutoMapper;
import com.stock.demo.models.Empresa;
import com.stock.demo.models.Produto;
import com.stock.demo.models.dto.ProdutoDTO;
import com.stock.demo.repositories.EmpresaRepository;
import com.stock.demo.repositories.ProdutoRepository;
import com.stock.demo.services.EmpresaService;
import com.stock.demo.services.ProdutoService;
import com.stock.demo.services.excepctions.DataIntegrityException;
import com.stock.demo.services.excepctions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl extends GenericServiceImpl<ProdutoRepository, ProdutoMapper> implements ProdutoService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EmpresaService empresaService;

    @Override
    public ProdutoDTO getProdutoById(Long id) {
        Optional<Produto> obj = getRepository().findById(id);
        obj.orElseThrow(() -> new ObjectNotFoundException(
                "Produto não encontrado"));
        return getModelMapper().produtoToProdutoDTO(obj.get());
    }

    @Override
    public List<ProdutoDTO> getAllProdutos() {
        List<Produto> produtos = getRepository().findAll();
        if (produtos.isEmpty() || produtos.size() <= 0) {
            throw new DataIntegrityException("Nenhum produto encontrado");
        }
        return getModelMapper().listProdutoToListProdutoDTO(produtos);
    }

    @Override
    public ProdutoDTO insertProduto(ProdutoDTO objDto) {
        Produto produto = getModelMapper().produtoDTOToProduto(objDto);
        addLocalDataCriacaoCompra(produto);

        Empresa empresa = getEmpresa(produto);
        addProdutoEmpresa(empresa, produto);

        produto.getEmpresa().setNomeFantasia(empresa.getNomeFantasia());
        getRepository().save(produto);
        return getModelMapper().produtoToProdutoDTO(produto);
    }

    @Override
    public void updateProduto(ProdutoDTO objDto, Long id) {
        ProdutoDTO produtoDTO = getProdutoById(id);
        updateData(produtoDTO, objDto);
        Produto produto = getModelMapper().produtoDTOToProduto(produtoDTO);
        produto.setDataAtualizacao(LocalDate.now());
        getRepository().save(produto);
    }

    @Override
    public void deleteProduto(Long id) {
        getProdutoById(id);
        try {
            getRepository().deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir um PRODUTO que possua associações");
        }

    }

    private void updateData(ProdutoDTO newObj, ProdutoDTO obj) {
        newObj.setNomeProduto(obj.getNomeProduto());
        newObj.setCodigoProduto(obj.getCodigoProduto());
        newObj.setTipoProduto(obj.getTipoProduto());
        newObj.setQuantidadeProduto(obj.getQuantidadeProduto());
        newObj.setValorCompra(obj.getValorCompra());
        newObj.setPrecoUnitario(obj.getPrecoUnitario());
        newObj.setGenero(obj.getGenero());
        newObj.setEmpresa(obj.getEmpresa());
    }

    private void addProdutoEmpresa(Empresa empresa, Produto produto) {
        empresa.getProdutos().add(produto);
        empresaRepository.save(empresa);
    }

    private Empresa getEmpresa(Produto produto) {
        return empresaService.getEmpresaById(produto.getEmpresa().getId());
    }

    private void addLocalDataCriacaoCompra(Produto produto) {
        produto.setDataCompra(LocalDate.now());
        produto.setDataCriacao(LocalDate.now());
    }
}
