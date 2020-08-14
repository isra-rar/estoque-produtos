package com.stock.demo.services.impl;

import com.stock.demo.mappers.EmpresaMapper;
import com.stock.demo.mappers.ProdutoMapper;
import com.stock.demo.models.Empresa;
import com.stock.demo.models.Produto;
import com.stock.demo.models.dto.EmpresaDTO;
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
public class EmpresaServiceImpl extends GenericServiceImpl<EmpresaRepository, EmpresaMapper> implements EmpresaService {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public EmpresaDTO getEmpresaDTOById(Long id) {
        Optional<Empresa> obj = getRepository().findById(id);
        obj.orElseThrow(() -> new ObjectNotFoundException(
                "Empresa não encontrado"));
        return getModelMapper().empresaToEmpresaDTO(obj.get());
    }

    @Override
    public Empresa getEmpresaById(Long id) {
        Optional<Empresa> obj = getRepository().findById(id);
        obj.orElseThrow(() -> new ObjectNotFoundException(
                "Empresa não encontrado"));
        return obj.get();
    }

    @Override
    public void deleteProduto(Long id, Long idProduto) {

    }
}
